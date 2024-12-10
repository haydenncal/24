import javax.swing.ImageIcon;

public class Shotgun extends Range{
    public Shotgun(){
        super();
    }

    public Shotgun(int x, int y, int h, int w){
        super(x, y,  2, 0,200, 200, 100,2,159, new ImageIcon("Shotgun.png"));

    }

    public String toString(){
        return "Shotgun";
    }
}

