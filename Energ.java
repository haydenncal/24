import javax.swing.ImageIcon;

public class Energ extends Range{
    public Energ(){
        super();
    }

    public Energ(int x, int y, int h, int w){
        super(x, y, 2, 0, h, w,  100,2,159, new ImageIcon("Energ.png"));

    }

    public String toString(){
        return "Energ";
    }
}
