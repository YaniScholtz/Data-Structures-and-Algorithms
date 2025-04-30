public class Vertex implements Comparable<Vertex> {
    public String name;
    public int color;
    public Vertex[] adjacencyList;
    public int adjacencyCount;
    public int maxNeighbors;

    public Vertex(String name) {
        this.name = name;
        this.color = -1; // -1 indicates no color assigned
        this.adjacencyList = new Vertex[10]; // Initialize with a default capacity
        this.adjacencyCount = 0;
        this.maxNeighbors = 0;
    }

    public void addNeighbor(Vertex neighbor) {
        adjacencyList[adjacencyCount] = neighbor;
        adjacencyCount++;
        neighbor.adjacencyList[neighbor.adjacencyCount] = this;
        neighbor.adjacencyCount++;

        // Update maxNeighbors if the current count exceeds the previous max
        if (adjacencyCount > maxNeighbors) {
            maxNeighbors = adjacencyCount;
        }
        if (neighbor.adjacencyCount > neighbor.maxNeighbors) {
            neighbor.maxNeighbors = neighbor.adjacencyCount;
        }
    }

    public int getIndex(Vertex[] vertices) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == this) {
                return i;
            }
        }
        return -1; // Vertex not found in the vertices array
    }

    public boolean isNeighbor(Vertex otherVertex) {
        // Check if the otherVertex is present in the adjacency list of this vertex
        for (int i = 0; i < adjacencyCount; i++) {
            if (adjacencyList[i] == otherVertex) {
                return true; // Found a neighbor
            }
        }
        return false; // No edge between the vertices
    }

    @Override
    public int compareTo(Vertex o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
