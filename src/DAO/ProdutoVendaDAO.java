package DAO;

import factory.ConnectionFactory;
import Modelo.ProdutoVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoVendaDAO {

    private Connection connection;

    public ProdutoVendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(ProdutoVenda produto) {

        String sql = "INSERT INTO produto_venda "
                + "(nome, valorCompra, valorVenda) "
                + "VALUES ( ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getValorcompra());
            stmt.setString(3, produto.getValorvenda());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto: " + e.getMessage());
        }
    }

    // LISTAR
    public ArrayList<ProdutoVenda> listar() {

        ArrayList<ProdutoVenda> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto_venda";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoVenda produto = new ProdutoVenda();

                produto.setCodigoProduto(rs.getLong("codigoProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValorcompra(rs.getString("valorCompra"));
                produto.setValorvenda(rs.getString("valorVenda"));

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
    public void atualizar(ProdutoVenda produto) {

        String sql = "UPDATE produto_venda "
                + "SET nome=?, valorCompra=?, valorVenda=? "
                + "WHERE codigoProduto=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getValorcompra());
            stmt.setString(3, produto.getValorvenda());
            stmt.setLong(4, produto.getCodigoProduto());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(Long codigoProduto) {
       

        String sql = "DELETE FROM produto_venda WHERE codigoProduto=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            // Mudado de setString para setLong
            stmt.setLong(1, codigoProduto);

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage());
        }
        
    }

    // BUSCAR POR CÓDIGO
    public ProdutoVenda buscarPorCodigo(Long codigoProduto) {

String sql = "SELECT * FROM produto_venda WHERE codigoProduto=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // Mudado de setString para setLong
            stmt.setLong(1, codigoProduto);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                ProdutoVenda produto = new ProdutoVenda();

                produto.setCodigoProduto(rs.getLong("codigoProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValorcompra(rs.getString("valorCompra"));
                produto.setValorvenda(rs.getString("valorVenda"));

                rs.close();
                stmt.close();

                return produto;
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage());
        }

        return null;
    
    }
    
}