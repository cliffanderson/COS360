public class g45{


   private static int i;

   private static int j;

   private static int k;

   private static CofinFin w = new CofinFin();

   private static CofinFin s = new CofinFin();

   private static CofinFin t = new CofinFin();

   private static CofinFin v = new CofinFin();

   private static CofinFin tt = new CofinFin();

   private static CofinFin ss = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {});
      w = $sv1;

      $sv1 = new CofinFin(true, new int[] {});
      v = $sv1;

      $sv1 = new CofinFin(true, new int[] {0,2,4,6,8,10});
      $sv1 = $sv1.complement();
      CofinFin $sv2 = new CofinFin(true, new int[] {});
      CofinFin $sv3 = new CofinFin(false, new int[] {});
      CofinFin $sv4 = new CofinFin(false, new int[] {0,4,10});
      $sv3 = $sv3.intersect($sv4);
      $sv2 = $sv2.union($sv3);
      $sv1 = $sv1.intersect($sv2.complement());
      t = $sv1;

      $sv1 = new CofinFin(true, new int[] {});
      $sv2 = new CofinFin(false, new int[] {0,1,2,3,4,5,30,31});
      $sv1 = $sv1.intersect($sv2);
      $sv3 = t;
      $sv4 = new CofinFin(false, new int[] {0,1,2,3,4,5,6,7,8,9,10});
      CofinFin $sv5 = new CofinFin(true, new int[] {0,1,2,3,4,5});
      $sv4 = $sv4.intersect($sv5);
      $sv3 = $sv3.union($sv4);
      $sv1 = $sv1.intersect($sv3.complement());
      s = $sv1;

      $sv1 = new CofinFin(false, new int[] {});
      ss = $sv1;

      tt = ss;

      i = 1;
      $sv1 = new CofinFin(false, new int[] {1});
      w = $sv1;

      v = w;

      $sv1 = s;
      $sv1 = $sv1.intersect(t);
      $sv2 = new CofinFin(false, new int[] {});
      $sv1 = $sv1.union($sv2);
      $sv3 = s;
      $sv4 = new CofinFin(true, new int[] {});
      $sv3 = $sv3.union($sv4);
      $sv1 = $sv1.intersect($sv3.complement());
      $sv5 = new CofinFin(false, new int[] {});
      CofinFin $sv6 = new CofinFin(false, new int[] {1,2,3});
      CofinFin $sv7 = new CofinFin(true, new int[] {});
      $sv6 = $sv6.intersect($sv7);
      $sv5 = $sv5.union($sv6);
      $sv1 = $sv1.intersect($sv5.complement());
      CofinFin $sv8 = new CofinFin(false, new int[] {});
      $sv1 = $sv1.intersect($sv8.complement());
      CofinFin $sv9 = s.complement();
      CofinFin $sv10 = t.complement();
      $sv9 = $sv9.intersect($sv10);
      CofinFin $sv11 = new CofinFin(false, new int[] {});
      $sv11 = $sv11.complement();
      $sv9 = $sv9.union($sv11);
      CofinFin $sv12 = w;
      $sv12 = $sv12.intersect(s);
      $sv9 = $sv9.union($sv12);
      $sv1 = $sv1.intersect($sv9.complement());
      $sv1 = $sv1.intersect(t.complement());
      CofinFin $sv13 = v;
      $sv13 = $sv13.union(s);
      CofinFin $sv14 = t;
      $sv14 = $sv14.intersect(v);
      $sv14 = $sv14.intersect(s);
      $sv14 = $sv14.intersect(t);
      $sv13 = $sv13.union($sv14);
      $sv1 = $sv1.intersect($sv13.complement());
      if ($sv1.isIn(0)){
         $sv1 = new CofinFin(false, new int[] {1});
         tt = $sv1;

      }
      else{
         $sv1 = new CofinFin(false, new int[] {25});
         tt = $sv1;

      }

      $sv1 = s;
      $sv1 = $sv1.union(t);
      $sv2 = w;
      $sv2 = $sv2.intersect(v);
      $sv3 = new CofinFin(false, new int[] {1,2,3,4,5});
      $sv2 = $sv2.union($sv3);
      $sv4 = new CofinFin(true, new int[] {});
      $sv2 = $sv2.union($sv4);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv5 = v;
      $sv5 = $sv5.intersect(w);
      $sv5 = $sv5.intersect(t);
      $sv6 = new CofinFin(false, new int[] {1,2,3,4});
      $sv5 = $sv5.union($sv6);
      $sv1 = $sv1.intersect($sv5.complement());
      $sv7 = new CofinFin(false, new int[] {});
      $sv8 = new CofinFin(false, new int[] {2});
      $sv7 = $sv7.union($sv8);
      $sv1 = $sv1.intersect($sv7.complement());
      if ($sv1.isIn(i)){
         $sv1 = new CofinFin(false, new int[] {0});
         ss = $sv1;

      }
      else{
         $sv1 = new CofinFin(false, new int[] {24});
         ss = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      $sv2 = new CofinFin(false, new int[] {0,1,2,3,4,5,30,31});
      $sv1 = $sv1.intersect($sv2);
      $sv3 = t;
      $sv4 = new CofinFin(false, new int[] {0,1,2,3,4,5,6,7,8,9,10});
      $sv5 = new CofinFin(true, new int[] {0,1,2,3,4,5});
      $sv4 = $sv4.intersect($sv5);
      $sv3 = $sv3.union($sv4);
      $sv1 = $sv1.intersect($sv3.complement());
      $sv6 = s;
      $sv6 = $sv6.intersect(t);
      $sv7 = new CofinFin(false, new int[] {});
      $sv6 = $sv6.union($sv7);
      $sv1 = $sv1.intersect($sv6.complement());
      $sv8 = s;
      $sv9 = new CofinFin(true, new int[] {});
      $sv8 = $sv8.union($sv9);
      $sv1 = $sv1.intersect($sv8.complement());
      $sv10 = new CofinFin(false, new int[] {});
      $sv11 = new CofinFin(false, new int[] {1,2,3});
      $sv12 = new CofinFin(true, new int[] {});
      $sv11 = $sv11.intersect($sv12);
      $sv10 = $sv10.union($sv11);
      $sv1 = $sv1.intersect($sv10.complement());
      $sv13 = new CofinFin(false, new int[] {});
      $sv1 = $sv1.intersect($sv13.complement());
      $sv14 = s.complement();
      CofinFin $sv15 = t.complement();
      $sv14 = $sv14.intersect($sv15);
      CofinFin $sv16 = new CofinFin(false, new int[] {});
      $sv16 = $sv16.complement();
      $sv14 = $sv14.union($sv16);
      $sv1 = $sv1.intersect($sv14.complement());
      CofinFin $sv17 = w;
      $sv17 = $sv17.intersect(s);
      $sv17 = $sv17.intersect(t.complement());
      CofinFin $sv18 = v;
      $sv18 = $sv18.union(s);
      CofinFin $sv19 = t;
      $sv19 = $sv19.intersect(v);
      $sv19 = $sv19.intersect(s);
      $sv19 = $sv19.intersect(t);
      $sv18 = $sv18.union($sv19);
      CofinFin $sv20 = new CofinFin(false, new int[] {1,2,3,4});
      $sv18 = $sv18.union($sv20);
      $sv17 = $sv17.intersect($sv18.complement());
      CofinFin $sv21 = new CofinFin(false, new int[] {});
      CofinFin $sv22 = new CofinFin(false, new int[] {2});
      $sv21 = $sv21.union($sv22);
      $sv17 = $sv17.intersect($sv21.complement());
      if ($sv1.isSubsetOf($sv17)){
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {5});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }
      else{
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {29});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }

      $sv1 = s;
      $sv1 = $sv1.union(t);
      $sv2 = w;
      $sv2 = $sv2.intersect(v);
      $sv3 = new CofinFin(false, new int[] {1,2,3,4,5});
      $sv2 = $sv2.union($sv3);
      $sv4 = new CofinFin(true, new int[] {});
      $sv2 = $sv2.union($sv4);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv5 = v;
      $sv5 = $sv5.intersect(w);
      $sv5 = $sv5.intersect(t);
      $sv6 = new CofinFin(false, new int[] {1,2,3,4});
      $sv5 = $sv5.union($sv6);
      $sv1 = $sv1.intersect($sv5.complement());
      $sv7 = new CofinFin(false, new int[] {});
      $sv8 = new CofinFin(false, new int[] {2});
      $sv7 = $sv7.union($sv8);
      $sv1 = $sv1.intersect($sv7.complement());
      $sv9 = new CofinFin(true, new int[] {});
      $sv10 = new CofinFin(false, new int[] {0,1,2,3,4,5,30,31});
      $sv9 = $sv9.intersect($sv10);
      $sv11 = t;
      $sv12 = new CofinFin(false, new int[] {0,1,2,3,4,5,6,7,8,9,10});
      $sv13 = new CofinFin(true, new int[] {0,1,2,3,4,5});
      $sv12 = $sv12.intersect($sv13);
      $sv11 = $sv11.union($sv12);
      $sv9 = $sv9.intersect($sv11.complement());
      $sv14 = s;
      $sv14 = $sv14.intersect(t);
      $sv15 = new CofinFin(false, new int[] {});
      $sv14 = $sv14.union($sv15);
      $sv9 = $sv9.intersect($sv14.complement());
      $sv16 = s;
      $sv17 = new CofinFin(true, new int[] {});
      $sv16 = $sv16.union($sv17);
      $sv9 = $sv9.intersect($sv16.complement());
      $sv18 = new CofinFin(false, new int[] {});
      $sv19 = new CofinFin(false, new int[] {1,2,3});
      $sv20 = new CofinFin(true, new int[] {});
      $sv19 = $sv19.intersect($sv20);
      $sv18 = $sv18.union($sv19);
      $sv9 = $sv9.intersect($sv18.complement());
      $sv21 = new CofinFin(false, new int[] {});
      $sv9 = $sv9.intersect($sv21.complement());
      $sv22 = s.complement();
      CofinFin $sv23 = t.complement();
      $sv22 = $sv22.intersect($sv23);
      CofinFin $sv24 = new CofinFin(false, new int[] {});
      $sv24 = $sv24.complement();
      $sv22 = $sv22.union($sv24);
      $sv9 = $sv9.intersect($sv22.complement());
      CofinFin $sv25 = new CofinFin(false, new int[] {});
      $sv9 = $sv9.intersect($sv25);
      if ($sv1.isSubsetOf($sv9)){
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {4});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }
      else{
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {28});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }

      $sv1 = t;
      $sv1 = $sv1.union(s);
      $sv1 = $sv1.intersect(w.complement());
      $sv2 = v.complement();
      $sv3 = new CofinFin(false, new int[] {1,2,3,4});
      $sv2 = $sv2.union($sv3);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv4 = new CofinFin(true, new int[] {});
      $sv5 = t;
      $sv5 = $sv5.union(s);
      $sv6 = w;
      $sv6 = $sv6.intersect(v);
      $sv5 = $sv5.union($sv6);
      $sv4 = $sv4.intersect($sv5.complement());
      if ($sv1.equals($sv4)){
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {7});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }
      else{
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {31});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }

      $sv1 = s;
      $sv1 = $sv1.intersect(t);
      $sv2 = new CofinFin(false, new int[] {});
      $sv1 = $sv1.union($sv2);
      $sv3 = s;
      $sv4 = new CofinFin(true, new int[] {});
      $sv3 = $sv3.union($sv4);
      $sv1 = $sv1.intersect($sv3.complement());
      $sv5 = new CofinFin(false, new int[] {});
      $sv6 = new CofinFin(false, new int[] {1,2,3});
      $sv7 = new CofinFin(true, new int[] {});
      $sv6 = $sv6.intersect($sv7);
      $sv5 = $sv5.union($sv6);
      $sv1 = $sv1.intersect($sv5.complement());
      $sv8 = new CofinFin(false, new int[] {});
      $sv1 = $sv1.intersect($sv8.complement());
      $sv9 = s.complement();
      $sv10 = t.complement();
      $sv9 = $sv9.intersect($sv10);
      $sv11 = new CofinFin(false, new int[] {});
      $sv11 = $sv11.complement();
      $sv9 = $sv9.union($sv11);
      $sv12 = w;
      $sv12 = $sv12.intersect(s);
      $sv9 = $sv9.union($sv12);
      $sv1 = $sv1.intersect($sv9.complement());
      $sv1 = $sv1.intersect(t.complement());
      $sv13 = v;
      $sv13 = $sv13.union(s);
      $sv14 = t;
      $sv14 = $sv14.intersect(v);
      $sv14 = $sv14.intersect(s);
      $sv14 = $sv14.intersect(t);
      $sv13 = $sv13.union($sv14);
      $sv1 = $sv1.intersect($sv13.complement());
      if (!$sv1.isIn(0)){
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {6});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }
      else{
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {30});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }

      $sv1 = s;
      $sv1 = $sv1.union(t);
      $sv2 = w;
      $sv2 = $sv2.intersect(v);
      $sv3 = new CofinFin(false, new int[] {1,2,3,4,5});
      $sv2 = $sv2.union($sv3);
      $sv4 = new CofinFin(true, new int[] {});
      $sv2 = $sv2.union($sv4);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv5 = v;
      $sv5 = $sv5.intersect(w);
      $sv5 = $sv5.intersect(t);
      $sv6 = new CofinFin(false, new int[] {1,2,3,4});
      $sv5 = $sv5.union($sv6);
      $sv1 = $sv1.intersect($sv5.complement());
      $sv7 = new CofinFin(false, new int[] {});
      $sv8 = new CofinFin(false, new int[] {2});
      $sv7 = $sv7.union($sv8);
      $sv1 = $sv1.intersect($sv7.complement());
      if (!$sv1.isIn(i)){
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {9});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }
      else{
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {33});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }

      $sv1 = new CofinFin(true, new int[] {});
      $sv2 = new CofinFin(false, new int[] {0,1,2,3,4,5,30,31});
      $sv1 = $sv1.intersect($sv2);
      $sv3 = t;
      $sv4 = new CofinFin(false, new int[] {0,1,2,3,4,5,6,7,8,9,10});
      $sv5 = new CofinFin(true, new int[] {0,1,2,3,4,5});
      $sv4 = $sv4.intersect($sv5);
      $sv3 = $sv3.union($sv4);
      $sv1 = $sv1.intersect($sv3.complement());
      $sv6 = s;
      $sv6 = $sv6.intersect(t);
      $sv7 = new CofinFin(false, new int[] {});
      $sv6 = $sv6.union($sv7);
      $sv1 = $sv1.intersect($sv6.complement());
      $sv8 = s;
      $sv9 = new CofinFin(true, new int[] {});
      $sv8 = $sv8.union($sv9);
      $sv1 = $sv1.intersect($sv8.complement());
      $sv10 = new CofinFin(false, new int[] {});
      $sv11 = new CofinFin(false, new int[] {1,2,3});
      $sv12 = new CofinFin(true, new int[] {});
      $sv11 = $sv11.intersect($sv12);
      $sv10 = $sv10.union($sv11);
      $sv1 = $sv1.intersect($sv10.complement());
      $sv13 = new CofinFin(false, new int[] {});
      $sv1 = $sv1.intersect($sv13.complement());
      $sv14 = s.complement();
      $sv15 = t.complement();
      $sv14 = $sv14.intersect($sv15);
      $sv16 = new CofinFin(false, new int[] {});
      $sv16 = $sv16.complement();
      $sv14 = $sv14.union($sv16);
      $sv1 = $sv1.intersect($sv14.complement());
      $sv17 = w;
      $sv17 = $sv17.intersect(s);
      $sv17 = $sv17.intersect(t.complement());
      $sv18 = v;
      $sv18 = $sv18.union(s);
      $sv19 = t;
      $sv19 = $sv19.intersect(v);
      $sv19 = $sv19.intersect(s);
      $sv19 = $sv19.intersect(t);
      $sv18 = $sv18.union($sv19);
      $sv20 = new CofinFin(false, new int[] {1,2,3,4});
      $sv18 = $sv18.union($sv20);
      $sv17 = $sv17.intersect($sv18.complement());
      $sv21 = new CofinFin(false, new int[] {});
      $sv22 = new CofinFin(false, new int[] {2});
      $sv21 = $sv21.union($sv22);
      $sv17 = $sv17.intersect($sv21.complement());
      if (!$sv1.isSubsetOf($sv17)){
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {5});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {8});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }
      else{
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {32});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }

      $sv1 = s;
      $sv1 = $sv1.union(t);
      $sv2 = w;
      $sv2 = $sv2.intersect(v);
      $sv3 = new CofinFin(false, new int[] {1,2,3,4,5});
      $sv2 = $sv2.union($sv3);
      $sv4 = new CofinFin(true, new int[] {});
      $sv2 = $sv2.union($sv4);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv5 = v;
      $sv5 = $sv5.intersect(w);
      $sv5 = $sv5.intersect(t);
      $sv6 = new CofinFin(false, new int[] {1,2,3,4});
      $sv5 = $sv5.union($sv6);
      $sv1 = $sv1.intersect($sv5.complement());
      $sv7 = new CofinFin(false, new int[] {});
      $sv8 = new CofinFin(false, new int[] {2});
      $sv7 = $sv7.union($sv8);
      $sv1 = $sv1.intersect($sv7.complement());
      $sv9 = new CofinFin(true, new int[] {});
      $sv10 = new CofinFin(false, new int[] {0,1,2,3,4,5,30,31});
      $sv9 = $sv9.intersect($sv10);
      $sv11 = t;
      $sv12 = new CofinFin(false, new int[] {0,1,2,3,4,5,6,7,8,9,10});
      $sv13 = new CofinFin(true, new int[] {0,1,2,3,4,5});
      $sv12 = $sv12.intersect($sv13);
      $sv11 = $sv11.union($sv12);
      $sv9 = $sv9.intersect($sv11.complement());
      $sv14 = s;
      $sv14 = $sv14.intersect(t);
      $sv15 = new CofinFin(false, new int[] {});
      $sv14 = $sv14.union($sv15);
      $sv9 = $sv9.intersect($sv14.complement());
      $sv16 = s;
      $sv17 = new CofinFin(true, new int[] {});
      $sv16 = $sv16.union($sv17);
      $sv9 = $sv9.intersect($sv16.complement());
      $sv18 = new CofinFin(false, new int[] {});
      $sv19 = new CofinFin(false, new int[] {1,2,3});
      $sv20 = new CofinFin(true, new int[] {});
      $sv19 = $sv19.intersect($sv20);
      $sv18 = $sv18.union($sv19);
      $sv9 = $sv9.intersect($sv18.complement());
      $sv21 = new CofinFin(false, new int[] {});
      $sv9 = $sv9.intersect($sv21.complement());
      $sv22 = s.complement();
      $sv23 = t.complement();
      $sv22 = $sv22.intersect($sv23);
      $sv24 = new CofinFin(false, new int[] {});
      $sv24 = $sv24.complement();
      $sv22 = $sv22.union($sv24);
      $sv9 = $sv9.intersect($sv22.complement());
      $sv25 = new CofinFin(false, new int[] {});
      $sv9 = $sv9.intersect($sv25);
      if (!$sv1.isSubsetOf($sv9)){
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {4});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {11});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }
      else{
         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {35});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {36});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

      }

      $sv1 = t;
      $sv1 = $sv1.union(s);
      $sv1 = $sv1.intersect(w.complement());
      $sv2 = v.complement();
      $sv3 = new CofinFin(false, new int[] {1,2,3,4});
      $sv2 = $sv2.union($sv3);
      $sv1 = $sv1.intersect($sv2.complement());
      $sv4 = new CofinFin(true, new int[] {});
      $sv5 = t;
      $sv5 = $sv5.union(s);
      $sv6 = w;
      $sv6 = $sv6.intersect(v);
      $sv5 = $sv5.union($sv6);
      $sv4 = $sv4.intersect($sv5.complement());
      if (!$sv1.equals($sv4)){
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {10});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {37});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }
      else{
         $sv1 = ss;
         $sv2 = new CofinFin(false, new int[] {34});
         $sv1 = $sv1.union($sv2);
         ss = $sv1;

         $sv1 = tt;
         $sv2 = new CofinFin(false, new int[] {39});
         $sv1 = $sv1.union($sv2);
         tt = $sv1;

      }


      $sv1 = ss;
      $sv1 = $sv1.union(tt);
      System.out.println($sv1.toString());
   }
}
// Successful parse.
