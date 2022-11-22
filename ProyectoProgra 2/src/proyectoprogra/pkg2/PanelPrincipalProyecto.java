
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipalProyecto extends JPanel {
    private Pelota p;
    private MesaPool m;
    private Image wallpaper;
    public PanelPrincipalProyecto(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        p = new Pelota();
        m = new MesaPool();
        wallpaper = new ImageIcon("sources/wallpaper.jpg").getImage();
    }
    public void paint(Graphics g){
        g.drawImage(wallpaper,0,0, 800, 800,null);
        m.paint(g);
        p.paint(g);
        repaint();
    }
}
