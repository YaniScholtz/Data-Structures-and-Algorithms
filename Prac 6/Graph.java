import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    private String[] vertices;
    private Integer[][] adjacencyMatrix;
    private int numVertices;
    private int numEdges;
    // own variable
    private int visited[];
    private int pred[];
    String work;

    public Graph(String fileName) {
        if (!fileName.isEmpty()) {
            try {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);

                // Read number of vertices
                numVertices = Integer.parseInt(scanner.nextLine());
                numEdges = 0;

                // Initialize adjacency matrix and other arrays
                adjacencyMatrix = new Integer[numVertices][numVertices];
                visited = new int[numVertices];
                pred = new int[numVertices];

                // Read and set vertices
                vertices = new String[numVertices];
                String[] verticesData = scanner.nextLine().split(" ");
                for (int i = 0; i < verticesData.length; i++) {
                    vertices[i] = verticesData[i];
                }

                // Read edge data and populate adjacency matrix
                int row = 0;
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(" ");
                    for (int col = 0; col < numVertices; col++) {
                        adjacencyMatrix[row][col] = Integer.parseInt(data[col]);
                        if (adjacencyMatrix[row][col] != 0) {
                            numEdges++;
                        }
                    }
                    row++;
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            adjacencyMatrix = new Integer[0][0];
            numVertices = 0;
            numEdges = 0;
            vertices = new String[0];
        }
    }

    public void insertVertex(String name) {
        Integer[][] newAdjacencyMatrix = new Integer[numVertices + 1][numVertices + 1];
        String[] newVertices = new String[numVertices + 1];
        visited = new int[numVertices + 1];
        pred = new int[numVertices + 1];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newAdjacencyMatrix[i][j] = adjacencyMatrix[i][j];
            }
            newAdjacencyMatrix[i][numVertices] = 0;
            newAdjacencyMatrix[numVertices][i] = 0;
        }
        newAdjacencyMatrix[numVertices][numVertices] = 0;

        for (int i = 0; i < numVertices; i++) {
            newVertices[i] = vertices[i];
        }
        newVertices[numVertices] = name;

        numVertices++;
        adjacencyMatrix = newAdjacencyMatrix;
        vertices = newVertices;
    }

    public void insertEdge(String start, String end, int weight) {
        int countstart = -1, countend = -1;
        if (weight == 0) {
            return;
        }
        for (int i = 0; i < numVertices; i++) {
            if (start.equals(vertices[i])) {
                countstart = -1;
                break;
            }
        }
        for (int i = 0; i < numVertices; i++) {
            if (end.equals(vertices[i])) {
                countend = -1;
                break;
            }
        }
        if ((countend == -1) || (countstart == -1)) {
            return;
        }
        adjacencyMatrix[countstart][countend] = weight;
        numEdges++;
    }

    public String[] getVertices() {
        return vertices;
    }

    public void removeVertex(String name) {
        int nameCol = Indexcol(name);
        if (nameCol == -1) {
            return;
        }

        Integer[][] copyDb = new Integer[numVertices - 1][numVertices - 1];
        int countrow = 0;
        int countnum = 0;
        int edgeCounter = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i != nameCol) {
                countrow = countnum = 0;
                for (int j = 0; j < numVertices; j++) {
                    if (j != nameCol) {
                        if (adjacencyMatrix[i][j] != 0) {
                            edgeCounter++;
                        }
                        copyDb[countrow][countnum] = adjacencyMatrix[i][j];
                        countnum++;
                    }
                }
                countrow++;
            }
        }
        adjacencyMatrix = copyDb;

        String[] copy = new String[numVertices - 1];
        int counter = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i != nameCol) {
                copy[counter] = vertices[i];
                counter++;
            }
        }
        vertices = copy;

        numEdges = edgeCounter;
        numVertices--;
        visited = new int[numVertices];
        pred = new int[numVertices];
    }

    public void removeEdge(String start, String end) {
        int startCol = Indexcol(start);
        int endCol = Indexcol(end);

        if (startCol != -1 && endCol != -1) {
            adjacencyMatrix[startCol][endCol] = 0;
            numEdges--;
        }
    }

    public String depthFirstTraversal() {
        if (numVertices == 0) {
            return "";
        }
        boolean[] visited = new boolean[numVertices];
        StringBuilder traversalBuilder = new StringBuilder();
        traverseDFS(0, visited, traversalBuilder);
        return traversalBuilder.toString();
    }

    void traverseDFS(int vertex, boolean[] visited, StringBuilder traversalBuilder) {
        visited[vertex] = true;
        traversalBuilder.append("[").append(vertex).append("]");

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
                traverseDFS(i, visited, traversalBuilder);
            }
        }
    }

    @Override
    public String toString() {
        if (adjacencyMatrix.length == 0) {
            return "Empty Graph";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Graph Summary:\n")
                .append("Vertices: ").append(numVertices)
                .append(", Edges: ").append(numEdges)
                .append("\n");

        for (int i = 0; i < numVertices; i++) {
            builder.append("Vertex ").append(i).append(": ").append(vertices[i]).append("\n");
        }

        builder.append("Adjacency Matrix:\n");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                builder.append(adjacencyMatrix[i][j]).append("\t");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    private int getTotalEdges() {
        return numEdges;
    }

    private int getWeight(String source, String destination) {
        // Implement your logic to calculate the weight dynamically or assume a default
        // weight value
        int row = -1;
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(source)) {
                row = i;
                break;
            }
        }
        int col = -1;
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(destination)) {
                col = i;
                break;
            }
        }
        return adjacencyMatrix[row][col]; // Assuming a default weight of 1
    }

    private int getAdjacentVerticesCount(String vertex) {
        int count = 0;
        int vertexIndex = Indexcol(vertex);

        if (vertexIndex != -1) {
            Integer[] neighbors = adjacencyMatrix[vertexIndex];
            for (int i = 0; i < neighbors.length; i++) {
                if (neighbors[i] != null) {
                    count++;
                }
            }
        }

        return count;
    }

    public int Indexcol(String name) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String breadthFirstTraversal() {
        if (numVertices == 0) {
            return "";
        }

        StringBuilder traversalBuilder = new StringBuilder();
        boolean[] visited = new boolean[numVertices];
        int[] queue = new int[numVertices];
        int front = 0;
        int rear = 0;

        visited[0] = true;
        enqueue(queue, rear++, 0);

        while (front < rear) {
            int currentVertex = dequeue(queue, front++);

            traversalBuilder.append(rw(currentVertex));

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && adjacencyMatrix[currentVertex][j] != 0) {
                    visited[j] = true;
                    enqueue(queue, rear++, j);
                }
            }
        }

        return traversalBuilder.toString();
    }

    void enqueue(int[] queue, int rear, int vertex) {
        queue[rear] = vertex;
    }

    int dequeue(int[] queue, int front) {
        int vertex = queue[front];
        return vertex;
    }

    public String rw(int cellName) {
        return "[" + name(cellName) + "]";
    }

    public String name(int i) {
        return vertices[i];
    }

    public String BinarySearch(int v, boolean[] visited) {
        String result = "";
        int[] queue = new int[0];
        int j = 0;
        while (j < numVertices) {
            if (visited[j] == false) {
                if (adjacencyMatrix[v][j] != 0) {
                    visited[j] = (1 == 1);
                    int[] newqueue = new int[queue.length + 1];
                    for (int i = 0; i < queue.length; i++) {
                        newqueue[i] = queue[i];
                    }
                    newqueue[queue.length] = j;
                    queue = newqueue;
                    result = result + "[" + vertices[j] + "]";
                }
            }
            j++;
        }
        for (int t = 0; t < queue.length; t++) {
            if (!false)
                result = result + BinarySearch(t, visited);
        }
        return result;
    }

    public Double[][] shortestPaths() {
        if (numVertices == 0) {
            return new Double[0][0];
        }

        Double[][] result = new Double[numVertices][numVertices];

        // Initialize result matrix with infinity values
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                result[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        // Compute shortest paths using Floyd-Warshall algorithm
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (i == j) {
                        result[i][j] = 0.0; // Distance to self is 0
                    } else {
                        double edgeWeight = adjacencyMatrix[i][j];
                        result[i][j] = Math.min(result[i][j], edgeWeight);
                    }
                }
            }

            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }

        return result;
    }

    public Double shortestPath(String start, String end) {
        if (numVertices == 0) {
            return null;
        }

        int startCol = Indexcol(start);
        int endCol = Indexcol(end);

        if (startCol == -1 || endCol == -1) {
            return null;
        }

        Double[] distances = new Double[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distances[i] = Double.POSITIVE_INFINITY;
        }
        distances[startCol] = 0.0;

        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                for (int k = 0; k < numVertices; k++) {
                    if (adjacencyMatrix[j][k] != 0 && distances[j] + adjacencyMatrix[j][k] < distances[k]) {
                        distances[k] = distances[j] + adjacencyMatrix[j][k];
                    }
                }
            }
        }

        // Check for negative cycles
        for (int j = 0; j < numVertices; j++) {
            for (int k = 0; k < numVertices; k++) {
                if (adjacencyMatrix[j][k] != 0 && distances[j] + adjacencyMatrix[j][k] < distances[k]) {
                    return Double.POSITIVE_INFINITY;
                }
            }
        }

        Double shortestDistance = distances[endCol];
        return shortestDistance.isInfinite() ? Double.POSITIVE_INFINITY : shortestDistance;
    }

    public boolean cycleDetection() {
        int n = vertices.length;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (cycleDetectionUtil(i, visited, recStack, adjacencyMatrix)) {
                return true;
            }
        }

        return false;
    }

    private boolean cycleDetectionUtil(int vertex, boolean[] visited, boolean[] recStack, Integer[][] graph) {
        visited[vertex] = true;
        recStack[vertex] = true;

        for (int i = 0; i < graph[vertex].length; i++) {
            int neighbor = graph[vertex][i];
            if (!visited[neighbor] && cycleDetectionUtil(neighbor, visited, recStack, graph)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[vertex] = false;
        return false;
    }

    public String stronglyConnectedComponents() {
        return "";
    }
}