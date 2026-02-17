package cardhub.dao;

import cardhub.model.Carta;
import cardhub.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaDAO {

    public void inserir(Carta carta) {

        String sql = "INSERT INTO Cartas (nome, raridade, idioma, preco, qtd_estoque) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carta.getNome());
            stmt.setString(2, carta.getRaridade());
            stmt.setString(3, carta.getIdioma());
            stmt.setDouble(4, carta.getPreco());
            stmt.setInt(5, carta.getQtdEstoque());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir carta: " + e.getMessage());
        }
    }

    public List<Carta> listar() {

        List<Carta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cartas";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carta c = new Carta();
                c.setIdCarta(rs.getInt("id_carta"));
                c.setNome(rs.getString("nome"));
                c.setRaridade(rs.getString("raridade"));
                c.setIdioma(rs.getString("idioma"));
                c.setPreco(rs.getDouble("preco"));
                c.setQtdEstoque(rs.getInt("qtd_estoque"));
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar cartas: " + e.getMessage());
        }

        return lista;
    }
}