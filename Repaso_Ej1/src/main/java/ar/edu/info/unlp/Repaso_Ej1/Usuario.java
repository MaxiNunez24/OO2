package ar.edu.info.unlp.Repaso_Ej1;

import java.util.ArrayList;

public class Usuario {

    private String screenName;
    private ArrayList<Tweet> tweets;


    public Usuario(String screenName){
        this.screenName = screenName;
        this.tweets = new ArrayList<>();
    }

    public void postearTweet(String tweet) {

    }

    public void leerTweet(TweetBase tweet){

    }

    public void eliminarTweet(TweetBase tweet){

    }

    public boolean mismoScreenName(Usuario usuario){
            return this.screenName.equals(usuario.screenName);
    }

}
