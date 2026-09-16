package dao;

import factory.ConnectionFactory;
import Modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(Funcionario funcionario) {

        String sql = "INSERT INTO funcionario "
                + "(matricula, nome, rua, bairro, numeroCasa, "
                + "numeroTel, cidade, cep, uf, pontoReferencia, complemento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setLong(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getRua());
            stmt.setString(4, funcionario.getBairro());
            stmt.setString(5, funcionario.getNumeroCasa());
            stmt.setString(6, funcionario.getNumeroTel());
            stmt.setString(7, funcionario.getCidade());
            stmt.setString(8, funcionario.getCep());
            stmt.setString(9, funcionario.getUf());
            stmt.setString(10, funcionario.getPontoReferencia());
            stmt.setString(11, funcionario.getComplemento());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir funcionário: "
                    + e.getMessage());
        }
    }

    // LISTAR
    public ArrayList<Funcionario> listar() {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM funcionario";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setMatricula(rs.getLong("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setNumeroCasa(rs.getString("numeroCasa"));
                funcionario.setNumeroTel(rs.getString("numeroTel"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setPontoReferencia(rs.getString("pontoReferencia"));
                funcionario.setComplemento(rs.getString("complemento"));

                funcionarios.add(funcionario);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários: "
                    + e.getMessage());
        }

        return funcionarios;
    }

    // ATUALIZAR
    public void atualizar(Funcionario funcionario) {

        String sql = "UPDATE funcionario SET "
                + "nome=?, rua=?, bairro=?, numeroCasa=?, numeroTel=?, "
                + "cidade=?, cep=?, uf=?, pontoReferencia=?, complemento=? "
                + "WHERE matricula=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getRua());
            stmt.setString(3, funcionario.getBairro());
            stmt.setString(4, funcionario.getNumeroCasa());
            stmt.setString(5, funcionario.getNumeroTel());
            stmt.setString(6, funcionario.getCidade());
            stmt.setString(7, funcionario.getCep());
            stmt.setString(8, funcionario.getUf());
            stmt.setString(9, funcionario.getPontoReferencia());
            stmt.setString(10, funcionario.getComplemento());
            stmt.setLong(11, funcionario.getMatricula());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Funcionário atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário: "
                    + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(String matricula) {

        String sql = "DELETE FROM funcionario WHERE matricula=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, matricula);

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Funcionário removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir funcionário: "
                    + e.getMessage());
        }
    }

    // BUSCAR POR MATRÍCULA
    public Funcionario buscarPorMatricula(String matricula) {

        String sql = "SELECT * FROM funcionario WHERE matricula=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, matricula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setMatricula(rs.getLong("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setNumeroCasa(rs.getString("numeroCasa"));
                funcionario.setNumeroTel(rs.getString("numeroTel"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setPontoReferencia(rs.getString("pontoReferencia"));
                funcionario.setComplemento(rs.getString("complemento"));

                rs.close();
                stmt.close();

                return funcionario;
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário: "
                    + e.getMessage());
        }

        return null;
    }
}