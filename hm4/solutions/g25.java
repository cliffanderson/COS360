public class g25{


   private static CofinFin s = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {1});
      s = $sv1;

      $sv1 = s.complement();
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
