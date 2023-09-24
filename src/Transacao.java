import java.util.*;

public class Transacao {
    private ArrayList<Conta> contas;
    private double valor;
    private TipoTransacao tipo;

    // Construtor para transferências
    public Transacao(Conta origem, Conta destino, double valor) {
        this.contas = new ArrayList<>();
        this.contas.add(origem);
        this.contas.add(destino);
        this.valor = valor;
        this.tipo = TipoTransacao.Transferencia;
        
        // Realizar a transferência passo a passo
        origem.retirar(valor);
        destino.depositar(valor);
    }

    // Construtor para depósitos ou retiradas
    public Transacao(Conta conta, double valor) {
        this.contas = new ArrayList<>();
        this.contas.add(conta);
        this.valor = valor;
        if (valor > 0) {
            this.tipo = TipoTransacao.Deposito;
            conta.depositar(valor);
        } else {
            this.tipo = TipoTransacao.Retirada;
            conta.retirar(Math.abs(valor));
        }
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public double getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }
}
