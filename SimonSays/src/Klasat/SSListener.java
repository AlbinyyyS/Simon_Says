package Klasat;

import javax.swing.Timer;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.*;

/**
*@author Albin Hoxha
*Klasa SSListener ka per detyre marrjen e informatave nga user-i permes mouselistener
*dhe ne baze te tyre te percaktoje nese loja mund te vazhdoj ose jo
*/
public class SSListener extends JPanel implements MouseListener,ActionListener
{
   SSview ssview; // objekt i klases SSview
   SS ss; // objekt i klases SS
   private int startimi ; // variabel qe tregon nese loja ka filluar
   private String loja = ""; // variabel e cila e permban "pattern" e dhene nga user-i
   private String rendi; // variabel e cila e permban "pattern" te dhene nga app
   private int tries = 4;// variabel e cila tregon sa here useri mund te shtyp nje ngjyre
   private int t = 4; // variabel backup e tries
   private int hupe = 0; // variabel qe tregon nese useri ka gabuar dhe loja ka perfunduar  
   Timer timer = new Timer(1000,this); // objekt i klases Timer
   public int highscore; // variabel e cila mban rekordin 
   SSstart ssstart; // objekt i klases SSstart 
   SShigh sshigh ; // objekt i klases SShigh
   /**
   *@param shpejtesia tregon shpejtesin me te cilen do te shfaqet "pattern"
   *@param ssstart permban objektin e klases SSstart
   *@param sshigh permban objektin e klases sshigh
   *Konstruktori i klases SSListener
   */
   public SSListener(int shpejtesia,SSstart ssstart,SShigh sshigh)
   { 
      this.ssstart = ssstart;
      this.ssview = new SSview(this,sshigh);
      this.ss = new SS(this.ssview, shpejtesia);
      this.sshigh = sshigh;
      ssview.paneli.addMouseListener(this);
   }
   /**
   *@param e permban objektin e klases ActionEvent 
   *Kjo metode ngjyrose panelin me te bardh 1 sekond pasi 
   * te ngjyroset me ndonje ngjyre tjeter
   */
   public void actionPerformed(ActionEvent e) {
         ssview.drawR(0); 
         ss.pattern = true;
         timer.stop();
   }
   /**
   *@param e permban informatat se ku eshte shtypur me mouse ne dritare
   *Metoda ka per qellim marrjen e informates se ku ka shtypur mouse dhe pastaj te 
   *vizatoj ne njeren prej katrorve ne baze te kordinatave
   */
   public void mousePressed(MouseEvent e) {
      
      if(e.getX()>30 & e.getX()<230 & e.getY() >30 & e.getY()<230 &ssview.startimi == 1& ss.pattern)
      {            
         ss.pattern = false;
         ssview.drawR(1);
         timer.start();
         loja += 1;
         ssview.repaint();         
         if(tries > 1){
            
            tries--;}
         else{
            if(loja.equals(rendi)){
               ssview.drawR(5);
               nextLvl();  
            }
            else if(hupe == 0){
               resGame();
            }
            
         }    
      }
      if(e.getX()>260 & e.getX()<460 & e.getY() >30 & e.getY()<230&ssview.startimi == 1&ss.pattern )
      {      
         ss.pattern = false;
         ssview.drawR(2);
         timer.start();
         loja += 2;
         ssview.repaint();  
         if(tries > 1){
             
            tries--;}
         else{
            if(loja.equals(rendi)){
               ssview.drawR(5);
               nextLvl();  
            }
            else if(hupe == 0){
               resGame();                 
            }
            
         }
      }
      if(e.getX()>30 & e.getX()<230 & e.getY() >260 & e.getY()<460&ssview.startimi == 1& ss.pattern)
      {
         ss.pattern = false;
         ssview.drawR(3);
         timer.start();
         loja += 3;
         ssview.repaint();
          
         if(tries > 1){
            
            tries--;}
         else{
            if(loja.equals(rendi))
            {
               ssview.drawR(5);
               nextLvl();
            }
            else if(hupe == 0){
               resGame();
            }  
         }
      }
      if(e.getX()>260 & e.getX()<460 & e.getY() >260 & e.getY()<460&ssview.startimi == 1& ss.pattern)
      {
         ss.pattern = false;
         ssview.drawR(4);
         timer.start();
         loja += 4;
         ssview.repaint();
         if(tries > 1){
            
            tries--;}
         else{
            if(loja.equals(rendi))
            {     
               ssview.drawR(5);
               nextLvl();      
            }
            else if(hupe == 0)
            {
               resGame();
            }
         }
      }   
   }
   @Override
   public void mouseReleased(MouseEvent e) {
   }
   @Override
    public void mouseEntered(MouseEvent e) {
   }
   @Override
    public void mouseExited(MouseEvent e) {   
   }
   @Override
    public void mouseClicked(MouseEvent e) {
   }
   /**
   *Kjo metode perfundon lojen ne rast se useri humbe
   */
   public void resGame()
   {           
      hupe = 1;
      sshigh.setHigh(t-4);
      System.out.println(t);
      ssview.paneli.setVisible(false);
      ssview.paneli.dispose();
      ssstart.pano.setVisible(true);          
   }
   /**
   *Kjo metode rrit nivelin per 1 ne rast se useri gjen 
   *"pattern" e sakt
   */
   public void nextLvl()
   {
      sshigh.setHigh(t-3);
      ss.level = ss.level +1;
      loja = "";
      ss.lv = 0;
      t = t +1 ;
      tries = t;
      ss.rendi = "";
      ssview.leveli += 1;
      ss.startGame(); 
   }   
   /**
   *kjo metode thirret nga klasa SS dhe i tregon SSListener "pattern" qe
   *ka caktuar
   */
   public void setGoal(String rendi)
   {
      this.rendi = rendi;
   }

}