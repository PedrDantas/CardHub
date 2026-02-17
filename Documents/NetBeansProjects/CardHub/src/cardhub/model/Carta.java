/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardhub.model;

/**
 *
 * @author Pedro
 */
public class Carta {
    private int idCarta;
    private String nome;
    private String raridade;
    private String idioma;
    private double preco;
    private int qtdEstoque;
    
    public int getIdCarta() { return idCarta; }
    public void setIdCarta(int idCarta) { this.idCarta = idCarta; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getRaridade() {return raridade; }
    public void setRaridade(String raridade) { this.raridade = raridade; }
    
    public String getIdioma() {return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    
    public double getPreco() {return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    public int getQtdEstoque() { return qtdEstoque; }
    public void setQtdEstoque(int qtdEstoque) { this.qtdEstoque = qtdEstoque; }
}
