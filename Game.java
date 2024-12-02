import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener,
MouseMotionListener{

    private BufferedImage back;
    private ImageIcon background;
    private int key, x, y;
    private ArrayList <Characters> charList;
    private String screen;
    private Characters player;
   // private Weapons weapom;
    private ArrayList <Range> rangeWeap;
    private Queue <Enemy> enemies;
    private File saveFile;
    private double curtime;
    private double time;



    public Game() {
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        saveFile = new File("saved_file2.0.txt");
        key =-1;
        x=0;
        y=0;
        rangeWeap = new ArrayList<>();
        charList = setCharList();
        for(Characters c: charList){
            System.out.println(c);                  
        }
        //rangeWeap = setrangeWeap();
        //for(Weapons w: rangeWeap){
         //   System.out.println(w);                  
        //}
        background = new ImageIcon("background.png");
        screen="start";
        //rangeWeap= new ArrayList <Range>();
        enemies = setEs();
        System.out.println(enemies.size());
        curtime = 0;
        time = System.currentTimeMillis();


    }

    public void createFile (){
        try {
            if(saveFile.createNewFile()){
                System.out.println("Successfuly created file!");
            }
            else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void readFile(){
        Scanner sc;
        try {
            sc = new Scanner(saveFile);
            while(sc.hasNext()){
                System.out.println(sc.next());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    public void writeToFile(){
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(saveFile);
       

        //write what u want to save
        if(time>0)
            myWriter.write("You spent "+curtime+" on the game");
        myWriter.close();
        System.out.println("Successfully wrote to file");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    }

    public Queue <Enemy> setEs(){
        Queue <Enemy> temp = new LinkedList <>();
        temp.add(new Demo(1400, 400));
        temp.add(new Demo(1400, 400));
        temp.add(new Demo(1400, 400));
        return temp;

    }

    public ArrayList <Characters> setCharList(){
        ArrayList <Characters> temp = new ArrayList <>();
        temp.add(new Mike(150, 400));
        temp.add(new Lucas(400, 400));
        temp.add(new Eleven(650, 400));
        temp.add(new Will(900, 400));
        temp.add(new Dustin(1150, 400));
        temp.add(new Max(1400, 400));




        return temp;
    }

   


//         return temp;
//    }

    public void run()

    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }
        catch(Exception e)
        {
        }
        }

    public void paint(Graphics g){
        Graphics2D twoDgraph = (Graphics2D) g;
        if(back == null)
        back = (BufferedImage) ((createImage(getWidth(), getHeight())));
        Graphics g2d = back.createGraphics();
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 65));
       
        //g2d.drawImage(background.getImage(),0,0, getWidth(), getHeight(),this);
        


        drawScreens(g2d);
        twoDgraph.drawImage(back, null, 0, 0);




       
    }

public void drawStartScreen(Graphics g2d) {
    for(Characters c: charList){
       // System.out.println(c);
        c.drawChar(g2d);
        g2d.drawString("Choose Your Character", 550, 200);

    }
}
public void drawGameScreen(Graphics g2d){
   if(player!=null)
    player.drawChar(g2d);
    if(!rangeWeap.isEmpty()){
        for(int i=0; i<rangeWeap.size(); i++) {
            rangeWeap.get(i).drawWeap(g2d);
            //   for (int j=0; j<Bullet.size(); j++) {
     //           if(rangeWeap.get(i).hit(sMissiles.get(j))) {
       //             aliens.remove(i);
      //              i--;
        //            sMissiles.remove(j);
              //      j--;
    }
    enemies.peek().drawChar(g2d);
  //  for(Characters c: charList){
        // System.out.println(c);
   //      c.drawChar(g2d);
 
  //   }
  // rangeWeap.drawWeap(g2d);

     g2d.drawString("Play!", 550, 200);
}
g2d.drawString( new DecimalFormat("#0.00").format(curtime), 350,100);
curtime=(System.currentTimeMillis()- time)/1000;
}

   



    public void drawScreens(Graphics g2d) {
        // TODO Auto-generated method stub
   
       // System.out.println(screen);
        switch(screen){
            
            case "start":
            drawStartScreen(g2d);
            break;
            case "selection":
                drawSelectScreen(g2d);
                break;
            case "gameplay":
                drawGameScreen(g2d);
                break;
           

        }
    }



    public void drawSelectScreen(Graphics g2d) {
        // TODO Auto-generated method stub
       player.drawChar(g2d);
       
     // g2d.drawImage(player.getWeapon().getPic().getImage(), player.getX(), player.getY(), 600, 600, this);
       g2d.setFont(new Font("Times New Roman", Font.BOLD, 40));
       g2d.drawString("You Picked "+ player.toString(), 700,250);
       g2d.drawString("Damage: " + player.getDamage(), 200, 800);
       g2d.drawString("Stamina: " + player.getStam(), 600, 800);
       g2d.drawString("Speed: " + player.getSpeed(), 1000, 800);
       g2d.drawString("Health: " + player.getHealth(), 1400, 800);
      System.out.println(player.getWeapon().getX());
     //  weapom.
      player.getWeapon().drawChar(g2d);



    }

    //DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
public void attack(){
    if(player.getWeapon() instanceof Range){
        rangeWeap.add(new Range(player.getX(), player.getY(), player.getH(), player.getW(), player.getWeapon().getDam(), player.getWeapon().getDuribility(), player.getWeapon().getDPS(), player.getWeapon().getPic()));
    }
    else{
        
    }
}
    //DO NOT DELETE
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        key= e.getKeyCode();
        System.out.println(key);
        if(key==32){
            screen="selection";
            player=charList.get(1);
        }
    //     if(key==65){
    //       screen="gameplay";
    //         //player=charList.get(1);
    //    }
        else if (key==65){
            screen = "gameplay";
            attack();
        }
        if(e.getKeyChar() == '1') {
            player = charList.get(0);
            screen = "selection";
        }
        if(e.getKeyChar() == '1') {
            player = charList.get(0);
            System.out.println(player);
        }
        if(e.getKeyChar() == '2') {
            player = charList.get(1);
            screen = "selection";
        }
        if(e.getKeyChar() == '2') {
            player = charList.get(1);
            System.out.println(player);
        }
        if(e.getKeyChar() == '3') {
            player = charList.get(2);
            screen = "selection";
        }
        if(e.getKeyChar() == '3') {
            player = charList.get(2);
            System.out.println(player);
        }
        if(e.getKeyChar() == '4') {
            player = charList.get(3);
            screen = "selection";
        }
        if(e.getKeyChar() == '4') {
            player = charList.get(3);
            System.out.println(player);
        }
        if(e.getKeyChar() == '5') {
            player = charList.get(4);
            screen = "selection";
        }
        if(e.getKeyChar() == '5') {
            player = charList.get(4);
            System.out.println(player);
        }
        if(e.getKeyChar() == '6') {
            player = charList.get(5);
            screen = "selection";
        }
        if(e.getKeyChar() == '6') {
            player = charList.get(5);
            System.out.println(player);
        }


    }

    //DO NOT DELETE
    @Override
    public void keyReleased(KeyEvent e) {





    }

    @Override

    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub




    }

    @Override

    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        x=arg0.getX();
        y=arg0.getY();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        // check to see if on start screen
        // for lopp to check through all mainchars
        // if mousecollision is true
        //player = loop.get(i)
        //enemies.remove();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("exited");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

        System.out.println("you clicked at"+ arg0.getY());
        x=arg0.getX();
        y=arg0.getY();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }




    
}