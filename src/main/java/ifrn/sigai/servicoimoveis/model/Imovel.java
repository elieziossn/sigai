package ifrn.sigai.servicoimoveis.model;

public class Imovel {

    private Long id;
    private String endereco;
    private Double valorAluguel;
    private String descricao;

    public Imovel() {}

    public Imovel(Long id, String endereco, Double valorAluguel, String descricao) {
        this.id = id;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Double getValorAluguel() {
        return valorAluguel;    
    }
    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }   

    @Override
    public String toString() {
        return "Imovel {id=" + id + ", endereco='" + endereco + "', valorAluguel=" + valorAluguel + "}";
    }
}