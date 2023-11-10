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
        String initialState0 = "17;" +
                "49,30,46;" +
                "7,57,6;" +
                "7,1;20,2;29,2;" +
                "350,10,9,8,28;" +
                "408,8,12,13,34;";
        System.out.println(LLAPSearch.solve(initialState0, "BF", false));
  }
}