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
    
    public int inserirCliente(Cliente cliente) throws Exception {
    	
    	int isSucesso = 0;
    	
    	try{
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO cliente(nome, telefone, email, sexo, datanascimento, ativo) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getDatanascimento());
            ps.setInt(6, 1);
            
            System.out.println(sql);
            
            isSucesso = ps.executeUpdate();
            
            connection.close();
        }catch(Exception e){
            throw new Exception(e);
        }
        
      return isSucesso;
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
        		cliente.setIdCliente(resultado.getInt("idcliente"));
        		cliente.setNome(resultado.getString("nome"));
        		cliente.setTelefone(resultado.getString("telefone"));
        		cliente.setEmail(resultado.getString("email"));
        		cliente.setSexo(resultado.getString("sexo"));
        		cliente.setDatanascimento(resultado.getString("datanascimento"));
                    
        		listaCliente.add(cliente);
        	}
        	
        	connection.close();
        	
        }catch(Exception e){
            throw new Exception(e);
        }
        
        return listaCliente;
    }

    public Cliente listaClientePorNome(String nome) throws Exception {
    	
    	Cliente cliente = new Cliente();
    	
        try {
            
            JOptionPane.showMessageDialog(null, "Inicio Consulta");
        	String sql = "select * from cliente where nome = ? and ativo = 1";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ps.setString(1, nome);
        	ResultSet resultado = ps.executeQuery();
        	
        	if(resultado.next()) {
        		cliente.setIdCliente(resultado.getInt("idcliente"));
        		cliente.setNome(resultado.getString("nome"));
        		cliente.setTelefone(resultado.getString("telefone"));
        		cliente.setEmail(resultado.getString("email"));
        		cliente.setSexo(resultado.getString("sexo"));
                        cliente.setDatanascimento(resultado.getString("datanascimento"));
               	}
        	
        	connection.close();
        	
        }catch(Exception e){
            throw new Exception(e);
        }
        
        return cliente;
    }

    public boolean excluirCliente(int idCliente) throws Exception {
        
        try {
        
        	Connection connection = conexao.getConnection();
            //String sql = "delete from cliente where idcliente = ?";
        	String sql = "update cliente set ativo = 0 where idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            
            ps.execute();
            
            connection.close();
        }
        catch(Exception e){
            throw new Exception(e);
        }
        
        return true;
    }
}
