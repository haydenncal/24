import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Dustin extends Characters{
    public Dustin(){
        super();
    }
    
    public Dustin(int x, int y){
        super(x,y, 200,250, 1000,3,250,1, new ImageIcon("Dustin.png"), new Bat(1400,400, 200, 200));
    //    super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
        return "Dustin ";
    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp = new ArrayList <Weapons> ();
        temp.add(new Bat());
        temp.add(new Bat());
        temp.add(new Bat());
        return temp;

    }
}
