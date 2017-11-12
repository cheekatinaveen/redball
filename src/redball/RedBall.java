
package redball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class RedBall extends JComponent implements ActionListener, MouseMotionListener, KeyListener {

    private int ballx = 150;
    private int bally = 30;
    private int ballx1 = 100;
    private int bally1 = 10;
    private int paddlex = 0;
    private int paddley = 0;
    private int ballySpeed = 7;
    private int ballxSpeed = 5;
    private int bally1Speed = 14;
    private int ballx1Speed = 10;
    public int score = 0;
    public int score1 = 0;
    private int scorefinal;
    public int bestscore;
    public int bestscore1;
    public boolean gameOver, started;  
    public void FrameLoad()
    {     
        JFrame f = new JFrame("DownBall Baser / MAHARSHI (MIT)");
        RedBall g = new RedBall();
        f.add(g);
        f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.addMouseMotionListener(g);
        f.addKeyListener(g);
        Timer t = new Timer(17, g);
        t.start();
    }
    public void newball(int ballx, int bally, int ballxspeed, int ballyspeed) {
        ballx = 150;
        bally = 30;
        ballxspeed = 5;
        ballyspeed = 7;
        JOptionPane.showMessageDialog(null, "new ball !");
        return;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
              
        //draw the sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 1380, 600);

        g.setColor(Color.GREEN);
        g.fillRect(0, 600, 1380, 110);

        //draw the paddel
        g.setColor(Color.black);
        g.fillRect(paddlex, 560, 150, 20);
              
        
        //draw the ball
        g.setColor(Color.RED);
        g.fillOval(ballx, bally, 30, 30);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.BOLD,16));
        g.drawString(" Developed By Maharshi Thatikonda", 1050,650);
        g.drawString(" ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---", 1050,660);
        
        
        //draw the ball_1
        if (score >=20) {
            g.setColor(Color.BLUE);
            g.fillOval(ballx1, bally1, 30, 30);

        }
        
        //score	
        if (score >= 5) {
                g.setColor(Color.red);
                g.setFont(new Font("Tahoma", 8,30));
                g.drawString(String.valueOf(score + score1), 30 / 1 - 15, 80);
        } else {
                g.setColor(Color.white);
                g.setFont(new Font("Tahoma", 8, 50));
                g.drawString(String.valueOf(score), 30 / 1 - 15, 80);
        }
         
       
        // start && gameOver
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 8, 50));

        if (gameOver) {
             g.setColor(Color.blue);
             g.setFont(new Font("TimesRoman", Font.BOLD,14));
             g.drawString(String.valueOf("Your Score:" + scorefinal),1250, 40);
             if(scorefinal>50)
             {
             g.setColor(Color.red);
             g.setFont(new Font("TimesRoman", Font.BOLD,16));
             g.drawString("Try To Best", 1250,60);
             }
             if(scorefinal>80)
             {
             g.setColor(Color.red);
             g.setFont(new Font("TimesRoman", Font.BOLD,16));
             g.drawString("Super", 1250,60);
             }
             if(scorefinal>100)
             {
             g.setColor(Color.red);
             g.setFont(new Font("TimesRoman", Font.BOLD,16));
             g.drawString("Excellent", 1250,60);
             }
        }
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {

        ballx = ballx + ballxSpeed;
        bally = bally + ballySpeed;

        // Window Down 
        if (ballx >= paddlex && ballx <= paddlex + 100 && bally >= 530) {

            ballySpeed = -7;
            score++;

        }if (score >= 5){
        if (ballx >= paddley && ballx <= paddley + 100 && bally >= 530) {

            ballySpeed = -7;
            score++;

        }}

        if (bally >= 800 ) {

            score = 0;
            bally = 30;
            gameOver = true;

        }

        // Window up
        if (bally <= 0) {

            ballySpeed = 7;

        }

        // Window right
        if (ballx >= 1350) {

            ballxSpeed = -5;

        }

        // Window left
        if (ballx <= 0) {

            ballxSpeed = 5;

        }

        //**********************************************************************
        ballx1 = ballx1 + ballx1Speed;
        bally1 = bally1 + bally1Speed;

        // Window down
        if (ballx1 >= paddlex && ballx1 <= paddlex + 100 && bally1 >= 475) {

            bally1Speed = -14;
            score1++;

        }if (score >= 5){
        if (ballx1 >= paddley && ballx1 <= paddley + 100 && bally1 >= 475) {

            bally1Speed = -14;
            score1++;

        }}

        if (bally1 >= 1350) {

            score1 = 0;
            bally1 = 10;


        }

        // Window up
        if (bally1 <= 0) {

            bally1Speed = 14;

        }

        // Window right
        if (ballx1 >= 1350) {

            ballx1Speed = -10;

        }

        // Window left
        if (ballx1 <= 0) {

            ballx1Speed = 10;

        }

        //**********************************************************************
        bestscore = score;
        bestscore1 = score1;

        if (scorefinal > bestscore) {

            scorefinal = scorefinal;

        } else {

            scorefinal = bestscore1;
            scorefinal = score + score1;
        }
        
        if (scorefinal > bestscore) {

            scorefinal = scorefinal;

        } else {

            scorefinal = bestscore;
            scorefinal = score + score1;
        }

        
        repaint();
    }
   

    

    @Override
    public void mouseMoved(MouseEvent e) {

        paddlex = e.getX() - 50;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        paddlex = e.getX() - 50;
        repaint(); 
     
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
               paddlex+= 20;
                repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                paddlex-= 20; }  
           
            repaint();
         }

    @Override
    public void keyReleased(KeyEvent e) {

    }
      public static void main(String[] args) {
         RedBall r=new RedBall();
         r.FrameLoad();
    }
    

}
