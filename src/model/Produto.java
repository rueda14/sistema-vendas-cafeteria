package model;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private int idCategoria;

    // Construtores
    public Produto() {}

    public Produto(int id, String nome, double preco, String descricao, int idCategoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }

    
}
