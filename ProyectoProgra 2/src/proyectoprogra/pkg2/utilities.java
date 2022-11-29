package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

class startConfig {
    
    ArrayList<Pelota> ballSetter;
    Taco taco;
    
    public startConfig(){
        ballSetter = new ArrayList<>();
        taco = new Taco();
    }
    
    public void startGame(){
        ballSetter = new ArrayList<>();
        boolean colDetector;
        Pelota aux;
        for(int i = 0; i < 16; i++){
            do{
                colDetector = false;
                Random randX = new Random();
                Random randY = new Random();
                int x = 199 + randX.nextInt(683);
                int y = 108 + randY.nextInt(396);
                aux = new Pelota(x,y,i+1);
                for(int j = 0; j < ballSetter.size();j++){
                    if(bCollision(aux, ballSetter.get(j)) == true && aux.getType()!= ballSetter.get(j).getType()){
                        colDetector = true;
                    }
                }
            }while(colDetector == true);
            ballSetter.add(aux);
            ballSetter.get(i).setVelocity(0, 0);
        }
    }
    
    public boolean bCollision(Pelota A, Pelota B){
        float dx = B.x- A.x;
        float dy = B.y - A.y;
        double dist = Math.sqrt(dx*dx + dy*dy);
        if(dist < 20){
            double angle = Math.atan2(dy, dx);
            double sin = Math.sin(angle);
            double cos = Math.cos(angle);
            
            double x1 = 0, y1  = 0;
            double x2 = dx*cos+dy*sin;
            double y2 = dy*cos-dx*sin;
            
            double vx1 = A.velX*cos+A.velY*sin;
            double vy1 = A.velY*cos-A.velX*sin;
            double vx2 = B.velX*cos+B.velY*sin;
            double vy2 = B.velY*cos-B.velX*sin;
            
            double vx1final = ((A.mass-B.mass)*vx1+2*B.mass*vx2)/(A.mass+B.mass);
            double vx2final = ((B.mass-A.mass)*vx2+2*A.mass*vx1)/(A.mass+B.mass);
            
            vx1 = vx1final;
            vx2 = vx2final;
            
            double absV = Math.abs(vx1)+Math.abs(vx2);
            double overlap = (20)-Math.abs(x1-x2);
            x1 += vx1/absV*overlap;
            x2 += vx2/absV*overlap;
            
            double x1final = x1*cos-y1*sin;
            double  y1final = y1*cos+x1*sin;
            double x2final = x2*cos-y2*sin;
            double y2final = y2*cos+x2*sin;
            
            B.x = (float) (A.x + x2final);
            B.y = (float) (A.y + y2final);
    
            A.x = (float) (A.x + x1final);
            A.y = (float) (A.y + y1final);
            
            A.velX = (float) (vx1*cos-vy1*sin);
            A.velY = (float) (vy1*cos+vx1*sin);
            B.velX = (float) (vx2*cos-vy2*sin);
            B.velY = (float) (vy2*cos+vx2*sin);
            return true;
        }
        return false;
    }
    
    public void paint(Graphics g, JPanel Frame){
        for(int i = 0; i < ballSetter.size(); i++){
            if(ballSetter.get(i).getType()==16){
                taco.BallPosition(ballSetter.get(i).x, ballSetter.get(i).y, ballSetter.get(i).velX, ballSetter.get(i).velY);
            }
            ballSetter.get(i).move();
            ballSetter.get(i).paint(g);
        }
        for(int i = 0; i < ballSetter.size()-1; i++){
            for(int j = i+1; j<ballSetter.size(); j++){
                bCollision(ballSetter.get(i), ballSetter.get(j));
            }
        }
        taco.updatePosition(Frame);
        taco.paint(g, Color.red, ballSetter, Frame);
    }
}
