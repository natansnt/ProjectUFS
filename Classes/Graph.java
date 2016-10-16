/**Federal University of Sergipe
 * Computing Department - DCOMP
 * @author Natanael Batista dos Santos
 * @author Paulo de Brito
 * 
 * Class responsible for the implementation
 * of the graph structure .
 */
package my;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Class responsible for the edge structure. 
 * @author Natanael and Paulo
 *
 */
class Edge {
  protected int name, weight;  // Name and Weight's Edge
  protected Edge next;  // Next Edge of List
  // Coordinates for drawing the line in UI
  protected ArrayList<Point> coordinates;  // Array of coordinates

  public Edge(int name, int weight, ArrayList<Point> coordinates) {
    this.name = name;
	this.weight = weight;
	this.coordinates = coordinates;
  }  // End of Constructor
}  // End of Class Edge

/**
 * Class responsible for the vertex structure
 * Each vertex is a Linked List, such that
 * your nodes are Edges.
 * @author Natanael and Paulo
 *
 */
class Vertex {  // Structure Linked List
  private Edge first,  // Head of List
			   last,  // Last of List
			   bygone;  // Edge recently accesses
  private int name;

  public Vertex(int name) {
    first = null;
	bygone = null;
	last = first;
	this.name = name;
  } // End of Constructor

  private boolean isEmpty() {
    if (first == null) {
	  return true;
	} else {
	  return false;
	}
  } // End of Method isEmpty

  public void add(int name, int weight, ArrayList<Point> coordinates) {
	if (isEmpty()) {
	  first = new Edge(name, weight, coordinates);
	  last = first;
	  bygone = first;
	} else {
	  last.next = new Edge(name, weight, coordinates);
	  last = last.next;
	}
  } // End of Method add

  // Method next(): Returns the next edge to be accessed
  public Edge next() {
    Edge aux = bygone;
    
	if (!isEmpty()) {
	  if (aux == null) {
	    bygone = first;
	  } else {
	    bygone = bygone.next;
	  }
	}
    return aux;
  } // End of Method next

  // Restore the bygone to first position
  public void reset() {
    bygone = first;
  }// End do Method getFirst

  /**
  * Method to check if there is a next element
  * @return boolean
  */
  public boolean hasNext() {
    if (bygone == null) {
	  return false;
	} else {
	  return true;
	}
  }  // End of Method hasNext
  
  public int getName() {
    return this.name;
  }

} // End of Class Vertex

public class Graph {
  protected Vertex[] EA;  // Structure Adjacency
  protected int order;  // Order of Graph

  public Graph(int order) {
    this.order = order;
	EA = new Vertex[order];
	for (int i = 0; i < order; i++) {
	  EA[i] = new Vertex(i);
	}
  }// End of Constructor

  // Directed Graph
  public void join(int v1, int v2, int weight, ArrayList<Point> coordinates) {
    EA[v1].add(v2, weight, coordinates);
  }//End of Method join

  public void print() {
	for (int i = 0; i < order; i++) {
	  System.out.print(i + "-> ");
	  while (EA[i].hasNext()) {
	    System.out.print(EA[i].next().name + " ");
	  }
	  EA[i].reset();
	  System.out.println();
	}
  }// End of Method print
  
  public void reset() {
    for (int i = 0; i < EA.length; i++) {
      EA[i].reset();
    }
  }  // End of Method reset

}// End of Class Graph