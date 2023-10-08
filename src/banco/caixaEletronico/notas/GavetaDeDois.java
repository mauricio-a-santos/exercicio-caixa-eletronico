package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

public class GavetaDeDois extends Gavetas {

    int dois = 0;
    int contSaqDois = 0;

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

    /*public void sacar(int valor) {
        valor -= 2;
        this.setDois(this.getDois() + 1);
        this.setContSaqDois(this.getContSaqDois() + 1);
        super.setValorTotalGavetas(super.getValorTotalGavetas() - 2);
    }*/

    public void printSingular(){

        System.out.println(this.getContSaqDois() + " NOTA DE 2 REAIS");
        this.setContSaqDois(0);

    }

    public void printPlural(){

        System.out.println(this.getContSaqDois() + " NOTAS DE 2 REAIS");
        this.setContSaqDois(0);

    }
}
