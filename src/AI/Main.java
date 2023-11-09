package AI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int currentMaxLevel=0;
//        for(int j=0;j<5;j++) {
//            for (int i = 0; i <= currentMaxLevel; i++) {
//                System.out.print("\n"+i);
//
//            }
//            currentMaxLevel++;
//        }
        State s1=new State(100,100,100,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10);
        State s2=new State(100,100,100,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,10,10,10,10);
        System.out.println(s1.equals(s2));
  }
}