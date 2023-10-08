package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

public class GavetaDeDez extends Gavetas {

    int dez = 0;
    int contSaqDez = 0;

    public int getDez() {
        return dez;
    }

    public void setDez(int dez) {
        this.dez = dez;
    }

    public int getContSaqDez() {
        return contSaqDez;
    }

    public void setContSaqDez(int contSaqDez) {
        this.contSaqDez = contSaqDez;
    }

    /*public void sacar(int valor) {
        valor -= 10;
        this.setDez(this.getDez() + 1);
        this.setContSaqDez(this.getContSaqDez() + 1);
        super.setValorTotalGavetas(super.getValorTotalGavetas() - 10);
    }*/

    public void printSingular(){

        System.out.println(this.getContSaqDez() + " NOTA DE 10 REAIS");
        this.setContSaqDez(0);

    }

    public void printPlural(){

        System.out.println(this.getContSaqDez() + " NOTAS DE 10 REAIS");
        this.setContSaqDez(0);

    }
}
