
package proyectoprogra.pkg2;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

class MesaPool {
    private final Image poolImage;
    private int x, y;
    private final int w = 126*7;
    private final int h = 126*4;
    
    public MesaPool(){   
        poolImage = new ImageIcon("sources/mesapool.png").getImage();
    }
    
    public void paint(Graphics g){
        g.drawImage(poolImage, 199, 108, w, h, null);
    }
    
}
