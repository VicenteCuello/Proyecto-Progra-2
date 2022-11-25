
package proyectoprogra.pkg2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

class Player {
    private int Score;
    private final ArrayList<Pelota> Puntos;
    
    public Player(){
        Puntos = new ArrayList<>();
        Score = 0;
    }
    
    public void addPoint(Pelota A){
        if(A.getType() == 16 && Score > 0) {
            Score--;
        }
        else{
            if(A.getType() == 8){
                Score +=2;
            }else{
                Score++;
                Puntos.add(A);
            }
        }
    }
    
    public void Paint(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 150, 520);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 150, 520);
    }
    
}
