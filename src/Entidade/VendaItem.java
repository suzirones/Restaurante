package Entidade;

public class VendaItem {

    private int IdProduto;
    private String DescricaoProduto;
    private int Quantidade;

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int IdProduto) {
        this.IdProduto = IdProduto;
    }

    public String getDescricaoProduto() {
        return DescricaoProduto;
    }

    public void setDescricaoProduto(String DescricaoProduto) {
        this.DescricaoProduto = DescricaoProduto;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
}
