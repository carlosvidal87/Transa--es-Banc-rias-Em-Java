public class Conta {
    String numero;
    double saldo;
    Cliente titular;

    public Conta (String numero, double saldo, Cliente titular){
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso na Conta #" + numero);
        } else {
            System.out.println("O valor do depósito deve ser maior que zero.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada de R$" + valor + " realizada com sucesso na Conta #" + numero);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para retirada.");
        }
    }

    public double saldoAtual() {
        return saldo;
    }

    public String numeroConta() {
        return numero;
    }
    
}
