package Views;

import Entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ProdutoComboboxModel extends AbstractListModel implements ComboBoxModel{

    private List<Produto> listaProdutos;
    private Produto produtoSelecionado;
    
    public ProdutoComboboxModel(){
        this.listaProdutos = new ArrayList<>();
    }

        @Override
    public int getSize() {
        return listaProdutos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaProdutos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Produto) {
            this.produtoSelecionado = (Produto)anItem;
            fireContentsChanged(this.listaProdutos, 0, this.listaProdutos.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.produtoSelecionado;
    }
    
    public void addProdutos(Produto pProduto) {
        this.listaProdutos.add(pProduto);
    }
    
    private void reset(){
        this.listaProdutos.clear();
    }
}
