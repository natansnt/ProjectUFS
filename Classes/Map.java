package My;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Icons extends JLabel {
  private static final long serialVersionUID = 1L;
  private int vertex;

  public Icons(int vertex, URL url) {
    super(new ImageIcon(url));
  }

  public int getVertex() {
    return vertex;
  }
}

public class Map extends JPanel {

  private static final long serialVersionUID = 1L;
  private Rectangle points[];
  private Icons vertices[];
  private boolean Matriz[][];
  private int root, end;
  public Djikstra algorithm;
  private Graph graph;

  public Map() throws MalformedURLException {
    super();
    super.setBackground(Color.WHITE);
    super.setLayout(null);
    super.setSize(600, 600);
    
    Matriz = new boolean[600][600];
    
    root = -1;
    end = -1;
    points = new Rectangle[19];
    vertices = new Icons[19];
    initIcons();
    initMatriz();
  }

  public void initIcons() throws MalformedURLException {
    
    
      vertices[0] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/entrada.png"));
      vertices[1] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/did.png"));
      vertices[2] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/did.png"));
      vertices[3] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/did.png"));
      vertices[4] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/did.png"));
      vertices[5] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/did.png"));
      vertices[6] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/did.png"));
      vertices[7] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/moura.png"));
      vertices[8] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/resun.png"));
      vertices[9] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/bicen2.png"));
      vertices[10] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/reitoria.png"));
      vertices[11] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/ccet.png"));
      vertices[12] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/ccbs.png"));
      vertices[13] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/dce.png"));
      vertices[14] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/cv.png"));
      vertices[15] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/cech1.png"));
      vertices[16] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/CECH2.png"));
      vertices[17] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/ccsa2.png"));
      vertices[18] = new Icons(0, new URL("file:///C:/Users/Nayara/Documents/NetBeansProjects/PAA/src/My/image_grafos/ccsa1.png"));
    
    
    vertices[0].setBounds(points[0] = new Rectangle(this.getWidth()/2 - 30, 0, 30, 30));           // OK ENTRADA
    vertices[1].setBounds(points[1] = new Rectangle(this.getWidth()/2 - 120, 130, 30, 30 ));       // OK DID1
    vertices[2].setBounds(points[2] = new Rectangle(this.getWidth()/2 - 40, 130, 30, 30 ));        // OK DID2
    vertices[3].setBounds(points[3] = new Rectangle(this.getWidth()/2 + 40, 130, 30, 30 ));        // OK DID3
    vertices[4].setBounds(points[4] = new Rectangle(this.getWidth()/2 + 120, 130, 30, 30 ));       // OK DID4
    vertices[5].setBounds(points[5] = new Rectangle(this.getWidth()/2 + 5, 60, 30, 30 ));         // OK DID5
    vertices[6].setBounds(points[6] = new Rectangle(this.getWidth()/2 - 90, 60, 30, 30 ));         // OK DID6
    vertices[7].setBounds(points[7] = new Rectangle(this.getWidth()/2 - 220, 155, 30, 30 ));       // OK MOURA
    vertices[8].setBounds(points[8] = new Rectangle(this.getWidth()/2 - 260, 230, 30, 30 ));       // OK RESUN 
    vertices[9].setBounds(points[9] = new Rectangle(this.getWidth()/2 - 260, 320, 30, 40 ));       // OK BICEN
    vertices[10].setBounds(points[10] = new Rectangle(this.getWidth()/2 - 30, 385, 30, 30 ));       // OK REITORIA
    vertices[11].setBounds(points[11] = new Rectangle(this.getWidth()/2 + 180, 310, 30, 30 ));      // OK CCET
    vertices[12].setBounds(points[12] = new Rectangle(this.getWidth()/2 + 180, 270, 30, 30 ));      // OK CCBS
    vertices[13].setBounds(points[13] = new Rectangle(this.getWidth()/2 + 165, 190, 40, 40 ));      // OK DCE
    vertices[14].setBounds(points[14] = new Rectangle(this.getWidth()/2 + 200, 140, 30, 30 ));      // OK CV
    vertices[15].setBounds(points[15] = new Rectangle(this.getWidth()/2 - 150, 190, 30, 30 ));      // OK DEPD
    vertices[16].setBounds(points[16] = new Rectangle(this.getWidth()/2 - 80, 190, 30, 30 ));       // OK DEPC
    vertices[17].setBounds(points[17] = new Rectangle(this.getWidth()/2 + 5, 190, 30, 30 ));        // OK DEPB
    vertices[18].setBounds(points[18] = new Rectangle(this.getWidth()/2 + 82, 190, 30, 30 ));        // OK DEPA
    
    for(int i = 0; i < 19; i++) {
      super.add(vertices[i]);
    }
  }
  
  private void initMatriz(){
    for (int i = 0; i < Matriz.length; i++) {
      for (int k = 0; k < Matriz.length; k++) {
        Matriz[i][k] = false;        
      }
    }
  }
  
