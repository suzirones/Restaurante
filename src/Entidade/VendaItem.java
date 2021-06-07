package Entidade;

public class VendaItem {

    private int IdVendaItem;
    private Produto DadosProduto;
    private int Quantidade;

    public int getIdVendaItem() {
        return IdVendaItem;
    }

    public void setIdVendaItem(int IdVendaItem) {
        this.IdVendaItem = IdVendaItem;
    }

    public Produto getDadosProduto() {
        return DadosProduto;
    }

    public void setDadosProduto(Produto DadosProduto) {
        this.DadosProduto = DadosProduto;
    }
    
    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
}
