package model;

import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private Funcionario funcionario;
    private Date data;
    private double total;
    private List<ItemVenda> itens;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public List<ItemVenda> getItens() { return itens; }
    public void setItens(List<ItemVenda> itens) { this.itens = itens; }
    
    public void calcularTotal() {
        total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
    }
}
