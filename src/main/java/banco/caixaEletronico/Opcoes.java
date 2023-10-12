package banco.caixaEletronico;

import banco.Conta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Opcoes {
    private int opcao;
    private int valor;
    private int escolha;
    Conta conta = new Conta();

    public void operacoes(Conta conta) {

        String operacoes = """
                |--------------------------------------------------|
                |          OPERAÇÕES DO CAIXA ELETRÔNICO           |
                |--------------------------------------------------|
                |               1 - Consultar saldo                |
                |               2 - Depositar                      |
                |               3 - sacar                          |
                |               4 - Sair                           |
                |--------------------------------------------------|
                """;
        System.out.println(operacoes);
        System.out.println("DIGITE A OPÇÃO DESEJADA:");
        telaInicial();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.printf("\nSEU SALDO ATUAL É DE R$%.2f%n\n", conta.getSaldo());
                    break;
                case 2:
                    conta.depositar(valor);
                    break;
                case 3:
                    opcoesDeSaque(conta);
                    break;
                default:
                    System.out.println("DIGITO INCORRETO!");
            }

            System.out.println(operacoes);
            System.out.println("DIGITE A OPÇÃO DESEJADA:");
            telaInicial();

        }
        System.out.println("OPERAÇÃO FINALIZADA COM SUCESSO");

    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    private void telaInicial() {
        try {
            this.setOpcao(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
        }

    }

    private void opcoesDeSaque(Conta conta){
        System.out.println("\n=============================================");
        System.out.println("||       ESCOLHA UMA OPÇÃO DE SAQUE:       ||");
        String opcoesDeSaque = """
                                =============================================
                                ||           1 - R$10,00                   ||
                                ||           2 - R$20,00                   ||
                                ||           3 - R$50,00                   ||
                                ||           4 - R$100,00                  ||
                                ||           5 - OUTRO VALOR               ||
                                =============================================             
                                """;
        System.out.println(opcoesDeSaque);
        switch (escolha = new Scanner(System.in).nextInt()) {
            case 1:
                valor = 10;
                conta.sacar(valor);
                break;
            case 2:
                valor = 20;
                conta.sacar(valor);
                break;
            case 3:
                valor = 50;
                conta.sacar(valor);
                break;
            case 4:
                valor = 100;
                conta.sacar(valor);
                break;
            case 5:
                System.out.println("DIGITE O VALOR DO SAQUE: ");
                valor = new Scanner(System.in).nextInt();
                conta.sacar(valor);
                break;
        }

    }

}
