package Klasat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SSstart extends JPanel implements ActionListener
{
   JFrame pano ; // objekt i klases JFrame
   int widthp = 525; // variabel e cila tregon gjeresine e dritares
   int widthh = 587; // variabel e cila tregon gjatesine e dritares
   JButton easyb ; // objekt i klases JButton qe njekohesisht ruan njerin nga butonat
   JButton normalb ; // objekt i klases JButton qe njekohesisht ruan njerin nga butonat
   JButton hardb; // objekt i klases JButton qe njekohesisht ruan njerin nga butonat
   JButton insaneb; // objekt i klases JButton qe njekohesisht ruan njerin nga butonat
   int starti ; // variabel qe tregon se nese loja ka filluar nje here 
   int shpejtesia ; // variabel qe tregon shpejtesin me te cilen do te luhet loja
   public boolean shihet = true; // variabel qe cakton nese dritarja do te jete e dukshme apo jo
   SShumbe sshumbe; // objekt i klases SShumbe
   SShigh sshigh = new SShigh(); // objekt i klasese SShigh
   int krijuar = 0; // variable qe sheh nese dritarja eshte duke u krijuar per her te pare 
   JButton YESb = new JButton(new ImageIcon("Po.png")); // objekt i klases JButton
   JButton NOb = new JButton(new ImageIcon("Jo.png")); // objekt i klases JButton
   /**
   *Konstruktori i klases SSstart
   */
   public SSstart()
   {
      this.pano = new JFrame();
      pano.setVisible(shihet);
      pano.setSize(widthp,widthh);
      pano.setLocationRelativeTo(null);
      pano.setLayout(new BoxLayout(pano.getContentPane(), BoxLayout.LINE_AXIS));
      starti = 1;
      pano.getContentPane().add(this);
      setOpaque(false);
      pano.setResizable(false);
      YESb.setBounds(140,300,100,100);
      NOb.setBounds(250,300,100,100);
      krijoStartin();
      this.repaint();
   }
   /**
   *@param g sherben si pend per te vizatuar ne panel
   *Metoda ka per qellim vizatimin ne panel
   */
   public void paintComponent(Graphics g)
   {
      if(starti == 1)
      {
         ImageIcon wall = new ImageIcon("Wall.jpg");
         wall.paintIcon(this,g,0,0);
          
           
      }
      if(starti == 2 )
      {
         ImageIcon humbe = new ImageIcon("humbe.jpg");
         humbe.paintIcon(this,g,0,0);
         if(krijuar == 0)
         {
            krijoFundin();
         }
         if(krijuar != 0)
         {
            resetButtonin();
         }
         krijuar = 1;   
      }  
             
   }
   /**
   *@param e merr informata se cila nga butonat po shtypet 
   *Kjo metode ka per detyre fillimin e lojes ne baze te butonit qe eshte shtypur
   */
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == easyb)
      {
         shihet = false;
         starti = 2;
         fshijStartin();
         System.out.println("easy");
         fshirja(0);
         this.repaint();        
      }
      if(e.getSource() == normalb)
      {
         starti = 2;
         fshijStartin();
         fshirja(200);
         shihet = false;
      }
      if(e.getSource() == hardb)
      {
         starti = 2;
         fshijStartin();
         fshirja(450);
         shihet = false;
      }
      if(e.getSource() == insaneb)
      {
         starti = 2;
         fshijStartin();
         fshirja(700);
         shihet = false;
      }
      if(e.getSource() == YESb)
      {
         fshirja(shpejtesia);
      }
      if(e.getSource() == NOb)
      {
         System.exit(0);
      }  
   }
   /**
   *@param a tregon shpejtesin ne te cilen do te luhet loja 
   *kjo metode ka per detyre largimin e butonave dhe fillimin e lojes
   *me thirrjen e klases SSListener
   */
   public void fshirja(int a)
   {
      pano.remove(easyb);
      pano.remove(normalb);
      pano.remove(hardb);
      pano.remove(insaneb);
      pano.setVisible(false);
      this.shpejtesia = a;
      new SSListener(a,this,sshigh);         
      this.repaint();        
   }
   /**
   *Kjo metod i vendos buttonat ne dritare dhe ne panel
   */
   public void krijoStartin()
   {
      easyb = new JButton(new ImageIcon("easy.png"));
      easyb.setBounds(150,220,100,100);
      normalb = new JButton(new ImageIcon("normal.png"));
      normalb.setBounds(260,220,100,100);
      hardb = new JButton(new ImageIcon("hard.png"));
      hardb.setBounds(150,330,100,100);
      insaneb = new JButton(new ImageIcon("insane.png"));
      insaneb.setBounds(260,330,100,100);
      pano.add(easyb);
      add(easyb);
      pano.add(normalb);
      add(normalb);
      pano.add(hardb);
      add(hardb);
      pano.add(insaneb);
      add(insaneb);
      easyb.addActionListener(this);
      normalb.addActionListener(this);
      hardb.addActionListener(this);
      insaneb.addActionListener(this);
   }
   /**
   *Kjo metod i shton disa butona te tjere ne panel dhe dritare  
   */
   public void krijoFundin()
   {           
      pano.add(YESb);
      add(YESb);
      pano.add(NOb);
      add(NOb); 
      YESb.addActionListener(this);
      NOb.addActionListener(this);          
   }
   /**
   *Kjo metod ka per qellim largimin e butonave nga dritarja dhe paneli
   */
   public void fshijStartin()
   {
      pano.remove(easyb);
      pano.remove(normalb);
      pano.remove(hardb);
      pano.remove(insaneb);
      remove(easyb);
      remove(normalb);
      remove(hardb);
      remove(insaneb);
   }
   /**
   *Kjo metod i largon dhe i shton buttonat ne dritare dhe panel
   *ne nje menyre i ben "update" butonat
   */
   public void resetButtonin()
   {
      pano.remove(YESb);
      remove(YESb);
      pano.remove(NOb);
      remove(NOb);
      YESb.setBounds(140,300,100,100);
      NOb.setBounds(250,300,100,100);
      pano.add(YESb);
      add(YESb);
      pano.add(NOb);
      add(NOb);
   }   
}