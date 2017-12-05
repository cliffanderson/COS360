public class g26{


   private static CofinFin s = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {1});
      s = $sv1;

      $sv1 = s.complement();
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
