import javax.swing.ImageIcon;

public class Vision extends Melee{
    public Vision(){
        super();
    }

    public Vision(int x, int y, int h, int w){
        super(x, y, 200, 200, 100,2,159, new ImageIcon("Vision.png"));

    }

    public String toString(){
        return "Vision";
    }
}
