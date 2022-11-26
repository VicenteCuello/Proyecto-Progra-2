
package proyectoprogra.pkg2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;

class Taco extends MouseAdapter{
    private final int ball = 16;
    private final Point MousePosition;
    private final Point BallPosition;
    private float velX, velY;
    
    public Taco(){
        MousePosition = new Point();
        BallPosition = new Point();
        updatePosition();
    }
    
    public void updatePosition(){
        final Point newPosicion = MouseInfo.getPointerInfo().getLocation();
        MousePosition.setLocation(newPosicion.getX(),newPosicion.getY());
    }
    
    public void BallPosition(Pelota A){
        BallPosition.setLocation((A.x+A.w)/2, (A.y+A.h)/2);
        velX = A.velX;
        velX = A.velY;
    }
    
    public void paint(Graphics g, Color c){
        g.setColor(c);
        int x1 = (int)Math.round(MousePosition.getX());
        int y1 = (int)Math.round(MousePosition.getY());
        int x2 = (int)Math.round(BallPosition.getX());
        int y2 = (int)Math.round(BallPosition.getY());
        if(velX == 0 && velY == 0){
            g.drawLine(x2, y2, x1, y1);
        }
    }
}
