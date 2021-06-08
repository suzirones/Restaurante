package Negocio;

import Entidade.Cliente;
import java.util.ArrayList;

public interface IClienteNegocio {
    boolean inserirCliente(Cliente cliente);
    boolean atualizarCliente (Cliente cliente);
    boolean excluirCliente(String cpf);
    ArrayList<Cliente> listaClienteTodos();
    Cliente listaClientePorCPF(String cpf);
}
