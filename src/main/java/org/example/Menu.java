
package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    public static GerenciadorVoos gerenciadorVoos = new GerenciadorVoos();

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            mostrarMenu();
            try {
                int opcoes = scanner.nextInt();
                scanner.nextLine();
                switch (opcoes) {
                    case 1:
                        adicionarVoo();
                        break;
                    case 2:
                        atualizarVoo();
                        break;
                    case 3:
                        removerVoo();
                        break;
                    case 4:
                        consultarVoos();
                        break;
                    case 5:
                        ordenarPorTempoDoVoo();
                        break;
                    case 6:
                        ordenarPorHorarioPartida();
                        break;
                    case 7:
                        carregarDados();
                        break;
                    case 8:
                        sair = true;
                        break;
                    default:
                        System.out.println("Digite apenas números de 1 a 8!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números de 1 a 8!");
                scanner.nextLine();
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n##--Gerenciador de Voos--##");
        System.out.println("|-------------------------------|");
        System.out.println("| 1 - Adicionar Voo             |");
        System.out.println("| 2 - Remover Voo               |");
        System.out.println("| 3 - Atualizar Voo             |");
        System.out.println("| 4 - Mostrar Voos              |");
        System.out.println("| 5 - Ordenação Shell Sort      |");
        System.out.println("| 6 - Ordenação Insertion Sort  |");
        System.out.println("| 7 - Ler Arquivo               |");
        System.out.println("| 8 - Sair                      |");
        System.out.println("|------------------------------ |");
        System.out.println("Digite uma opção: ");
    }

    public static void adicionarVoo() {
        System.out.println("Digite o horário de partida: ");
        String horarioPartida = scanner.nextLine();
        System.out.println("Digite a origem do voo: ");
        String origemVoo = scanner.nextLine();
        System.out.println("Digite o destino do voo: ");
        String destinoVoo = scanner.nextLine();
        System.out.println("Digite o tempo de voo: ");
        int tempoVoo = scanner.nextInt();
        scanner.nextLine();
        gerenciadorVoos.criarVoo(horarioPartida, origemVoo, destinoVoo, tempoVoo);
        System.out.println("Voo adicionado com sucesso!");
    }

    public static void atualizarVoo() {
        System.out.println("Digite o índice do voo: ");
        int indiceVoo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o horário de partida: ");
        String horarioPartida = scanner.nextLine();
        System.out.println("Digite a origem do voo: ");
        String origemVoo = scanner.nextLine();
        System.out.println("Digite o destino do voo: ");
        String destinoVoo = scanner.nextLine();
        System.out.println("Digite o tempo de voo: ");
        int tempoVoo = scanner.nextInt();
        scanner.nextLine();
        gerenciadorVoos.atualizarVoo(indiceVoo, horarioPartida, origemVoo, destinoVoo, tempoVoo);
        System.out.println("Voo atualizado com sucesso!");
    }

    public static void removerVoo() {
        System.out.println("Digite o índice do voo: ");
        int indiceVoo = scanner.nextInt();
        scanner.nextLine();
        gerenciadorVoos.removerVoo(indiceVoo);
        System.out.println("Voo removido com sucesso!");
    }

    public static void consultarVoos() {
        gerenciadorVoos.consultarVoos();
    }

    public static void ordenarPorTempoDoVoo() {
        gerenciadorVoos.ordenarPorTempoDoVoo();
    }

    public static void ordenarPorHorarioPartida() {
        gerenciadorVoos.ordenarPorHorarioPartida();
    }

    public static void carregarDados() {
        System.out.println("Digite o caminho do arquivo: ");
        String caminhoArquivo = scanner.nextLine();
        gerenciadorVoos.carregarVoosArquivo(caminhoArquivo);
    }
}

