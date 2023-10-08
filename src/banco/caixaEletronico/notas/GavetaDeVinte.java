package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

public class GavetaDeVinte extends Gavetas {

    int vin = 0;
    int contSaqVin = 0;

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

    /*public void sacar(int valor) {
        valor -= 20;
        this.setVin(this.getVin() + 1);
        this.setContSaqVin(this.getContSaqVin() + 1);
        super.setValorTotalGavetas(super.getValorTotalGavetas() - 20);
    }*/

    public void printSingular(){

        System.out.println(this.getContSaqVin() + " NOTA DE 20 REAIS");
        this.setContSaqVin(0);

    }

    public void printPlural(){

        System.out.println(this.getContSaqVin() + " NOTAS DE 20 REAIS");
        this.setContSaqVin(0);

    }
}
