package edu.daianebs;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final String nome;
    private final List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            cliente.adicionarBanco(this);
        }
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public String getNome() {
        return nome;
    }
}
