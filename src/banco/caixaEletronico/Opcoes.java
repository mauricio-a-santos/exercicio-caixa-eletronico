package banco.caixaEletronico;

import banco.Conta;
import banco.caixaEletronico.notas.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Opcoes {

    private int digito;
    private int opcao;
    public void operacoes(Conta conta) {

        Gavetas gaveta = new Gavetas();
        GavetaDeDois dois = new GavetaDeDois();
        GavetaDeCinco cinco = new GavetaDeCinco();
        GavetaDeDez dez = new GavetaDeDez();
        GavetaDeVinte vinte = new GavetaDeVinte();
        GavetaDeCinquenta cinquenta = new GavetaDeCinquenta();
        GavetaDeCem cem = new GavetaDeCem();

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
                case 0:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
                case 1:
                    System.out.printf("SEU SALDO ATUAL É DE R$%.2f%n", conta.getSaldo());
                    break;
                case 2:
                    int valor = 0;
                    System.out.println("DIGITE O VALOR DO DEPÓSITO: ");
                    conta.depositar(valor);
                    break;
                case 3:
                    System.out.println("DIGITE O VALOR DO SAQUE: ");
                    valor = new Scanner(System.in).nextInt();
                    if ((valor <= conta.getSaldo()) && (gaveta.getValorTotalGavetas() >= valor)) {
                        conta.setSaldo(conta.getSaldo() - valor);
                        while ((valor >= 100) && (cem.getCem() < 3)) {

                            //cem.sacar(valor);
                            valor -= 100;
                            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 100);
                            cem.setCem(cem.getCem() + 1);
                            cem.setContSaqCem(cem.getContSaqCem() + 1);


                        }
                        while ((valor >= 50) && (cinquenta.getCinq() < 3)) {

                            //cinquenta.sacar(valor);
                            valor -= 50;
                            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 50);
                            cinquenta.setCinq(cinquenta.getCinq() + 1);
                            cinquenta.setContSaqCinq(cinquenta.getContSaqCinq() + 1);
                        }
                        while ((valor >= 20) && (vinte.getVin() < 3)) {

                            //vinte.sacar(valor);
                            valor -= 20;
                            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 20);
                            vinte.setVin(vinte.getVin() + 1);
                            vinte.setContSaqVin(vinte.getContSaqVin() + 1);
                        }
                        while ((valor >= 10) && (dez.getDez() < 3)) {

                            //dez.sacar(valor);
                            valor -= 10;
                            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 10);
                            dez.setDez(dez.getDez() + 1);
                            dez.setContSaqDez(dez.getContSaqDez() + 1);
                        }
                        while ((valor >= 5) && (cinco.getCinc() < 3)) {

                            //cinco.sacar(valor);
                            valor -= 5;
                            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 5);
                            cinco.setCinc(cinco.getCinc() + 1);
                            cinco.setContSaqCinc(cinco.getContSaqCinc() + 1);
                        }
                        while ((valor >= 2) && (dois.getDois() < 3)) {

                            //dois.sacar(valor);
                            valor -= 2;
                            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 2);
                            dois.setDois(dois.getDois() + 1);
                            dois.setContSaqDois(dois.getContSaqDois() + 1);
                        }
                        System.out.println("SAQUE REALIZADO COM SUCESSO!");
                        //System.out.println("RESTAM NAS GAVETAS " + gaveta.getValorTotalGavetas() + " REAIS");
                        System.out.println("VOCÊ RECEBEU:");
                        if ((cem.getCem() <= 1) && cem.getContSaqCem() == 1) {
                            cem.printSingular();
                        } else if ((cem.getCem() > 1) && cem.getContSaqCem() != 0) {
                            cem.printPlural();
                        }
                        if ((cinquenta.getCinq() <= 1) && cinquenta.getContSaqCinq() == 1) {
                            cinquenta.printSingular();
                        } else if ((cinquenta.getCinq() > 1) && cinquenta.getContSaqCinq() != 0) {
                            cinquenta.printPlural();
                        }
                        if ((vinte.getVin() <= 1) && vinte.getContSaqVin() == 1) {
                            vinte.printSingular();
                        } else if ((vinte.getVin() > 1) && vinte.getContSaqVin() != 0) {
                            vinte.printPlural();
                        }
                        if ((dez.getDez() <= 1) && dez.getContSaqDez() == 1) {
                            dez.printSingular();
                        } else if ((dez.getDez() > 1) && dez.getContSaqDez() != 0) {
                            dez.printPlural();
                        }
                        if ((cinco.getCinc() <= 1) && cinco.getContSaqCinc() == 1) {
                            cinco.printSingular();
                        } else if ((cinco.getCinc() > 1) && cinco.getContSaqCinc() != 0) {
                            cinco.printPlural();
                        }
                        if ((dois.getDois() <= 1) && dois.getContSaqDois() == 1) {
                            dois.printSingular();
                        } else if ((dois.getDois() > 1) && dois.getContSaqDois() != 0) {
                            dois.printPlural();
                        }

                        if (conta.getSaldo() == 1) {
                            System.out.println("RESTA 1 REAL NA SUA CONTA!");
                        }
                        System.out.printf("SEU SALDO ATUAL É DE R$%.2f%n", conta.getSaldo());
                    } else {
                        System.out.println("SALDO INSUFICIENTE!");
                    }
                    break;
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

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void telaInicial(){
        try {
            this.setDigito(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
            System.out.println("ERRO! DÍGITO INVÁLIDO");
        }
        if (this.getDigito() < 5) {
            this.setOpcao(digito);

        } else {
            System.out.println("ERRO! ESCOLHA UM NÚMERO ENTRE 1 E 4!");
        }
        this.digito = 0;
    }

}
