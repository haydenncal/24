import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Mike extends Characters{
    public Mike(){
        super();
    }
    
    public Mike(int x, int y){
        super(x,y, 200,250, 100000,5,150,1, new ImageIcon("Mike.png"), new Pistol(1400, 400,200,200));
      //  super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
        return "Mike  ";
    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp = new ArrayList <Weapons> ();
        temp.add(new Pistol());
        temp.add(new Pistol());
        temp.add(new Pistol());
        return temp;

    }
}
