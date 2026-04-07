package ar.edu.info.unlp.Repaso_Ej2;

public abstract class Juego {
    public abstract Juego contra(Juego otro);
    public abstract Juego contraPiedra();
    public abstract Juego contraPapel();
    public abstract Juego contraTijera();
    public abstract Juego contraSpock();

    public abstract Juego contraLagarto();
}
