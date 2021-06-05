package Entidade;

import java.util.Date;

public class Venda {
    
    private int idVenda;
    private Cliente DadosCliente;
    private Garcom DadosGarcom;
    private Date dataVenda;
    private double valorTotal;

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Garcom getDadosGarcom() {
        return DadosGarcom;
    }

    public void setDadosGarcom(Garcom DadosGarcom) {
        this.DadosGarcom = DadosGarcom;
    }

    public Cliente getDadosCliente() {
        return DadosCliente;
    }

    public void setDadosCliente(Cliente DadosCliente) {
        this.DadosCliente = DadosCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
}
