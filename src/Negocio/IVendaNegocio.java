package Negocio;

import Entidade.Cliente;
import Entidade.Venda;
import java.util.ArrayList;

public interface IVendaNegocio {
    int inserirVenda(Venda produto);
    ArrayList<Venda> listaVendaPorCliente(Cliente DadosCliente);
    Venda obtemVendaPorCodigo(int idVenda);
    boolean excluirVenda(int idVenda);    
}
