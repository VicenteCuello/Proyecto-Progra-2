
package proyectoprogra.pkg2;
import javax.swing.JFrame;

public class VentanaProyecto extends JFrame {
    public PanelPrincipalProyecto panel;
    public VentanaProyecto(){
        this.setSize(800, 800);
        setTitle("Pool");
        this.setResizable(false);
        this.add(new PanelPrincipalProyecto());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
