public class IntRing extends Ring {
    private int[] source;
    public IntRing(int[] src){
        source = src;
        idx = 0;
    }

    public int next(){
        if(idx >= source.length) idx = 0;
        return source[idx++];
    }
}