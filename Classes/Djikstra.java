/**
 * Federal University of Sergipe Computing Department - DCOMP
 * 
 * @author Natanael Batista dos Santos
 * @author Paulo de Brito
 * 
 * Class responsible for implementing the dijkstra's algorithm
 */
package my;

import java.util.ArrayList;

public class Djikstra {
  private Node[] distance; // Stores smaller distances between vertices
  private Min_Heap Q; // Minimum Heap
  private Graph G; // Graph
  private int root, end; // Origin and destiny, respectively
  private ArrayList<Vertex> solution;  // Solution Set

  private int[] way; // Stores the previous vertex needed to reach the vertex i

  public Djikstra(Graph G) {
    this.G = G;
    root = -1;
    distance = new Node[G.order];
    way = new int[G.order];
  } // End of Constructor

  private void initDistance(int root) {
    for (int i = 0; i < distance.length; i++) {
      distance[i] = new Node(i, Integer.MAX_VALUE);
      way[i] = -1;
    }
    distance[root].setDistance(0);
    solution = new ArrayList<>();
  } // End of Method initDistance

  private void print(int root, int end) {
    if (root != end) {
      print(root, way[end]);
      solution.add(G.EA[end]);
    } else {
      solution.add(G.EA[root]);
    }
  } // End of Method print

  public ArrayList<Vertex> start(int root, int end) {
    if (this.root == root) {
      this.end = end;
      solution = new ArrayList<>();
    } else {
      this.root = root;
      this.end = end;
      initDistance(root);
      Q = new Min_Heap(distance);
      G.reset();

      while (!Q.isEmpty()) {
        Node minimum = Q.remove();

        while (G.EA[minimum.getVertex()].hasNext()) { // While has Edges
          Edge adj = G.EA[minimum.getVertex()].next();
          int aux = distance[minimum.getVertex()].getDistance() + adj.weight;

          if (distance[adj.name].getDistance() > aux) {
            distance[adj.name].setDistance(aux);
            Q.fixHeap(adj.name);
            way[adj.name] = minimum.getVertex();
          } // End of if
        } // End of While
      } // End of While
    }
    if (way[end] == -1) {
      return null;
    } else {
      print(root, end);
      return solution;
    }
  } // End of Method start

} // End of Class Djikstra's algorithm