  private void ligar(int x, int y, int x1, int y1){
    if(x == x1){
      if(y > y1){
        for (int i = y; i != y1 ; i--) {
          Matriz[x][i] = true;
        }
      }else if(y < y1){
        for (int i = y; i != y1 ; i++) {
          Matriz[x][i] = true;
        }
      }
    }else{
      if(y == y1){
        if(x > x1){
          for (int i = x; i != x1 ; i--) {
            Matriz[i][y] = true;
          }
        }else if(x < x1){
          for (int i = x; i != x1 ; i++) {
            Matriz[i][y] = true;
          }
        } 
      }
    }
  }

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
    
    g2.drawLine(this.getWidth()/2 - 12, 25, this.getWidth()/2 - 12, 110);       //CAMINHO DA ENTRADA
    ligar(this.getWidth()/2 - 12, 25, this.getWidth()/2 - 12, 110);  // X = X1
    
    g2.drawLine(this.getWidth()/2 - 12, 110, this.getWidth()/2 - 175, 110);     //CAMINHO ENTRADA MOURA
    ligar(this.getWidth()/2 - 12, 110, this.getWidth()/2 - 175, 110); //Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 12, 110, this.getWidth()/2 + 180, 110);     //CAMINHO ENTRADA DID 4
    ligar(this.getWidth()/2 - 12, 110, this.getWidth()/2 + 180, 110); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 180, 110, this.getWidth()/2 + 180, 160);    //CAMINHO ENTRADA CV
    ligar(this.getWidth()/2 + 180, 110, this.getWidth()/2 + 180, 160); //X = X1
    
    g2.drawLine(this.getWidth()/2 + 180, 160, this.getWidth()/2 + 202, 160);    //CV
    ligar(this.getWidth()/2 + 180, 160, this.getWidth()/2 + 202, 160); //Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 72, 110, this.getWidth()/2 - 72, 89);       //DID6
    ligar(this.getWidth()/2 - 72, 110, this.getWidth()/2 - 72, 89); // X = X1
    
    g2.drawLine(this.getWidth()/2 - 102, 112, this.getWidth()/2 - 102, 135);    //DID1
    ligar(this.getWidth()/2 - 102, 112, this.getWidth()/2 - 102, 135); // X= X1
    
    g2.drawLine(this.getWidth()/2 + 22, 89, this.getWidth()/2 + 22, 175);       //DID5
    ligar(this.getWidth()/2 + 22, 89, this.getWidth()/2 + 22, 175); //X = X1
    
    g2.drawLine(this.getWidth()/2 + 22, 150, this.getWidth()/2 + 42, 150);      //DID3
    ligar(this.getWidth()/2 + 22, 150, this.getWidth()/2 + 42, 150); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 22, 150, this.getWidth()/2 - 9, 150);       //DID2
    ligar(this.getWidth()/2 + 22, 150, this.getWidth()/2 - 9, 150); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 100, 110, this.getWidth()/2 + 100, 198);    //CAMINHO ENTRADA DID 4 DID 3
    ligar(this.getWidth()/2 + 100, 110, this.getWidth()/2 + 100, 198); // X = X1
    
    g2.drawLine(this.getWidth()/2 + 100, 150, this.getWidth()/2 + 122, 150);    //DID 4
    ligar(this.getWidth()/2 + 100, 150, this.getWidth()/2 + 122, 150); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 100, 150, this.getWidth()/2 + 73, 150);     //DID 4 DID 3
    ligar(this.getWidth()/2 + 100, 150, this.getWidth()/2 + 73, 150); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 88, 150, this.getWidth()/2 - 37, 150);      //DID 1 DID 2
    ligar(this.getWidth()/2 - 88, 150, this.getWidth()/2 - 37, 150); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 175, 110, this.getWidth()/2 - 175, 265);    //CAMINHO ENTRADA MOURA
    ligar(this.getWidth()/2 - 175, 110, this.getWidth()/2 - 175, 265); //X = X1
    
    g2.drawLine(this.getWidth()/2 - 175, 175, this.getWidth()/2 - 189, 175);    //MOURA
    ligar(this.getWidth()/2 - 175, 175, this.getWidth()/2 - 189, 175); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 175, 175, this.getWidth()/2 + 195, 175);    //CAMINHO MOURA DCE
    ligar(this.getWidth()/2 - 175, 175, this.getWidth()/2 + 195, 175); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 195, 175, this.getWidth()/2 + 195, 160);    //CAMINHO MOURA DCE CV
    ligar(this.getWidth()/2 + 195, 175, this.getWidth()/2 + 195, 160); // X = X1
    
    g2.drawLine(this.getWidth()/2 - 102, 175, this.getWidth()/2 - 102, 155);    //DID1 MOURA DCE
    ligar(this.getWidth()/2 - 102, 175, this.getWidth()/2 - 102, 155); // X= X1
    
    g2.drawLine(this.getWidth()/2 - 23, 175, this.getWidth()/2 - 23, 155);      //DID2 MOURA DCE
    ligar(this.getWidth()/2 - 23, 175, this.getWidth()/2 - 23, 155); // X =X1
    
    g2.drawLine(this.getWidth()/2 + 58, 175, this.getWidth()/2 + 58, 155);      //DID3 MOURA DCE
    ligar(this.getWidth()/2 + 58, 175, this.getWidth()/2 + 58, 155); // X= X1
    
    g2.drawLine(this.getWidth()/2 - 132, 175, this.getWidth()/2 - 132, 197);    //DEPD MOURA DCE
    ligar(this.getWidth()/2 - 132, 175, this.getWidth()/2 - 132, 197); // X= X1
    
    g2.drawLine(this.getWidth()/2 - 62, 150, this.getWidth()/2 - 62, 197);      //DEPC MOURA DCE
    ligar(this.getWidth()/2 - 62, 150, this.getWidth()/2 - 62, 197); // X= X1
    
    g2.drawLine(this.getWidth()/2 + 23, 175, this.getWidth()/2 + 23, 197);      //DEPB MOURA DCE
    ligar(this.getWidth()/2 + 23, 175, this.getWidth()/2 + 23, 197); // X = X1
    
    g2.drawLine(this.getWidth()/2 - 132, 175, this.getWidth()/2 - 132, 197);    //DEPA MOURA DCE
    ligar(this.getWidth()/2 - 132, 175, this.getWidth()/2 - 132, 197); // X= X1
    
    g2.drawLine(this.getWidth()/2 - 120, 210, this.getWidth()/2 - 70, 210);     //DEPD DEPC
    ligar(this.getWidth()/2 - 120, 210, this.getWidth()/2 - 70, 210); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 50, 210, this.getWidth()/2 + 8, 210);       //DEPC DEPB
    ligar(this.getWidth()/2 - 50, 210, this.getWidth()/2 + 8, 210); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 38, 210, this.getWidth()/2 + 85, 210);      //DEPB DEPA
    ligar(this.getWidth()/2 + 38, 210, this.getWidth()/2 + 85, 210); //Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 110, 210, this.getWidth()/2 + 168, 210);    //DEPA DCE
    ligar(this.getWidth()/2 + 110, 210, this.getWidth()/2 + 168, 210); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 183, 197, this.getWidth()/2 + 183, 178);    //DEPA DCE
    ligar(this.getWidth()/2 + 183, 197, this.getWidth()/2 + 183, 178); // X = X1
    
    g2.drawLine(this.getWidth()/2 + 152, 150, this.getWidth()/2 + 160, 150);    //DID 4 DCE
    ligar(this.getWidth()/2 + 152, 150, this.getWidth()/2 + 160, 150); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 160, 150, this.getWidth()/2 + 160, 370);    //DCE CCET
    ligar(this.getWidth()/2 + 160, 150, this.getWidth()/2 + 160, 370); // X = X1
    
    g2.drawLine(this.getWidth()/2 + 160, 370, this.getWidth()/2 - 210, 370);    //CCET BICEN
    ligar(this.getWidth()/2 + 160, 370, this.getWidth()/2 - 210, 370); //Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 210, 370, this.getWidth()/2 - 210, 265);    //CCET BICEN
    ligar(this.getWidth()/2 - 210, 370, this.getWidth()/2 - 210, 265); //X = X1
    
    g2.drawLine(this.getWidth()/2 - 242, 265, this.getWidth()/2 - 175, 265);    //BICEN RESUN
    ligar(this.getWidth()/2 - 242, 265, this.getWidth()/2 - 175, 265); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 242, 326, this.getWidth()/2 - 242, 245);
    ligar(this.getWidth()/2 - 242, 326, this.getWidth()/2 - 242, 245); // X= X1
    
    g2.drawLine(this.getWidth()/2 - 242, 320, this.getWidth()/2 - 210, 320);
    ligar(this.getWidth()/2 - 242, 320, this.getWidth()/2 - 210, 320);  // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 160, 290, this.getWidth()/2 + 182 , 290);
    ligar(this.getWidth()/2 + 160, 290, this.getWidth()/2 + 182 , 290); // Y = Y1
    
    g2.drawLine(this.getWidth()/2 + 160, 332, this.getWidth()/2 + 182 , 332);
    ligar(this.getWidth()/2 + 160, 332, this.getWidth()/2 + 182 , 332);  // Y = Y1
    
    g2.drawLine(this.getWidth()/2 - 12, 370, this.getWidth()/2 - 12, 384);    //CCET BICEN
    ligar(this.getWidth()/2 - 12, 370, this.getWidth()/2 - 12, 384);    // X= X1
    
    g2.dispose();
  }

}
