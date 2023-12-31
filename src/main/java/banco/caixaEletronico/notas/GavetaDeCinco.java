package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

import javax.swing.*;

public class GavetaDeCinco extends Gavetas {

    int cinc = 0;
    int contSaqCinc = 0;
    Gavetas gaveta = new Gavetas();

    public int getCinc() {
        return cinc;
    }

    public void setCinc(int cinc) {
        this.cinc = cinc;
    }

    public int getContSaqCinc() {
        return contSaqCinc;
    }

    public void setContSaqCinc(int contSaqCinc) {
        this.contSaqCinc = contSaqCinc;
    }

    public int sacar(int valor) {
      //  while ((valor >= 5) && (this.getCinc() < 3)) {

           // valor -= 5;
            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 5);
            this.setCinc(this.getCinc() + 1);
            this.setContSaqCinc(this.getContSaqCinc() + 1);


       // }
        return valor;
    }

    public Gavetas retiraDoValorTotalDasGavetas(Gavetas gaveta) {
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 5);
        return gaveta;
    }

    public void printSingular(){
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqCinc() + " NOTA" + " DE 5 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqCinc(0);
    }

    public void printPlural(){
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqCinc() + " NOTAS" + " DE 5 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqCinc(0);
    }
}
