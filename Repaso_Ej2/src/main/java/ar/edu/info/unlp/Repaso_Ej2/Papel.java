package ar.edu.info.unlp.Repaso_Ej2;

public class Papel extends Juego {

    public Juego contra(Juego otro) {
        return otro.contraPapel();
    }

    public Juego contraPiedra() {
        return new Papel();
    }

    public Juego contraPapel() {
        return new Empate();
    }

    public Juego contraTijera() {
        return new Tijera();
    }

    public Juego contraLagarto() {
        return new Lagarto();
    }

    public Juego contraSpock() {
        return new Papel();
    }

    @Override
    public String toString() {
        return "Papel";
    }


}
