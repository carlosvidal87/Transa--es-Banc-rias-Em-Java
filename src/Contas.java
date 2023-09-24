import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta encontrarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.numeroConta().equals(numero)) {
                return conta;
            }
        }
        return null; //Se não encontrar retorna NULL
    }

    public Conta encontrarContaPorCliente(Cliente cliente) {
        for (Conta conta : contas) {
            if (conta.titular.equals(cliente)) {
                return conta;
            }
        }
        return null;
    }

}
