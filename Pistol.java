import javax.swing.ImageIcon;

public class Pistol extends Range{
    public Pistol(){
        super();
    }

    public Pistol(int x, int y, int h, int w){
        super(x, y, 2, 0, h, w,  100,2,159, new ImageIcon("Pistol.png"));

    }

    public String toString(){
        return "Pistol";
    }
}
