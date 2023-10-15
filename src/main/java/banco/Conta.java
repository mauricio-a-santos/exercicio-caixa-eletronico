package banco;

import banco.caixaEletronico.Gavetas;
import banco.caixaEletronico.notas.*;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta {
    public Conta() {
    }

    private String titular;
    private String tipo;
    private double saldo;

   private final Gavetas gaveta = new Gavetas();
   private final GavetaDeDois dois = new GavetaDeDois();
    private final GavetaDeCinco cinco = new GavetaDeCinco();
    private final GavetaDeDez dez = new GavetaDeDez();
    private final GavetaDeVinte vinte = new GavetaDeVinte();
    private final GavetaDeCinquenta cinquenta = new GavetaDeCinquenta();
    private final GavetaDeCem cem = new GavetaDeCem();


       public String getTitular() {
        return titular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void abrirConta() {
        if (this.getTipo().equals("cc")) {
            this.setTipo("Conta Corrente".toUpperCase());
            this.setSaldo(2500.00);
        } else if (this.getTipo().equals("cp")) {
            this.setTipo("Conta Poupança".toUpperCase());
            this.setSaldo(1000.00);
        }
    }

    public void boasVindas() {
        System.out.println("\n-------------------------------------");
        System.out.println("| *** BEM-VINDO(A) AO BANCO MSA *** |");
        System.out.println("-------------------------------------\n");
        System.out.println("DIGITE SEUS DADOS PARA ABERTURA DE CONTA");

        this.titular = JOptionPane.showInputDialog("\nTITULAR DA CONTA: ");
        while (this.getTitular().length() > 30){
            System.out.println("Favor, digite um nome válido!!");
            this.titular = JOptionPane.showInputDialog("\nTITULAR DA CONTA: ");
        }
        this.tipo  = JOptionPane.showInputDialog("DIGITE [cc] PARA CONTA CORRENTE OU [cp] PARA CONTA POUPANÇA: ").toLowerCase();
        while (!this.getTipo().equals("cc") && !this.getTipo().equals("cp")){
            System.out.println("DÍGITO INVÁLIDO!");
            this.tipo  = JOptionPane.showInputDialog("DIGITE [cc] PARA CONTA CORRENTE OU [cp] PARA CONTA POUPANÇA: ").toLowerCase();
        }
    }

    public void status() {
        System.out.println("\n*****************************************************************");
        System.out.println("=== " + this.getTipo() + " ABERTA COM SUCESSO! ===");
        System.out.printf(">> Você recebeu um presente de R$%.2f na sua " + this.getTipo().toLowerCase() + " <<%n\n", this.getSaldo());
        System.out.println("TITULAR DA CONTA: " + this.getTitular());
        System.out.println("TIPO DA CONTA: " + this.getTipo());
        System.out.printf("SALDO: R$%.2f%n", this.getSaldo());
        System.out.println("*****************************************************************\n");
    }

    public void depositar(int valor) {
        System.out.println("\nDIGITE O VALOR DO DEPÓSITO: ");
        try {
            valor = new Scanner(System.in).nextInt();
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("\nDEPÓSITO REALIZADO COM SUCESSO!");
            System.out.printf("\nSEU SALDO ATUAL É DE R$%.2f%n\n", this.getSaldo());
        } catch (InputMismatchException e) {
            System.out.println("\n>> ERRO! APENAS NÚMEROS INTEIROS SÃO VÁLIDOS! <<\n");
        }
    }

    public void sacar(int valor) {
        if ((valor <= this.getSaldo()) && (gaveta.getValorTotalGavetas() >= valor)) {
            this.setSaldo(this.getSaldo() - valor);
            //var valorRestante = cem.sacar(valor);
            while ((valor >= 100) && (cem.getCem() < 4)) {

                cem.sacar(valor);
                valor -= 100;
                cem.retiraDoValorTotalDasGavetas(gaveta);


            }
            while ((valor >= 50) && (cinquenta.getCinq() < 4)) {

                cinquenta.sacar(valor);
                valor -= 50;
                cinquenta.retiraDoValorTotalDasGavetas(gaveta);
            }
            while ((valor >= 20) && (vinte.getVin() < 4)) {

                vinte.sacar(valor);
                valor -= 20;
                vinte.retiraDoValorTotalDasGavetas(gaveta);
            }
            while ((valor >= 10) && (dez.getDez() < 4)) {

                dez.sacar(valor);
                valor -= 10;
                dez.retiraDoValorTotalDasGavetas(gaveta);
            }
            while ((valor >= 5) && (cinco.getCinc() < 4)) {

                cinco.sacar(valor);
                valor -= 5;
                cinco.retiraDoValorTotalDasGavetas(gaveta);
            }
            while ((valor >= 2) && (dois.getDois() < 4)) {

                dois.sacar(valor);
                valor -= 2;
                dois.retiraDoValorTotalDasGavetas(gaveta);
            }

            System.out.println("\nSAQUE REALIZADO COM SUCESSO!");
            //System.out.println("RESTAM NAS GAVETAS " + gaveta.getValorTotalGavetas() + " REAIS");
            System.out.println("\nVOCÊ RECEBEU:");
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

            if (this.getSaldo() == 1) {
                System.out.println("\nRESTA 1 REAL NA SUA CONTA!\n");
            }
            System.out.printf("\nSEU SALDO ATUAL É DE R$%.2f%n\n", this.getSaldo());
        } else {
            System.out.println("\nSALDO INSUFICIENTE!\n");
        }

    }
}
