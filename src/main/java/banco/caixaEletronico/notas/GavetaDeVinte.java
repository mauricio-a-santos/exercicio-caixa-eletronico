package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

import javax.swing.*;

public class GavetaDeVinte extends Gavetas {

    int vin = 0;
    int contSaqVin = 0;
    Gavetas gaveta = new Gavetas();

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getContSaqVin() {
        return contSaqVin;
    }

    public void setContSaqVin(int contSaqVin) {
        this.contSaqVin = contSaqVin;
    }

    public int sacar(int valor) {
       // while ((valor >= 20) && (this.getVin() < 3)) {

          //  valor -= 20;
            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 20);
            this.setVin(this.getVin() + 1);
            this.setContSaqVin(this.getContSaqVin() + 1);


       // }
        return valor;
    }

    public Gavetas retiraDoValorTotalDasGavetas(Gavetas gaveta) {
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 20);
        return gaveta;
    }

    public void printSingular(){
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqVin() + " NOTA" + " DE 20 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqVin(0);
    }

    public void printPlural(){
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqVin() + " NOTAS" + " DE 20 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqVin(0);
    }
}
