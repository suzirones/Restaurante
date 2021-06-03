package Negocio;

import Entidade.Produto;
import java.util.ArrayList;

public interface IProdutoNegocio {

    int inserirProduto(Produto produto);
    ArrayList<Produto> listaProdutoTodos();
    Produto listaProdutoPorNome(String nome);
    boolean excluirProduto(int idProduto);
}
