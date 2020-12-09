import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Fill in the add and floor methods.
 */
public class AListFloorSet implements Lab5FloorSet {
    AList<Double> items;

    public AListFloorSet() {
        items = new AList<>();
    }

    /* adds x to the set. If x is already present, it has no effect. */
    public void add(double x) {
//        for (int i=0; i<items.size();i++) {
//            if (items.get(i) == x) {
//                return;
//            }
//        }
        items.addLast(x);
    }

    /* gives the largest value in the set that is less than or equal to x.
    If no values are smaller than x, it should return negative infinity
    (Double.NEGATIVE_INFINITY */
    public double floor(double x) {
        Double largest = Double.NEGATIVE_INFINITY;
        List<Double> values = new ArrayList<>();
        for (int i=0; i<items.size(); i+=1) {
            if (items.get(i) <= x && items.get(i)>=largest) {
                largest = items.get(i);
            }
        }
        return largest;
    }
}
