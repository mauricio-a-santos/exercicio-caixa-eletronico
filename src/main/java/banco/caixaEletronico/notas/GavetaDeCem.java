package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

import javax.swing.*;

public class GavetaDeCem extends Gavetas {

    private int cem = 0;
    private int contSaqCem = 0;

    Gavetas gaveta = new Gavetas();


    public int getCem() {
        return cem;
    }

    public void setCem(int cem) {
        this.cem = cem;
    }

    public int getContSaqCem() {
        return contSaqCem;
    }

    public void setContSaqCem(int contSaqCem) {
        this.contSaqCem = contSaqCem;
    }


    public void sacar(int valor) {
        // while ((valor >= 100) && (this.getCem() < 3)) {

        //  valor -= 100;
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 100);
        this.setCem(this.getCem() + 1);
        this.setContSaqCem(this.getContSaqCem() + 1);


        // }
    }

    public void retiraDoValorTotalDasGavetas(Gavetas gaveta) {
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 100);
    }

    public void printSingular() {
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqCem() + " NOTA DE 100 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqCem(0);
    }

    public void printPlural() {
        JOptionPane.showMessageDialog(null,
                "VOCÊ RECEBEU " + this.getContSaqCem() + " NOTAS" + " DE 100 REAIS",
                "SAQUE REALIZADO COM SUCESSO",
                JOptionPane.INFORMATION_MESSAGE);
        this.setContSaqCem(0);
    }

}


