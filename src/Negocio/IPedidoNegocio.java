package Negocio;

import Entidade.Pedido;
import java.util.ArrayList;

public interface IPedidoNegocio {
    boolean inserirPedido(ArrayList<Pedido> listagemPedidos);
    boolean atualizarPedido(ArrayList<Pedido> listagemPedidos);
    boolean excluirPedido(int codigoPedido);
    ArrayList<Pedido> listaPedidoPorCliente(String codigoCliente);
    ArrayList<Pedido> listaPedidoPorPedido(int codigoPedido);
}
