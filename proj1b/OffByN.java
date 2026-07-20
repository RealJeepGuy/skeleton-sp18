public class OffByN implements CharacterComparator{
    private int n;

    //Constructor
    public OffByN(int N){
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int diff = Math.bas(x - y);
        return diff == n;
    }
}
