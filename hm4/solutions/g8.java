public class g8{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {1});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {2});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {3});
      u = $sv1;

      $sv1 = new CofinFin(false, new int[] {4});
      v = $sv1;

      $sv1 = s;
      $sv1 = $sv1.union(t);
      s = $sv1;

      $sv1 = u;
      $sv1 = $sv1.union(v);
      u = $sv1;


      $sv1 = s;
      $sv1 = $sv1.union(u);
      System.out.println($sv1.toString());
   }
}
// Successful parse.
