public class g44{


   private static int i;

   private static int j;

   private static int k;

   private static CofinFin w = new CofinFin();

   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin v = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {});
      s = $sv1;

      t = s;

      i = 1;
      $sv1 = new CofinFin(false, new int[] {1});
      w = $sv1;

      v = w;

      if (s.isIn(0)){
         $sv1 = new CofinFin(false, new int[] {1});
         t = $sv1;

      }
      else{
         $sv1 = new CofinFin(false, new int[] {25});
         t = $sv1;

      }

      if (w.isIn(i)){
         $sv1 = new CofinFin(false, new int[] {0});
         s = $sv1;

      }
      else{
         $sv1 = new CofinFin(false, new int[] {24});
         s = $sv1;

      }

      $sv1 = w;
      $sv1 = $sv1.intersect(w.complement());
      w = $sv1;

      $sv1 = new CofinFin(false, new int[] {0,1});
      if ($sv1.isIn(0)){
         $sv1 = t;
         CofinFin $sv2 = new CofinFin(false, new int[] {3});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         CofinFin $sv2 = new CofinFin(false, new int[] {27});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {0,1,2,3});
      if ($sv1.isIn(i)){
         $sv1 = s;
         CofinFin $sv2 = new CofinFin(false, new int[] {2});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         CofinFin $sv2 = new CofinFin(false, new int[] {26});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(false, new int[] {});
      if ($sv1.isSubsetOf(s)){
         $sv1 = t;
         CofinFin $sv2 = new CofinFin(false, new int[] {5});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         CofinFin $sv2 = new CofinFin(false, new int[] {29});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      if (w.isSubsetOf($sv1)){
         $sv1 = s;
         CofinFin $sv2 = new CofinFin(false, new int[] {4});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         CofinFin $sv2 = new CofinFin(false, new int[] {28});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      CofinFin $sv2 = new CofinFin(false, new int[] {0,1});
      if ($sv1.isSubsetOf($sv2)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {7});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {31});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      if (s.isSubsetOf(w)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {6});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {30});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(false, new int[] {});
      if ($sv1.equals(s)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {9});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {33});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      if (w.equals($sv1)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {8});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {32});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      $sv2 = new CofinFin(false, new int[] {0,1});
      if ($sv1.equals($sv2)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {11});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {35});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      if (s.equals(w)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {10});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {34});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      if (!s.isIn(0)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {13});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {37});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      if (!w.isIn(i)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {12});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {36});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(false, new int[] {0,1});
      if (!$sv1.isIn(0)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {15});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {39});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {0,1,2,3});
      if (!$sv1.isIn(i)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {14});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {38});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(false, new int[] {});
      if (!$sv1.isSubsetOf(s)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {17});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
      }

      $sv1 = new CofinFin(true, new int[] {});
      if (!w.isSubsetOf($sv1)){
      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {16});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      $sv2 = new CofinFin(false, new int[] {0,1});
      if (!$sv1.isSubsetOf($sv2)){
      }
      else{
      }

      if (!s.isSubsetOf(w)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {18});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {19});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      $sv1 = new CofinFin(false, new int[] {});
      if (!$sv1.equals(s)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {21});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {41});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      if (!w.equals($sv1)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {20});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {40});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      $sv2 = new CofinFin(false, new int[] {0,1});
      if (!$sv1.equals($sv2)){
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {23});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }
      else{
         $sv1 = t;
         $sv2 = new CofinFin(false, new int[] {43});
         $sv1 = $sv1.union($sv2);
         t = $sv1;

      }

      if (!s.equals(w)){
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {22});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }
      else{
         $sv1 = s;
         $sv2 = new CofinFin(false, new int[] {42});
         $sv1 = $sv1.union($sv2);
         s = $sv1;

      }


      $sv1 = s;
      $sv1 = $sv1.union(t);
      System.out.println($sv1.toString());
   }
}
// Successful parse.
