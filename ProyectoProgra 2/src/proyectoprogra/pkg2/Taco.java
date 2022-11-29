
package proyectoprogra.pkg2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

final class Taco extends MouseAdapter{
    private final int ball = 16;
    private float MousePositionX, MousePositionY;
    private float BallPositionX, BallPositionY;
    private float velX, velY;
    MouseListener ma;
    
    public Taco(){
    }
    
    public void updatePosition(JPanel Frame){
        JPanel XY = Frame;
        MousePositionX = MouseInfo.getPointerInfo().getLocation().x - XY.getLocationOnScreen().x;
        MousePositionY = MouseInfo.getPointerInfo().getLocation().y - XY.getLocationOnScreen().y;
    }
    
    public void BallPosition(float x, float y, float vx, float vy){
        BallPositionX = x+10;
        BallPositionY = y+10;
        double distX = MousePositionX - BallPositionX;
        double distY = MousePositionY - BallPositionY;
        double angle = Math.atan2(distY, distX);
        BallPositionX =(float) (BallPositionX + 20*Math.cos(angle));
        BallPositionY =(float) (BallPositionY + 20*Math.sin(angle));
        velY = vy;
    }
    public void golpearBola(Pelota bola, JPanel Frame){
        ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(bola.velX == 0 && bola.velY==0){
                    double distX = MousePositionX - BallPositionX;
                    double distY = MousePositionY - BallPositionY;
                    double angle = Math.atan2(distY, distX);
                    bola.setVelocity((float)((-1)*(1*Math.cos(angle))), (float)((-1)*(1*Math.sin(angle))));
                }
            }
        };Frame.addMouseListener(ma);
        
    }
    
    public void paint(Graphics g, Color c, ArrayList<Pelota> A, JPanel Frame){
        g.setColor(c);
        double distX = MousePositionX - BallPositionX;
        double distY = MousePositionY - BallPositionY;
        double angle = Math.atan2(distY, distX);
        int x1 = (int)(BallPositionX + 350*Math.cos(angle));
        int y1 = (int)(BallPositionY + 350*Math.sin(angle));
        int x2 = (int)Math.round(BallPositionX);
        int y2 = (int)Math.round(BallPositionY);
        this.updatePosition(Frame);
        if(velX == 0 && velY == 0){
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
