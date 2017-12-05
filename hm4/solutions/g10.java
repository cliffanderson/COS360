public class g10{


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
      $sv1 = $sv1.union(t);
      $sv1 = $sv1.union(u);
      $sv1 = $sv1.union(v);
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
