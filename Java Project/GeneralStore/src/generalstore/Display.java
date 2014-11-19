package generalstore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * De class die ervoor zorgt dat de verschillende gekleurde blokken worden weergegeven.
 * @author Joep
 */
public class Display {

    private JFrame frame;
    
    /**
     * De kaart van de supermarkt
     * 0 is een muur,
     * 1 is een loop pad,
     * 2 is een afdeling,
     * 3 is een pathway,
     * 4 is een kassa,
     * 5 is de ingang
     */
    int[][] map = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 5, 5, 0, 0, 1, 4, 1, 4, 1, 4, 1, 4, 3, 0, 0, 0},
        {0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0},
        {0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    /**
     * De methode om het frame te laten zine.
     */
    public void makeFrame() {
        frame = new JFrame();
        frame.pack();
        
        //De scherm groote
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) d.getWidth(), (int) d.getHeight());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //De gridlayout voor het gestructureerd laten zien van de blokken.
        GridLayout gl = new GridLayout();
        //28 rijen net zoals de map
        gl.setRows(28);
        //28 columns net zoals de map
        gl.setColumns(28);
        
        //De panel waar de map in komt te staan.
        JPanel panel = new JPanel();
        panel.setLayout(gl);

        //De for lus die alle columns in de map langs gaat.
        for (int y = 0; y < gl.getColumns(); y++) {
            //De for lus die alle rijen in de map langs gaat
            //Er word dan gekeken wat voor kleur de label moet hebben.
            for (int x = 0; x < gl.getRows(); x++) {
                JLabel l = new JLabel();
                if (map[y][x] == 0) {
                    //Wall
                    l.setBackground(Color.black);
                } else if (map[y][x] == 1) {
                    //Walkway
                    l.setBackground(Color.white);
                } else if (map[y][x] == 2) {
                    //Departement
                    l.setBackground(Color.red);
                } else if (map[y][x] == 3) {
                    //Pathway
                    l.setBackground(Color.CYAN);
                    l.setBorder(BorderFactory.createLineBorder(Color.black));
                } else if (map[y][x] == 4) {
                    //Kassa
                    l.setBackground(Color.pink);
                    l.setBorder(BorderFactory.createLineBorder(Color.black));
                } else if (map[y][x] == 5) {
                    //Entrance
                    l.setBackground(Color.white);
                } else {
                    //Als er een cijfer word gevonden dat niet bekend is dan word er een willikeurige kleur gekozen.
                    Random rand = new Random();
                    float r = rand.nextFloat();
                    float g = rand.nextFloat();
                    float b = rand.nextFloat();
                    l.setBackground(new Color(r, g, b));

                }

                l.setOpaque(true);
                l.setName(x + "," + y);
                panel.add(l);
            }
        }
        //Om het scherm voledig te laten zien.
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.add(panel);
        frame.setResizable(false);
        frame.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}
