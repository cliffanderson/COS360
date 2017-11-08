public class g32{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   private static CofinFin w = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {});
      u = $sv1;

      $sv1 = new CofinFin(true, new int[] {});
      v = $sv1;

      $sv1 = s;
      $sv1 = $sv1.union(t);
      CofinFin $sv2 = u;
      $sv2 = $sv2.union(v);
      $sv1 = $sv1.intersect($sv2.complement());
      w = $sv1;


      System.out.println(w.toString());
   }
}
// Successful parse.
