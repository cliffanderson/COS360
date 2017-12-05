public class g15{


   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin u = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {1,3,5,7,8});
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {2,3,4,5,6,8});
      t = $sv1;

      $sv1 = new CofinFin(false, new int[] {5,10,11,12,8});
      u = $sv1;

      $sv1 = new CofinFin(false, new int[] {5,8,10});
      v = $sv1;

      $sv1 = s;
      $sv1 = $sv1.intersect(t);
      $sv1 = $sv1.intersect(u);
      $sv1 = $sv1.intersect(v);
      s = $sv1;


      System.out.println(s.toString());
   }
}
// Successful parse.
