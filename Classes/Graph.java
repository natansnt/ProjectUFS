package My;

public class Graph {
	
	private class Edge {
		int name, weight;
		Edge next;
		public Edge(int name, int weight) {
			this.name = name;
			this.weight = weight;
		}
	} // End of Class Edge

//------------------------------------------------------------------
	
	private class Vertex { // Structure Linked List

		private Edge first, 	// Head of List
	     			 last, 		// Last of List
					 bygone; 	// Edge recently accesses

		public Vertex() {
			first = null;
			bygone = null;
			last = first;
		} // End of Constructor

		private boolean isEmpty() {
			if (first == null) return true;
			else return false;
		} // End of Method isEmpty

		public void add(int name, int weight) {
			if (isEmpty()) {
				first = new Edge(name, weight);
				last = first;
			} else {
				last.next = new Edge(name, weight);
				last = last.next;
			}
		} // End of Method add

		//Method next(): Returns the next edge to be accessed
		public int next() {
			if (!isEmpty()) {
				if (bygone == null) bygone = first;
				else bygone = bygone.next;
			}
			return (bygone != null) ? bygone.name : -1;
		} // End of Method next

		//Restore the bygone to first position
		public int getFirst() {
			bygone = null;
			return next();
		}//End do Method getFirst

	} // End of Class Vertex

//------------------------------------------------------------------------------
	
	private Vertex[] EA;
	
	public Graph(int ordem){
		EA = new Vertex[ordem];
		for(int i = 0; i < ordem; i++)
			EA[i] = new Vertex();
	}
	
	
}
