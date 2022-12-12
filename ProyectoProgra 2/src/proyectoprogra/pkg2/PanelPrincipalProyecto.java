
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPrincipalProyecto extends JPanel implements KeyListener {
    
    private final startConfig start;
    private final MesaPool Table;
    private final Image wallpaper;
    
    public PanelPrincipalProyecto(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        start = new startConfig();
        Table = new MesaPool();
        wallpaper = new ImageIcon("sources/wallpaper.jpg").getImage();
        start.startGame(this);
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(wallpaper,0,0, 1280, 720,null);
        Font font = new Font("Space Invaders",Font.BOLD,14);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("PULSE ", 500, 650);
        g.drawString("PULSE ", 500, 80);
        g.drawString("PULSE ", 500, 100);
        g.setColor(Color.green);
        g.drawString("'R' ", 570, 650);
        g.drawString("'A' ", 570, 80);
        g.setColor(Color.red);
        g.drawString("'M' ", 570, 100);
        g.setColor(Color.white);
        g.drawString("PARA  REINICIAR  LA  MESA", 600, 650);
        g.drawString("PARA  ANADIR PELOTAS", 600, 80);
        g.drawString("PARA  REMOVER PELOTAS", 600, 100);
        Table.paint(g); 
        start.paint(g, this);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.VK_R == e.getKeyCode()){
            start.restart(this);
        }
        if(e.VK_A == e.getKeyCode()){
            start.addBall(17);
        }
        if(e.VK_M == e.getKeyCode()){
            start.removeBall();
        }
        if(e.VK_SPACE == e.getKeyCode()){
            start.finish = false;
            start.startGame(this);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
}
