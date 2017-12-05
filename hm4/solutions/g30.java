public class g30{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   private static CofinFin w = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {1,2});
      s = $sv1;

      $sv1 = new CofinFin(true, new int[] {2,3});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {1,2});
      u = $sv1;

      $sv1 = new CofinFin(false, new int[] {1,3});
      v = $sv1;

      $sv1 = s;
      CofinFin $sv2 = t;
      $sv2 = $sv2.intersect(u);
      $sv1 = $sv1.union($sv2);
      $sv1 = $sv1.union(v);
      w = $sv1;


      System.out.println(w.toString());
   }
}
// Successful parse.
