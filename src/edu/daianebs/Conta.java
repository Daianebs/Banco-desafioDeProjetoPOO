package edu.daianebs;

// Classe abstrata Conta que representa uma abstração de uma conta bancária
public abstract class Conta {
  protected double saldo;

  public void depositar(double valor) {
    saldo += valor;
    System.out.println(String.format("Depósito de R$%.2f realizado com sucesso. Saldo atual: R$%.2f.", valor, saldo));
  }

  public void sacar(double valor) {
    saldo -= valor;
    System.out.println(String.format("Saque de R$%.2f realizado com sucesso. Saldo atual: R$%.2f.", valor, saldo));
  }

  public double getSaldo() {
    return saldo;
  }

  // Método abstrato que será implementado pelas subclasses
  public abstract void transferir(Conta destino, double valor);
}