import java.util.*;

public class Clientes{

    private ArrayList<Cliente> clientes = new ArrayList<>(); //cria vetor de clietes

    public void adicionarCliente(Cliente cliente){ //função de adicionar clientes
        clientes.add(cliente);
    }

    public Cliente encontrarCliente(String CPF){ //função para achar cliente pelo CPF
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(CPF)) {
                return cliente;
            }
        }
        return null; //Se não encontrar retorna NULL
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}   