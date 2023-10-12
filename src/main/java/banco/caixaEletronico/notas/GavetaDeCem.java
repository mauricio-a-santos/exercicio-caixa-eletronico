package banco.caixaEletronico.notas;

import banco.caixaEletronico.Gavetas;

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


    public int sacar(int valor) {
        // while ((valor >= 100) && (this.getCem() < 3)) {

        //  valor -= 100;
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 100);
        this.setCem(this.getCem() + 1);
        this.setContSaqCem(this.getContSaqCem() + 1);


        // }
        return valor;
    }

    public Gavetas retiraDoValorTotalDasGavetas(Gavetas gaveta) {
        gaveta.setValorTotalGavetas(gaveta.getValorTotalGavetas() - 100);
        return gaveta;
    }

    public void printSingular() {

        System.out.println(this.getContSaqCem() + " NOTA DE 100 REAIS");
        this.setContSaqCem(0);

    }

    public void printPlural() {

        System.out.println(this.getContSaqCem() + " NOTAS DE 100 REAIS");
        this.setContSaqCem(0);

    }

}


