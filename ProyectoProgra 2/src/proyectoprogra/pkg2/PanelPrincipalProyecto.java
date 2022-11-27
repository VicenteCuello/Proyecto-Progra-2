
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPrincipalProyecto extends JPanel {
    
    private final startConfig start;
    private final ArrayList<Player> Players;
    private final MesaPool Table;
    private final Image wallpaper;
    
    public PanelPrincipalProyecto(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        Players = new ArrayList<>();
        Players.add(new Player());
        Players.add(new Player());
        start = new startConfig();
        Table = new MesaPool();
        wallpaper = new ImageIcon("sources/wallpaper.jpg").getImage();
        start.startGame();
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(wallpaper,0,0, 1280, 720,null);
        Table.paint(g);
        start.paint(g, this);
        Players.get(0).Paint(g, 24, 100,1);
        Players.get(1).Paint(g, 1100, 100,2);
        repaint();
    }
}
