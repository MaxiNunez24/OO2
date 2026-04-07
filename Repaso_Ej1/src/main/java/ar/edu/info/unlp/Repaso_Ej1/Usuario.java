package ar.edu.info.unlp.Repaso_Ej1;

import java.util.ArrayList;

public class Usuario {

    private String screenName;
    private ArrayList<Tweet> tweets;


    public Usuario(String screenName){
        this.screenName = screenName;
        this.tweets = new ArrayList<>();
    }

    public boolean postearTweet(String tweet) {
        if(tweet.length() > 1 && tweet.length() <= 280){
            tweets.add(new Tweet(tweet));
            return true;
        } else return false;
    }

    public void eliminarTweets() {
        tweets.forEach(Tweet::autoEliminar);
    }

    public boolean mismoScreenName(Usuario usuario){
            return this.screenName.equals(usuario.screenName);
    }

}
