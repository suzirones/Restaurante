package Persistencia;

import Entidade.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private ConexaoBD conexao;
    
    public ClienteDAO() {
        conexao = new ConexaoBD();
    }
    
    public boolean inserirCliente(Cliente cliente) throws Exception {
    	boolean sucesso = false;
        
        try{
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO cliente(cpf, nome, fone, endereco) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getFone());
            ps.setString(4, cliente.getEndereco());
            
            int linhasAfetadas = ps.executeUpdate();
            sucesso = (linhasAfetadas>0);
            
            connection.close();
            return sucesso;
        }catch(Exception e){
            throw new Exception(e);
        }
}

    public ArrayList<Cliente> listaClienteTodos() throws Exception {
    	
    	ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    	
        try {
        	String sql = "select * from cliente";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ResultSet resultado = ps.executeQuery();
        	
        	while(resultado.next()) {
        		Cliente cliente = new Cliente();
        		cliente.setCpf(resultado.getString("cpf"));
        		cliente.setNome(resultado.getString("nome"));
        		cliente.setFone(resultado.getString("fone"));
        		cliente.setEndereco(resultado.getString("endereco"));

                        listaCliente.add(cliente);
        	}
        	
        	connection.close();
        	
        }catch(Exception e){
            throw new Exception(e);
        }
        
        return listaCliente;
    }

    public Cliente listaClientePorCPF(String cpf) throws Exception {
    	
    	Cliente cliente = new Cliente();
    	
        try {
            String sql = "select * from cliente where cpf = ?";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet resultado = ps.executeQuery();

            if(resultado.next()) {
                    cliente.setCpf(resultado.getString("cpf"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setFone(resultado.getString("fone"));
                    cliente.setEndereco(resultado.getString("endereco"));
            }

            connection.close();

        }catch(Exception e){
            throw new Exception(e);
        }
        
        return cliente;
    }

    public boolean excluirCliente(String cpf) throws Exception {
        boolean sucesso = false;
        
        try {
            Connection connection = conexao.getConnection();
            String sql = "delete from cliente where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);

            int linhasAfetadas = ps.executeUpdate();
            sucesso = (linhasAfetadas>0);
            
            connection.close();
            return sucesso;
        }
        catch(Exception e){
            throw new Exception(e);
        }
    }

    public boolean atualizarCliente(Cliente cliente) throws Exception {
        boolean sucesso = false;
        
        try {
            Connection connection = conexao.getConnection();

            String sql = "update cliente set nome = ?, fone = ?, endereco = ? where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getFone());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCpf());
            
            int linhasAfetadas = ps.executeUpdate();
            sucesso = (linhasAfetadas>0);
            
            connection.close();
            return sucesso;
        }
        catch(Exception e){
            throw new Exception(e);
        }
    }
}
