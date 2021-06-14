package Views;

import Entidade.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PedidoTableModel extends AbstractTableModel {

    private List<Pedido> listagemPedido = new ArrayList<>();
    private String[] colunas = {"Código", "Produto", "Quantidade", "Valor Unitário"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return listagemPedido.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna) {
            case 0:
                return listagemPedido.get(linha).getProduto().getCodigo();

            case 1:
                return listagemPedido.get(linha).getProduto().getNome();

            case 2:
                return listagemPedido.get(linha).getQuantidade();

            case 3:
                return listagemPedido.get(linha).getValortotal();
        }
        
        return null;
    }
    
    public void addPedido(Pedido item) {
        this.listagemPedido.add(item);
        this.fireTableDataChanged();
    }
    
    public void removePedido(int linha){
        this.listagemPedido.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void reset() {
        listagemPedido = new ArrayList<Pedido>();
        this.fireTableDataChanged();
    }
    
    public ArrayList<Pedido> getArray() {
        return new ArrayList<Pedido>(listagemPedido);
    }
}