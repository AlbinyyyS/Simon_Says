package Klasat;

/**
*@author Albin Hoxha
*Klasa SShigh ka per detyre ruajtjen e rezultatit me te larte
*/
public class SShigh
{
   public int high_score ; // variabel qe permban rezultatin me te larte
   /**
   *@param high tregon rezultatin e user-it ne rastin kur ka humbur ose ka kaluar nje level
   *Kjo metod ne baze te parametrit qe merr shikon nese aj numer eshte 
   *numri me i madh dhe nese po e ruan ate
   */
   public void setHigh(int high)
   {
      if(high > high_score)
      {
         high_score = high;   
      }
      
   }
   /**
   *Kjo metode kthen variablen high_score 
   */
   public int getHigh()
   {
      return high_score;
   }
}
