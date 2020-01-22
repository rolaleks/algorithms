import java.util.ArrayList;
import java.util.HashMap;

public class MyGraph {

    private HashMap<Integer, ArrayList<Integer>> nodes;

    public MyGraph() {
        nodes = new HashMap<>();
    }

    private ArrayList<Integer> getOrCreateNode(int nodeIndex) {
        ArrayList<Integer> foundNode = nodes.getOrDefault(nodeIndex, new ArrayList<>());
        nodes.put(nodeIndex, foundNode);
        return foundNode;
    }

    public void addEdge(int nodeIndex1, int nodeIndex2) {
        if (nodeIndex1 < 0 || nodeIndex2 < 0) {
            throw new IllegalArgumentException();
        }

        this.getOrCreateNode(nodeIndex1).add(nodeIndex2);
        if (nodeIndex1 != nodeIndex2)
            this.getOrCreateNode(nodeIndex2).add(nodeIndex1);
    }

    public ArrayList<Integer> getEdges(int nodeIndex) {
        return nodes.getOrDefault(nodeIndex, new ArrayList<>());
    }

    public int getSize() {
        return nodes.size();
    }

}
