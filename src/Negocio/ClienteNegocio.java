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
    public boolean inserirCliente(Cliente cliente) {
        try {
            return clienteDAO.inserirCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
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
    public boolean excluirCliente(String cpf) {
        try {
            return clienteDAO.excluirCliente(cpf);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        try {
            return clienteDAO.atualizarCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Cliente listaClientePorCPF(String cpf) {
        try {
            return clienteDAO.listaClientePorCPF(cpf);
        } catch (Exception ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Cliente();
    }
}
