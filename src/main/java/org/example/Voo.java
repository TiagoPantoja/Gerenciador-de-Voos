package org.example;

public class Voo {
    public String horarioPartida;
    public String origemVoo;
    public String destinoVoo;
    public int tempoVoo;

    public Voo(String horarioPartida, String origemVoo, String destinoVoo, int tempoVoo) {
        this.horarioPartida = horarioPartida;
        this.origemVoo = origemVoo;
        this.destinoVoo = destinoVoo;
        this.tempoVoo = tempoVoo;
    }

    public String getHorarioPartida() {
        return horarioPartida;
    }

    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }

    public String getOrigemVoo() {
        return origemVoo;
    }

    public void setOrigemVoo(String origemVoo) {
        this.origemVoo = origemVoo;
    }

    public String getDestinoVoo() {
        return destinoVoo;
    }

    public void setDestinoVoo(String destinoVoo) {
        this.destinoVoo = destinoVoo;
    }

    public int getTempoVoo() {
        return tempoVoo;
    }

    public void setTempoVoo(int tempoVoo) {
        this.tempoVoo = tempoVoo;
    }

    @Override
    public String toString() {
        return "Voo: " + horarioPartida + " - " + origemVoo + " - " + destinoVoo + " - " + tempoVoo;
    }
}
