/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My;

import static java.lang.Integer.MAX_VALUE;

/**
 *
 * @author Nayara
 */
public class Dijkstra {
   // private static final int MAXVALUE = 1000;
   private  int []  vis_way ;
   private  int [] distace;
   private int [] position;
   private Node  [] node;
   private Graph graph;
    
    
    public  Dijkstra(int init, int end, Graph graph){
       this.graph = graph;
       
       int n = this.graph.EA.length;
       
       this.position = new int [n];
       this.distace = new int [n];
       this.vis_way = new int [n];
       this.node = new Node[n];
       
       //graph.numberVertice();
          
        for(int i = 0;i< n;i++){
                distace[i] = MAX_VALUE;
                vis_way[i] = -1;
                position[i] = i; 
                node[i] = new Node(i,MAX_VALUE);
        }
        distace[init] = 0;
     
        node[init]   = new Node(position[init], distace[init]);
        Min_Heap heap = new Min_Heap(node);
        while(!heap.isEmpty()){
            Node min = heap.remove();
            
            if(!graph.EA[min.getVertex()].isEmpty()){
                Edge adj =  graph.EA[min.getVertex()].next();
                while( adj != null){
                    int v = adj.name;
                    if (distace[v] > (distace[min.getVertex()] + adj.weight)) {
                        vis_way[v] = distace[min.getVertex()]; 
                        heap.fixHeap(v);
                       
                    }
                adj = graph.EA[min.getVertex()].next();
            }
        }    
    }
   
}
        
    
  public void imprime () {
    for (int u = 0; u < distace.length; u++)
      if (vis_way[u] != -1) 
        System.out.println ("(" +vis_way[u] +"," +u+ ") -- p:" +distace[u]);

  }
    
}
