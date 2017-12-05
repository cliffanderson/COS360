public class g24{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {8,9,10,11,12,13,14,15});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {4,5,6,7,12,13,14,15});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {2,3,6,7,10,11,14,15});
      u = $sv1;

      $sv1 = new CofinFin(false, new int[] {1,3,5,7,9,11,13,15});
      v = $sv1;

      $sv1 = s;
      CofinFin $sv2 = t;
      $sv2 = $sv2.intersect(u.complement());
      $sv2 = $sv2.intersect(v.complement());
      $sv1 = $sv1.intersect($sv2.complement());
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
