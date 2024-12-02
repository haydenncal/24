import javax.swing.ImageIcon;

public class Bullet extends Range{

    public String toString(){
        return "Bullet";

    }

    public Bullet(){
        super();
    }

    public Bullet(int xV, int yV){
    super(xV,yV,2,2,4,5,3, new ImageIcon("Eleven.png"));

    }
    
}
