package code;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

import com.sun.management.OperatingSystemMXBean;

public class Main {
    public static void main(String[] args) {

        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        String initialState0 = "17;" +
//                "49,30,46;" +
//                "7,57,6;" +
//                "7,1;20,2;29,2;" +
//                "350,10,9,8,28;" +
//                "408,8,12,13,34;";
        String initialState4 = "21;" +
                "15,19,13;" +
                "50,50,50;" +
                "12,2;16,2;9,2;" +
                "3076,15,26,28,40;" +
                "5015,25,15,15,38;";
        DecimalFormat df = new DecimalFormat("#.##");
        long startTime = System.currentTimeMillis();
        String sol=LLAPSearch.solve(initialState4, "AS1", false);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Path Cost or Total Money spent to reach goal: "+sol.split(";")[1]);
        System.out.println("Num of Expanded Nodes: "+sol.split(";")[2]);
        String formatted = df.format((osBean.getProcessCpuLoad() * 100));
        System.out.println("CPU utilization: "+ formatted+ " %");
        System.out.println("Total Time: "+totalTime+" ms");
        Runtime runtime = Runtime.getRuntime();
        // Used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory in megabytes: "
                + df.format(bytesToMegabytes(memory)));
//        System.out.println("Used memory in bytes: "
//                + memory);
    }
    private static double bytesToMegabytes(double bytes) {
        return bytes / (1024L * 1024L);
    }
}