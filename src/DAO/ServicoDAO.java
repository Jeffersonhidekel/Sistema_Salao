package DAO;

import factory.ConnectionFactory;
import Modelo.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO {

    private Connection connection;

    public ServicoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(Servico servico) {

        String sql = "INSERT INTO servico "
                + "( nome, Valor) "
                + "VALUES ( ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getValor());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Serviço cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir serviço: " + e.getMessage());
        }
    }

    // LISTAR
    public ArrayList<Servico> listar() {

        ArrayList<Servico> lista = new ArrayList<>();

        String sql = "SELECT * FROM servico";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Servico servico = new Servico();

                servico.setId(rs.getLong("id"));
                servico.setNome(rs.getString("nome"));
                servico.setValor(rs.getString("valor"));

                lista.add(servico);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar serviços: " + e.getMessage());
        }

        return lista;
    }

    // ATUALIZAR
    public void atualizar(Servico servico) {

        String sql = "UPDATE servico "
                + "SET nome=?, valor=? "
                + "WHERE id=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getValor());
            stmt.setLong(3, servico.getId());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Serviço atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar serviço: " + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(long id) {

        String sql = "DELETE FROM servico WHERE id=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id); 

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Serviço removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir serviço: " + e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Servico buscarPorId(long id) {

        String sql = "SELECT * FROM servico WHERE id=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Servico servico = new Servico();

                servico.setId(rs.getLong("id"));
                servico.setNome(rs.getString("nome"));
                servico.setValor(rs.getString("valor"));

                rs.close();
                stmt.close();

                return servico;
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar serviço: " + e.getMessage());
        }

        return null;
    }
    
}