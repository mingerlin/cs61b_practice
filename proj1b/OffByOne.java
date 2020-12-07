public class OffByOne implements CharacterComparator{

    /* Returns true for characters that are off by one from each other */
    @Override
    public boolean equalChars(char x, char y){
        return Math.abs((int) x - (int) y) == 1;
    }
}
