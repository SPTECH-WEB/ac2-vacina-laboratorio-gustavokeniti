package sptech.school;

import java.time.LocalDate;

public class Vacina {
    private String codigo;
    private String nome;
    private String tipo;
    private Double preco;
    private Double eficacia;
    private LocalDate dataLancamento;

    public Vacina(String codigo, String nome, String tipo, Double preco, Double eficacia, LocalDate dataLancamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.eficacia = eficacia;
        this.dataLancamento = dataLancamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEficacia() {
        return eficacia;
    }

    public void setEficacia(Double eficacia) {
        this.eficacia = eficacia;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getEficaciaDescricao() {
        if (eficacia >= 90.5) {
            return "EXCELENTE";
        }
        if (eficacia >= 75.5) {
            return "BOM";
        }
        if (eficacia >= 50.5) {
            return "REGULAR";
        }
        return "RUIM";
    }
}
