package com.joaopedro.cofrinho.main;

import java.util.Scanner; // Aqui é onde será usado o Scanner (input) via teclado.
import com.joaopedro.cofrinho.model.*; // Aqui vai importar todas as classes do pacote model.

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Comando pro input.
        Cofrinho cofrinho = new Cofrinho(); // Instância do cofrinho.
        int opcao = 0;

        do {
            System.out.println("\n|===========================|");
            System.out.println("|=====  MENU COFRINHO  =====|");
            System.out.println("|===========================|\n");
            System.out.println("[1] - Adicionar moeda");
            System.out.println("[2] - Remover moeda");
            System.out.println("[3] - Listar moedas");
            System.out.println("[4] - Calcular total convertido em reais");
            System.out.println("[5] - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = teclado.nextInt();

            // Estrutura de controle pro menu principal.
            switch (opcao) {
                case 1:
                    adicionarMoeda(teclado, cofrinho);
                    break;

                case 2:
                    removerMoeda(teclado, cofrinho);
                    break;

                case 3:
                    cofrinho.listarMoedas();
                    break;

                case 4:
                    System.out.printf("💰 Total convertido: R$ %.2f\n", cofrinho.calcularTotal());
                    System.out.println("-----------------------------\n"); // Coloquei um separador pra deixar mais legível.
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    System.out.println("Até a próxima :)");
                    System.out.println("obs: Esse trabalho deu trabalho ein!\n");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 5);

        teclado.close();
    }


    // método pra adicionar moedas.
    private static void adicionarMoeda(Scanner teclado, Cofrinho cofrinho) {
        int tipo = 0;
        boolean tipoValido = false;

        // Bloco que valida o tipo da moeda. Pq na hora de testar ele aceitava qualquer número.
        // E só DEPOIS na hora de colocar o valor que ele acusava o erro: 'tipo inválido'.
        while (!tipoValido) {
            System.out.println("\nQual moeda será adicionada?");
            System.out.println("[1] - Real");
            System.out.println("[2] - Dólar");
            System.out.println("[3] - Euro\n");

            System.out.print("Moeda: ");
            if (teclado.hasNextInt()) {
                tipo = teclado.nextInt();
                if (tipo >= 1 && tipo <= 3) {
                    tipoValido = true;
                } else {
                    System.out.println("Tipo inválido! Escolha entre [1], [2] ou [3].\n");
                }
            } else {
                System.out.println("Entrada inválida! Digite apenas números inteiros.\n");
                teclado.next(); // limpa o input errado que foi inserido.
            }
        }

        // Aqui ele continua executando caso o tipo seja válido. 
        System.out.print("\nDigite o valor da moeda: ");
       
        double valor = 0;
        boolean entradaValida = false;

        // Coloquei esse bloco de verificação do input pra garantir e forçar que o usuário digite um valor numérico válido.
        // Pq na hora de testar com n° flutuante, o programa quebrava.
        while (!entradaValida) {
            try {
                String valorTexto = teclado.next().replace(",", ".");
                valor = Double.parseDouble(valorTexto);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Tente novamente usando números, ex: 2.50 ou 2,50.");
                teclado.nextLine(); // comando que pede uma nova entrada.
            }
        }

        // Faz a instância da moeda escolhida.
        Moeda novaMoeda = null;
        switch (tipo) {
            case 1:
                novaMoeda = new Real(valor);
                break;
            case 2:
                novaMoeda = new Dolar(valor);
                break;
            case 3:
                novaMoeda = new Euro(valor);
                break;
        }

        cofrinho.adicionar(novaMoeda);
        System.out.println("Moeda adicionada com sucesso!");
        System.out.println("-----------------------------"); 

    }

    // método pra remover moedas.
    private static void removerMoeda(Scanner teclado, Cofrinho cofrinho) {
        int tipo = 0;
        boolean tipoValido = false;

        // Outro bloco de validação do tipo da moeda.
        while (!tipoValido) {
            System.out.println("\nQual moeda será removida?");
            System.out.println("[1] - Real");
            System.out.println("[2] - Dólar");
            System.out.println("[3] - Euro\n");

            System.out.print("Moeda: ");
            if (teclado.hasNextInt()) {
                tipo = teclado.nextInt();
                if (tipo >= 1 && tipo <= 3) {
                    tipoValido = true;
                } else {
                    System.out.println("Tipo inválido! Escolha entre [1], [2] ou [3].\n");
                }
            } else {
                System.out.println("Entrada inválida! Digite apenas números inteiros.\n");
                teclado.next();
            }
        }
        System.out.print("\nDigite o valor da moeda: ");

        double valor = 0;
        boolean entradaValida = false;

        // Repeti o bloco de verificação do input pra parte de exclusão tbm.
        while (!entradaValida) {
            try {
                String valorTexto = teclado.next().replace(",", ".");
                valor = Double.parseDouble(valorTexto);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Tente novamente usando números, ex: 2.50 ou 2,50.");
                teclado.nextLine(); // limpa o buffer
            }
        }

        // Tbm faz a instância da moeda escolhida, nesse caso, pra remoção.
        Moeda moedaRemover = null;
        switch (tipo) {
            case 1:
                moedaRemover = new Real(valor);
                break;
            case 2:
                moedaRemover = new Dolar(valor);
                break;
            case 3:
                moedaRemover = new Euro(valor);
                break;
        }

        cofrinho.remover(moedaRemover);
        System.out.println("Moeda removida com sucesso!");
        System.out.println("-----------------------------\n"); 
    }
}