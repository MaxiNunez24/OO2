package ar.edu.info.unlp.Repaso_Ej1;

import java.time.LocalDate;

public abstract class TweetBase {

    protected LocalDate fecha;

    public abstract boolean conozcoTweet(Tweet tweet);

}
