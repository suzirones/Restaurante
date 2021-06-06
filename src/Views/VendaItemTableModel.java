package Views;

import Entidade.VendaItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendaItemTableModel extends AbstractTableModel {

    private List<VendaItem> listagemVendaItem = new ArrayList<>();
    private String[] colunas = {"ID", "Produto", "Quantidade"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return listagemVendaItem.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna) {
            case 0:
                return listagemVendaItem.get(linha).getIdProduto();

            case 1:
                return listagemVendaItem.get(linha).getDescricaoProduto();

            case 2:
                return listagemVendaItem.get(linha).getQuantidade();
        }
        
        return null;
    }
    
    public void addVendaItem(VendaItem item) {
        this.listagemVendaItem.add(item);
        this.fireTableDataChanged();
    }
    
    public void removeVendaItem(int linha){
        this.listagemVendaItem.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
