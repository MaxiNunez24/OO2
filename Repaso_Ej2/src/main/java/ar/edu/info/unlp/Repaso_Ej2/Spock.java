package ar.edu.info.unlp.Repaso_Ej2;

public class Spock extends Juego {

    public Juego contra(Juego otro) {
        return otro.contraSpock();
    }

    public Juego contraPiedra() {
        return new Spock();
    }

    public Juego contraPapel() {
        return new Papel();
    }

    public Juego contraTijera() {
        return new Spock();
    }

    public Juego contraSpock(){
        return new Empate();
    }

    public Juego contraLagarto(){
        return new Lagarto();
    }

    @Override
    public String toString() {
        return "Spock";
    }

}
