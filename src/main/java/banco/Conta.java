package banco;

import banco.caixaEletronico.Gavetas;
import banco.caixaEletronico.notas.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

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
        showMessageDialog(null,
                "DIGITE SEUS DADOS PARA ABERTURA DE CONTA",
                " SEJA BEM-VINDO(A) AO BANCO MSA ",
                JOptionPane.INFORMATION_MESSAGE);

        this.titular = JOptionPane.showInputDialog(null,
                "TITULAR DA CONTA: ",
                "BANCO MSA",
                JOptionPane.INFORMATION_MESSAGE);

        try {
            while (this.getTitular().length() > 30) {
                showMessageDialog(null,
                        "Favor, digite um nome válido!!",
                        "ERRO!",
                        JOptionPane.ERROR_MESSAGE);
                this.titular = JOptionPane.showInputDialog(null,
                        "TITULAR DA CONTA: ",
                        "BANCO MSA",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException titularVazio) {
            showMessageDialog(null,
                    "OPERAÇÃO CANCELADA!!",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        try {
            this.tipo = JOptionPane.showInputDialog(null,
                    "DIGITE [cc] PARA CONTA CORRENTE OU [cp] PARA CONTA POUPANÇA: ",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE).toLowerCase();

            while (!this.getTipo().equals("cc") && !this.getTipo().equals("cp")) {
                showMessageDialog(null,
                        "DÍGITO INVÁLIDO!",
                        "ERRO!",
                        JOptionPane.ERROR_MESSAGE);
                this.tipo = JOptionPane.showInputDialog(null,
                        "DIGITE [cc] PARA CONTA CORRENTE OU [cp] PARA CONTA POUPANÇA: ",
                        "BANCO MSA",
                        JOptionPane.INFORMATION_MESSAGE).toLowerCase();
            }
        } catch (NullPointerException tipoVazio) {
            showMessageDialog(null,
                    "OPERAÇÃO CANCELADA!!",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void status() {
        showMessageDialog(null,
                String.format("Você recebeu um presente de R$%.2f na sua " + this.getTipo().toLowerCase(), this.getSaldo()),
                this.getTipo() + " ABERTA COM SUCESSO!",
                JOptionPane.INFORMATION_MESSAGE);

        showMessageDialog(null,
                String.format("TITULAR: " + this.getTitular() +
                        "\nTIPO DE CONTA: " + this.getTipo().toLowerCase() +
                        "\nSALDO: R$%.2f%n ", this.getSaldo()),
                "STATUS DA CONTA",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void depositar(int valor) {
        try {
            valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "DIGITE O VALOR DO DEPÓSITO",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE));
            this.setSaldo(this.getSaldo() + valor);
            JOptionPane.showMessageDialog(null,
                    String.format("SEU SALDO ATUAL É DE R$%.2f", this.getSaldo()),
                    "DEPÓSITO REALIZADO COM SUCESSO!",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException n){
            JOptionPane.showMessageDialog(null,
                    "APENAS NÚMEROS INTEIROS SÃO VÁLIDOS",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void sacar(int valor) {

        if ((valor <= this.getSaldo()) && (gaveta.getValorTotalGavetas() >= valor)) {
            this.setSaldo(this.getSaldo() - valor);

            contarNotas(valor);
            imprimeRecibos();

            if (this.getSaldo() == 1) {
                JOptionPane.showMessageDialog(null,
                        "RESTA 1 REAL NA SUA CONTA!",
                        "BANCO MSA",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(null,
                    String.format("SEU SALDO ATUAL É DE R$%.2f", this.getSaldo()),
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "SALDO INSUFICIENTE!",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void contarNotas(int valor){

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
    }

    public void imprimeRecibos(){
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

    }
}
