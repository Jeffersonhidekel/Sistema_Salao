package DAO;

import factory.ConnectionFactory;
import Modelo.ProdutoConsumo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoConsumoDAO {

    private Connection connection;

    public ProdutoConsumoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(ProdutoConsumo produto) {

        String sql = "INSERT INTO produto_consumo "
                + "(nome, valorCompra) "
                + "VALUES (?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            //stmt.setString(1, produto.getCodigoProduto());
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getValorcompra());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto: " + e.getMessage());
        }
    }

    // LISTAR
    public ArrayList<ProdutoConsumo> listar() {

        ArrayList<ProdutoConsumo> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto_consumo";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoConsumo produto = new ProdutoConsumo();

                produto.setCodigoProduto(rs.getLong("codigoProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValorcompra(rs.getString("valorCompra"));

                lista.add(produto);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }

    // ATUALIZAR
    public void atualizar(ProdutoConsumo produto) {

        String sql = "UPDATE produto_consumo "
                + "SET nome=?, valorCompra=? "
                + "WHERE codigoProduto=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getValorcompra());
            stmt.setLong(3, produto.getCodigoProduto());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(String codigoProduto) {

        String sql = "DELETE FROM produto_consumo WHERE codigoProduto=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, codigoProduto);

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage());
        }
    }
}