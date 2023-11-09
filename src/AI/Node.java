package AI;

public class Node {
    private State state;
    private Node parentNode;
    private Operator operator;
    private int depth;
    private int pathCost;
    private int heuristicValue1;
    private int heuristicValue2;


    public Node(State state, Node parentNode, Operator operator, int depth, int pathCost, int heuristicValue1, int heuristicValue2) {
        this.state = state;
        this.parentNode = parentNode;
        this.operator = operator;
        this.depth = depth;
        this.pathCost = pathCost;
        this.heuristicValue1 = heuristicValue1;
        this.heuristicValue2 = heuristicValue2;
    }
    public int getHeuristicValue2() {
        return heuristicValue2;
    }

    public void setHeuristicValue2(int heuristicValue2) {
        this.heuristicValue2 = heuristicValue2;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getHeuristicValue1() {
        return heuristicValue1;
    }

    public void setHeuristicValue1(int heuristicValue1) {
        this.heuristicValue1 = heuristicValue1;
    }
}
