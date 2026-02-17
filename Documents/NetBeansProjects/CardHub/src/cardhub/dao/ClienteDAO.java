package cardhub.dao;

import cardhub.model.Cliente;
import cardhub.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class ClienteDAO {

    public void inserir(Cliente cliente) {

        String sql = "INSERT INTO Clientes (nome, email, telefone) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();

            System.out.println("✅ Cliente inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }
    
    public List<Cliente> listar() {

    List<Cliente> lista = new ArrayList<>();
    String sql = "SELECT * FROM Clientes";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("id_cliente"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            lista.add(c);
        }

    } catch (Exception e) {
        System.out.println("Erro ao listar clientes: " + e.getMessage());
    }

    return lista;
}

    
}
