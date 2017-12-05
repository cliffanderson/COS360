public class g11{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(true, new int[] {1,2,3,4,5,6,7,8,9,10});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {4,5});
      t = $sv1;

      $sv1 = new CofinFin(true, new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
      u = $sv1;

      $sv1 = new CofinFin(false, new int[] {3,5});
      v = $sv1;

      $sv1 = s;
      CofinFin $sv2 = t;
      CofinFin $sv3 = u;
      $sv3 = $sv3.union(v);
      $sv2 = $sv2.union($sv3);
      $sv1 = $sv1.union($sv2);
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
