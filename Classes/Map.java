/**
 * Federal University of Sergipe Computing Department - DCOMP
 * 
 * @author Natanael Batista dos Santos
 * @author Paulo de Brito
 * 
 * Class responsible for the UI
 */
package my;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class responsible for icon of the vertices
 * @author Natanael and Paulo
 *
 */
class Icons extends JLabel {
  private static final long serialVersionUID = 1L;
  private int vertex;

  public Icons(int vertex, URL url) {
    super(new ImageIcon(url));
    this.vertex = vertex;

    super.addMouseListener(new MouseListener() {

      @Override
      public void mouseReleased(MouseEvent e) {}

      @Override
      public void mousePressed(MouseEvent e) {}

      @Override
      public void mouseExited(MouseEvent e) {}

      @Override
      public void mouseEntered(MouseEvent e) {}

      @Override
      public void mouseClicked(MouseEvent e) {
        if (Map.control == 0) {
          Map.root = getVertex();
          Map.t1.setText(Map.nomes[getVertex()]);
        } else {
          Map.end = getVertex();
          Map.t2.setText(Map.nomes[getVertex()]);
        }
      }
    });
  }
  
  public int getVertex() {
    return this.vertex;
  }
}  // End of Class Icons


public class Map extends JPanel {

  protected static JTextField t1, t2;  // Text's Boxes
  protected static String nomes[];  // Names of the Vertices
  protected static int root, end, control;  // Origin, Destiny and Variable of control
  private static final long serialVersionUID = 1L;

  private Djikstra algorithm;
  private Graph graph;  // Map Graph
  private Icons vertices[];  // Image of Vertices
  private JButton b1, b2, start;  // Buttons
  private JLabel legend;  // Image of legend
  private ArrayList<Vertex> way_paint, way; // way for paint and way for restore

  public Map(Graph G) throws MalformedURLException {
    super();
    super.setLayout(null);
    super.setSize(600, 600);
    super.setBackground(new Color(0, 0, 0, 0));

    graph = G;
    algorithm = new Djikstra(graph);
    b1 = new JButton("Origem");
    b2 = new JButton("Destino");
    legend =
        new JLabel(new ImageIcon(new File("imagens/legenda.png").toURL()));
    t1 = new JTextField("Escolha");
    t2 = new JTextField("Escolha");
    start = new JButton("Procurar");
    vertices = new Icons[19];
    end = -1;
    root = -1;

    initIcons();
    initNomes();
  } // End of Constructor

  private void initNomes() {
    nomes = new String[19];
    nomes[0] = "Entrada";
    nomes[1] = "Didática 1";
    nomes[2] = "Didática 2";
    nomes[3] = "Didática 3";
    nomes[4] = "Didática 4";
    nomes[5] = "Didática 5";
    nomes[6] = "Didática 6";
    nomes[7] = "Moura";
    nomes[8] = "Resun";
    nomes[9] = "Bicen";
    nomes[10] = "Reitoria";
    nomes[11] = "CCET";
    nomes[12] = "CCBS";
    nomes[13] = "DCE";
    nomes[14] = "Centro de Vivência";
    nomes[15] = "CCSA 1";
    nomes[16] = "CCSA 2";
    nomes[17] = "CCEH 1";
    nomes[18] = "CCEH 2";
  } // End of Method initNomes

  public void initIcons() throws MalformedURLException {

    for (int i = 0; i < 19; i++) {
      vertices[i] = new Icons(i, new File("imagens/" + i + ".png").toURL());
    }
    vertices[0].setBounds(270, 9, 30, 30);
    vertices[1].setBounds(180, 130, 30, 30); 
    vertices[2].setBounds(261, 130, 30, 30); 
    vertices[3].setBounds(344, 130, 30, 30); 
    vertices[4].setBounds(423, 130, 30, 30);
    vertices[5].setBounds(307, 60, 30, 30);
    vertices[6].setBounds(212, 60, 30, 30);
    vertices[7].setBounds(80, 155, 30, 30);
    vertices[8].setBounds(42, 220, 30, 30);
    vertices[9].setBounds(42, 320, 30, 30); 
    vertices[10].setBounds(274, 380, 30, 30); 
    vertices[11].setBounds(484, 310, 30, 30);
    vertices[12].setBounds(486, 270, 30, 30);
    vertices[13].setBounds(462, 194, 30, 30); 
    vertices[14].setBounds(504, 142, 30, 30); 
    vertices[15].setBounds(152, 198, 30, 30);
    vertices[16].setBounds(222, 198, 30, 30);
    vertices[17].setBounds(308, 198, 30, 30); 
    vertices[18].setBounds(385, 196, 30, 30); 
    
    for (int i = 0; i < 19; i++) {
      super.add(vertices[i]);
    }
    super.add(b1);
    super.add(b2);
    super.add(legend);
    super.add(t1);
    super.add(t2);
    super.add(start);

    t1.setBounds(88, 390, 120, 25);
    t2.setBounds(88, 420, 120, 25);
    b1.setBounds(5, 390, 80, 25);
    b2.setBounds(5, 420, 80, 25);
    start.setBounds(500, 420, 90, 25);
    legend.setBounds(0, 412, 600, 200);
    t1.setEditable(false);
    t2.setEditable(false);
    actionButton();
  }  // End of Method initIcons

