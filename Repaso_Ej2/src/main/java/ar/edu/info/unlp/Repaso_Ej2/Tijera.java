package ar.edu.info.unlp.Repaso_Ej2;

public class Tijera extends Juego {
    public Juego contra(Juego otro) {
        return otro.contraTijera();
    }

    public Juego contraPiedra() {
        return new Piedra();
    }

    public Juego contraPapel() {
        return new Tijera();
    }

    public Juego contraTijera() {
        return new Empate();
    }

    public Juego contraLagarto() {
        return new Tijera();
    }

    public Juego contraSpock() {
        return new Spock();
    }

    @Override
    public String toString() {
        return "Tijera";
    }

}
