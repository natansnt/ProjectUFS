package My;

class Node implements Comparable<Node>{

	private int vertex, distance;

	public Node(int vertex, int distance){
		this.vertex = vertex;
		this.distance = distance;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		if(distance == o.distance)
			return 0;
		else if(distance < o.distance)
			return -1;
		else
			return 1;
	}
}//End of Class Node

public class Min_Heap {

	private int size; 		// Length of Heap
	private int[] local;	//Storage location's vertices
	private Node[] array;	// Array of Heap

	public Min_Heap(Node[] array){
		size = array.length;
		this.array = new Node[size];
		local = new int[size];

		for(int i = 0; i < size; i++){
			this.array[i] = array[i];
			local[i] = i;
		}
		mountHeap();
	}//End of Constructor

	//Method to checks if is empty
	public boolean isEmpty(){
		if(size == 0){
			return true;
		} else{
			return false;
		}
	}

	//Method to build MinHeap
	private void mountHeap(){
		int w = (size-1)/2;
		for(int i = w; i>= 0; i--){
			heapFyDown(i);
		}
	}

	/**Fix Heap in order maintain property's heap
	 * @param vertex - Vertex changed in Djikstra
	 */
	protected void fixHeap(int vertex){
		int child = local[vertex];
		int father = child/2;

		if(array[child].compareTo(array[father]) == -1){
			heapFyUp(child);
		}else {
			heapFyDown(child);
		}
	}

	private void heapFyUp(int child){
		int father = child/2;

		if((father != child)  && (array[child].compareTo(array[father]) == -1)){
			swap(child, father);
			heapFyUp(father);
		}
	}

	//Method to keep property's Heap
	private void heapFyDown(int father){

		int left = father*2 + 1;
		int right = father*2 + 2;
		int smaller = father;

		if((left < size) && (array[left].compareTo(array[father]) == -1 )){
			smaller = left;
		}
		if((right < size) && (array[right].compareTo(array[smaller]) == -1 )){
			smaller = right;
		}
		if(smaller != father){
			swap(smaller, father);
			heapFyDown(smaller);
		}
	}

	//Method's swap
	private void swap(int i, int y){
		Node aux_n = array[i];
		array[i] = array[y];
		array[y] = aux_n;
		local[array[i].getVertex()] = local[array[y].getVertex()];
		local[array[y].getVertex()] = local[aux_n.getVertex()];
	}

	//Method for remove the root's Heap
	public Node remove(){
		Node aux = null;

		if(!isEmpty()){
			aux = array[0];
			swap( 0, size-1);
			size--;
			heapFyDown(0);
		}
		return aux;
	}

}//End of Class Min_Heap
