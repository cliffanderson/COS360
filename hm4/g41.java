public class g41{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   private static CofinFin x = new CofinFin();

   private static CofinFin y = new CofinFin();

   private static CofinFin z = new CofinFin();

   private static CofinFin w = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {1,2,3,4,5});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {1,2});
      u = $sv1;

      $sv1 = new CofinFin(true, new int[] {});
      v = $sv1;

      $sv1 = new CofinFin(true, new int[] {1,3,5,7});
      x = $sv1;

      $sv1 = new CofinFin(false, new int[] {2,4,6});
      y = $sv1;

      $sv1 = new CofinFin(true, new int[] {1,2,3,4,5,6,7,8,9,0});
      z = $sv1;

      $sv1 = s.complement();
      CofinFin $sv2 = t;
      CofinFin $sv3 = u;
      $sv3 = $sv3.intersect(v);
      $sv2 = $sv2.union($sv3);
      $sv2 = $sv2.union(y);
      $sv1 = $sv1.intersect($sv2.complement());
      CofinFin $sv4 = z;
      $sv4 = $sv4.intersect(x);
      $sv1 = $sv1.intersect($sv4.complement());
      w = $sv1;


      System.out.println(w.toString());
   }
}
// Successful parse.
