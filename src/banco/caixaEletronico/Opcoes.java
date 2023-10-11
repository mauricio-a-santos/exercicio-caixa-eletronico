package banco.caixaEletronico;

import banco.Conta;
import banco.caixaEletronico.notas.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Opcoes {
    private int opcao;
    private int valor;
    public void operacoes(Conta conta) {

        String operacoes = """
                **************************************************
                Operações
                                
                1 - Consultar saldo
                2 - Depósito
                3 - SAQUE
                4 - Sair
                """;

        System.out.println(operacoes);
        System.out.println("DIGITE A OPÇÃO DESEJADA:");
        telaInicial();
        while (opcao != 4) {

            switch (opcao) {
                case 1:
                    System.out.printf("SEU SALDO ATUAL É DE R$%.2f%n", conta.getSaldo());
                    break;
                case 2:
                    conta.depositar(valor);
                    break;
                case 3:
                    conta.sacar(valor);
                    break;
                default:
                    System.out.println("DIGITO INCORRETO!");
            }

           /* System.out.println("GAVETA DE 2: " + dois.getDois());
            System.out.println("GAVETA DE 5: " + cinco.getCinc());
            System.out.println("GAVETA DE 10: " + dez.getDez());
            System.out.println("GAVETA DE 20: " + vinte.getVin());
            System.out.println("GAVETA DE 50: " + cinquenta.getCinq());*/
            //System.out.println("CONTAGEM GAVETA DE 100: " + cem.getCem());

            System.out.println(operacoes);
            System.out.println("DIGITE A OPÇÃO DESEJADA:");
            telaInicial();

        }
        System.out.println("OPERAÇÃO FINALIZADA COM SUCESSO");

    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void telaInicial(){
        try {
            this.setOpcao(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
            //System.out.println("ERRO! DÍGITO INVÁLIDO");
        }

    }

}
