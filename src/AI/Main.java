package AI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int currentMaxLevel=0;
        for(int j=0;j<5;j++) {
            for (int i = 0; i <= currentMaxLevel; i++) {
                System.out.println(i);

            }
            currentMaxLevel++;
        }
    }
}