package Views;

import Entidade.Garcom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class GarcomComboboxModel extends AbstractListModel implements ComboBoxModel{

    private List<Garcom> listaGarcons;
    private Garcom garcomSelecionado;

    public GarcomComboboxModel(){
        this.listaGarcons = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listaGarcons.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaGarcons.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Garcom) {
            this.garcomSelecionado = (Garcom)anItem;
            fireContentsChanged(this.listaGarcons, 0, this.listaGarcons.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.garcomSelecionado;
    }

    public void addGarcons(Garcom pGarcom) {
        this.listaGarcons.add(pGarcom);
    }
    
    private void reset(){
        this.listaGarcons.clear();
    }    
}
