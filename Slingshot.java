import javax.swing.ImageIcon;

public class Slingshot extends Range{
    public Slingshot(){
        super();
    }

    public Slingshot(int x, int y, int h, int w){
        super(x, y, 2, 0,h, w, 100,2,159, new ImageIcon("Slingshot.png"));

    }

    public String toString(){
        return "Slingshot";
    }
}
