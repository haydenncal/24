import javax.swing.ImageIcon;
import java.awt.Graphics;


public class Weapons {
   // public static Object getX;
    //
    int x, y, dx, dy, w, h, dam, duribility, dps ;
   private ImageIcon pic;
    public Weapons() {

    }
    public Weapons(int d, int dur, int dp, ImageIcon p){
        dam=d;
        duribility=dur;
        dps=dp;
        pic = p;
    }

   public void drawChar(Graphics g2d){
     g2d.drawImage(pic.getImage(), x,y,w,h, null);
   }

    //range
   public Weapons(int x, int y, int Dx, int Dy, int h, int w, int dam2, int dur, int dp, ImageIcon p) {
        //TODO Auto-generated constructor stub
        dam=dam2;
        duribility=dur;
        dps=dp;
        pic = p;
        this.x=x;
        this.y=y;
       this.h=h;
       this.w=w;
       dx = Dx;
       dy = Dy;
        
    
    }

    //melee
    public Weapons( int x, int y, ImageIcon p) {
        this.x=x;
        this.y=y;
        pic = p;

    }
    public void setX(int i) {
        // TODO Auto-generated method stub
   x=i; 
}

public void move() {
    x += dx;
    y += dy;
    System.out.println(x+"  "+ dx);
}

public boolean Collision(Characters character) {
    // Check for a collision between this weapon and the character
    return getX() + getW() >= character.getX() && getX() <= character.getX() + character.getW() &&
           getY() + getH() >= character.getY() && getY() <= character.getY() + character.getH();
}




//need more getters ans setters.
// Getters
public int getX() { return x; }
public int getY() { return y; }
public int getW() { return w; }
public int getH() { return h; }
//public int getSpeed() { return speed; }
//public int getHealth() { return health; }
//public int getDamage() { return damage; }
//public int getStam() { return stam; }
//public int getDx() { return dx; }
//public int getDy() { return dy; }
//public ImageIcon getPic() { return pic; }

// Setters
//public void setX(int x) { this.x = x; }
public void setY(int y) { this.y = y; }
public void setW(int w) { this.w = w; }
public void setH(int h) { this.h = h; }
//public void setSpeed(int speed) { this.speed = speed; }
//public void setHealth(int health) { this.health = health; }
//public void setDamage(int damage) { this.damage = damage; }
//public void setStam(int stam) { this.stam = stam; }
//public void setDx(int dx) { this.dx = dx; }
//public void setDy(int dy) { this.dy = dy; }
public void setPic(ImageIcon pic) { this.pic = pic; }
    public ImageIcon getPic() {
            return pic;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getPic'");
    }
    public int getDPS() {
            return dam;
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getDPS'");
    }
    public int getDuribility() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getDuribility'");
        return duribility;
    }
    public int getDam() {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'getDam'");
      return dam;
    }

    //setters
    public void setDamage(int dam) {
        this.dam = dam;

    }
    public void setDuribility( int dur) {
        this.duribility = dur;

    }
    public void setDps(int dps) {
        this.dps = dps;
    }

public void drawWeap(Graphics g2d){
    g2d.drawImage(pic.getImage(), x, y, w, h, null);
  //  System.out.println(getX() + " y" + getY() + " h" + getH() + "w " + getW() + " pic " + getPic());

}
    

}
