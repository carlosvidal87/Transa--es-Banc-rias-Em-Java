//Carlos Eduardo Vidal - 2210100600
//Atividade Semipresencial 1 - POO

import java.text.*;
import java.util.*;

public class Main {
    private static int proximoNumeroConta = 1;
    private static DecimalFormat decimalFormat = new DecimalFormat("R$0.00");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clientes clientes = new Clientes();
        Contas contas = new Contas();
        LogDeTransacoes logDeTransacoes = new LogDeTransacoes();

        while (true) {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Transferência entre contas");
            System.out.println("2. Depósito numa conta");
            System.out.println("3. Retirada de uma conta");
            System.out.println("4. Mostrar log de transações");
            System.out.println("5. Criar Cliente e Conta");
            System.out.println("6. Mostrar Clientes");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Transferência entre contas
                    System.out.println("===== Transferência entre Contas =====");
                    System.out.print("Digite o CPF do cliente de origem: ");
                    String cpfOrigem = scanner.nextLine();
                    Cliente clienteOrigem = clientes.encontrarCliente(cpfOrigem);

                    if (clienteOrigem == null) {
                        System.out.println("Cliente de origem não encontrado.");
                        break;
                    }

                    System.out.print("Digite o CPF do cliente de destino: ");
                    String cpfDestino = scanner.nextLine();
                    Cliente clienteDestino = clientes.encontrarCliente(cpfDestino);

                    if (clienteDestino == null) {
                        System.out.println("Cliente de destino não encontrado.");
                        break;
                    }

                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (valorTransferencia <= 0) {
                        System.out.println("O valor da transferência deve ser maior que zero.");
                        break;
                    }

                    Conta contaOrigem = contas.encontrarContaPorCliente(clienteOrigem);
                    Conta contaDestino = contas.encontrarContaPorCliente(clienteDestino);

                    if (contaOrigem == null || contaDestino == null) {
                        System.out.println("Conta de origem ou destino não encontrada.");
                        break;
                    }

                    Transacao transferencia = new Transacao(contaOrigem, contaDestino, valorTransferencia);
                    logDeTransacoes.adicionar(transferencia);
                    System.out.println("Transferência realizada com sucesso: " + decimalFormat.format(valorTransferencia));
                    break;

                case 2:
                    // Depósito numa conta
                    System.out.println("===== Depósito em Conta =====");
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfDeposito = scanner.nextLine();
                    Cliente clienteDeposito = clientes.encontrarCliente(cpfDeposito);

                    if (clienteDeposito == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    if (valorDeposito <= 0) {
                        System.out.println("O valor do depósito deve ser maior que zero.");
                        break;
                    }

                    Conta contaDeposito = contas.encontrarContaPorCliente(clienteDeposito);

                    if (contaDeposito == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }

                    Transacao deposito = new Transacao(contaDeposito, valorDeposito);
                    logDeTransacoes.adicionar(deposito);
                    System.out.println("Depósito realizado com sucesso: " + decimalFormat.format(valorDeposito));
                    break;

                case 3:
                    // Retirada de uma conta
                    System.out.println("===== Retirada de Conta =====");
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfRetirada = scanner.nextLine();
                    Cliente clienteRetirada = clientes.encontrarCliente(cpfRetirada);

                    if (clienteRetirada == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Digite o valor a ser retirado: ");
                    double valorRetirada = scanner.nextDouble();
                    scanner.nextLine();

                    Conta contaRetirada = contas.encontrarContaPorCliente(clienteRetirada);

                    if (contaRetirada == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }

                    if (valorRetirada <= 0 || valorRetirada > contaRetirada.saldoAtual()) {
                        System.out.println("Valor inválido ou saldo insuficiente para retirada.");
                        break;
                    }

                    Transacao retirada = new Transacao(contaRetirada, -valorRetirada);
                    logDeTransacoes.adicionar(retirada);
                    System.out.println("Retirada realizada com sucesso: " + decimalFormat.format(valorRetirada));
                    break;

                case 4:
                    // Mostrar log de transações
                    System.out.println("===== Log de Transações =====");
                    String listaTransacoes = logDeTransacoes.listarTransacoes();
                    System.out.println(listaTransacoes);
                    break;

                case 5:
                    // Criar Cliente e Conta
                    System.out.println("===== Criar Cliente e Conta =====");
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nomeCliente, cpfCliente);
                    clientes.adicionarCliente(novoCliente);

                    String numeroConta = String.format("%04d", proximoNumeroConta++);
                    System.out.print("Digite o saldo inicial da conta: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine();

                    Conta novaConta = new Conta(numeroConta, saldoInicial, novoCliente);
                    contas.adicionarConta(novaConta);

                    System.out.println("Cliente e Conta criados com sucesso.");
                    System.out.println("Seu numero de conta é #" + String.format("%04d", proximoNumeroConta-1));
                    break;

                case 6:
                    // Mostrar Clientes
                    System.out.println("===== Lista de Clientes =====");
                    for (Cliente cliente : clientes.getClientes()) {
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCPF());
                        Conta contaCliente = contas.encontrarContaPorCliente(cliente);
                        System.out.println("Número da Conta: " + contaCliente.numeroConta());
                        System.out.println("Saldo Atual: " + decimalFormat.format(contaCliente.saldoAtual()));
                        System.out.println();
                    }
                    break;

                case 7:
                    // Sair
                    System.out.println("Saindo do programa. Obrigado!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
