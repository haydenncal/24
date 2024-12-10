import javax.swing.ImageIcon;

public class Energ extends Melee{
    public Energ(){
        super();
    }

    public Energ(int x, int y, int h, int w){
        super(x, y, new ImageIcon("Energ.png"));

    }

    public String toString(){
        return "Energ";
    }
}
