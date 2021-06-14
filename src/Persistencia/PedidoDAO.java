package Persistencia;

import Entidade.Cliente;
import Entidade.Pedido;
import Entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PedidoDAO {

    private ConexaoBD conexao;

    public PedidoDAO() {
        conexao = new ConexaoBD();
    }

    public boolean inserirPedido(ArrayList<Pedido> listagemPedidos) throws Exception {
        boolean sucesso = false;
        int codigoPedido = 0;
        
        try {
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO pedido (numero, cpf_cliente, codigo_produto, quantidade, valortotal) VALUES (?, ?, ?, ?, ?)";
            codigoPedido = ((Pedido)listagemPedidos.get(0)).getCodigoPedido();
                
            for (Pedido itemPedido: listagemPedidos) {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setInt(1, codigoPedido);
                ps.setString(2, itemPedido.getCliente().getCpf());
                ps.setInt(3, itemPedido.getProduto().getCodigo());
                ps.setInt(4, itemPedido.getQuantidade());
                ps.setDouble(5, itemPedido.getValortotal());
                
                int linhasAfetadas = ps.executeUpdate();
                sucesso = (linhasAfetadas>0);                
            }

            connection.close();
            return sucesso;
        } catch (Exception e) {
            throw new Exception(e);
        } 
    }

    public boolean atualizarPedido(ArrayList<Pedido> listagemPedidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluirPedido(int codigoPedido) throws Exception {
        boolean sucesso = false;
        
        try {
            Connection connection = conexao.getConnection();
            String sql = "delete from pedido where numero = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, codigoPedido);
            
            int linhasAfetadas = ps.executeUpdate();
            sucesso = (linhasAfetadas > 0);
            
            connection.close();
            return sucesso;
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public ArrayList<Pedido> listaPedidoPorCliente(String codigoCliente) throws Exception {
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();

        try {
            String sql = "select numero, c.nome, sum(quantidade * valortotal) valortotal from pedido p inner join cliente c on c.cpf = p.cpf_cliente where cpf_cliente = ? group by numero, c.nome";
            Connection connection = conexao.getConnection();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCliente);
            
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setCliente(new Cliente(codigoCliente, resultado.getString("nome")));
                pedido.setCodigoPedido(resultado.getInt("numero"));
                pedido.setValortotal(resultado.getDouble("valortotal"));

                listaPedido.add(pedido);
            }

            connection.close();

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return listaPedido;
    }

    public ArrayList<Pedido> listaPedidoPorPedido(int codigoPedido) throws Exception {
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();

        try {
            String sql = "select numero, cpf_cliente, codigo_produto, p.nome, valortotal, quantidade from pedido pd inner join produto p on pd.codigo_produto = p.codigo where numero = ?";
            Connection connection = conexao.getConnection();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigoPedido);
            
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setCliente(new Cliente(resultado.getString("cpf_cliente")));
                pedido.setCodigoPedido(resultado.getInt("numero"));
                pedido.setProduto(new Produto(resultado.getInt("codigo_produto"), resultado.getString("nome")));
                pedido.setValortotal(resultado.getDouble("valortotal"));
                pedido.setQuantidade(resultado.getInt("quantidade"));

                listaPedido.add(pedido);
            }

            connection.close();

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return listaPedido;
    }

    public int ObterProximoCodigoPedido() throws Exception {

        try {
            String sql = "select max(numero) sequencial from pedido";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                return resultado.getInt("sequencial") + 1;
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return 1;
    }
    
    private boolean inserirPedido(Pedido itemPedido) throws Exception {
        boolean sucesso = false;
        
        try {
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO produto(numero, cpf_cliente, codigo_produto, quantidade, valortotal) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, itemPedido.getCodigoPedido());
            ps.setString(2, itemPedido.getCliente().getCpf());
            ps.setInt(3, itemPedido.getProduto().getCodigo());
            ps.setInt(4, itemPedido.getQuantidade());
            ps.setDouble(5, itemPedido.getValortotal());

            int linhasAfetadas = ps.executeUpdate();
            sucesso = (linhasAfetadas>0);                

            connection.close();
            return sucesso;
        } catch (Exception e) {
            throw new Exception(e);
        } 
    }
}
