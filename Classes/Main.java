package my;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

  public static void main(String[] args) throws MalformedURLException {

    try {
      FileReader input = new FileReader(args[0]);
      BufferedReader read = new BufferedReader(input);

      Map panel;
      Graph G = new Graph(19);
      JFrame window = new JFrame("UFS Maps");
      JLabel fundo =
          new JLabel(new ImageIcon(new URL("file:///D:/workspace/Projeto/imagens/fundo.png")));

      String buffer, data[];

      while ((buffer = read.readLine()) != null) {
        data = buffer.split(" ");
        int v1 = Integer.parseInt(data[0]);
        int v2 = Integer.parseInt(data[1]);
        int weight = Integer.parseInt(data[2]);

        ArrayList<Point> coordenates = new ArrayList<>();

        for (int i = 3; i < data.length-1; i = i + 2) {
          coordenates.add(new Point(Integer.parseInt(data[i]), Integer.parseInt(data[i + 1])));
        }

        G.join(v1, v2, weight, coordenates);
      }

      panel = new Map(G);

      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(600, 600);
      window.setLayout(null);
      window.setVisible(true);
      window.setLocationRelativeTo(null);
      window.setResizable(false);

      fundo.setBounds(0, 0, 600, 480);
      window.add(panel);
      window.add(fundo);

      read.close();
      input.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
