package cardhub.dao;

import cardhub.model.Venda;
import cardhub.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public void inserir(Venda venda) {

        String sql = "INSERT INTO Vendas (id_cliente, data_venda, valor_total, qnt_itens) VALUES (?, CURDATE(), ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getCliente().getIdCliente());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.setInt(3, venda.getQntItens());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir venda: " + e.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public List<Venda> listar() {

        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vendas";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("id_venda"));
                v.setValorTotal(rs.getDouble("valor_total"));
                v.setQntItens(rs.getInt("qnt_itens"));
                lista.add(v);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }

        return lista;
    }

    
}
