package proyectoprogra.pkg2;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

class startConfig {
    
    private ArrayList<Pelota> ballSetter;
    
    public startConfig(){
        ballSetter = new ArrayList<>();
    }
    public void startGame(){
        ballSetter = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            Random randX = new Random();
            Random randY = new Random();
            Random randse = new Random();
            Random randxo = new Random();
            int x = 40 + randX.nextInt(680);
            int y = 150 + randY.nextInt(380);
            float se = randse.nextInt(3)+1;
            float xo = randxo.nextInt(3)+1;
            ballSetter.add(new Pelota(x, y, i+1));
            ballSetter.get(i).setDirections(1, 1);
            ballSetter.get(i).setVelocity((float)se, (float)xo);
        }
        ballSetter.add(new Pelota(40, 150, 16));
        ballSetter.get(15).setDirections(1, 1);
        ballSetter.get(15).setVelocity(20.5f, 30.5f);
    }
    
    public void paint(Graphics g){
        for(int i = 0; i < ballSetter.size(); i++){
            ballSetter.get(i).colission();
            ballSetter.get(i).move();
            ballSetter.get(i).paint(g);
            ballSetter.get(15).getDirY();
        }
    }
    
}
