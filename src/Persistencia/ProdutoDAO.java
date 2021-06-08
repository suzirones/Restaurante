package Persistencia;

import Entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProdutoDAO {

    private ConexaoBD conexao;

    public ProdutoDAO() {
        conexao = new ConexaoBD();
    }

    public boolean inserirProduto(Produto produto) throws Exception {
        int linhasAfetadas = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        
        try {
            Connection connection = conexao.getConnection();

            String sql = "INSERT INTO produto(nome, preco) VALUES (?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, produto.getNome());
            ps.setString(2, String.valueOf(produto.getPreco()).replace(',','.'));

            System.out.println(sql);

            linhasAfetadas = ps.executeUpdate();

            connection.close();
            return linhasAfetadas > 0;
        } catch (Exception e) {
            throw new Exception(e);
        } 
    }

    public ArrayList<Produto> listaProdutoTodos() throws Exception {

        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        try {
            String sql = "select * from produto";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setCodigo(resultado.getInt("codigo"));
                produto.setNome(resultado.getString("nome"));
                produto.setPreco(resultado.getDouble("preco"));

                listaProduto.add(produto);
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return listaProduto;
    }

    public boolean alterarProduto(Produto produto) throws Exception {

        try {
            Connection connection = conexao.getConnection();
            String sql = "update produto set nome = ?, preco = ? where codigo = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, produto.getNome());
            ps.setString(2, String.valueOf(produto.getPreco()).replace(',','.'));
            ps.setInt(3, produto.getCodigo());
            
            ps.execute();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }

    public Produto listaProdutoPorCodigo(int codigo) throws Exception {
        Produto produto = new Produto();

        try {
            String sql = "select * from produto where codigo = ?";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                produto.setCodigo(resultado.getInt("codigo"));
                produto.setNome(resultado.getString("nome"));
                produto.setPreco(resultado.getDouble("preco"));
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return produto;
    }

    public boolean excluirProduto(int codigo) throws Exception {

        try {
            Connection connection = conexao.getConnection();
            String sql = "delete produto where codigo = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, codigo);
            
            ps.execute();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }
}
