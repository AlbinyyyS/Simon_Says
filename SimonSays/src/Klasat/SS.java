package Klasat;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.Timer;

import java.awt.event.*;
/**
*@author Albin Hoxha.
*Klasa SS ka per detyre kontrollin e rrjedhes
*se lojes 
*/
public class SS implements ActionListener
{
   public int level = 4; //leveli i lojes
   public int lv = 0;  // ndryshore e cila rritet per secilin cikel te lojes  
   public String rendi = ""; // renditja e "pattern" te lojes
   SSListener sslistener; // objekti i klases SSListener
   SSview ssview; // objekt i klases SSview
   private int bardh = 0 ; // ndryshore qe percakton nese duhet te ngjyroset paneli me te bardh
   public boolean pattern = false ; // ndryshore qe tregon nese "pattern" eshte duke u vizatuar
   Timer timer; // objekt i klases Timer
   public ArrayList<Integer> renditja = new ArrayList<Integer>(); // Arraylist ne te cilin gjendet "pattern"
   
   /**
   *@param ssview pranon si parameter objektin e SSview
   *@param shpejtesia pranon si parameter shpejtesin e vizatimit te "pattern"
   *Konstruktori i klases SS
   */
   
   public SS(SSview ssview,int shpejtesia)
   {
      this.ssview = ssview;
      this.sslistener = ssview.sslistener;
      this.timer = new Timer(1000-shpejtesia,this);
      timer.setRepeats(true);
      startGame();
   }
    
   /**
   *@param e permban parametrin e objektit ActionEvent
   *Kjo metode aktivizohet kur fillon timer dhe 
   *vizaton ne panel ne baze te "pattern"
   */
   public void actionPerformed(ActionEvent e) {
      
      if(lv<level)
       { 
        if(bardh%2 == 0)
          {
            renditja.add((int)(Math.random() *4 + 1));   
            ssview.drawR(renditja.get(lv));
            rendi = rendi + renditja.get(lv); 
            lv++;
          }
         if(bardh%2==1){
            ssview.drawR(0);
          }
       bardh++;
     }
     else if(lv == level)
         {
       ssview.drawR(0);
       sslistener.setGoal(rendi);
       pattern = true;
       timer.stop();
         }
       }
   /**
   *Kjo metode e ben nisjen e lojes
   */
   public void startGame()
   {
      pattern = false ;
      timer.start();     
   }  

}