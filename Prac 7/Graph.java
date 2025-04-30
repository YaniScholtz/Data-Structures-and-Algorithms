public class Graph {
    int verticescount = 0;
    int edgescount = 0;
    public Vertex[] vertices = new Vertex[verticescount];
    public Edge[] edges = new Edge[edgescount];

    public void addVertex(String v) {
        Vertex vert = new Vertex(v);

        if (vertices.length == 0) {
            vertices = new Vertex[1];
            vertices[0] = vert;
            return;
        }

        if (containsVertex(vert)) {
            return;
        }

        int insertionIndex = findInsertionIndex(vert);
        Vertex[] updatedVertices = new Vertex[vertices.length + 1];

        for (int i = 0, j = 0; i < updatedVertices.length; i++, j++) {
            if (i == insertionIndex) {
                updatedVertices[i] = vert;
                j--;
            } else {
                updatedVertices[i] = vertices[j];
            }
        }

        vertices = updatedVertices;
    }

    private boolean containsVertex(Vertex vertex) {
        for (Vertex v : vertices) {
            if (v != null && v.equals(vertex)) {
                return true;
            }
        }
        return false;
    }

    private int findInsertionIndex(Vertex vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null && vertex.compareTo(vertices[i]) < 0) {
                return i;
            }
        }
        return vertices.length;
    }

    public void removeVertex(String v) {
        int pos = -1;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].name.equals(v)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return; // Vertex not found
        }

        removeRelatedEdges(vertices[pos]);

        Vertex[] updatedVertices = new Vertex[vertices.length - 1];

        for (int i = 0, j = 0; i < vertices.length; i++) {
            if (i == pos) {
                continue; // Skip the vertex to be removed
            }
            updatedVertices[j++] = vertices[i];
        }

        vertices = updatedVertices;
    }

    private void removeRelatedEdges(Vertex vertex) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].vertexA.equals(vertex) || edges[i].vertexB.equals(vertex)) {
                removeEdge(edges[i].vertexA.name, edges[i].vertexB.name);
            }
        }
    }

    // public void addEdge(String a, String b, int w) {
    // Vertex vertexA = null;
    // Vertex vertexB = null;

    // for (Vertex vertex : vertices) {
    // if (vertex != null && vertex.name.equals(a)) {
    // vertexA = vertex;
    // } else if (vertex != null && vertex.name.equals(b)) {
    // vertexB = vertex;
    // }
    // }

    // if (vertexA == null || vertexB == null) {
    // return; // One or both vertices not found
    // }

    // Edge newEdge = new Edge(vertexA, vertexB, w);

    // for (Edge edge : edges) {
    // if (edge != null && edge.equals(newEdge)) {
    // return; // Duplicate edge found
    // }
    // }

    // Edge[] updatedEdges = new Edge[edges.length + 1];
    // int index = 0;

    // for (Edge edge : edges) {
    // if (edge != null && edge.compareTo(newEdge) < 0) {
    // updatedEdges[index++] = edge;
    // } else {
    // break;
    // }
    // }

    // updatedEdges[index] = newEdge;

    // for (int i = index + 1; i < updatedEdges.length; i++) {
    // updatedEdges[i] = edges[i - 1];
    // }

    // edges = updatedEdges;
    // }

    public void addEdge(String a, String b, int w) {
        Vertex vertexA = null;
        Vertex vertexB = null;

        for (Vertex vertex : vertices) {
            if (vertex != null && vertex.name.equals(a)) {
                vertexA = vertex;
            } else if (vertex != null && vertex.name.equals(b)) {
                vertexB = vertex;
            }
        }

        if (vertexA == null || vertexB == null) {
            return; // One or both vertices not found
        }

        Edge newEdge = new Edge(vertexA, vertexB, w);

        for (Edge edge : edges) {
            if (edge != null && edge.equals(newEdge)) {
                return; // Duplicate edge found
            }
        }

        Edge[] updatedEdges = new Edge[edges.length + 1];
        int index = 0;
        boolean inserted = false;

        for (int i = 0; i < edges.length; i++) {
            if (!inserted && edges[i] != null && edges[i].compareTo(newEdge) > 0) {
                updatedEdges[index++] = newEdge;
                inserted = true;
            }
            updatedEdges[index++] = edges[i];
        }

        if (!inserted) {
            updatedEdges[index] = newEdge;
        }

        edges = updatedEdges;
    }

    public void removeEdge(String a, String b) {
        int pos = -1;

        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            boolean isMatch = (edge.vertexA.name.equals(a) && edge.vertexB.name.equals(b))
                    || (edge.vertexA.name.equals(b) && edge.vertexB.name.equals(a));

            if (isMatch) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return; // Edge does not exist
        }

        Edge[] updatedEdges = new Edge[edges.length - 1];
        int index = 0;

        for (int i = 0; i < edges.length; i++) {
            if (i != pos) {
                updatedEdges[index++] = edges[i];
            }
        }

        edges = updatedEdges;
    }

    private int getPosition(Vertex vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1; // Vertex not found
    }

    public int[][] unionFind() {
        int[] root = new int[vertices.length];
        int[] next = new int[vertices.length];
        int[] length = new int[vertices.length];
        int[][] finalarr = new int[4][vertices.length];
        int[] result = new int[vertices.length];
        boolean cycle = false;

        for (int i = 0; i < vertices.length; i++) {
            root[i] = i;
            next[i] = i;
            length[i] = 1;
        }

        for (int j = 0; j < edges.length; j++) {
            int v = getPosition(edges[j].vertexA);
            int u = getPosition(edges[j].vertexB);

            if (root[u] == root[v]) {
                cycle = true;
            } else if (length[root[v]] < length[root[u]]) {
                int rt = root[v];
                length[root[u]] += length[rt];
                root[rt] = root[u];
                for (int k = next[rt]; k != rt; k = next[k]) {
                    root[k] = root[u];
                }
                int temp = next[rt];
                next[rt] = next[root[u]];
                next[root[u]] = temp;
            } else { // length[root[u]] >= length[root[v]]
                int rt = root[u];
                length[root[v]] += length[rt];
                root[rt] = root[v];
                for (int k = next[rt]; k != rt; k = next[k]) {
                    root[k] = root[v];
                }
                int temp = next[rt];
                next[rt] = next[root[v]];
                next[root[v]] = temp;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (cycle) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        // Assign the arrays to finalarr
        finalarr[0] = root;
        finalarr[1] = next;
        finalarr[2] = length;
        finalarr[3] = result;

        return finalarr;
    }

    public boolean cycle() {
        int[][] unionFindResult = unionFind();
        int[] root = unionFindResult[0];
        int[] next = unionFindResult[1];
        int[] length = unionFindResult[2];
        int[] result = unionFindResult[3];

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                // A cycle was found
                return true;
            }
        }

        return false;
    }

    public Graph minSpanningTree() {

        Graph mst = new Graph();

        // Copy the vertices from the original graph to the minimum spanning tree
        for (int i = 0; i < vertices.length; i++) {
            mst.addVertex(vertices[i].name);
        }

        // Sort the edges in non-decreasing order of their weights using bubble sort
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

        // Apply Kruskal's algorithm to generate the minimum spanning tree
        for (int i = 0; i < edges.length; i++) {
            // Get the vertices of the current edge
            Vertex vertexA = edges[i].vertexA;
            Vertex vertexB = edges[i].vertexB;

            // Create a temporary graph to check for cycles
            Graph tempGraph = new Graph();
            tempGraph.vertices = mst.vertices;
            tempGraph.edges = mst.edges;

            // Add the current edge to the temporary graph
            tempGraph.addEdge(vertexA.name, vertexB.name, edges[i].weight);

            // Check if adding the current edge creates a cycle in the minimum spanning
            // tree
            if (!tempGraph.cycle()) {
                // Add the edge to the minimum spanning tree
                mst.addEdge(vertexA.name, vertexB.name, edges[i].weight);
            }
        }

        return mst;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int[] rank, int vertexA, int vertexB) {
        if (rank[vertexA] < rank[vertexB]) {
            parent[vertexA] = vertexB;
        } else if (rank[vertexA] > rank[vertexB]) {
            parent[vertexB] = vertexA;
        } else {
            parent[vertexB] = vertexA;
            rank[vertexA]++;
        }
    }

    private int findVertexIndex(Vertex vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    private void qsort(Edge[] edges, int left, int right) {
        if (left < right) {
            int pivot = partition(edges, left, right);
            qsort(edges, left, pivot - 1);
            qsort(edges, pivot + 1, right);
        }
    }

    private int partition(Edge[] edges, int left, int right) {
        Edge pivot = edges[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (edges[j].weight <= pivot.weight) {
                i++;
                Edge temp = edges[i];
                edges[i] = edges[j];
                edges[j] = temp;
            }
        }
        Edge temp = edges[i + 1];
        edges[i + 1] = edges[right];
        edges[right] = temp;
        return i + 1;
    }

    private boolean isColor0(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return true;
            }
        }
        return false;
    }

    private int[] Push(int[] array, int num) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[array.length] = num;
        return result;
    }

    public int maxNeighbours(int[] highestIndexes, int[] neighbour) {
        int highest = Integer.MIN_VALUE;
        for (int i = 0; i < highestIndexes.length; i++) {
            if (highest < neighbour[highestIndexes[i]]) {
                highest = neighbour[highestIndexes[i]];
            }
        }
        for (int j = 0; j < highestIndexes.length; j++) {
            if (neighbour[highestIndexes[j]] == highest) {
                return highestIndexes[j];
            }
        }
        return 0;
    }

    public Vertex[][] brelazColouring() {
        if (vertices.length == 0) {
            return new Vertex[0][0];
        }
        int[] saturation = new int[vertices.length];
        int[] uncoloured = new int[vertices.length];
        int[] color = new int[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            saturation[i] = 0;
            uncoloured[i] = countNeighbours(vertices[i]);
            color[i] = 0;
        }
        // Do this while there is still an uncolouored vertex
        while (isColor0(color)) {
            int[] satResult = new int[0];
            // Find the highest saturation number that isn't coloured in yet
            int high = -1;
            for (int i = 0; i < saturation.length; i++) {
                if (color[i] != 0) {
                } else {
                    if (high < saturation[i]) {
                        high = saturation[i];
                    }
                }
            }
            // Make an array that contains all the highest saturation numbers that isn't
            // coloured inn yet
            for (int i = 0; i < saturation.length; i++) {
                if (color[i] != 0) {

                } else if (saturation[i] == high) {
                    satResult = Push(satResult, i);
                }
            }
            // Find the highest uncoloureddeggree from our saturation group
            int saveIndex = maxNeighbours(satResult, uncoloured);
            Vertex v = vertices[saveIndex];
            // Finds the smallest colour possiblee so that 2 colours aren't adjacent to
            // each
            // other
            int j = smallIndex(v, color);
            int[] uncoloredVertecis = findFriendsunColoured(color, v);
            for (int i = 0; i < uncoloredVertecis.length; i++) {
                // find neighbour for if function
                int[] thisNeighbour = findFriendsunColoured(color,
                        vertices[uncoloredVertecis[i]]);
                // check if neighbbours neighbour has the colour j
                boolean colourinneighbors = false;
                for (int k = 0; k < thisNeighbour.length; k++) {
                    if (color[thisNeighbour[k]] == j) {
                        colourinneighbors = true;
                    }
                }
                // If the neighbour doesn't contain the colour j
                if (!colourinneighbors) {
                    saturation[uncoloredVertecis[i]]++;
                }
                uncoloured[uncoloredVertecis[i]]--;
            }
            color[saveIndex] = j;
        }
        // Finds the amount of colours
        int maxColor = 0;
        for (int i = 0; i < color.length; i++) {
            if (maxColor < color[i]) {
                maxColor = color[i];
            }
        }
        // We need 3 categories
        Vertex[][] end = new Vertex[maxColor][];
        for (int i = 0; i < maxColor; i++) {
            for (int k = 0; k < color.length; k++) {
                if (color[k] == (i + 1)) {
                    if (end[i] == null) {
                        end[i] = new Vertex[0];
                    }
                    end[i] = Push(end[i], vertices[k]);
                }
            }
        }
        return end;

    }

    private Vertex[] Push(Vertex[] ar, Vertex v) {
        Vertex[] result = new Vertex[ar.length + 1];
        for (int i = 0; i < ar.length; i++) {
            result[i] = ar[i];
        }
        result[ar.length] = v;
        return result;
    }

    private int countNeighbours(Vertex vert) {
        int counter = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].vertexA.name.equals(vert.name)) {
                counter++;
            } else if (edges[i].vertexB.name.equals(vert.name)) {
                counter++;
            }
        }
        return counter;

    }

    // @Override
    // public String toString() {
    // StringBuilder strBuilder = new StringBuilder();

    // if (vertices.length == 0) {
    // return strBuilder.toString();
    // }

    // for (Vertex vertex : vertices) {
    // strBuilder.append("\t").append(vertex.toString());
    // }

    // for (Vertex vertex : vertices) {
    // strBuilder.append("\n").append(vertex.toString());

    // for (Vertex otherVertex : vertices) {
    // strBuilder.append("\t").append(edgeW(vertex, otherVertex));
    // }
    // }

    // return strBuilder.toString();
    // }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Append the column headers
        strBuilder.append("\t");
        for (Vertex vertex : vertices) {
            strBuilder.append(vertex.name).append("\t");
        }
        strBuilder.append("\n");

        // Append the rows with edge weights
        for (Vertex vertex : vertices) {
            strBuilder.append(vertex.name).append("\t");

            for (Vertex otherVertex : vertices) {
                int weight = edgeW(vertex, otherVertex);
                strBuilder.append(weight).append("\t");
            }

            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }

    public int[] findFriendsunColoured(int[] col, Vertex searcher) {
        int[] returner = new int[0];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].vertexA.name.equals(searcher.name)) {
                int pos = findPos(edges[i].vertexB.name);
                if (col[pos] == 0)
                    returner = Push(returner, pos);
            } else if (edges[i].vertexB.name.equals(searcher.name)) {
                int pos = findPos(edges[i].vertexB.name);
                if (col[pos] == 0)
                    returner = Push(returner, findPos(edges[i].vertexA.name));
            }
        }
        return returner;
    }

    private int smallIndex(Vertex v, int[] array) {
        boolean increment = true;
        int[] friends = new int[0];
        int index = 1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].vertexA.name.equals(v.name)) {
                friends = Push(friends, findPos(edges[i].vertexB.name));
            } else if (edges[i].vertexB.name.equals(v.name)) {
                friends = Push(friends, findPos(edges[i].vertexA.name));
            }
        }
        while (increment) {
            increment = false;
            for (int i = 0; i < friends.length; i++) {
                if (array[friends[i]] == index) {
                    index++;
                    // We found him coach
                    increment = true;
                }
            }
        }
        return index;
    }

    private int edgeW(Vertex a, Vertex b) {
        for (Edge edge : edges) {
            boolean isMatch = (edge.vertexA.equals(a) && edge.vertexB.equals(b))
                    || (edge.vertexA.equals(b) && edge.vertexB.equals(a));

            if (isMatch) {
                return edge.weight;
            }
        }

        return 0;
    }

    private int findPos(String string) {
        // We need to find the position of the vertex in the vert array
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].name.equals(string)) {
                return i;
            }
        }
        return -1;
    }

}
