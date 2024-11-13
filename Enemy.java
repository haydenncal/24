import javax.swing.ImageIcon;

public class Enemy extends Characters {
    public Enemy(){
        super();

    }

    public Enemy(int x, int y, int h, int w,int speed, int hea, int dam, int st, ImageIcon pic, Weapons wea){
        super(x,y,w,h,speed,hea,dam,st, pic, wea);

    }
    
}
