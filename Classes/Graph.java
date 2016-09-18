package My;

class Edge {

	protected int name, weight; // Name and Weight's Edge
	protected Edge next; // Next Edge of List

	public Edge(int name, int weight) {
		this.name = name;
		this.weight = weight;
	}// End of Constructor
} // End of Class Edge

class Vertex { // Structure Linked List

	private Edge first, // Head of List
			last, // Last of List
			bygone; // Edge recently accesses

	public Vertex() {
		first = null;
		bygone = null;
		last = first;
	} // End of Constructor

	private boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	} // End of Method isEmpty

	public void add(int name, int weight) {
		if (isEmpty()) {
			first = new Edge(name, weight);
			last = first;
			bygone = first;
		} else {
			last.next = new Edge(name, weight);
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
	public Edge getFirst() {
		bygone = null;
		return next();
	}// End do Method getFirst

	/**
	 * Method to check if there is a next element
	 * 
	 * @return boolean
	 */
	public boolean hasNext() {
		if (bygone == null) {
			return false;
		} else {
			return true;
		}
	}

} // End of Class Vertex

public class Graph {

	protected Vertex[] EA;
	protected int order;

	public Graph(int order) {
		this.order = order;
		EA = new Vertex[order];
		for (int i = 0; i < order; i++) {
			EA[i] = new Vertex();
		}
	}// End of Constructor

	public void join(int v1, int v2, int weight) {
		EA[v1].add(v2, weight);
	}//End of Method join

	public void print() {
		for (int i = 0; i < order; i++) {
			System.out.print(i + "-> ");
			while (EA[i].hasNext()) {
				System.out.print(EA[i].next().name + " ");
			}
			System.out.println();
		}
	}// End of Method print

}// End of Class Graph