package Negocio;

import Entidade.Cliente;
import Persistencia.ClienteDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteNegocio implements IClienteNegocio {

    private ClienteDAO clienteDAO;

    public ClienteNegocio() {
        clienteDAO = new ClienteDAO();
    }

    
    @Override
    public int inserirCliente(Cliente cliente) {
        try {
            return clienteDAO.inserirCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    @Override
    public ArrayList<Cliente> listaClienteTodos() {
        try {
            return clienteDAO.listaClienteTodos();
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Cliente>();
    }

    @Override
    public Cliente listaClientePorNome(String nome) {
        try {
            return clienteDAO.listaClientePorNome(nome);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Cliente();
    }

    @Override
    public boolean excluirCliente(int idCliente) {
        boolean resultado = false;
        
        try {
            resultado = clienteDAO.excluirCliente(idCliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
