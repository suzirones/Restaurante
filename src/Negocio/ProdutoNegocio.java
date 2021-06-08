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
    public boolean inserirProduto(Produto produto) {
        try {
            return produtoDAO.inserirProduto(produto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean alterarProduto(Produto produto) {
        try {
            return produtoDAO.alterarProduto(produto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;

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
    public Produto listaProdutoPorCodigo(int codigo) {
        try {
            return produtoDAO.listaProdutoPorCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Produto();
    }

    @Override
    public boolean excluirProduto(int codigo) {
        try {
            return produtoDAO.excluirProduto(codigo);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
