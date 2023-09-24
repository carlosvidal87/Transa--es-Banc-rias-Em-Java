import java.util.ArrayList;

public class LogDeTransacoes {
    private ArrayList<Transacao> transacoes;

    public LogDeTransacoes() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionar(Transacao trans) {
        transacoes.add(trans);
    }

    public String listarTransacoes() {
        StringBuilder lista = new StringBuilder("Lista de Transações:\n");

        for (Transacao transacao : transacoes) {
            lista.append("Tipo: ").append(transacao.getTipo()).append("\n");
            lista.append("Contas envolvidas: ");
            
            ArrayList<Conta> contas = transacao.getContas();
            for (Conta conta : contas) {
                lista.append(conta.numeroConta()).append(" ");
            }
            lista.append("\n");

            lista.append("Valor: R$").append(transacao.getValor()).append("\n\n");
        }

        return lista.toString();
    }
}
