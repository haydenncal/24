import javax.swing.ImageIcon;

public class RangeAttack extends Range{
   public RangeAttack(){
    super();

   }

   public RangeAttack(int x, int y){
    super(x, y,10, 10, 70, 5, 4, new ImageIcon("Bullet.png"));
   }

   public String toString(){
    return "RangeAttack";
   }

}