package ar.edu.info.unlp.Repaso_Ej2;

public class Empate extends Juego {
    public Juego contra(Juego otro) {
        return otro;
    }

    public Juego contraPiedra() {
        return new Piedra();
    }

    public Juego contraPapel() {
        return new Papel();
    }

    public Juego contraTijera() {
        return new Tijera();
    }

    public Juego contraSpock(){
        return new Spock();
    }

    public Juego contraLagarto(){
        return new Lagarto();
    }

    @Override
    public String toString() {
        return "Empate";
    }

}

