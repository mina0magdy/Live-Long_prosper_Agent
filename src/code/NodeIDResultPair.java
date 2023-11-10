package code;

public class NodeIDResultPair {
    private Node node;
    private IDResult result;

    public NodeIDResultPair(Node node, IDResult result) {
        this.node = node;
        this.result = result;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public IDResult getResult() {
        return result;
    }

    public void setResult(IDResult result) {
        this.result = result;
    }
}
