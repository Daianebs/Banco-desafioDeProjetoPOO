# Desafio de projeto Dio.me

Neste desafio, desenvolvemos uma solução orientada a objetos em Java para um sistema bancário simplificado. O sistema permite a gestão de clientes e suas contas, oferecendo dois tipos de contas: corrente e poupança. As principais funcionalidades incluem depósitos, saques e transferências entre contas.

* [Repositório no GitHub](https://github.com/falvojr/dio-live-20210802) (implementação de referência)

# Diagrama de Classes do Sistema Bancário

Aqui está o diagrama de classes que representa a estrutura do sistema bancário.

```mermaid
%% Diagrama C4 do programa de Contas Bancárias
%%{init: {"theme": "default"}}%%
classDiagram
    %% Definindo as classes
    class Conta {
        +int agencia
        +int numero
        +double saldo
        +Cliente cliente
        +void sacar(double valor)
        +void depositar(double valor)
        +void transferir(Conta destino, double valor)
        +int getAgencia()
        +int getNumero()
        +double getSaldo()
        +void imprimirInfosComuns()
    }

    class ContaCorrente {
        +double limiteChequeEspecial
        +double getLimiteChequeEspecial()
    }

    class ContaPoupanca {
        +double taxaRendimento
        +void renderJuros()
    }

    class Cliente {
        +String nome
        +ContaCorrente contaCorrente
        +ContaPoupanca contaPoupanca
        +List<Banco> bancos
        +void adicionarBanco(Banco banco)
        +List<Banco> getBancos()
        +void setContaCorrente(ContaCorrente contaCorrente)
        +void setContaPoupanca(ContaPoupanca contaPoupanca)
        +ContaCorrente getContaCorrente()
        +ContaPoupanca getContaPoupanca()
        +String getNome()
        +String getNumeroContaCorrente()
        +String getNumeroContaPoupanca()
        +String getAgencia()
    }

    class Banco {
        +String nome
        +List<Cliente> clientes
        +void adicionarCliente(Cliente cliente)
        +List<Cliente> getClientes()
        +String getNome()
    }

    %% Definindo as relações entre as classes
    Conta <|-- ContaCorrente : extends
    Conta <|-- ContaPoupanca : extends
    Cliente  "1" -- "0..1" ContaCorrente : possui >
    Cliente "1" -- "0..1" ContaPoupanca : possui >
    Cliente "0..*" -- "0..*" Banco : associado a
    Banco "1" -- "0..*" Cliente : tem




```
