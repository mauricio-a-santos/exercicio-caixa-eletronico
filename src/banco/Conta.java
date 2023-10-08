package banco;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Conta {
    private String titular;
    private String tipo;
    private double saldo;

    public Conta(String titular, String tipo) {
        this.titular = titular;
        this.tipo = tipo;
    }
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
    public void boasVindas(){
        System.out.println("\n*** BEM-VINDO(A) AO BANCO MSA ***");
        System.out.println("DIGITE SEUS DADOS PARA ABERTURA DE CONTA");
        System.out.println("\nTITULAR DA CONTA: ");
        this.titular = new Scanner(System.in).nextLine();
        System.out.println("DIGITE 'cc' PARA CONTA CORRENTE OU 'cp' PARA CONTA POUPANÇA: ");
        this.tipo = new Scanner(System.in).next();
    }
    public void status(){
        System.out.println("**************************************************");
        System.out.println("=== " + this.getTipo() + " ABERTA COM SUCESSO! ===");
        System.out.printf(">> Você recebeu um presente de R$%.2f na sua " + this.getTipo().toLowerCase() + " <<%n", this.getSaldo());
        System.out.println("TITULAR DA CONTA: " + this.getTitular());
        System.out.println("TIPO DA CONTA: " + this.getTipo());
        System.out.printf("SALDO: R$%.2f%n", this.getSaldo());
        System.out.println("**************************************************\n");
    }

    public void depositar(int valor){
        try {
            valor = new Scanner(System.in).nextInt();
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("\nDEPÓSITO REALIZADO COM SUCESSO!");
            System.out.printf("SEU SALDO ATUAL É DE R$%.2f%n\n", this.getSaldo());
        } catch (InputMismatchException e) {
            System.out.println("\n>> ERRO! APENAS NÚMEROS INTEIROS SÃO VÁLIDOS! <<\n");
        }
    }

}
