import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Max extends Characters{
    public Max(){
        super();
    }
    
    public Max(int x, int y){
        super(x,y, 200,250, 200000,5,125,2, new ImageIcon("Max.png"), new Shotgun(200, 200, 200, 200));
        super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
        return "Max ";
    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp = new ArrayList <Weapons> ();
        temp.add(new Shotgun());
        temp.add(new Shotgun());
        temp.add(new Shotgun());
        return temp;

    }
}
