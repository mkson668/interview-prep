import java.util.*;

public class CritialRouters{
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edgeIn = new ArrayList<>();
        edgeIn.add(new ArrayList<>(Arrays.asList(0,1)));
        edgeIn.add(new ArrayList<>(Arrays.asList(0,2)));
        edgeIn.add(new ArrayList<>(Arrays.asList(1,3)));
        edgeIn.add(new ArrayList<>(Arrays.asList(2,3)));
        edgeIn.add(new ArrayList<>(Arrays.asList(2,5)));
        edgeIn.add(new ArrayList<>(Arrays.asList(5,6)));
        edgeIn.add(new ArrayList<>(Arrays.asList(3,4)));
        ArrayList<Integer> ret = findArticualtionPoints(7, 7, edgeIn);
        System.out.println(ret);
    }

    /*
        numNodes, an integer representing the number of nodes in the graph.
        numEdges, an integer representing the number of edges in the graph.
        edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
    */

    // bruteforce
    public static ArrayList<Integer> findArticualtionPoints(int numNodes, int numEdges, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> edgeStore = new ArrayList<>();
        // keep track of visited vertices
        Set<Integer> vertexSet = new HashSet<Integer>();
        ArrayList<Integer> actuationVertices = new ArrayList<>();
        int currVertex = 0;
        for (int i = 0; i < numNodes; i++){
            currVertex = i;
            for (int j = 0; j < numEdges; j++){
                if (!edges.get(j).contains(currVertex)) {
                    // add edges that dont contain this vertex
                    edgeStore.add(edges.get(j));
                    
                }            
            }
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(edgeStore.get(0).get(0));
            vertexSet.add(edgeStore.get(0).get(0));
            //BFS graph
            while(!q.isEmpty()) {
                int vertex = q.poll();
                // check all outbound edges and add the vertices they touch to queue
                for (ArrayList<Integer> edg: edgeStore) {
                    if (edg.contains(vertex)) {
                        if (edg.get(0) == vertex) {
                            // only add if not visited yet or else infinite cycle
                            if (!vertexSet.contains(edg.get(1))) {
                                vertexSet.add(edg.get(1));
                                q.add(edg.get(1));
                            }
                        } else {
                            if (!vertexSet.contains(edg.get(0))) {
                                vertexSet.add(edg.get(0));
                                q.add(edg.get(0));
                            }
                        }
                    }
                }
            }
            // check if still possible to reach rest of vertices depite removed vertex
            if (!(vertexSet.size() == (numNodes - 1))) {
                actuationVertices.add(currVertex);
            }
            vertexSet.clear();
            edgeStore.clear();;  
        }
        return actuationVertices;
    }
}