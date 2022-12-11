
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPrincipalProyecto extends JPanel {
    
    private final startConfig start;
    private final MesaPool Table;
    private final Image wallpaper;
    
    public PanelPrincipalProyecto(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        start = new startConfig();
        Table = new MesaPool();
        wallpaper = new ImageIcon("sources/wallpaper.jpg").getImage();
        start.startGame();
        start.Players.get(0).taco.golpearBola(start.ballSetter.get(15),this, start.ballSetter);
        start.Players.get(1).taco.golpearBola(start.ballSetter.get(15),this, start.ballSetter);
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(wallpaper,0,0, 1280, 720,null);
        Table.paint(g); 
        start.paint(g, this);
        repaint();
    }
}
