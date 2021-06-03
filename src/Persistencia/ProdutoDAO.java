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

    public int inserirProduto(Produto produto) throws Exception {

        int isSucesso = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        
        try {
            Connection connection = conexao.getConnection();

            String sql = "INSERT INTO produto(nome, valor_unitario, ativo) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, produto.getNome());
            ps.setString(2, df.format(produto.getValor()).replace(',','.'));
            ps.setInt(3, 1);

            System.out.println(sql);

            isSucesso = ps.executeUpdate();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return isSucesso;
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
                produto.setIdProduto(resultado.getInt("idproduto"));
                produto.setNome(resultado.getString("nome"));
                produto.setValor(resultado.getDouble("valor_unitario"));

                listaProduto.add(produto);
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return listaProduto;
    }

    public Produto listaProdutoPorNome(String nome) throws Exception {

        Produto produto = new Produto();

        try {
            String sql = "select * from produto where nome = ? and ativo = 1";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                produto.setIdProduto(resultado.getInt("idproduto"));
                produto.setNome(resultado.getString("nome"));
                produto.setValor(resultado.getDouble("valor_unitario"));
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return produto;
    }

    public boolean excluirProduto(int idProduto) throws Exception {

        try {
            Connection connection = conexao.getConnection();
            String sql = "update produto set ativo = 0 where idproduto = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProduto);

            ps.execute();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }
}
