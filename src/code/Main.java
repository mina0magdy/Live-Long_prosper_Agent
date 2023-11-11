package code;

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
//        State s1=new State(100,100,100,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10);
//        State s2=new State(100,100,100,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,10,10,10,10);
//        System.out.println(s1.equals(s2));
        String initialState4 = "21;" +
                "15,19,13;" +
                "50,50,50;" +
                "12,2;16,2;9,2;" +
                "3076,15,26,28,40;" +
                "5015,25,15,15,38;";
        System.out.println(LLAPSearch.solve(initialState4, "BF", false));
  }
}