package code;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

import com.sun.management.OperatingSystemMXBean;

public class Main {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        String initialState0 = "17;" +
                "49,30,46;" +
                "7,57,6;" +
                "7,1;20,2;29,2;" +
                "350,10,9,8,28;" +
                "408,8,12,13,34;";
        DecimalFormat df = new DecimalFormat("#.##");
        String sol=LLAPSearch.solve(initialState0, "AS1", false);
        System.out.println("Num of Expanded Nodes: "+sol.split(";")[2]);
        String formatted = df.format((osBean.getProcessCpuLoad() * 100));
        System.out.println("CPU utilization: "+ formatted+ " %");
        Runtime runtime = Runtime.getRuntime();

        // Used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory in megabytes: "
                + bytesToMegabytes(memory));
    }
    private static long bytesToMegabytes(long bytes) {
        return bytes / (1024L * 1024L);
    }
}