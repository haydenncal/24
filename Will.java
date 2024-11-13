import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Will extends Characters{
    public Will(){
        super();
    }
    
    public Will(int x, int y){
        super(x,y, 200,250, 1000,3,250,1, new ImageIcon("Will.png"), new Vision(200, 200, 200, 200));
        super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
        return "Will";
    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp = new ArrayList <Weapons> ();
        temp.add(new Vision());
        temp.add(new Vision());
        temp.add(new Vision());
        return temp;

    }
}
