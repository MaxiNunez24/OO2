public class CharRing extends Ring{
    private char[] source;
    public CharRing(String src){
        source = src.toCharArray();
        idx = 0;
    }

    public char next(){
        if(idx >= source.length) idx = 0;
        return source[idx++];
    }
}