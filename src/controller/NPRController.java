package controller;

import br.org.Kay_Almeida.pilhaint.*;

public class NPRController {

    public void insereValor(Pilha pilha, int valor) {
        pilha.push(valor);
    }

    public int npr(Pilha pilha, String op) throws Exception {
        switch (op) {
            case "+":
                return operacao(pilha, '+');
            case "-":
                return operacao(pilha, '-');
            case "*":
                return operacao(pilha, '*');
            case "/":
                return operacao(pilha, '/');
            default:
                throw new IllegalArgumentException("Operação inválida: " + op);
        }
    }

    private int operacao(Pilha pilha, char op) throws Exception {
        if (pilha.size() < 2) {
            throw new Exception("Operação não pode ser realizada, pilha contém menos de 2 valores.");
        }

        int b = pilha.pop();
        int a = pilha.pop();

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Divisão por zero.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operação inválida: " + op);
        }
    }
}
