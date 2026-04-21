package ar.edu.info.unlp.Repaso_Ej1;

public class ReTweet extends TweetBase {

    private TweetBase tweetOriginal;

    public ReTweet(TweetBase tweetOriginal) {
        this.tweetOriginal = tweetOriginal;
    }

    public boolean conozcoTweet(TweetBase tweet) {
        if(tweet.equals(this)) return true;
        return tweetOriginal.conozcoTweet(tweet);
    }

    public void leer(){
        System.out.println("ReTweet de:");
        this.tweetOriginal.leer();
    }

    @Override
    public void autoEliminar(){}



}
