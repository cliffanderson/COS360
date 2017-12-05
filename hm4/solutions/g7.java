public class g7{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {1,2,3});
      s = $sv1;

      t = s;

      $sv1 = new CofinFin(false, new int[] {});
      s = $sv1;


      System.out.println(t.toString());
   }
}
// Successful parse.
