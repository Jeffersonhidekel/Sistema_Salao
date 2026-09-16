package DAO;

import factory.ConnectionFactory;
import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(Cliente cliente) {

        String sql = "INSERT INTO cliente "
                + "(id, nome, cpf, rg, nascimento, telefone, rua, numero, "
                + "bairro, cidade, estado, cep, complemento, pontoReferencia) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setLong(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setString(5, cliente.getNascimento());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getRua());
            stmt.setString(8, cliente.getNumero());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getCidade());
            stmt.setString(11, cliente.getEstado());
            stmt.setString(12, cliente.getCep());
            stmt.setString(13, cliente.getComplemento());
            stmt.setString(14, cliente.getPontoreferencia());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    // LISTAR
    public ArrayList<Cliente> listarTodos() {

        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setNascimento(rs.getString("nascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCep(rs.getString("cep"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setPontoreferencia(rs.getString("pontoReferencia"));

                clientes.add(cliente);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    // ATUALIZAR
    public void atualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET "
                + "nome=?, cpf=?, rg=?, nascimento=?, telefone=?, "
                + "rua=?, numero=?, bairro=?, cidade=?, estado=?, "
                + "cep=?, complemento=?, pontoReferencia=? "
                + "WHERE id=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getNascimento());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getRua());
            stmt.setString(7, cliente.getNumero());
            stmt.setString(8, cliente.getBairro());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getEstado());
            stmt.setString(11, cliente.getCep());
            stmt.setString(12, cliente.getComplemento());
            stmt.setString(13, cliente.getPontoreferencia());
            stmt.setLong(14, cliente.getId());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(String id) {

        String sql = "DELETE FROM cliente WHERE id=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, id);

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Cliente removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Cliente buscarPorId(String id) {

        String sql = "SELECT * FROM cliente WHERE id=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setNascimento(rs.getString("nascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCep(rs.getString("cep"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setPontoreferencia(rs.getString("pontoReferencia"));

                rs.close();
                stmt.close();

                return cliente;
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
        }

        return null;
    }

    
}
    

