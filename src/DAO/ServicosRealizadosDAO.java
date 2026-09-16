package DAO;

import factory.ConnectionFactory;
import Modelo.ServicosRealizados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicosRealizadosDAO {

    private Connection connection;

    public ServicosRealizadosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERIR
    public void inserir(ServicosRealizados servico) {

        String sql = "INSERT INTO servicos_realizados "
                + "(idCliente, idServico, dataServico, ValorServico) "
                + "VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setLong(1, servico.getIdcliente());
            stmt.setString(2, servico.getIdservico());
            stmt.setString(3, servico.getdataServico());
            stmt.setDouble(4, servico.getValorServico());
            

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Serviço realizado registrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir serviço realizado: "
                    + e.getMessage());
        }
    }

    // LISTAR
    
    public ArrayList<ServicosRealizados> listar() {

        ArrayList<ServicosRealizados> lista = new ArrayList<>();
        String sql = "SELECT * FROM servicos_realizados";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ServicosRealizados servico = new ServicosRealizados();
                
                servico.setIdAtendimento(rs.getInt("idAtendimento"));
                
                servico.setIdcliente(rs.getLong("idCliente"));
                servico.setIdservico(rs.getString("idServico"));        
                servico.setdataServico(rs.getString("dataServico")); 
                servico.setValorServico(rs.getDouble("ValorServico"));

                lista.add(servico);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    // ATUALIZAR
    public void atualizar(ServicosRealizados servico) {

        
        String sql = "UPDATE servicos_realizados "
                + "SET dataServico=?, valorServico=?, idCliente=?, idServico=? "
                + "WHERE IdAtendimento=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, servico.getdataServico());                    
            stmt.setDouble(2, servico.getValorServico());
            stmt.setLong(3, servico.getIdcliente());
            stmt.setString(4, servico.getIdservico());
            stmt.setInt(5, servico.getIdAtendimento()); // <-- Passando o ID único aqui

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Registro atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar: " + e.getMessage());
        }
    }

    // EXCLUIR
    public void excluir(String idAtendimentoStr) { 
        
        
        String sql = "DELETE FROM servicos_realizados WHERE idAtendimento=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
          
            stmt.setInt(1, Integer.parseInt(idAtendimentoStr));

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Registro removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new RuntimeException("O ID não é um número válido!");
        }
    }
        
    }
