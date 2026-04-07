package ar.edu.info.unlp.Repaso_Ej1;

public class Tweet extends TweetBase {

    private String texto;

    public Tweet(String texto) {
        this.texto = texto;
    }

    public boolean conozcoTweet(TweetBase tweet) {
        return tweet.equals(this);
    }

    public void leer(){
        System.out.println(this.texto);
    }

    @Override
    public void autoEliminar(){
        this.texto = "Este tweet ha sido eliminado.";
    }
}
