import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Lucas extends Characters{
    public Lucas(){
        super();
    }
    
    public Lucas(int x, int y){
        super(x,y, 200,250, 100000,5,100,2, new ImageIcon("Lucas.png"), new Slingshot(200, 200, 200, 200));
        super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
        return "Lucas ";
    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp = new ArrayList <Weapons> ();
        temp.add(new Slingshot());
        temp.add(new Slingshot());
        temp.add(new Slingshot());
        return temp;

    }
}
