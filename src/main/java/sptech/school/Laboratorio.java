package sptech.school;

import sptech.school.exception.ArgumentoInvalidoException;
import sptech.school.exception.VacinaInvalidaException;
import sptech.school.exception.VacinaNaoEncontradaException;

import java.time.LocalDate;
import java.util.*;

public class Laboratorio {
    private String nome;
    private List<Vacina> vacinas;

    public Laboratorio(String nome, List<Vacina> vacinas) {
        this.nome = nome;
        this.vacinas = vacinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void adicionarVacina(Vacina vacina) {
        if (vacina == null) {
            throw new VacinaInvalidaException("A vacina a ser adicionada não pode ser nulo");
        }
        if (vacina.getCodigo() == null || vacina.getCodigo().isEmpty()) {
            throw new VacinaInvalidaException("O código da vacina deve ser válido (não nulo e não vazio)");
        }
        if (vacina.getNome() == null || vacina.getNome().isEmpty()) {
            throw new VacinaInvalidaException("O nome da vacina deve ser válido (não nulo e não vazio)");
        }
        if (vacina.getTipo() == null || vacina.getTipo().isEmpty()) {
            throw new VacinaInvalidaException("O tipo da vacina deve ser válido (não nulo e não vazio)");
        }
        if (vacina.getPreco() == null || vacina.getPreco() <= 0) {
            throw new VacinaInvalidaException("O preço da vacina deve ser maior que zero e não nulo");
        }
        if (vacina.getEficacia() == null || vacina.getEficacia() < 0 || vacina.getEficacia() > 100) {
            throw new VacinaInvalidaException("A eficácia da vacina deve estar dentro do intervalo de 0 a 100");
        }
        if (vacina.getDataLancamento() == null || LocalDate.EPOCH.isAfter(LocalDate.now())) {
            throw new VacinaInvalidaException("A data de lançamento da vacina deve ser válida (não nula e não pode ser uma data futura)");
        } else {
            vacinas.add(vacina);
        }
    }

    public Vacina buscarVacinaPorCodigo(String codigo) {
        Vacina vacinaBuscada = null;
        if (codigo == null || codigo.isEmpty()) {
            throw new ArgumentoInvalidoException("O código fornecido não pode ser nulo, vazio ou em branco");
        }
        for (Vacina v : vacinas) {
            if (v.getCodigo().equals(codigo)) {
                vacinaBuscada = v;
            }
        }
        if (vacinaBuscada == null) {
            throw new VacinaNaoEncontradaException("Vacina não encontrada");
        }
        return vacinaBuscada;
    }

    public void removerVacinaPorCodigo(String codigo) {
        Vacina vacinaBuscada = null;
        if (codigo == null || codigo.isEmpty()) {
            throw new ArgumentoInvalidoException("O código fornecido não pode ser nulo, vazio ou em branco");
        }
        for (Vacina v : vacinas) {
            if (v.getCodigo().equals(codigo)) {
                vacinaBuscada = v;
                vacinas.remove(vacinaBuscada);
            }
        }
        if (vacinaBuscada == null) {
            throw new VacinaNaoEncontradaException("Vacina não encontrada");
        }
    }

    public Vacina buscarVacinaComMelhorEficacia() {
        Double eficacia = 0.0;
        Vacina maiorEficacia = null;

        if (vacinas.isEmpty()) {
            throw new VacinaNaoEncontradaException("Lista de vacinas vazia");
        } else {
            for (Vacina v : vacinas) {
                if (v.getEficacia() > eficacia) {
                    eficacia = v.getEficacia();
                    maiorEficacia = v;
                }
            }
        } return maiorEficacia;
    }

    public List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        List<Vacina> vacinasBuscadas = new ArrayList<>();
        if (dataInicio == null || dataFim == null || dataInicio.isAfter(dataFim)) {
            throw new ArgumentoInvalidoException("As datas de início ou fim não podem ser nulas, e a data de início não pode ser maior que a data de fim");
        }
        for (Vacina v : vacinas) {
            if (v.getDataLancamento().isAfter(dataInicio) && v.getDataLancamento().isBefore(dataFim)) {
                vacinasBuscadas.add(v);
            }
        }
        return vacinasBuscadas;
    }
}
