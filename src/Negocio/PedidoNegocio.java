package Negocio;

import Entidade.Pedido;
import Persistencia.PedidoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoNegocio implements IPedidoNegocio {

    PedidoDAO pedidoDAO;

    public PedidoNegocio() {
        pedidoDAO = new PedidoDAO();
    }
    
    @Override
    public boolean inserirPedido(ArrayList<Pedido> listagemPedidos) {
        try {
            return pedidoDAO.inserirPedido(listagemPedidos);
        } catch (Exception ex) {
            Logger.getLogger(PedidoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean atualizarPedido(ArrayList<Pedido> listagemPedidos) {
        try {
            return pedidoDAO.atualizarPedido(listagemPedidos);
        } catch (Exception ex) {
            Logger.getLogger(PedidoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean excluirPedido(int codigoPedido) {
        try {
            return pedidoDAO.excluirPedido(codigoPedido);
        } catch (Exception ex) {
            Logger.getLogger(PedidoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public ArrayList<Pedido> listaPedidoPorCliente(String codigoCliente) {
        try {
            return pedidoDAO.listaPedidoPorCliente(codigoCliente);
        } catch (Exception ex) {
            Logger.getLogger(PedidoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Pedido>();
    }

    @Override
    public ArrayList<Pedido> listaPedidoPorPedido(int codigoPedido) {
        try {
            return pedidoDAO.listaPedidoPorPedido(codigoPedido);
        } catch (Exception ex) {
            Logger.getLogger(PedidoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Pedido>();
    }
}
