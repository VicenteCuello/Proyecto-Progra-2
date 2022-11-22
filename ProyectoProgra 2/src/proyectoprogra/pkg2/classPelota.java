
package proyectoprogra.pkg2;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

class Pelota {
    private Image ballImage;
    private float x, y;
    private int w = 20;
    private int h = 20;
    private int dirX;
    private int dirY;
    public Pelota(){
        x = 150;
        y = 200;
        dirX = 1;
        dirY = 1;
        ballImage = new ImageIcon("sources/pelota.png").getImage();
    }
    public void moverPelota(){
        if(this.x<40){
            dirX = dirX*-1;
        }
        if(this.y<150){
            dirY = dirY*-1;
        }
        if(this.x+this.w>40+700){
            dirX = dirX*-1;
        }
        if(this.y+this.h>400+110){
            dirY = dirY*-1;
        }
        x += dirX;
        y += dirY;
    }
    public void paint(Graphics g){
        g.drawImage(ballImage, (int)x, (int)y, w, h, null);
        moverPelota();
    }
}
