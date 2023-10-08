package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

public class GavetaDeCinquenta extends Gavetas {

    int cinq = 0;
    int contSaqCinq = 0;

    public int getCinq() {
        return cinq;
    }

    public void setCinq(int cinq) {
        this.cinq = cinq;
    }

    public int getContSaqCinq() {
        return contSaqCinq;
    }

    public void setContSaqCinq(int contSaqCinq) {
        this.contSaqCinq = contSaqCinq;
    }

    /*public void sacar(int valor) {
        valor -= 50;
        this.setCinq(this.getCinq() + 1);
        this.setContSaqCinq(this.getContSaqCinq() + 1);
        super.setValorTotalGavetas(super.getValorTotalGavetas() - 50);
    }*/

    public void printSingular(){

        System.out.println(this.getContSaqCinq() + " NOTA DE 50 REAIS");
        this.setContSaqCinq(0);

    }

    public void printPlural(){

        System.out.println(this.getContSaqCinq() + " NOTAS DE 50 REAIS");
        this.setContSaqCinq(0);

    }
}
