import javax.swing.ImageIcon;

public class Demo extends Enemy{
    public Demo(){
        super();
    }
    public String toString(){
        return "Demo";
    }
    public Demo(int x, int y){
        super(x,y, 200, 250, 2, 172, 2000, 5, new ImageIcon("Will.png"), new Bat());


    }
}