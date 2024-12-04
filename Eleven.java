import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Eleven extends Characters{
    public Eleven(){
        super();
    }
    
    public Eleven(int x, int y){
        super(x,y, 200,250, 1000000,10,4000,3, new ImageIcon("Eleven.png"), new Energ(200, 200, 200, 200));
       // super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
        return "Eleven ";
    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp = new ArrayList <Weapons> ();
        temp.add(new Energ());
        temp.add(new Energ());
        temp.add(new Energ());
        return temp;

    }
}
