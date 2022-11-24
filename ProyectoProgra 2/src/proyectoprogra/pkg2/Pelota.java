
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class Pelota {
    private float x, y; 
    private final int w = 20, h = 20;
    private int dirX, dirY;
    private float velX, velY;
    private int type;
    private float deltaTime = 0.9f;
    private Color color;
    public Pelota(float x, float y, int type){
        this.x = x;
        this.y = y;
        this.velX = 0;
        this.velY = 0;
        this.type = type;
    }
    public void move(){
        if(velX > 0.001 || velY > 0.001){
         this.x += velX*(float)dirX; 
         this.y += velY*(float)dirY;
         this.velX *=0.99555;
         this.velY *=0.99555;
        }else{
            velX = 0;
            velY = 0;
        }
    }
    public void setVelocity(float x, float y){
        this.velX = (float)x;
        this.velY = (float)y;
    }
    public void setDirections(int x, int y){
        this.dirX = x;
        this.dirY = y;
    }
    public void colission(){
        if(this.x - 40 < 0.1){
            this.velX -=0.2;
            this.x = 40f;
            this.dirX*=-1;
        }
        if(this.x -40 - 700 > 0.1){
            this.velX -=0.2;
            this.x = 40 + 700;
            this.dirX*=-1;
        }
        if(this.y - 150 < 0.1){
            this.velY -=0.2;
            this.y = 150;
            this.dirY*=-1;
        }
        if(this.y - 150 - 400 > 0.8){
            this.velY -=0.2;
            this.y = 150 + 400;
            this.dirY*=-1;
        }
    }

    public void getDirY() {
        String pos2 = String.valueOf(this.x);
        String pos = String.valueOf(this.y);
        System.out.println(pos+"-----"+pos2);
    }
    
    public void paint(Graphics g){
        Font font = new Font("Space Invaders",Font.BOLD, 8*w/25);
        g.setFont(font);
        switch (type){
            case 1:
                this.color = new Color(255, 215, 0);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 2:
                this.color = new Color(0,0, 139);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 3:
                this.color = new Color(255, 0, 0);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 4:
                this.color = new Color(75, 0, 130);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 5:
                this.color = new Color(255, 69, 0);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 6:
                this.color = new Color(0, 100, 0);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 7:
                this.color = new Color(139, 0, 0);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 8:
                this.color = new Color(0, 0, 0);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 9:
                this.color = new Color(255, 215, 0);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+8, Math.round(y)+12);
                break;
            case 10:
                this.color = new Color(0,0, 139);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+7, Math.round(y)+12);
                break;
            case 11:
                this.color = new Color(255, 0, 0);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+7, Math.round(y)+12);
                break;
            case 12:
                this.color = new Color(75, 0, 130);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+7, Math.round(y)+12);
                break;
            case 13:
                this.color = new Color(255, 69, 0);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+7, Math.round(y)+12);
                break;
            case 14:
                this.color = new Color(0, 100, 0);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+7, Math.round(y)+12);               
                break;
            case 15:
                this.color = new Color(139, 0, 0);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                g.setColor(this.color);
                g.fillRoundRect(Math.round(x), Math.round(y)+4, w, h-8, 8, 8);
                g.setColor(Color.WHITE);
                g.fillArc(Math.round(x)+4, Math.round(y)+4, w-8, h-8, 0, 360);
                g.setColor(Color.BLACK);
                g.drawString(this.type+"", Math.round(x)+7, Math.round(y)+12);
                break;
            case 16:
                this.color = new Color(255, 255, 255);
                g.setColor(this.color);
                g.fillArc(Math.round(x), Math.round(y), w, h, 0, 360);
                break;
        }
    }
}