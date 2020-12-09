import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {

        // Ns
        List<Integer> Ns = new ArrayList<>();
        Ns.add(1000);
        Ns.add(2000);
        Ns.add(4000);
        Ns.add(8000);
        Ns.add(16000);
        Ns.add(32000);
        Ns.add(64000);
        Ns.add(128000);

        // times // opCounts
        List<Double> times = new ArrayList<>();
        List<Integer> opCounts = new ArrayList<>();
        for (int N : Ns) {
            SLList<Integer> tempAList = new SLList<>();
            while (N > 0) {
                tempAList.addLast(N);
                N-=1;
            }
            Stopwatch sw = new Stopwatch();
            for (int m = 0; m < 10000; m++) {
                tempAList.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.add(timeInSeconds);
            opCounts.add(10000);
        }

        // print out the table
        System.out.println("Timing table for getLast");
        printTimingTable(Ns, times, opCounts);
    }

}
