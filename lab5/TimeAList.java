import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {

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

        // times
        List<Double> times = new ArrayList<>();
        for (int N: Ns) {
            Stopwatch sw = new Stopwatch();
            AList<Integer> tempAList = new AList<>();
            while (N > 0) {
                tempAList.addLast(N);
                N-=1;
            }
            double timeInSeconds = sw.elapsedTime();
            times.add(timeInSeconds);
        }

        // opCounts = Ns

        // print out the table
        System.out.println("Timing table for addLast");
        printTimingTable(Ns, times, Ns);

    }
}
