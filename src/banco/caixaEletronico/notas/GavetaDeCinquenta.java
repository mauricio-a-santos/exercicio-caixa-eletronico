package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

public class GavetaDeCinquenta extends Gavetas {

    int cinq = 0;
    int contSaqCinq = 0;
    Gavetas gaveta = new Gavetas();

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

    public int sacar(int valor) {
       // while ((valor >= 50) && (this.getCinq() < 3)) {

           // valor -= 50;
            gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 50);
            this.setCinq(this.getCinq() + 1);
            this.setContSaqCinq(this.getContSaqCinq() + 1);


       // }
        return valor;
    }

    public Gavetas retiraDoValorTotalDasGavetas(Gavetas gaveta) {
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 50);
        return gaveta;
    }

    public void printSingular(){

        System.out.println(this.getContSaqCinq() + " NOTA DE 50 REAIS");
        this.setContSaqCinq(0);

    }

    public void printPlural(){

        System.out.println(this.getContSaqCinq() + " NOTAS DE 50 REAIS");
        this.setContSaqCinq(0);

    }
}
