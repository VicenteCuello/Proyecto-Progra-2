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
        for(int i = 0; i < 16; i++){
            Random randX = new Random();
            Random randY = new Random();
            int x = 40 + randX.nextInt(680);
            int y = 150 + randY.nextInt(380);
            ballSetter.add(new Pelota(x, y, i+1));
        }
    }
    
    public void paint(Graphics g){
        for(int i = 0; i < ballSetter.size(); i++){
            ballSetter.get(i).paint(g);
        }
    }
    
}
