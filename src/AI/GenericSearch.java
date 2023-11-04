package AI;

import java.util.ArrayList;
import java.util.List;

public class GenericSearch {
    private Problem problem;
    private SearchStrategy searchStrategy;
    private int numExpandedNodes=0;
    private boolean visualize;

    public boolean isVisualize() {
        return visualize;
    }

    public void setVisualize(boolean visualize) {
        this.visualize = visualize;
    }


    public int getNumExpandedNodes() {
        return numExpandedNodes;
    }

    public void setNumExpandedNodes(int numExpandedNodes) {
        this.numExpandedNodes = numExpandedNodes;
    }



    public GenericSearch(Problem problem, SearchStrategy searchStrategy) {
        this.problem = problem;
        this.searchStrategy = searchStrategy;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public SearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
    public Node SolveGenericSearch (){
        Node initialNode= new Node(problem.getInitialState(),null,null,0,0,0);
        List<Node> nodes=null;
        if (searchStrategy== SearchStrategy.BF|| searchStrategy== SearchStrategy.DF)
        {
         nodes=new ArrayList<Node>();
         nodes.add(initialNode);
        }
        while(!(nodes.isEmpty()))
        {
          Node current=nodes.removeFirst();
          if (goalTest(current))
              return current;
          List<Node> tempNodes=new ArrayList<Node>();
          Node node1= Actions.requestFood(current,visualize);
          Node node2= Actions.requestMaterials(current,visualize);
          Node node3= Actions.requestEnergy(current,visualize);
          Node node4= Actions.wait(current,visualize);
          Node node5= Actions.build1(current,visualize);
          Node node6= Actions.build2(current,visualize);
          tempNodes.add(node1);
          tempNodes.add(node2);
          tempNodes.add(node3);
          tempNodes.add(node4);
          tempNodes.add(node5);
          tempNodes.add(node6);
          for(int i=0;i<6;i++){
              if (searchStrategy== SearchStrategy.BF)
              {
                  if(tempNodes.get(i)!=null){
                    nodes.add(tempNodes.get(i));
                    numExpandedNodes++;
                  }
              }
              if (searchStrategy== SearchStrategy.DF)
              {
                  if(tempNodes.get(5-i)!=null){
                    nodes.addFirst(tempNodes.get(5-i));
                    numExpandedNodes++;
                  }
              }
          }

        }
            return null;


    }
    private boolean goalTest(Node testNode){
        if(testNode.getState().getCurrentProsperity()>=100 && testNode.getState().getMoneySoFar()<=100000 )
           return true;
        return false;
    }
}
