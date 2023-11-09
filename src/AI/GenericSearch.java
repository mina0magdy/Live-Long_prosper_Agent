package AI;

import java.util.*;

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
        int prosperityGainBuild1=problem.getInitialState().getProsperityBUILD1();
        int prosperityGainBuild2=problem.getInitialState().getProsperityBUILD2();
        int totalSpentBuild1=problem.getInitialState().getPriceBUILD1()+problem.getInitialState().getMaterialsUseBUILD1()+problem.getInitialState().getFoodUseBUILD1()+problem.getInitialState().getEnergyUseBUILD1();
        int totalSpentBuild2=problem.getInitialState().getPriceBUILD2()+problem.getInitialState().getMaterialsUseBUILD2()+problem.getInitialState().getFoodUseBUILD2()+problem.getInitialState().getEnergyUseBUILD2();
        int minCostPerProsperityLevel=Math.min(prosperityGainBuild1/totalSpentBuild1,prosperityGainBuild2/totalSpentBuild2);
        int maxGainBuild=Math.max(prosperityGainBuild1,prosperityGainBuild2);
        int currentProsperityLevel=problem.getInitialState().getCurrentProsperity();
        Node initialNode= new Node(
                problem.getInitialState(),
                null,
                null,
                0,
                0,
                (100-currentProsperityLevel)/maxGainBuild,
                (100-currentProsperityLevel)*minCostPerProsperityLevel);
        if (searchStrategy== SearchStrategy.BF|| searchStrategy== SearchStrategy.DF )
        {
            return BF_DFSearch(initialNode);
        } else if (searchStrategy ==SearchStrategy.ID) {
            return IDSearch(initialNode);
        } else if(searchStrategy==SearchStrategy.UC){
            return uniformCostSearch(initialNode);
        }
        else if (searchStrategy==SearchStrategy.GR1) {
            return greedySearch1(initialNode);
        }
        else if (searchStrategy==SearchStrategy.GR2) {
            return greedySearch2(initialNode);
        }
        else if (searchStrategy==SearchStrategy.AS1) {
            return AStar1(initialNode);
        }
        else {
            return AStar2(initialNode);
        }
    }

    private Node BF_DFSearch(Node initialNode){
        LinkedList<Node> nodesBF_DF=new LinkedList<Node>();
        nodesBF_DF.add(initialNode);
        HashSet<State> visitedStates=new HashSet<>();
        while(!(nodesBF_DF.isEmpty())) {
            Node current = nodesBF_DF.removeFirst();
            visitedStates.add(current.getState());
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);

            for (int i = 0; i < 6; i++) {
                if (searchStrategy == SearchStrategy.BF) {
                    if (tempNodes.get(i) != null) {
                        if(!visitedStates.contains(tempNodes.get(i).getState()))
                            nodesBF_DF.add(tempNodes.get(i));
                    }
                }
                if (searchStrategy == SearchStrategy.DF) {
                    if (tempNodes.get(5 - i) != null) {
                        if(!visitedStates.contains(tempNodes.get(5 - i).getState()))
                            nodesBF_DF.addFirst(tempNodes.get(5 - i));
                    }
                }
            }
        }
        return null;
    }

    private Node IDSearch(Node initialNode){
        int currentMaxLevel=0;
        for(int maxLevel=0;maxLevel<Integer.MAX_VALUE;maxLevel++) {
            for (int i = 0; i <= currentMaxLevel; i++) {
                LinkedList<Node> nodesID = null;
                nodesID = new LinkedList<>();
                nodesID.add(initialNode);
                boolean maxLevelReached=false;
                HashSet<State> visitedStates=new HashSet<>();
                while (!(nodesID.isEmpty())) {
                    Node current = nodesID.removeFirst();
                    visitedStates.add(current.getState());
                    numExpandedNodes++;
                    if (goalTest(current))
                        return current;

                    //check if we reached tha max level
                    if (current.getDepth() == currentMaxLevel) {
                        maxLevelReached=true;
                        continue;
                    }
                    List<Node> tempNodes = expand(current);
                    for (int j = 0; j < 6; j++) {
                        if (tempNodes.get(5 - j) != null) {
                            if(!visitedStates.contains(tempNodes.get(5 - j).getState()))
                                nodesID.addFirst(tempNodes.get(5 - j));
                        }
                    }
                }
                if(!maxLevelReached)
                    return null;
            }
            currentMaxLevel++;
        }
        return null;
    }
    private Node uniformCostSearch(Node initialNode){
        PriorityQueue <Node> ucQueue=new PriorityQueue<>((node1,node2)->node1.getPathCost()-node2.getPathCost());
        ucQueue.add(initialNode);
        HashSet<State> visitedStates=new HashSet<>();
        while(!(ucQueue.isEmpty())) {
            Node current = ucQueue.remove();
            visitedStates.add(current.getState());
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);
            for (int i = 0; i < 6; i++) {
                if (tempNodes.get(i) != null) {
                    if(!visitedStates.contains(tempNodes.get(i).getState()))
                        ucQueue.add(tempNodes.get(i));
                }
            }
        }
        return null;
    }
    private Node greedySearch1(Node initialNode){
        PriorityQueue <Node> gsQueue=new PriorityQueue<>((node1,node2)->node1.getHeuristicValue1()-node2.getHeuristicValue1());
        gsQueue.add(initialNode);
        HashSet<State> visitedStates=new HashSet<>();
        while(!(gsQueue.isEmpty())) {
            Node current = gsQueue.remove();
            visitedStates.add(current.getState());
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);
            for (int i = 0; i < 6; i++) {
                if (tempNodes.get(i) != null) {
                    if(!visitedStates.contains(tempNodes.get(i).getState()))
                        gsQueue.add(tempNodes.get(i));
                }
            }
        }
        return null;
    }
    private Node greedySearch2(Node initialNode){
        PriorityQueue <Node> gsQueue=new PriorityQueue<>((node1,node2)->node1.getHeuristicValue2()-node2.getHeuristicValue2());
        gsQueue.add(initialNode);
        HashSet<State> visitedStates=new HashSet<>();
        while(!(gsQueue.isEmpty())) {
            Node current = gsQueue.remove();
            visitedStates.add(current.getState());
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);
            for (int i = 0; i < 6; i++) {
                if (tempNodes.get(i) != null) {
                    if(!visitedStates.contains(tempNodes.get(i).getState()))
                        gsQueue.add(tempNodes.get(i));
                }
            }
        }
        return null;
    }
    private Node AStar1(Node initialNode){
        PriorityQueue <Node> AQueue=new PriorityQueue<>((node1,node2)->(node1.getHeuristicValue1()+node1.getPathCost())-(node2.getHeuristicValue1()+node2.getPathCost()));
        AQueue.add(initialNode);
        HashSet<State> visitedStates=new HashSet<>();
        while(!(AQueue.isEmpty())) {
            Node current = AQueue.remove();
            visitedStates.add(current.getState());
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);
            for (int i = 0; i < 6; i++) {
                if (tempNodes.get(i) != null) {
                    if(!visitedStates.contains(tempNodes.get(i).getState()))
                        AQueue.add(tempNodes.get(i));
                }
            }
        }
        return null;
    }
    private Node AStar2(Node initialNode){
        PriorityQueue <Node> AQueue=new PriorityQueue<>((node1,node2)->(node1.getHeuristicValue2()+node1.getPathCost())-(node2.getHeuristicValue2()+node2.getPathCost()));
        AQueue.add(initialNode);
        HashSet<State> visitedStates=new HashSet<>();
        while(!(AQueue.isEmpty())) {
            Node current = AQueue.remove();
            visitedStates.add(current.getState());
            numExpandedNodes++;
            if (goalTest(current))
                return current;
            List<Node> tempNodes = expand(current);
            for (int i = 0; i < 6; i++) {
                if (tempNodes.get(i) != null) {
                    if(!visitedStates.contains(tempNodes.get(i).getState()))
                        AQueue.add(tempNodes.get(i));
                }
            }
        }
        return null;
    }

    public  LinkedList<Node> expand(Node current) {
        LinkedList<Node> tempNodes = new LinkedList<>();
        Node node1 = Actions.requestFood(current, visualize);
        Node node2 = Actions.requestMaterials(current, visualize);
        Node node3 = Actions.requestEnergy(current, visualize);
        Node node4 = Actions.wait(current, visualize);
        Node node5 = Actions.build1(current, visualize);
        Node node6 = Actions.build2(current, visualize);
        tempNodes.add(node1);
        tempNodes.add(node2);
        tempNodes.add(node3);
        tempNodes.add(node4);
        tempNodes.add(node5);
        tempNodes.add(node6);
        return tempNodes;
    }
    private boolean goalTest(Node testNode){
        if(testNode.getState().getCurrentProsperity()>=100 && testNode.getState().getMoneySoFar()<=100000 )
           return true;
        return false;
    }
}
