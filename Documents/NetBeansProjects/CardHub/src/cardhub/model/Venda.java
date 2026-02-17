
package cardhub.model;

import java.util.Date;
import cardhub.model.Cliente;








public class Venda {

    private int idVenda;
    private Date dataVenda;
    private double valorTotal;
    private int qntItens;
    private Cliente cliente;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQntItens() {
        return qntItens;
    }

    public void setQntItens(int qntItens) {
        this.qntItens = qntItens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
