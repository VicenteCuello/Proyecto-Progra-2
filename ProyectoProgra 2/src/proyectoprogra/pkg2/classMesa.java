
package proyectoprogra.pkg2;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

class MesaPool {
    private Image poolImage;
    private int x, y;
    private int w = 700;
    private int h = 400;
    public MesaPool(){   
        poolImage = new ImageIcon("sources/mesapool.png").getImage();
    }
    public void paint(Graphics g){
        g.drawImage(poolImage, 40, 150, w, h, null);
    }
}
