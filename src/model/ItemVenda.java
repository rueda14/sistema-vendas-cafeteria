package model;

public class ItemVenda {
    private int id;
    private int vendaId; 
    private Produto produto;
    private int produtoId; 
    private int quantidade;
    private double subtotal;
    private double preco_unitario;
    private String nomeFuncionario; 

    public ItemVenda() {}

    public ItemVenda(Produto produto, int quantidade, double preco_unitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
        this.preco_unitario = preco_unitario;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
    if (this.produto != null) {
        this.subtotal = produto.getPreco() * quantidade;
    }
}

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    
    
    
}
