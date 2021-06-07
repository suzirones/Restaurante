package Persistencia;

import Entidade.Cliente;
import Entidade.Garcom;
import Entidade.Produto;
import Entidade.Venda;
import Entidade.VendaItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendaItemDAO {
    private ConexaoBD conexao;

    public VendaItemDAO() {
        conexao = new ConexaoBD();
    }

    public int inserirVendaItem(VendaItem vendaItem, int codigoVenda) throws Exception {
        int isSucesso = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        
        try {
            Connection connection = conexao.getConnection();

            String sql = "INSERT INTO vendaitem(idvenda, idproduto, quantidade, valorunitario) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, codigoVenda);
            ps.setInt(2, vendaItem.getDadosProduto().getIdProduto());
            ps.setInt(3, vendaItem.getQuantidade());
            ps.setString(4, df.format(vendaItem.getDadosProduto().getValor()).replace(',','.'));
            
            int qntdRegistros = ps.executeUpdate();
            if (qntdRegistros == 0) {
                throw new SQLException("Erro ao cadastrar uma venda.");
            }

            connection.close();
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return isSucesso;
    }

    public ArrayList<VendaItem> listaVenda(int codigoVenda) throws Exception {
        ArrayList<VendaItem> listaVendaItem = new ArrayList<VendaItem>();

        try {
            String sql = "select * from vendaitem where idvenda = ?";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, codigoVenda);
            
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                VendaItem vendaItem = new VendaItem();
                vendaItem.setIdVendaItem(resultado.getInt("idvendaitem"));
                vendaItem.setDadosProduto(new Produto(resultado.getInt("idproduto"), resultado.getDouble("valorunitario")));
                vendaItem.setQuantidade(resultado.getInt("quantidade"));
                
                listaVendaItem.add(vendaItem);
            }

            connection.close();

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return listaVendaItem;
    }
}
