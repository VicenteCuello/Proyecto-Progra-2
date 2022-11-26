
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class Pelota {
    float x, y; 
    float velX, velY;
    final float mass = 2;
    int w = 20, h = 20;
    private final int type;
    private Color color;
    
    public Pelota(float x, float y, int type){
        this.x = x;
        this.y = y;
        this.velX = 15;
        this.velY = 15;
        this.type = type;
    }
    
    public void move(){
        this.x += velX; 
        this.y += velY;
        this.velX *=0.99888f;
        this.velY *=0.99888f; 
        if(Math.abs(this.velX) < 0.05 && Math.abs(this.velY) < 0.05 ){
            velX = 0;
            velY = 0;
        }
        if(this.x - 199 - 39 < 0.1){
            this.velX *=0.8f;
            this.x = 199 + 39;
            this.velX*=-1;
        }
        if(this.x + this.w + 39 - 199 - 126*7 > 0.1){
            this.velX *=0.8f;
            this.x = -this.w - 39 + 199 + 126*7;
            this.velX*=-1;
        }
        if(this.y - 108 - 41 < 0.1){
            this.velY *=0.8f;
            this.y = 108 + 41;
            this.velY*=-1;
        }
        if(this.y + this.h + 41 - 108 - 126*4 > 0.1){
            this.velY *=0.8f;
            this.y = -this.h - 41 + 108 + 126*4;
            this.velY*=-1;
        }
    }
    
    public void setVelocity(float x, float y){
        this.velX = (float)x;
        this.velY = (float)y;
    }
    
    public int getType(){
        return this.type;
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