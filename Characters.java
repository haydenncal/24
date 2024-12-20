import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.ArrayList;

public class Characters {

    private int x,y,w,h, speed, health, damage, stam, dx, dy;
    private ImageIcon pic;
    private Weapons weap;
    private ArrayList <Weapons> weaponList;

    public Characters() {
        x=0;
        y=0;
        w=0;
        h=0;
        speed=0;
        health=0;
        damage=0;
        stam=0;
        dx=0;
        dy=0;
        pic= new ImageIcon();
    }

    public Characters(int xV, int yV, int width, int height, int sp, int hea, int dam, int st, ImageIcon p, Weapons we, ArrayList <Weapons> list){
        x=xV;
        y=yV;
        w=width;
        h=height;
        speed=sp;
        health=hea;
        damage=dam;
        stam=st;
        pic=p;
        dx=0;
        dy=0;
        weap=we;
        weaponList= list;


        }

        public Characters(int xV, int yV, int width, int height, int sp, int hea, int dam, int st, ImageIcon p, Weapons we){
            x=xV;
            y=yV;
            w=width;
            h=height;
            speed=sp;
            health=hea;
            damage=dam;
            stam=st;
            pic=p;
            dx=0;
            dy=0;
            weap=we;
    
    
            }

        public Weapons getWeapon(){
            return weap;
        }
        public void setWeapons(ArrayList <Weapons> list){
            weaponList =list;
        }


        public void drawChar(Graphics g2d){
            g2d.drawImage(pic.getImage(), x,y,w,h, null);
        }

        
    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getH() { return h; }
    public int getSpeed() { return speed; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getStam() { return stam; }
    public int getDx() { return dx; }
    public int getDy() { return dy; }
    public ImageIcon getPic() { return pic; }

    // Setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setW(int w) { this.w = w; }
    public void setH(int h) { this.h = h; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setStam(int stam) { this.stam = stam; }
    public void setDx(int dx) { this.dx = dx; }
    public void setDy(int dy) { this.dy = dy; }
    public void setPic(ImageIcon pic) { this.pic = pic; }


  //  public boolean Collision(Weapons C) {
  //      return getX()+getW()>=C.getX()&&getX()<=C.getX()+C.getW()&&
   //     getY()+getH()>=C.getY()&&getY()<=C.getY()+C.getH();
  //  
  //  }
}