public class Lesson {

    public static void main(String[] args) {

        MyGraph graph = new MyGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(2, 5);
        graph.addEdge(7, 8);
        graph.addEdge(10, 20);
        graph.addEdge(20, 30);
        graph.addEdge(30, 10);

        GraphBreadthFirstSearch firstSearch = new GraphBreadthFirstSearch(graph);
        System.out.println(firstSearch.hasPathTo(1, 5));
        System.out.println(firstSearch.hasPathTo(2, 20));

        System.out.println(firstSearch.pathTo(2, 7));

    }
}
