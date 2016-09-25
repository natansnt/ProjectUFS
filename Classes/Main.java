package my;

import java.net.MalformedURLException;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) throws MalformedURLException {
    JFrame window = new JFrame("UFS Maps");
    Map panel = new Map();
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(600, 600);
    window.setVisible(true);
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    window.add(panel);

  }

}
