public class g9{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {1,5});
      s = $sv1;

      $sv1 = new CofinFin(true, new int[] {2,5});
      t = $sv1;

      $sv1 = new CofinFin(true, new int[] {3,5});
      u = $sv1;

      $sv1 = new CofinFin(true, new int[] {4,5});
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
