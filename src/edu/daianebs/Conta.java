package edu.daianebs;

public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 11234;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println(String.format("Saque de R$%.2f realizado com sucesso. Saldo atual: R$%.2f.", valor, saldo));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser positivo.");
        }
        if (valor <= saldo) {
          System.out.println("Informações da transferencia...");
            this.sacar(valor);
            destino.depositar(valor);
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente na conta.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}