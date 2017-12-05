public class g38{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   private static CofinFin w = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {});
      s = $sv1;

      $sv1 = new CofinFin(true, new int[] {});
      t = $sv1;

      $sv1 = new CofinFin(true, new int[] {1});
      u = $sv1;

      $sv1 = new CofinFin(false, new int[] {});
      v = $sv1;

      $sv1 = s;
      CofinFin $sv2 = t;
      $sv2 = $sv2.intersect(u);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv1 = $sv1.intersect(v.complement());
      w = $sv1;


      System.out.println(w.toString());
   }
}
// Successful parse.
