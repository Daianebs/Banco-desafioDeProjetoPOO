package edu.daianebs;

public class ContaPoupanca extends Conta {
    private final double taxaRendimento;

    public ContaPoupanca(Cliente cliente, double taxaRendimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public void renderJuros() {
        double juros = this.getSaldo() * taxaRendimento;
        this.depositar(juros);
        System.out.printf("Rendimentos de R$%.2f aplicados na conta Poupança. Novo saldo: R$%.2f.%n", juros,
            this.getSaldo());
    }

    @Override
    protected void imprimirInfosComuns() {
        super.imprimirInfosComuns();
        System.out.println(String.format("Taxa de Rendimento: %.2f%%", this.taxaRendimento * 100));
    }
}