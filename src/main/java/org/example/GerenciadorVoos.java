package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class GerenciadorVoos {
    public List<Voo> voos;
    public GerenciadorVoos() {
        this.voos = new ArrayList<>();
    }

    public void criarVoo(String horarioPartida, String origemVoo, String destinoVoo, int tempoVoo) {
        Voo voo = new Voo(horarioPartida, origemVoo, destinoVoo, tempoVoo);
        voos.add(voo);
    }

    public void atualizarVoo(int indiceVoo, String horarioPartida, String origemVoo, String destinoVoo, int tempoVoo) {
        Voo voo = voos.get(indiceVoo);
        voo.setHorarioPartida(horarioPartida);
        voo.setOrigemVoo(origemVoo);
        voo.setDestinoVoo(destinoVoo);
        voo.setTempoVoo(tempoVoo);
    }

    public void removerVoo(int indiceVoo) {
        voos.remove(indiceVoo);
    }

    public List<Voo> consultarVoos() {
        return voos;
    }

    public void ordenarPorTempoDoVoo() {
        shellSort((Comparator.comparingInt(Voo::getTempoVoo)));
    }

    public void ordenarPorHorarioPartida() {
        insertionSort((Comparator.comparing(Voo::getHorarioPartida)));
    }

    public void shellSort(Comparator<Voo> comparator) {
        int n = voos.size();
        int separacao = n / 2;
        while (separacao > 0) {
            for (int i = separacao; i < n; i++) {
                Voo temp = voos.get(i);
                int j = i;
                while (j >= separacao && comparator.compare(voos.get(j - separacao), temp) > 0) {
                    voos.set(j, voos.get(j - separacao));
                    j -= separacao;
                }
                voos.set(j, temp);
            }
            separacao /= 2;
        }
    }

    public void insertionSort(Comparator<Voo> comparator) {
        int n = voos.size();
        for (int i = 1; i < n; ++i) {
            Voo key = voos.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(voos.get(j), key) > 0) {
                voos.set(j + 1, voos.get(j));
                j = j - 1;
            }
            voos.set(j + 1, key);
        }
    }

    public void carregarVoosArquivo(String caminhoArquivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String horarioPartida = dados[0];
                String origemVoo = dados[1];
                String destinoVoo = dados[2];
                int tempoVoo = Integer.parseInt(dados[3]);
                Voo voo = new Voo(horarioPartida, origemVoo, destinoVoo, tempoVoo);
                voos.add(voo);
            }
            reader.close();
            System.out.println("Voos carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar voos!" + e.getMessage());
        }
    }
}
