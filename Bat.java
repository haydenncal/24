import javax.swing.ImageIcon;

public class Bat extends Melee{
    public Bat(){
        super();
    }

    public Bat(int x, int y, int h, int w){
        super(x, y, new ImageIcon("Bat.png"));

    }

    public String toString(){
        return "Bat";
    }
}
