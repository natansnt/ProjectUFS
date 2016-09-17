/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Nayara
 */
public class testeclass {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        Scanner scanner = new Scanner(new FileReader("entradas.txt"));

        int number_vertex = (scanner.nextInt());
        int number_edge = (scanner.nextInt());
        Graph graph = new Graph(number_edge);
        while (scanner.hasNext()) {
            int vertex1 = (scanner.nextInt());
            int vertex2 = (scanner.nextInt());
            int weight = (scanner.nextInt());
            graph.join(vertex1, vertex2, weight);
        }
        graph.imprime(number_vertex);
    }

}
