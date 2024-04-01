package view;

import controller.NPRController;
import br.org.Kay_Almeida.pilhaint.*;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        NPRController nprController = new NPRController();
        Pilha pilha = new Pilha();

        boolean continuar = true;

        while (continuar) {
            String entrada = JOptionPane.showInputDialog("Digite um número, operação (+,-,*,/) ou 'S' para sair:");

            try {
                if (entrada == null || entrada.equalsIgnoreCase("S")) {
                    continuar = false;
                } else if (entrada.matches("-?\\d+")) {
                    // Se a entrada é um número
                    int valor = Integer.parseInt(entrada);
                    nprController.insereValor(pilha, valor);
                } else if (entrada.matches("[+\\-*/]")) {
                    // Se a entrada é uma operação
                    int resultado = nprController.npr(pilha, entrada);
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }
}
