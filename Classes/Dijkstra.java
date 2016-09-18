package My;

public class Djikstra {

   private  int[] vis_way ;
   private Node[] distance;
      
  public  Djikstra(int root, int end, Graph graph){
     
    vis_way = new int [graph.order];  // Armazena o caminho para chegar no vertice[i]  
    distance = new Node[graph.order]; // Armazena distancia do root ate o vertice[i]
          
    for(int i = 0; i< graph.order; i++){ //Inicializa Vetor distance e vis_way
      distance[i] = new Node(i , Integer.MAX_VALUE);
      vis_way[i] = -1;
    }
    distance[root].setDistance(0); //distance da raiz pra ela msm é 0
    Min_Heap heap = new Min_Heap(distance); // Heap minimo

    while(!heap.isEmpty()){ // Heap não estiver Vazio
      
      Node min = heap.remove();      
      
      while( graph.EA[min.getVertex()].hasNext() ){ 	//Para todas as arestas
        
    	Edge adj =  graph.EA[min.getVertex()].next(); //Pegua uma aresta
        //distancia do possivel caminho mais curto
        int aux = distance[min.getVertex()].getDistance() + adj.weight;

        if (distance[adj.name].getDistance() > aux ) {    //Se for mais curto
          distance[adj.name].setDistance(aux); 			  // atualiza valor
          vis_way[adj.name] = min.getVertex();  		  // Salva o caminho
          heap.fixHeap(adj.name); 						  // HeapFy no Heap, Mantendo a propriedade
        }
      }

    }//End of While
    imprime(root, end); // Imprime caminho no final
    System.out.println("Distancia Total: "+ distance[end].getDistance());
  }
        
  public void imprime (int root, int end) {
      if(root != end){
        imprime(root,vis_way[end]);
        System.out.print(end + " ");
      }else{
          System.out.print(root + " ");
      }
  }
}