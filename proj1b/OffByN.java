public class OffByN implements CharacterComparator{

    public int N;
    public OffByN() {
        N = 0;
    }
    public OffByN(int takeIn) {
        N = takeIn;
    }

    @Override
    public boolean equalChars(char x, char y){
        return Math.abs((int) x - (int) y) == N;
    }
}
