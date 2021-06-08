package Negocio;

import Entidade.Produto;
import java.util.ArrayList;

public interface IProdutoNegocio {
    boolean inserirProduto(Produto produto);
    boolean excluirProduto(int codigo);
    boolean alterarProduto(Produto produto);
    ArrayList<Produto> listaProdutoTodos();
    Produto listaProdutoPorCodigo(int codigo);
}
