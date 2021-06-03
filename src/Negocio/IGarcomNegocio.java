package Negocio;

import Entidade.Garcom;
import java.util.ArrayList;

public interface IGarcomNegocio {
    int inserirGarcom(Garcom cliente);
    ArrayList<Garcom> listaGarcomTodos();
    Garcom listaGarcomPorNome(String nome);
    boolean excluirGarcom(int idGarcom);   
}
