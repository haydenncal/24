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
    private ArrayList <Melee> meleeWeap;
    private Queue <Enemy> enemies;
    private File saveFile;
    private double curtime;
    private double time;
    private String cat;
    private int index;



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
      //  System.out.println(enemies.size());
        curtime = 0;
        time = System.currentTimeMillis();
        cat = "Choose your Character";
        index = 0;


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
        temp.add(new Demo(1400, 800));
        temp.add(new Demo(1400, 800));
     //   System.out.println("im here");
        temp.add(new Demo(1400, 400));
      //  System.out.println("im here");
       // temp.add(new Demo(1400, 400));
       // temp.add(new Demo(1400, 400));
       // temp.add(new Demo(1400, 400));
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
        //g2d.drawString("Choose Your Character", 550, 200);
        g2d.drawString(cat.substring(0, index), 550, 200);
     //   int index = 0;

        if (index<cat.length()){
            if(System.currentTimeMillis()-time>100){
                time = System.currentTimeMillis();
                index++;
            }
        }

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
   
    System.out.println("i am work");

  //  for(Characters c: charList){
        // System.out.println(c);
   //      c.drawChar(g2d);
 
  //   }
  // rangeWeap.drawWeap(g2d);

     g2d.drawString("Play!", 550, 200);
    
} 
if(!enemies.isEmpty())

enemies.peek().drawChar(g2d);
g2d.drawString( new DecimalFormat("#0.00").format(curtime), 350,100);
curtime=(System.currentTimeMillis()- time)/1000;

player.getWeapon().drawWeap(g2d);

//rangeWeap.move();

//for(int i=0; i<rangeWeap.size(); i++) {
  //  rangeWeap.get(i).move();
  //  enemies.element().Collision(rangeWeap.get(i));
  //  if (rangeWeap.Collision(enemies.element())) {
   //    enemies.peek().remove();
   //     rangeWeap.remove(i);
   // }
//}
if(enemies.isEmpty()) {
    
    screen = "win";
    
    //rangeWeap.get(i).move();
   // Enemy enemy = enemies.peek();

    //collision between the weapon and enemy
    //if (rangeWeap.get(i).Collision(enemy)) {
    
     //   enemies.remove(); 
      //  rangeWeap.remove(i); 

        
      //  i--;  
       // break;  
    
}
for (int i = 0; i < rangeWeap.size(); i++) {

    rangeWeap.get(i).move();
    Enemy enemy = enemies.peek();

    //collision between the weapon and enemy
    if (rangeWeap.get(i).Collision(enemy)) {
    
        enemies.remove(); 
        rangeWeap.remove(i); 

        
        i--;  
        break;  
    }
}




//public void drawGameScreen(Graphics g2d){
  //  if(player != null)
   //     player.drawChar(g2d);
 
    // Draw all range weapons
   // for (Range weapon : rangeWeap) {
  //      weapon.drawWeap(g2d);  // Draw weapon
  //  }
 
    // Draw enemies
   // for (Enemy enemy : enemies) {
   //     enemy.drawChar(g2d);
   // }
 
   // System.out.println("i am printing");
 
    // Handle collisions between range weapons and enemies
  //  for (int i = 0; i < rangeWeap.size(); i++) {
  //      Range weapon = rangeWeap.get(i);  // Get each weapon in the list
  //      for (Enemy enemy : enemies) {
 //           // Check if the weapon's hitbox overlaps with the enemy's hitbox
  //          if (weapon.getX() >= enemy.getX() && weapon.getX() <= (enemy.getX() + enemy.getW()) &&
  //              weapon.getY() >= enemy.getY() && weapon.getY() <= (enemy.getY() + enemy.getH())) {
                    
                // Remove the enemy and the weapon upon collision
  //              enemies.remove(enemy);
  //              rangeWeap.remove(i);
  //              i--;  // Decrement the index to prevent skipping the next weapon
   //             break; // Break the inner loop as the weapon already hit an enemy
           // }
//  }
  //  }
 
    // Display current time
   // g2d.drawString(new DecimalFormat("#0.00").format(curtime), 350, 100);
   // curtime = (System.currentTimeMillis() - time) / 1000;
 
    // Draw player's weapon
  //  player.getWeapon().drawWeap(g2d);
 }
 

