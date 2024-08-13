package edu.daianebs;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nome;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private final List<Banco> bancos;

    public Cliente(String nome) {
        this.nome = nome;
        this.bancos = new ArrayList<>();
    }

    public void adicionarBanco(Banco banco) {
        if (!bancos.contains(banco)) {
            bancos.add(banco);
        }
    }

    public List<Banco> getBancos() {
        return new ArrayList<>(bancos);
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroContaCorrente() {
        return contaCorrente != null ? String.valueOf(contaCorrente.getNumero()) : "Nenhuma conta corrente";
    }

    public String getNumeroContaPoupanca() {
        return contaPoupanca != null ? String.valueOf(contaPoupanca.getNumero()) : "Nenhuma conta poupança";
    }

    public String getAgencia() {
        return contaCorrente != null ? String.valueOf(contaCorrente.getAgencia()) : 
               (contaPoupanca != null ? String.valueOf(contaPoupanca.getAgencia()) : "Nenhuma agência");
    }
}
