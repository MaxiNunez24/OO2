package ar.edu.info.unlp.Repaso_Ej2;

public class Lagarto extends Juego {
    public Juego contra(Juego otro) {
        return otro.contraLagarto();
    }

    public Juego contraPiedra() {
        return new Piedra();
    }

    public Juego contraPapel() {
        return new Lagarto();
    }

    public Juego contraTijera() {
        return new Tijera();
    }

    public Juego contraSpock(){
        return new Lagarto();
    }

    public Juego contraLagarto(){
        return new Empate();
    }

    @Override
    public String toString() {
        return "Lagarto";
    }

}

