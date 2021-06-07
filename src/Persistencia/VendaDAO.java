package Persistencia;

import Entidade.Cliente;
import Entidade.Garcom;
import Entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendaDAO {

    private ConexaoBD conexao;

    public VendaDAO() {
        conexao = new ConexaoBD();
    }

    public int inserirVenda(Venda venda) throws Exception {

        int isSucesso = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        
        try {
            Connection connection = conexao.getConnection();

            String sql = "INSERT INTO venda(idcliente, idgarcom, datavenda, valortotal, ativo) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, venda.getDadosCliente().getIdCliente());
            ps.setInt(2, venda.getDadosGarcom().getIdGarcom());
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(4, df.format(venda.getValorTotal()).replace(',','.'));
            ps.setInt(5, 1);

            int qntdRegistros = ps.executeUpdate();
            if (qntdRegistros == 0) {
                throw new SQLException("Erro ao cadastrar uma venda.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    isSucesso = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Problema ao obter o código da venda.");
                }
            }
            
            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return isSucesso;
    }

    public ArrayList<Venda> listaVendaPorCliente(int idCliente) throws Exception {

        ArrayList<Venda> listaVenda = new ArrayList<Venda>();

        try {
            String sql = "select * from venda where ativo = 1 and idCliente = ?";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idCliente);
            
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(resultado.getInt("idvenda"));
                venda.setDadosCliente(new Cliente(resultado.getInt("idCliente")));
                venda.setDadosGarcom(new Garcom(resultado.getInt("idGarcom")));
                venda.setValorTotal(resultado.getDouble("valorTotal"));
                venda.setDataVenda(resultado.getDate("dataVenda"));
                
                listaVenda.add(venda);
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return listaVenda;
    }

    public Venda obtemVendaPorCodigo(int idVenda) throws Exception {

        Venda venda = new Venda();

        try {
            String sql = "select * from venda where idvenda = ? and ativo = 1";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idVenda);
            
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                venda.setIdVenda(resultado.getInt("idvenda"));
                venda.setDadosCliente(new Cliente(resultado.getInt("idCliente")));
                venda.setDadosGarcom(new Garcom(resultado.getInt("idGarcom")));
                venda.setValorTotal(resultado.getDouble("valorTotal"));
                venda.setDataVenda(resultado.getDate("dataVenda"));
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return venda;
    }

    public boolean excluirVenda(int idVenda) throws Exception {

        try {
            Connection connection = conexao.getConnection();
            String sql = "update venda set ativo = 0 where idvenda = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idVenda);

            ps.execute();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }
}
