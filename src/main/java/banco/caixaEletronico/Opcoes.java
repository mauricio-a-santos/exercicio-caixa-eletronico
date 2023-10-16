package banco.caixaEletronico;

import banco.Conta;

import javax.swing.*;

public class Opcoes {
    private int opcao;
    private int valor;

    public void operacoes(Conta conta) {
        try {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    """
                            DIGITE A OPÇÃO DESEJADA:                
                            1 - Consultar saldo
                            2 - Depositar
                            3 - sacar
                            4 - Sair 
                            """,
                    "OPERAÇÕES DO CAIXA ELETRÔNICO",
                    JOptionPane.INFORMATION_MESSAGE));

            while (opcao != 4) {
                switch (opcao) {
                    case 1 -> JOptionPane.showMessageDialog(null,
                            String.format("SEU SALDO ATUAL É DE R$%.2f", conta.getSaldo()),
                            "BANCO MSA",
                            JOptionPane.INFORMATION_MESSAGE);
                    case 2 -> conta.depositar(valor);
                    case 3 -> opcoesDeSaque(conta);
                    default -> JOptionPane.showMessageDialog(null,
                            "OPÇÃO INVÁLIDA!",
                            "ERRO!",
                            JOptionPane.ERROR_MESSAGE);
                }

                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        """
                                DIGITE A OPÇÃO DESEJADA:                
                                1 - Consultar saldo
                                2 - Depositar
                                3 - sacar
                                4 - Sair 
                                """,
                        "OPERAÇÕES DO CAIXA ELETRÔNICO",
                        JOptionPane.INFORMATION_MESSAGE));

            }
            JOptionPane.showMessageDialog(null,
                    "OPERAÇÃO FINALIZADA COM SUCESSO",
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null,
                    "DÍGITO INVÁLIDO!",
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void opcoesDeSaque(Conta conta) {

        try {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
                    """
                            ESCOLHA UMA OPÇÃO DE SAQUE:                
                            1 - R$10,00
                            2 - R$20,00
                            3 - R$50,00
                            4 - R$100,00
                            5 - OUTRO VALOR 
                            """,
                    "BANCO MSA",
                    JOptionPane.INFORMATION_MESSAGE));

            switch (escolha) {
                case 1 -> {
                    valor = 10;
                    conta.sacar(valor);
                }
                case 2 -> {
                    valor = 20;
                    conta.sacar(valor);
                }
                case 3 -> {
                    valor = 50;
                    conta.sacar(valor);
                }
                case 4 -> {
                    valor = 100;
                    conta.sacar(valor);
                }
                case 5 -> {
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "DIGITE O VALOR DO SAQUE",
                            "BANCO MSA",
                            JOptionPane.INFORMATION_MESSAGE));
                    conta.sacar(valor);
                }
                default -> JOptionPane.showMessageDialog(null,
                        "OPÇÃO INVÁLIDA!",
                        "BANCO MSA",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null,
                    "DÍGITO INVÁLIDO!",
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE);
        }


    }

}
