public class g19{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {1,2,3});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {4,6,7,12,13,14,15});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {2,3,6,7,10,11,14,15});
      u = $sv1;

      $sv1 = new CofinFin(true, new int[] {16});
      v = $sv1;

      $sv1 = s;
      $sv1 = $sv1.intersect(t.complement());
      s = $sv1;

      $sv1 = u;
      $sv1 = $sv1.intersect(v.complement());
      u = $sv1;


      $sv1 = s;
      $sv1 = $sv1.intersect(u.complement());
      System.out.println($sv1.toString());
   }
}
// Successful parse.
