
package proyectoprogra.pkg2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;


final class Taco extends MouseAdapter{
    Boolean myTurn;
    private final int ball = 16;
    private double MousePositionX, MousePositionY;
    private double BallPositionX, BallPositionY;
    MouseListener ma;
    
    public Taco(Boolean state){
        myTurn = state;
    }
    
    public void updatePosition(JPanel Frame){
        JPanel XY = Frame;
        MousePositionX = MouseInfo.getPointerInfo().getLocation().x - XY.getLocationOnScreen().x;
        MousePositionY = MouseInfo.getPointerInfo().getLocation().y - XY.getLocationOnScreen().y;
    }
    
    public void BallPosition(double x, double y, double vx, double vy){
        BallPositionX = x+10;
        BallPositionY = y+10;
        double distX = MousePositionX - BallPositionX;
        double distY = MousePositionY - BallPositionY;
        double angle = Math.atan2(distY, distX);
        if(Math.sqrt(distX*distX+distY*distY) < Math.sqrt((BallPositionX-(BallPositionX + 20*Math.cos(angle)))*(BallPositionX-(BallPositionX + 20*Math.cos(angle)))+(BallPositionY-(BallPositionY + 20*Math.sin(angle)))*(BallPositionY-(BallPositionY + 20*Math.sin(angle))))){
            double deltaX = MousePositionX -BallPositionX - 20*Math.cos(angle);
            double deltaY = MousePositionY -BallPositionY - 20*Math.sin(angle);
            MousePositionX =BallPositionX + Math.sqrt(deltaX*deltaX+deltaY*deltaY)*Math.cos(angle)+Math.cos(angle);
            MousePositionY =BallPositionY + Math.sqrt(deltaX*deltaX+deltaY*deltaY)*Math.sin(angle)+Math.sin(angle);
        }else{
            BallPositionX =(float) (BallPositionX + 20*Math.cos(angle));
            BallPositionY =(float) (BallPositionY + 20*Math.sin(angle));
        }
    }
    
    public void golpearBola(Pelota bola, JPanel Frame, ArrayList<Pelota> p){
        ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(balls(p) == true){
                    double distX = MousePositionX - BallPositionX;
                    double distY = MousePositionY - BallPositionY;
                    double angle = Math.atan2(distY, distX);
                    bola.setVelocity((float)((-1)*(Math.cos(angle))), (float)((-1)*(Math.sin(angle))));
                }
            }
        };Frame.addMouseListener(ma);
    }
    
    public Boolean balls(ArrayList<Pelota> setter){
        Boolean lector = true;
        for (int i = 0; i < setter.size(); i++) {
            if(setter.get(i).velX != 0 && setter.get(i).velY != 0){
                lector = false;
            }
        }
        return lector;
    }
    
    public void paint(Graphics g, Color c, ArrayList<Pelota> A, JPanel Frame){
        g.setColor(c);
        this.balls(A);
        double distX = MousePositionX - BallPositionX;
        double distY = MousePositionY - BallPositionY;
        double angle = Math.atan2(distY, distX);
        int x1 = (int)(BallPositionX + 350*Math.cos(angle));
        int y1 = (int)(BallPositionY + 350*Math.sin(angle));
        int x2 = (int)Math.round(BallPositionX);
        int y2 = (int)Math.round(BallPositionY);
        this.updatePosition(Frame);
        if(this.balls(A) == true){
            g.drawLine(x1, y1, x2, y2);
        }
    }
    
}

