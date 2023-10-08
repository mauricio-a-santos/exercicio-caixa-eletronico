package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

public class GavetaDeCinco extends Gavetas {

    int cinc = 0;
    int contSaqCinc = 0;

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

    /*public void sacar(int valor) {
        valor -= 5;
        this.setCinc(this.getCinc() + 1);
        this.setContSaqCinc(this.getContSaqCinc() + 1);
        super.setValorTotalGavetas(super.getValorTotalGavetas() - 5);
    }*/

    public void printSingular(){

        System.out.println(this.getContSaqCinc() + " NOTA DE 5 REAIS");
        this.setContSaqCinc(0);

    }

    public void printPlural(){

        System.out.println(this.getContSaqCinc() + " NOTAS DE 5 REAIS");
        this.setContSaqCinc(0);

    }
}
