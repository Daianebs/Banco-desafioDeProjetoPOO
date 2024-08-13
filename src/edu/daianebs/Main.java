package edu.daianebs;

public class Main {
    public static void main(String[] args) {
        // Criando bancos
        Banco banco1 = new Banco("Banco Central");
        Banco banco2 = new Banco("Banco Virtual");

        // Criando clientes
        Cliente cliente1 = new Cliente("João Silva");
        Cliente cliente2 = new Cliente("Maria Oliveira");

        // Adicionando clientes

        banco1.adicionarCliente(cliente1);
        banco2.adicionarCliente(cliente2);

        // Criando contas
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, 1000);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente2, 0.02);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente1, 0.02);

        // Associando as contas aos clientes
        cliente1.setContaCorrente(contaCorrente1);
        cliente2.setContaPoupanca(contaPoupanca2);
        cliente1.setContaPoupanca(contaPoupanca1);

        // Mostrando informações das contas
        System.out.println(cliente1.getNome() + " - Informações da Conta Corrente:");
        contaCorrente1.imprimirInfosComuns();
        System.out.println("Informações da Conta Poupança:");
        contaPoupanca1.imprimirInfosComuns();

        System.out.println(cliente1.getNome() + " - Informações da Conta Poupança:");
        contaPoupanca2.imprimirInfosComuns();

        // Realizando operações bancárias
        System.out.println("Notificações de " + cliente1.getNome());
        contaCorrente1.depositar(500);
        contaCorrente1.sacar(200);
        contaCorrente1.transferir(cliente2.getContaPoupanca(), 300);

        System.out.println("Notificações de " + cliente2.getNome());
        contaPoupanca2.renderJuros();
        contaPoupanca2.transferir(cliente1.getContaCorrente(), 100);

        System.out.println(cliente1.getNome() + " tenta realizar um novo saque");
        contaCorrente1.sacar(1000);

        System.out.println(cliente2.getNome() + " tenta realizar um novo saque");
        contaPoupanca2.sacar(300);

        // Mostrando o saldo final de cada conta
        System.out
                .println("Saldo final da Conta Corrente de " + cliente1.getNome() + ": R$" + contaCorrente1.getSaldo());
        System.out
                .println("Saldo final da Conta Poupança de " + cliente2.getNome() + ": R$" + contaPoupanca2.getSaldo());

    }
}