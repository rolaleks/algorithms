import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphBreadthFirstSearch {

    private MyGraph graph;
    private HashMap<Integer, HashMap<Integer, Integer>> edgesOnSource;

    public GraphBreadthFirstSearch(MyGraph graph) {
        this.graph = graph;
        edgesOnSource = new HashMap<>();
    }


    private HashMap<Integer, Integer> getEdges(int source) {
        HashMap<Integer, Integer> edges = edgesOnSource.get(source);
        if (edges == null) {
            return prepareData(source);
        }

        return edges;
    }

    private HashMap<Integer, Integer> prepareData(int source) {

        HashMap<Integer, Integer> edges = new HashMap<>();
        HashMap<Integer, Boolean> flags = new HashMap<>();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        flags.put(source, true);

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            for (int edgeTo : graph.getEdges(node)) {
                if (!flags.getOrDefault(edgeTo, false)) {
                    flags.put(edgeTo, true);
                    edges.put(edgeTo, node);
                    queue.addLast(edgeTo);
                }
            }
        }
        edgesOnSource.put(source, edges);
        return edges;
    }

    public boolean hasPathTo(int source, int destination) {

        return getEdges(source).get(destination) != null;
    }

    public LinkedList<Integer> pathTo(int source, int destination) {
        if (!hasPathTo(source, destination)) {
            return null;
        }
        HashMap<Integer, Integer> edges = getEdges(source);
        LinkedList<Integer> paths = new LinkedList<>();
        Integer nodeIndex = destination;

        while (nodeIndex != source) {
            if (nodeIndex == null) {
                return null;
            }
            paths.push(nodeIndex);
            nodeIndex = edges.get(nodeIndex);
        }
        paths.push(source);
        return paths;
    }
}
