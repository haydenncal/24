import javax.swing.ImageIcon;

public class RangeAttack extends Range{
   public RangeAttack(){
    super();

   }

   public RangeAttack(int xV, int yV, int w, int h){
    super(xV, yV, 2, 0, w, h, 30, 20, 2, new ImageIcon("Bullet.png"));
   }

   public String toString(){
    return "RangeAttack";
   }

}