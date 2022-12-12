
package proyectoprogra.pkg2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

final class MesaPool {
    
    private final Image poolImage;
    private int x, y;
    private final int w = 882;
    private final int h = 504;
    ArrayList<Segmento> Bordes;
    
    public MesaPool(){   
        poolImage = new ImageIcon("sources/mesapool.png").getImage();
        Bordes = new ArrayList<>();
        this.addSegments();
    }
    
    public void addSegments(){
        
        //DOWN BORDERS
        Bordes.add(new Segmento(199+486, 108+464, 199+818, 108+464));
        Bordes.add(new Segmento(199+466, 108+479, 199+486, 108+464));
        Bordes.add(new Segmento(199+466-9, 108+479, 199+466, 108+479));
        Bordes.add(new Segmento(199+818, 108+464, 199+837, 108+479));
        Bordes.add(new Segmento(199+837, 108+479, 199+837+5, 108+479));
        
        Bordes.add(new Segmento(199+64, 108+464, 199+395, 108+464));
        Bordes.add(new Segmento(199+44, 108+479, 199+64, 108+464));
        Bordes.add(new Segmento(199+44-3, 108+479, 199+44, 108+479));
        Bordes.add(new Segmento(199+395, 108+464, 199+415, 108+479));
        Bordes.add(new Segmento(199+415, 108+479, 199+415+11, 108+479));
        
        //TOP BORDERS
        Bordes.add(new Segmento(262, 149, 594, 149));
        Bordes.add(new Segmento(243, 135, 262, 149));
        Bordes.add(new Segmento(240, 135, 243, 135));
        Bordes.add(new Segmento(594, 149, 199+414, 108+27));
        Bordes.add(new Segmento(199+414, 108+27, 199+426, 108+27));
        
        Bordes.add(new Segmento(199+457, 108+27, 199+467, 108+27));
        Bordes.add(new Segmento(199+467, 108+27, 199+486, 108+41));
        Bordes.add(new Segmento(199+486, 108+41, 199+818, 108+41));
        Bordes.add(new Segmento(199+818, 108+41, 199+838, 108+26));
        Bordes.add(new Segmento(199+838, 108+26, 199+842, 108+26));
        
        //LEFT BORDERS
        Bordes.add(new Segmento(238, 177, 238, 544));
        Bordes.add(new Segmento(224, 158, 238, 177));
        Bordes.add(new Segmento(238, 544, 225, 563));
        Bordes.add(new Segmento(224, 150, 224, 158));
        Bordes.add(new Segmento(224, 563, 224, 108+462));
       
        //RIGHT BORDERS
        Bordes.add(new Segmento(199+843, 108+71, 199+843, 108+435));
        Bordes.add(new Segmento(199+857, 108+51, 199+843, 108+71));
        Bordes.add(new Segmento(199+857, 108+42, 199+857, 108+51));
        Bordes.add(new Segmento(199+843, 108+435, 199+857, 108+455));
        Bordes.add(new Segmento(199+857, 108+455, 199+857, 108+455+8)); 
    }
    
    public void paint(Graphics g){
        
        g.drawImage(poolImage, 199, 108, w, h, null);
        for (int i = 0; i < Bordes.size(); i++) {
            Bordes.get(i).paint(g);
        }
        
    }

}

class Segmento{
    
    double x1, y1, x2, y2;
    double cx, cy, angle, large;
    
    public Segmento(float x1, float y1, float x2, float y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        cx = (x1+x2)/2;
        cy = (y1+y2)/2;
        large = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        angle = Math.atan2((y2-y1), (x2-x1));
    }
    
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
    }
    
}