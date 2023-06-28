package br.com.devsibre;

public class Teste {
    public static void main(String[] args) {
        int[] vetor = {2, 5, 3, 1, 4};
        metodo(vetor, 0);
    }

    public static void metodo(int[] vetor, int indice) {
        if (indice < vetor.length) {
            int numero = vetor[indice];
            System.out.print(numero + " ");
            metodo(vetor, numero);
        }
    }
}
