package Views;

import Entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ClienteComboboxModel extends AbstractListModel implements ComboBoxModel {

    private List<Cliente> listaClientes;
    private Cliente clienteSelecionado;
    
    public ClienteComboboxModel(){
        this.listaClientes = new ArrayList<>();
    }
        
    @Override
    public int getSize() {
        return listaClientes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaClientes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Cliente) {
            this.clienteSelecionado = (Cliente)anItem;
            fireContentsChanged(this.listaClientes, 0, this.listaClientes.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.clienteSelecionado;
    }
    
    public void addClientes(Cliente pCliente) {
        this.listaClientes.add(pCliente);
    }
    
    private void reset(){
        this.listaClientes.clear();
    }
}