  private void actionButton() {
    b1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        control = 0;
      }
    });
    b2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        control = 1;
      }
    });
    start.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        if(root == -1 || end == -1) {
          JOptionPane.showMessageDialog(null, "Por Favor Escolha o Seu Trajeto!");
        } else {
          if( root == end) {
            JOptionPane.showMessageDialog(null, "Por Favor Escolha o Destino!");
          } else {
            way = algorithm.start(root, end);
            paintWay();            
          }
        }
      }
    });
  } // End of Method actionButton

  private Edge aresta(Vertex v, int v2) {
    Edge aux = v.next();
    
    while (aux.name != v2) {
      aux = v.next();
    }
    return aux;
  } // End of Method aresta

  private void paintWay() {
    Edge aux;

    if (way_paint != null) {
      graph.reset();
      for (int i = 0; i < way_paint.size() - 1; i++) {
        aux = aresta(way_paint.get(i), way_paint.get(i + 1).getName());
        paint(aux, 0);
      }
    }
    if (start != null) {
      graph.reset();
      for (int i = 0; i < way.size() - 1; i++) {
        aux = aresta(way.get(i), way.get(i + 1).getName());
        paint(aux, 1);
      }
    }
    way_paint = way;
  }  // End of Method paintWay

  private void paint(Edge w, int x) {
    Graphics2D g2 = (Graphics2D) this.getGraphics();
    RenderingHints rh =
        new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    BasicStroke line = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    g2.setRenderingHints(rh);
    g2.setStroke(line);
    if (x == 0) {
      g2.setColor(Color.BLACK);
    } else {
      g2.setColor(Color.RED);
    }
    for (int i = 0; i < w.coordinates.size() - 1; i++) {
      int x1 = w.coordinates.get(i).x;
      int y1 = w.coordinates.get(i).y;
      int x2 = w.coordinates.get(i + 1).x;
      int y2 = w.coordinates.get(i + 1).y;
      g2.drawLine(x1, y1, x2, y2);
    }
    g2.dispose();
  } // End of Method paint


  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g.create();
    RenderingHints rh =
        new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    BasicStroke line = new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    g2.setRenderingHints(rh);
    g2.setStroke(line);
    g2.setColor(Color.BLACK);

    g2.drawLine(285, 35, 285, 110);  // Entrada
    g2.drawLine(125, 110, 480, 110); // Caminho
    g2.drawLine(480, 110, 480, 160); // Caminho
    g2.drawLine(480, 160, 502, 160); // CV 
    g2.drawLine(198, 110, 198, 133); // Did1 
    g2.drawLine(291, 150, 342, 150); // Did2 - Did3
    g2.drawLine(373, 150, 422, 150);  // Did3 - Did4
    g2.drawLine(322, 89, 322, 175); // Did5
    g2.drawLine(228, 110, 228, 89); // Did6
    g2.drawLine(400, 110, 400, 198); // Caminho
    g2.drawLine(238, 150, 263, 150); // Did2
    g2.drawLine(125, 110, 125, 265); // Caminho
    g2.drawLine(111, 175, 495, 175); // Moura - Caminho
    g2.drawLine(495, 175, 495, 160); // Caminho - CV
    g2.drawLine(198, 175, 198, 158); // Did1
    g2.drawLine(277, 175, 277, 155); // Did2
    g2.drawLine(358, 175, 358, 155); // Did3
    g2.drawLine(238, 150, 238, 197); // Caminho - Did2
    g2.drawLine(323, 175, 323, 197); // CCEH1
    g2.drawLine(168, 175, 168, 197); // CCSA 1
    g2.drawLine(180, 210, 224, 210); // CCSA1 - CCSA2
    g2.drawLine(250, 210, 308, 210); // CCSA2 - CCEH1 
    g2.drawLine(338, 210, 385, 210); //CCEH1 - CCEH2
    g2.drawLine(415, 210, 468, 210); // CCEH2 - DCE 
    g2.drawLine(483, 194, 483, 175); // DCE
    g2.drawLine(452, 150, 460, 150); // Did4 
    g2.drawLine(460, 150, 460, 370); // Caminho 
    g2.drawLine(460, 370, 90, 370); // Caminho 
    g2.drawLine(90, 265, 90, 370); // Caminho 
    g2.drawLine(58, 265, 125, 265); // Caminho
    g2.drawLine(58, 245, 58, 326); // Resun - Bicen
    g2.drawLine(58, 320, 90, 320); // Bicen
    g2.drawLine(460, 290, 482, 290); // CCBS
    g2.drawLine(460, 332, 482, 332); // CCET
    g2.drawLine(288, 370, 288, 384); // Reitoria

    g2.dispose();
  } // End of Method paintComponent

}
