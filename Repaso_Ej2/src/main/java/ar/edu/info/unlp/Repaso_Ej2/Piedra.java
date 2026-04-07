package ar.edu.info.unlp.Repaso_Ej2;

public class Piedra extends Juego {

    @Override
    public Juego contra(Juego otro) {
        return otro.contraPiedra();
    }

    public Juego contraPiedra() {
        return new Empate();
    }

    public Juego contraPapel() {
        return new Papel();
    }

    public Juego contraTijera() {
        return new Piedra();
    }

    public Juego contraLagarto() {
        return new Piedra();
    }

    public Juego contraSpock() {
        return new Spock();
    }

    @Override
    public String toString() {
        return "Piedra";
    }

}
