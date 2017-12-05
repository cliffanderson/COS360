public class g34{


   private static CofinFin s = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin w = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {1,2});
      u = $sv1;

      $sv1 = s.complement();
      $sv1 = $sv1.union(u);
      w = $sv1;


      System.out.println(w.toString());
   }
}
// Successful parse.