//melee colliion help
//enemies.element().Collision(player.getWeapon());



   



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
            case "win":
            drawWinScreen(g2d);
                break;
           

        }
    }

    public void drawWinScreen(Graphics g2d){
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g2d.drawString(" You Win", 700,250);
    }

    public void drawSelectScreen(Graphics g2d) {
        // TODO Auto-generated method stub
       player.drawChar(g2d);
       
     // g2d.drawImage(player.getWeapon().getPic().getImage(), player.getX(), player.getY(), 600, 600, this);
       g2d.setFont(new Font("Times New Roman", Font.BOLD, 40));
       g2d.drawString("You Picked "+ player.toString(), 700,250);
       g2d.drawString("Press 'A' to start your game.", 625, 300);
       g2d.drawString("Damage: " + player.getDamage(), 200, 800);
       g2d.drawString("Stamina: " + player.getStam(), 600, 800);
       g2d.drawString("Speed: " + player.getSpeed(), 1000, 800);
       g2d.drawString("Health: " + player.getHealth(), 1400, 800);
      //System.out.println(player.getWeapon().getX());
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
        if (player instanceof Mike){
            rangeWeap.add(new RangeAttack(player.getX()+150, player.getY()+75,20, 20));
            System.out.println(x);
            System.out.println("i am working");
        }
        else if(player instanceof Max){
            rangeWeap.add(new RangeAttack(player.getX()+150, player.getY()+75,20, 20));
           // System.out.println("working");

        }
        else if(player instanceof Lucas){
            rangeWeap.add(new RangeAttack(player.getX()+150, player.getY()+75,20, 20));
           // System.out.println("working");

        }
        else if(player instanceof Dustin){
            rangeWeap.add(new RangeAttack(player.getX()+150, player.getY()+75,20, 20));
           // System.out.println("working");

     //   rangeWeap.add(new Range(player.getX(), player.getY(), player.getH(), player.getW(), player.getWeapon().getDam(), player.getWeapon().getDuribility(), player.getWeapon().getDPS(), player.getWeapon().getPic()));
    }
    else if(player instanceof Eleven){
        rangeWeap.add(new RangeAttack(player.getX()+150, player.getY()+75,20, 20));
       // System.out.println("working");
    }
    else if(player instanceof Will){
        rangeWeap.add(new RangeAttack(player.getX()+150, player.getY()+75,20, 20));
       // System.out.println("working");

    }

    else{ 

    }    
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
            player.setX(100);
            player.setY(800);
            player.setW(150);
            player.setH(200);
            player.getWeapon().setX(200);
            player.getWeapon().setY(850);
            player.getWeapon().setW(75);
            player.getWeapon().setH(75);

          // attack();
        }
        if(e.getKeyChar() == '1') {
            player = charList.get(0);
            screen = "selection";
        }
     
        if(e.getKeyChar() == '2') {
            player = charList.get(1);
            screen = "selection";
        }
      
        if(e.getKeyChar() == '3') {
            player = charList.get(2);
            screen = "selection";
        }
       
        if(e.getKeyChar() == '4') {
            player = charList.get(3);
            screen = "selection";
        }
       
        if(e.getKeyChar() == '5') {
            player = charList.get(4);
            screen = "selection";
        }
    
        if(e.getKeyChar() == '6') {
            player = charList.get(5);
            screen = "selection";
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

    //@Override
    @Override
    public void mouseMoved(MouseEvent arg0) {
        
        if ("gameplay".equals(screen)) {
            x = arg0.getX();
            y = arg0.getY();
    
            
            player.setX(x - player.getW() / 2);
            player.setY(y - player.getH() / 2);
            player.getWeapon().setX(x - player.getW() / 2);
            player.getWeapon().setY(y - player.getH() / 2);
            repaint(); 
        }
    }
    
   // public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
      //  x=arg0.getX();
      //  y=arg0.getY();
       // screen = "gameplay";
        
   // }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        // check to see if on start screen
        // for lopp to check through all mainchars
        // if mousecollision is true
        //player = loop.get(i)
        //enemies.remove();
        attack();
     //   Weapons.move();
        System.out.println("this works");
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