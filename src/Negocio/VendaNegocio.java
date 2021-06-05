package Negocio;

import Entidade.Cliente;
import Entidade.Venda;
import Persistencia.VendaDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaNegocio implements IVendaNegocio {

    private VendaDAO vendaDAO;

    public VendaNegocio() {
        vendaDAO = new VendaDAO();
    }

    
    @Override
    public int inserirVenda(Venda venda) {
        try {
            return vendaDAO.inserirVenda(venda);
        } catch (Exception ex) {
            Logger.getLogger(VendaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    @Override
    public ArrayList<Venda> listaVendaPorCliente(Cliente DadosCliente) {
        try {
            return vendaDAO.listaVendaPorCliente(DadosCliente.getIdCliente());
        } catch (Exception ex) {
            Logger.getLogger(VendaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Venda>();
    }

    @Override
    public Venda obtemVendaPorCodigo(int idVenda) {
        try {
            return vendaDAO.obtemVendaPorCodigo(idVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Venda();
    }

    @Override
    public boolean excluirVenda(int idVenda) {
        boolean resultado = false;
        
        try {
            resultado = vendaDAO.excluirVenda(idVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
