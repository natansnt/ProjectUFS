package My;

public class Dijkstra {

   private  int[] vis_way ;
   private Node[] distance;
   private Graph graph;
      
  public  Dijkstra(int root, int end, Graph graph){
     
    this.graph = graph;  // Referencia para o Grafo
    this.vis_way = new int [graph.order];  // Armazena o caminho para chegar no vertice[i]  
    this.distance = new Node[graph.order]; // Armazena distancia do root ate o vertice[i]
          
    for(int i = 0;i< n;i++){ //Inicializa Vetor distance e vis_way
      distance.setVertex(i);
      distance[i].setDistance(Integer.MAX_VALUE);
      vis_way[i] = -1;
    }
    distace[root].setDistance(0); //distance da raiz pra ela msm é 0
    Min_Heap heap = new Min_Heap(distance); // Heap minimo

    while(!heap.isEmpty()){ // Heap não estiver Vazio
      Node min = heap.remove();      
      while( graph.EA[min.getVertex()].hasNext() ){ //Para todas as arestas
          Edge adj =  graph.EA[min.getVertex()].next(); //Pegua uma aresta
          //distancia do possivel caminho mais curto
          int aux = distace[min.getVertex()].weight + adj.weight;

          if (distace[adj.name].weight > aux ) {    //Se for mais curto
            distace[adj.name].setDistance(aux); // atualiza valor
            vis_way[adj.name] = min.getVertex();  // Salva o caminho
            heap.fixHeap(adj.name); // HeapFy no Heap, Mantendo a propriedade
          }
        }
      }    
    }//End of While
    imprime(root, end); // Imprime caminho no final
    System.out.println("Distancia Total: "+ distance[end].weight);
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
