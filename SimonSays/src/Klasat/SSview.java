package Klasat;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.event.*;
/**
*@author Albin Hoxha
*Klasa SSview ka per detyre vizatimin ne panele 
*/
public class SSview extends JPanel implements ActionListener
{
   public JFrame paneli; //objekt i klases JFrame
   private int widthp = 510;// variabel qe permban gjeresine e dritares
   private int heightp = 560;// variabel qe permban gjatesine e dritares
   private int ngjyra = 0; //variabel ne baze se ciles ngjyroset njera prej ngjyrave
   public int startimi = 1 ; // 
   private String loja = "";
   SSListener sslistener; // objekt i klases SSListener
   Font font; // objekt i klases Font i cili ndryshon fontin e stringut qe do te vizatohet
   Font font1;// objekt i klases Font i cili ndryshon fontin e stringut qe do te vizatohet
   Timer koh; // objekt i klases Timer
   SShigh sshigh ; // objekt i klases SShigh
   public int leveli = 1; // variabel qe tregon levelin e lojes
   private int koha = 0; // variabel e cila nevojitet per ta ndalur applikacionin
   
   /**
   *@author Albin Hoxha
   *@param sslistener permban objektin e klases SSListener
   *param sshigh permban objektin e klases SShigh
   *Konstruktori i klases SSview
   */
   public SSview(SSListener sslistener,SShigh sshigh)
   {
      this.sslistener = sslistener;
      this.sshigh = sshigh;
      paneli = new JFrame();
      paneli.getContentPane().add(this);
      paneli.setSize(widthp,heightp);
      paneli.setVisible(true);
      paneli.setBackground(Color.black);
      paneli.setLocationRelativeTo(null);
      this.koh = new Timer(1000,this);
      koh.setRepeats(true);
      font = new Font("Correct",Font.PLAIN,100);
      font1 = new Font("Level " + leveli,Font.PLAIN,40);
   }
   /**
   *@param e permban objektin e klases ActionEvent
   *Metoda sherben per ta ndalur applikacionin per disa sekonda
   */
   public void actionPerformed(ActionEvent e) {
      if(koha%3==2)
      {
         koha =0;
         koh.stop();
      }
      koha++;
   }
   /**
   *@param g sherben si lloj pende per vizatim dhe eshte objekt i klases Graphics
   *Kjo metode sherben per te vizatuar ne panel 
   */
   public void paintComponent(Graphics g)
   {
      g.drawRect(30,40,200,200);
      g.drawRect(260,40,200,200);
      g.drawRect(30,270,200,200);
      g.drawRect(260,270,200,200);
      g.setFont(font1);
      g.setColor(Color.white);
      g.drawString("Level " + leveli,300,33);
      g.drawString("High Score " + sshigh.getHigh(),35,33);   
      if(ngjyra == 0){
         g.setColor(Color.white);
         g.fillRect(31,41,198,198);
         g.fillRect(261,41,198,198);
         g.fillRect(31,271,198,198);
         g.fillRect(261,271,198,198);
         paneli.repaint();
      }
      else if(ngjyra == 1 )
      {
         g.setColor(Color.blue);
         g.fillRect(31,41,198,198);
         g.setColor(Color.white);
         g.fillRect(261,41,198,198);
         g.fillRect(31,271,198,198);
         g.fillRect(261,271,198,198);
      }
      else if(ngjyra == 2)
      {
         g.setColor(Color.red);
         g.fillRect(261,41,198,198);
         g.setColor(Color.white);
         g.fillRect(31,41,198,198);
         g.fillRect(31,271,198,198);
         g.fillRect(261,271,198,198); 
      }
      else if(ngjyra == 3)
      {
         g.setColor(Color.green);
         g.fillRect(31,271,198,198);
         g.setColor(Color.white);
         g.fillRect(31,41,198,198);
         g.fillRect(261,41,198,198);
         g.fillRect(261,271,198,198); 
      }
      else if(ngjyra == 4)
      {
         g.setColor(Color.yellow);
         g.fillRect(261,271,198,198);
         g.setColor(Color.white);
         g.fillRect(31,41,198,198);
         g.fillRect(261,41,198,198);
         g.fillRect(31,271,198,198); 
      }
      else if(ngjyra == 5)
      {
         g.setColor(Color.black);
         g.fillRect(0,0,widthp,heightp);
         g.setFont(font);
         g.setColor(Color.white);
         g.drawString("Correct",50,300);
         koh.start();
      }
   }
   /**
   *@param number tregon se cila nga katroret do te ngjyroset
   *Kjo metode sherben per te vizatuar ne njerin prej katroreve
   *gje te cilin e caktojn klaset SSlistener dhe SS
   */
   public void drawR(int number)
   {
      ngjyra = number ;
      paneli.repaint();
   }
  
          
}