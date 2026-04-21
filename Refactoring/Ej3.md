# Ejercicio 3: Iteradores circulares bis

Se cuenta con las siguientes implementaciones de iteradores circulares, las cuales presentan implementaciones similares. 

```java
public class CharRing{
    private char[] source;
    private int idx;
    
    public CharRing(String src){
        source = src.toCharArray();
        idx = 0;
    }
    
    public char next(){
        if(idx >= source.length) idx = 0;
        return source[idx++];
    }
}
```

```java
public class IntRing{
    private char[] source;
    private int idx;
    
    public IntRing(Int[] src){
        source = src;
        idx = 0;
    }
    
    public int next(){
        if(idx >= source.length) idx = 0;
        return source[idx++];
    }
}
```


