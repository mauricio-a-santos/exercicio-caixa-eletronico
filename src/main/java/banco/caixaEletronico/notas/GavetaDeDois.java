package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

import javax.swing.*;

public class GavetaDeDois extends Gavetas {

    int dois = 0;
    int contSaqDois = 0;
    Gavetas gaveta = new Gavetas();

    public int getDois() {
        return dois;
    }

    public void setDois(int dois) {
        this.dois = dois;
    }

    public int getContSaqDois() {
        return contSaqDois;
    }

    public void setContSaqDois(int contSaqDois) {
        this.contSaqDois = contSaqDois;
    }

    public int sacar(int valor) {
       // while ((valor >= 2) && (this.getDois() < 3)) {

           // valor -= 2;
            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 2);
            this.setDois(this.getDois() + 1);
            this.setContSaqDois(this.getContSaqDois() + 1);


      //  }
        return valor;
    }

    public Gavetas retiraDoValorTotalDasGavetas(Gavetas gaveta) {
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 2);
        return gaveta;
    }

    public void printSingular(){
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqDois() + " NOTA" + " DE 2 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqDois(0);
    }

    public void printPlural(){
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqDois() + " NOTAS" + " DE 2 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqDois(0);
    }
}
