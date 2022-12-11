package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

class hole{
    int x, y, w=20, h=20;
    public hole(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean enterBall(Pelota p){
        boolean detector = false;
        double x1 = x + w/2;
        double y1 = y + h/2;
        double x2 = p.x+p.w/2;
        double y2 = p.y+p.h/2;
        double dx = x1-x2;
        double dy = y1-y2;
        if(Math.sqrt(dx*dx+dy*dy) < 20){
            detector = true;
        }
        return detector;
    }
}

class startConfig {
    
    ArrayList<Pelota> ballSetter;
    MesaPool Table;
    ArrayList<Player> Players;  
    ArrayList<hole> Agujeros;
    public startConfig(){
        Agujeros = new ArrayList();
        Agujeros.add(new hole(199+6,108+6));
        Agujeros.add(new hole(199+430,108+5));
        Agujeros.add(new hole(199+856,108+6));
        Agujeros.add(new hole(199+430,108+477));
        Agujeros.add(new hole(199+6,108+477));
        Agujeros.add(new hole(199+856,108+477));
        ballSetter = new ArrayList<>();
        Table = new MesaPool();
        Players = new ArrayList<>();
        Players.add(new Player(false));
        Players.add(new Player(true));
    }
    public boolean enterCheck(Pelota p){
        for (int i = 0; i < Agujeros.size(); i++) {
            if(Agujeros.get(i).enterBall(p) == true){
                return true;
            }
        }
        return false;
    }
    public void startGame(PanelPrincipalProyecto Frame){
        ballSetter = new ArrayList<>();
        boolean colDetector;
        Pelota aux;
        for(int i = 0; i < 16; i++){
            do{
                colDetector = false;
                Random randX = new Random();
                Random randY = new Random();
                int x = 251 + randX.nextInt(600);
                int y = 164 + randY.nextInt(300);
                aux = new Pelota(x,y,i+1);
                for(int j = 0; j < ballSetter.size(); j++){
                    if(bCollision(aux, ballSetter.get(j)) == true && aux.getType()!= ballSetter.get(j).getType()){
                        colDetector = true;
                    }
                }
            }while(colDetector == true);
            ballSetter.add(aux);
            ballSetter.get(i).setVelocity(0, 0);
        }
        Players.get(0).taco.golpearBola(ballSetter.get(15),Frame, ballSetter);
        Players.get(1).taco.golpearBola(ballSetter.get(15),Frame, ballSetter);
    }
    public void restart(PanelPrincipalProyecto Frame){
        for(int i=0; i<2; i++){
            Players.get(i).restart();
        }
        this.ballSetter.removeAll(this.ballSetter);
        this.startGame(Frame);
    }
    public boolean bCollision(Pelota A, Pelota B){
        double dx = B.x- A.x;
        double dy = B.y - A.y;
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
            double y1final = y1*cos+x1*sin;
            double x2final = x2*cos-y2*sin;
            double y2final = y2*cos+x2*sin;
            
            B.x = A.x + x2final;
            B.y = A.y + y2final;
    
            A.x = A.x + x1final;
            A.y = A.y + y1final;
            
            A.velX = vx1*cos-vy1*sin;
            A.velY = vy1*cos+vx1*sin;
            B.velX = vx2*cos-vy2*sin;
            B.velY = vy2*cos+vx2*sin;
            return true;
        }
        return false;
    }
    
    public void paint(Graphics g, JPanel Frame){
        
        for(int i = 0; i < ballSetter.size(); i++){
            ballSetter.get(i).checkCollision(Table.Bordes, 1);
            ballSetter.get(i).checkCollision(Table.Bordes, 2);
            ballSetter.get(i).checkCollision(Table.Bordes, 3);
            ballSetter.get(i).checkCollision(Table.Bordes, 4);
            if(ballSetter.get(i).getType()==16){
                Players.get(0).taco.BallPosition(ballSetter.get(i).x, ballSetter.get(i).y, ballSetter.get(i).velX, ballSetter.get(i).velY);
                Players.get(1).taco.BallPosition(ballSetter.get(i).x, ballSetter.get(i).y, ballSetter.get(i).velX, ballSetter.get(i).velY);
            }
            ballSetter.get(i).move();
            ballSetter.get(i).paint(g);
        }
        for (int i = 0; i < ballSetter.size(); i++) {
            if(this.enterCheck(ballSetter.get(i)) == true){
                if(Players.get(0).taco.myTurn == true){
                    Players.get(0).addPoint(ballSetter.get(i));
                    Players.get(0).addPelota(ballSetter.get(i));
                    ballSetter.remove(i);
                }
                if(Players.get(1).taco.myTurn == true){
                    Players.get(1).addPoint(ballSetter.get(i));
                    Players.get(1).addPelota(ballSetter.get(i));
                    ballSetter.remove(i);
                }
            }
        }
        for(int i = 0; i < ballSetter.size()-1; i++){
            for(int j = i+1; j<ballSetter.size(); j++){
                bCollision(ballSetter.get(i), ballSetter.get(j));
            }
        }
        Players.get(0).Paint(g, 24, 100,1, ballSetter, Frame);
        Players.get(1).Paint(g, 1100, 100,2, ballSetter, Frame);
    }
}
