
package proyectoprogra.pkg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class Player {
    
    public Taco taco;
    
    private int Score;
    private final ArrayList<Pelota> Puntos;
    
    public Player(Boolean state){
        taco = new Taco(state);
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
    
    public void addPelota(Pelota p){
        Puntos.add(p);
    }
    
    public void Paint(Graphics g, int x, int y, int numjugador, ArrayList<Pelota> p, JPanel Frame){
        
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 150, 520);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 150, 520);
        
        Font font = new Font("Space Invaders",Font.BOLD,12);
        Font font2 = new Font("Space Invaders",Font.BOLD,18);
        String score, player;
        switch (numjugador) {
            case 1:
                player = String.valueOf(numjugador);
                g.setColor(Color.red);
                
                g.setFont(font2);
                g.drawString("PLAYER " +player, x+5, y+50);
                
                g.setFont(font);
                score = String.valueOf(Score);
                g.drawString("PUNTAJE: "+score, x+5, y+130);
                taco.updatePosition(Frame);
                if(taco.myTurn == true){
                    taco.paint(g, Color.red, p, Frame);
                }
                break;
            case 2:
                player = String.valueOf(numjugador);
                g.setColor(Color.blue);
                
                g.setFont(font2);
                g.drawString("PLAYER " +player, x+5, y+50);
                
                g.setFont(font);
                score = String.valueOf(Score);
                g.drawString("PUNTAJE: "+score, x+5, y+130);
                taco.updatePosition(Frame);
                if(taco.myTurn == true){
                    taco.paint(g, Color.blue, p, Frame);
                }
                break;
        }
    }
    
}
