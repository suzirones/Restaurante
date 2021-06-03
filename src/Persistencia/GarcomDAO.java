package Persistencia;

import Entidade.Garcom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GarcomDAO {

    private ConexaoBD conexao;

    public GarcomDAO() {
        conexao = new ConexaoBD();
    }

    public int inserirGarcom(Garcom garcom) throws Exception {

        int isSucesso = 0;

        try {
            Connection connection = conexao.getConnection();

            String sql = "INSERT INTO garcom(nome, ativo) VALUES (?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, garcom.getNome());
            ps.setInt(2, 1);

            isSucesso = ps.executeUpdate();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return isSucesso;
    }

    public ArrayList<Garcom> listaGarcomTodos() throws Exception {

        ArrayList<Garcom> listaGarcom = new ArrayList<Garcom>();

        try {
            String sql = "select * from garcom";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Garcom garcom = new Garcom();
                garcom.setIdGarcom(resultado.getInt("idgarcom"));
                garcom.setNome(resultado.getString("nome"));

                listaGarcom.add(garcom);
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return listaGarcom;
    }

    public Garcom listaGarcomPorNome(String nome) throws Exception {

        Garcom garcom = new Garcom();

        try {

            JOptionPane.showMessageDialog(null, "Inicio Consulta");
            String sql = "select * from garcom where nome = ? and ativo = 1";
            Connection connection = conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                garcom.setIdGarcom(resultado.getInt("idgarcom"));
                garcom.setNome(resultado.getString("nome"));
            }

            connection.close();

        } catch (Exception e) {
            throw new Exception(e);
        }

        return garcom;
    }

    public boolean excluirGarcom(int idGarcom) throws Exception {

        try {

            Connection connection = conexao.getConnection();
            //String sql = "delete from garcom where idgarcom = ?";
            String sql = "update garcom set ativo = 0 where idgarcom = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idGarcom);

            ps.execute();

            connection.close();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }
}
