public class g14{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {1});
      s = $sv1;

      $sv1 = new CofinFin(true, new int[] {2});
      t = $sv1;

      $sv1 = new CofinFin(true, new int[] {3});
      u = $sv1;

      $sv1 = new CofinFin(true, new int[] {4});
      v = $sv1;

      $sv1 = s;
      $sv1 = $sv1.intersect(t);
      s = $sv1;

      $sv1 = s;
      $sv1 = $sv1.intersect(u);
      s = $sv1;

      $sv1 = s;
      $sv1 = $sv1.intersect(v);
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
