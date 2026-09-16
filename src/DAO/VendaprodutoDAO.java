package DAO;

import Modelo.VendaProduto;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VendaprodutoDAO {
    
    
    private Connection connection;

    public VendaprodutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(VendaProduto produto) {

       
        String sql = "INSERT INTO VendaProduto "
                + "(idCliente, idProduto, Quantidade, Data, ValorTotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setLong(1, produto.getidCliente());
            stmt.setLong(2, produto.getidProduto());
            stmt.setInt(3, produto.getQuantidade()); 
            
            
            java.time.format.DateTimeFormatter formatoBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            java.time.LocalDate dataConvertida = java.time.LocalDate.parse(produto.getData(), formatoBr);
            stmt.setDate(4, java.sql.Date.valueOf(dataConvertida));
            
            
            stmt.setDouble(5, produto.getValorTotal());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto: " + e.getMessage());
        }
    
        
    }

    // LISTAR
    public ArrayList<VendaProduto> listar() {

        ArrayList<VendaProduto> lista = new ArrayList<>();

        String sql = "SELECT * FROM Vendaproduto";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                VendaProduto produto = new VendaProduto();

                produto.setidVendas(rs.getLong("idVenda"));                
                produto.setQuantidade(rs.getInt("Quantidade"));
                produto.setidCliente(rs.getLong("idCliente"));
                produto.setidProduto(rs.getLong("idProduto"));
                
                produto.setData(rs.getString("Data"));
    produto.setValorTotal(rs.getDouble("ValorTotal"));

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
    public void atualizar(VendaProduto produto) {

        String sql = "UPDATE Vendaproduto "
                + "SET Quantidade=?, ValorTotal=? "
                + "WHERE idVenda=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
          
            stmt.setInt(1, produto.getQuantidade());
            stmt.setDouble(2, produto.getValorTotal());
            stmt.setLong(3, produto.getidVendas());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(Long idVendas) {
       

        String sql = "DELETE FROM Vendaproduto WHERE IdVenda=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            
            stmt.setLong(1, idVendas);

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage());
        }
        
    }

    // BUSCAR POR CÓDIGO
    public VendaProduto buscarPorCodigo(Long idVendas) {

String sql = "SELECT * FROM Vendaproduto WHERE idVendas=?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setLong(1, idVendas);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                VendaProduto produto = new VendaProduto();

                produto.setidVendas(rs.getLong("idVendas"));
                produto.setQuantidade(rs.getInt("Quantidade"));
                produto.setValorTotal(rs.getDouble("ValorTotal"));

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
    
