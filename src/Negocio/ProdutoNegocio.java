package Negocio;

import Entidade.Produto;
import Persistencia.ProdutoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoNegocio implements IProdutoNegocio {

    private ProdutoDAO produtoDAO;

    public ProdutoNegocio() {
        produtoDAO = new ProdutoDAO();
    }

    
    @Override
    public int inserirProduto(Produto produto) {
        try {
            return produtoDAO.inserirProduto(produto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    @Override
    public ArrayList<Produto> listaProdutoTodos() {
        try {
            return produtoDAO.listaProdutoTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Produto>();
    }

    @Override
    public Produto listaProdutoPorNome(String nome) {
        try {
            return produtoDAO.listaProdutoPorNome(nome);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Produto();
    }

    @Override
    public boolean excluirProduto(int idProduto) {
        boolean resultado = false;
        
        try {
            resultado = produtoDAO.excluirProduto(idProduto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
