package My;

public class Test_Heap {
	
	public static void main(String[] args) {
		Min_Heap heap;
		Node[] distance = new Node[100];
		
		for(int i = 0; i < 100; i++){
			distance[i] = new Node(i, Integer.MAX_VALUE);
		}
		distance[9].setDistance(0);
		distance[2].setDistance(3);
		distance[0].setDistance(5);
		distance[1].setDistance(6);
		
		heap = new Min_Heap(distance);
		
		for (int i = 0; i < 4; i++) {
		  System.out.println(heap.remove().getVertex());
		}
		
		distance[4].setDistance(1);
		heap.fixHeap(4);
		distance[99].setDistance(6);
		heap.fixHeap(99);
		System.out.println(heap.remove().getVertex());
		System.out.println(heap.remove().getVertex());
	}
	
}
