package banco;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class CaixaEletronicoPainel {

    private Conta conta;

    public CaixaEletronicoPainel(Conta conta) {
        this.conta = conta;
    }

    public void exibirPainelBoasVindas() {
        solicitarDadosAberturaConta();

        lerTitularConta();
    }

    private void lerTitularConta() {
        boolean titularContaValido;

        do {
            String titularConta = JOptionPane.showInputDialog(null,
                    "TITULAR DA CONTA: ",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE);

            titularContaValido = conta.validarTitularConta(titularConta);

            if(!titularContaValido) {
                exibirMensagemTitularInvalido();
            }
        } while(!titularContaValido);
   }

    private void exibirMensagemTitularInvalido() {
        showMessageDialog(null,
                "O TITULAR DA CONTA DEVE SER PREENCHIDO E NÃO PODE TER MAIS DE 30 CARACTERES",
                " TITULAR INVÁLIDO INFORMADO ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void solicitarDadosAberturaConta() {
        showMessageDialog(null,
                "DIGITE SEUS DADOS PARA ABERTURA DE CONTA",
                " SEJA BEM-VINDO(A) AO BANCO MSA ",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
