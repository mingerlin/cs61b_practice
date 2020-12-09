import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
        AListFloorSet afs = new AListFloorSet();
        RedBlackFloorSet rbfs = new RedBlackFloorSet();
        for (int i=0;i<1000000;i+=1) {
            double randomValue = StdRandom.uniform(-5000, 5000);
            afs.add(randomValue);
            rbfs.add(randomValue);
        }
        for (int i=0;i<100000;i+=1) {
            double randomValue2 = StdRandom.uniform(-5000, 5000);
            assertEquals(afs.floor(randomValue2), rbfs.floor(randomValue2),0.000001);
        }
    }
}
