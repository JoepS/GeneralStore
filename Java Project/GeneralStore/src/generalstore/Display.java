/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Joep
 */
public class Display {

    private JFrame frame;
    
    int[][] map = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                   {0,2,2,2,2,2,3,3,3,3,3,3,1,1,0,0,1,4,1,4,1,4,3,3,3,0},
                   {0,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
                   {0,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
                   {0,2,2,2,2,2,1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,1,1,1,3,0},
                   {0,2,2,2,2,2,1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,1,1,1,3,0},
                   {0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
                   {0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
                   {0,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,2,2,2,2,2,2,2,2,2,2,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,2,2,2,2,2,2,2,2,2,2,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,2,2,2,2,2,2,2,2,2,2,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,2,2,2,2,2,2,2,2,2,2,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,2,2,2,2,2,2,2,2,2,2,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,2,2,2,2,2,2,2,2,2,2,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,0},
                   {0,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,3,1,1,3,0},
                   {0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
                   {0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
                   {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
    //    Display display = new Display();
    //    display.makeFrame();
    //}

    public void makeFrame() {
        frame = new JFrame();
        frame.pack();
        frame.setSize(1366, 768);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gl = new GridLayout();
        gl.setRows(26);
        gl.setColumns(26);
        frame.setLayout(gl);

        for (int y = 0; y < gl.getColumns(); y++) {
            for (int x = 0; x < gl.getRows(); x++) {
                JLabel l = new JLabel();
                //l.setBorder(BorderFactory.createLineBorder(Color.black));
                if(map[y][x] == 0){
                    //Wall
                    l.setBackground(Color.black);
                }
                else if(map[y][x] == 1){
                    //Walkway
                    l.setBackground(Color.white);
                }
                else if(map[y][x] == 2){
                    //Departement
                    l.setBackground(Color.red);
                }
                else if(map[y][x] == 3){
                    //Pathway
                    l.setBackground(Color.blue);                    
                    l.setBorder(BorderFactory.createLineBorder(Color.black));
                }
                else if(map[y][x] == 4){
                    //Kassa
                    l.setBackground(Color.pink);                    
                    l.setBorder(BorderFactory.createLineBorder(Color.black));
                    l.setText("Kassa");
                }
                else {
                    Random rand = new Random();
                    float r = rand.nextFloat();
                    float g = rand.nextFloat();
                    float b = rand.nextFloat();
                    l.setBackground(new Color(r, g, b));
                }   
                l.setOpaque(true);
                l.setName(x + "," + y);
                frame.add(l);
            }
        }
        frame.setResizable(false);
        frame.repaint();
    }
}
