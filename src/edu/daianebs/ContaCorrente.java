package edu.daianebs;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println(String.format("Saque de R$%.2f realizado com sucesso. Saldo atual: R$%.2f.", valor, saldo));
        } else if (valor <= saldo + limiteChequeEspecial) {
            double valorUtilizadoChequeEspecial = valor - saldo;
            saldo = 0;
            limiteChequeEspecial -= valorUtilizadoChequeEspecial;
            System.out.println(String.format(
                "Saque de R$%.2f realizado com sucesso. Foi necessário utilizar R$%.2f do cheque especial. Saldo atual: R$%.2f. Limite de cheque especial restante: R$%.2f.",
                valor, valorUtilizadoChequeEspecial, saldo, limiteChequeEspecial));
        } else {
            System.out.println("Saque não realizado. Saldo e limite de cheque especial insuficientes.");
        }
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    @Override
    protected void imprimirInfosComuns() {
        super.imprimirInfosComuns();
        System.out.println(String.format("Limite Cheque Especial: %.2f", this.limiteChequeEspecial));
    }
}