package Views;

import Entidade.Cliente;
import Entidade.Pedido;
import java.sql.PreparedStatement;
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

    public void setSelectedItemPorCodigo(String cpf) {
        for (Cliente itemCliente: this.listaClientes) {
            if (itemCliente.getCpf().equals(cpf)) {
                this.clienteSelecionado = itemCliente;
                return;
            }
        }
    }
    
    
    @Override
    public Object getSelectedItem() {
        return this.clienteSelecionado;
    }

    public void clearSelectedItem() {
        this.clienteSelecionado = new Cliente();
        fireContentsChanged(this.listaClientes, 0, this.listaClientes.size());
    }    
    
    public void addClientes(Cliente pCliente) {
        this.listaClientes.add(pCliente);
    }
    
    private void reset(){
        this.listaClientes.clear();
    }
}
