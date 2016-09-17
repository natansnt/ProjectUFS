package My;

public class Min_Heap {
	
	 	
	private int size; 		// Length of Heap
	private Node[] array;	// Array of Heap
	
	public Min_Heap(Node[] array){
		size = array.length;
		this.array = new Node[size];
		
		for(int i = 0; i < size; i++)
			this.array[i] = array[i];
		
		mountHeap();
	}
	
	public boolean isEmpty(){
		if(size == 0)
			return true;
		else
			return false;
	}
	
	private void mountHeap(){
		int w = (size-1)/2;
		for(int i = w; i>= 0; i--)
			heapFy(i);
	}
	
	private void heapFy(int father){
		
		int left = father*2 + 1;
		int right = father*2 + 2;
		int smaller = father;
		
		if( (left < size) && ( array[left].compareTo(array[father]) == -1 ) )
			smaller = left;
		if( (right < size) && ( array[right].compareTo(array[smaller]) == -1 ) )
			smaller = right;
		
		if(smaller != father){
			swap(smaller, father);
			heapFy(smaller);
		}
	}
	
	private void swap(int i, int y){
		Node aux = array[i];
		
		array[i] = array[y];
		array[y] = aux;
	}
	
	public Node remove(){
		Node aux = null;
		
		if(!isEmpty()){
			aux = array[0];
			swap( 0, size-1);	
			size--;
			heapFy(0);
		}
			return aux;
	}
	
}//End of Class Min_Heap


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
