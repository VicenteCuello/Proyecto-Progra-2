
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPrincipalProyecto extends JPanel {
    private startConfig start;
    private MesaPool m;
    private Image wallpaper;
    
    public PanelPrincipalProyecto(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        start = new startConfig();
        m = new MesaPool();
        wallpaper = new ImageIcon("sources/wallpaper.jpg").getImage();
        start.startGame();
    }
    
    public void paint(Graphics g){
        g.drawImage(wallpaper,0,0, 800, 800,null);
        m.paint(g);
        start.paint(g);
        repaint();
    }
}
