package banco;

import banco.caixaEletronico.Gavetas;
import banco.caixaEletronico.Opcoes;

public class Principal {
    public static void main(String[] args) {

        Conta conta = new Conta(null, null);
        conta.boasVindas();
        conta.abrirConta();
        conta.status();

        Opcoes opcoes = new Opcoes();
        opcoes.operacoes(conta);
    }


}