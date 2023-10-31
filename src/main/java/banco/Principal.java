package banco;

public class Principal {
    public static void main(String[] args) {
        Conta conta = new Conta();

        CaixaEletronicoPainel painel = new CaixaEletronicoPainel(conta);

        painel.exibirPainelBoasVindas();

//        conta.exibirPainelBoasVindas();
//        conta.abrirConta();
//        conta.status();
//
//        Opcoes opcoes = new Opcoes();
//        opcoes.operacoes(conta);
    }


}