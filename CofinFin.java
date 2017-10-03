import java.util.*;

public class CofinFin {

/// THIS IS THE TEMPLATE YOU SHOULD USE
/**


Team members:






**/


   private static CofinFin emT;
   
   private boolean complement;
   private TreeSet<Integer> finite; // should never be null, even if
   // the set is empty
   
   /**

     This class implements an instance of a subset of the natural numbers,
     { 0, 1, 2, ... }, that is either finite or cofinite(that is, its complement
     with respect to the natural numbers is finite) according to the following
     scheme.
     
     There are two mutually exclusive cases
     
     Case I: the represented set is finite
     
     complement is false
     
     finite has exactly the members of the set which are ordered ascending in
     the tree.
     
     Examples
     
     1. empty set 
        complement is false 
        finite is empty, BUT NOT NULL

     2. { 0, 2, 4 }
        complement is false
        finite has the values { 0, 2, 4 }
     
     
     Case II: the represented is cofinite
     
     complement is true and finite has all the values that are NOT in the
     represented value.

     Below we use N to stand for the set of natural numbers { 0, 1, 2, 3, ... }

     Examples

     1. N = ( 0, 1, 2, 3, ... }
        complement is true
        finite is empty, BUT NOT NULL

     2. { 1, 3, 5, 6, 7, ... }
        complement is true
        finite has the values { 0, 2, 4 }

     class invariant:
        finite is not null and never contains a value < 0

     Constructors should establish the class invariant and mutators 
     should preserver it.

    ***/
   
   // constructors
   
   // I WILL CODE THIS ONE SO I CAN USE IT BELOW
   public CofinFin() {
      // / constructs the rep of the empty set
      finite = new TreeSet<Integer>();
      
   }
   
   public CofinFin(boolean comp, int n) {
      /****
         YOU NEED TO CODE THIS
       ****/
      /***
      if  n >= 0, if comp is false, constructs the rep of { n } else
      constructs the rep of the complement of { n }
      
         if n < 0 if comp is false creates the rep of the empty set else creates
         the rep of N
       ***/
      this();
   }
   
   public CofinFin(boolean comp, int[] A) {
      /****
         YOU NEED TO CODE THIS
       ****/
      /***
         if comp is false
            if A is null 
               constructs the rep of the empty set 
            else
               constructs the rep of the distinct values in A that are >= 0 (could be
               none, e.g., if A is { -1,-2,-3 }) 
         else 
            if A is null 
               constructs the rep of all of the natural numbers 
            else constructs the rep of the complement of all of the natural 
               numbers (which are all >= 0) that are elements of A)
       ***/
      this();
      
   }
   
   // mutators
   
   public void remove(int n) {
      // if n < 0 or n is not in the set represented by this, no changes are made
      // else, the rep is modified to reflect the removal of n from the set
      // this represents
      /****
         YOU NEED TO CODE THIS
       ****/
      
         
      
   }
   
   public void add(int n) {
      // if n < 0 or n is in the set represented by this, no changes are made
      // else, the rep is modified to reflect the addition of n to the set
      // this represents
      /****
         YOU NEED TO CODE THIS
       ****/
   }
   
   // operations
   
   public CofinFin union(CofinFin other) {

      /****
         YOU NEED TO CODE THIS
       ****/
      // creates and returns a new value that represents the union of this and
      // other;
      // this and other are NOT modified

      return new CofinFin();
      
   }
   
   public CofinFin intersect(CofinFin other) {
      /****
         YOU NEED TO CODE THIS
       ****/

      // creates and returns a new value that represents the intersection of this and
      // other;
      // this and other are NOT modified
      
      return new CofinFin();

   }
         
   public CofinFin complement() {
      /****
         YOU NEED TO CODE THIS
       ****/

      // creates and returns a new value that represents the complement of this;
      // this is NOT modified
      

      return new CofinFin();
   }
   
   public boolean isIn(int n) {
      /****
         YOU NEED TO CODE THIS
       ****/

      
      // returns false if n < 0 or n is not in the set
      // represented by this
      // else returns true
      
      // for the compiler
      return false;

    }

   
   public String toString() {
      /**
         If complement is false if the set is empty returns the string "{}" else
         returns the string "{ v1, v2, ... , vk }" where the vi are the distinct
         k values in the set sorted in increasing order For example, { 0, 2, 3 }
         should return the string "{ 0, 2, 3 }" else returns the string CMPx
         where x is the string for the set if complement were false, for
         example, all the natural numbers would have the string "CMP{}", the set
         that is all natural numbers except { 1, 3, 5 }, would have the string
         "CMP{ 1, 3, 5 }", etc.
         
         Of course, if complement is false and the set is large, this could be a
         very long string. We may want to stop after 5 values and just put "..."
         after the last value. That's acceptable to me.

       FOR THIS FIRST HOMEWORK, WE NEED TO PRINT THEM ALL OUT, AND SO THERE IS
       PERFECT AGREEMENT ON THE TEXT FILE OUTPUT, PLEASE USE MY VERSION.
       **/
    
      boolean notEmpt = !finite.isEmpty();
      
      StringBuffer bf = new StringBuffer();
      
      if (complement)
         bf.append("CMP");
      
      bf.append('{');
      if (notEmpt){
         bf.append(' ');
      
         Iterator<Integer> iter = finite.iterator();
      
         while (iter.hasNext()) {
            bf.append(iter.next().toString());
            if (iter.hasNext())
               bf.append(", ");
         }
         bf.append(' ');
      }
      
      bf.append('}');
      
      return bf.toString();
   }
   
   public boolean equals(CofinFin other) {
      /****
         YOU NEED TO CODE THIS
       ****/
      // returns true exactly when other and this represent the same set;
      // you can use the isSubsetOf method

      return false;
   }
  
   
   public boolean isSubsetOf(CofinFin other) {
      /****
         YOU NEED TO CODE THIS
       ****/
      /*
         
         returns true when this is a subset of other. This might be a little
         tricky, but it should be doable.
       */
      
      return false;

   }
            

   public int maximum() throws Exception{
      /****
         YOU NEED TO CODE THIS
       ****/
   /**

      if this is cofinite
         throws an exception with the message "maximum called for cofinite receiver"
      else if this is finite and empty
         throws an exception with the message "maximum called for empty receiver"
      else // this is finite and not empty
         returns the maximum value in this

   **/
     return -1;


   }

   public int minimum() throws Exception{
      /****
         YOU NEED TO CODE THIS
       ****/
   /**

      if this is empty
         throws an exception with the message "minimum called for empty receiver"
      else // this is not empty
         returns the minimum value in this

   **/


      return -1; 
   }
   
private static  // so they will all be initialized to null
   CofinFin
      a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,

      aa, ab, ac, ad, ae, af, ag, ah, ai, aj,ak, al, am, an,
      ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az,

      ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn,
      bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz,

      cc, dd, ee;




//  the driver tests the methods
public static void main (String[] args){

   int ii, jj, kk;

   int []
      A = { -1, -2, -3, -4},
      B = { 0, 1, 2, 3},
      C =  {-1, 0, -2, 1, -3, 2, -4}, 
      D = { 2, 3, 5, 7 },
      E = { 1, 3, 5, 7 },
      F = { 1, 2, 3, 4 },
      G = { 0,1,5,6,7,10,11,13},
      H = { 2,3,6,8,9 },
      I = { 2,4,6,8,10,13 },
      J = { 13,15,17,19,21},
      K = { 3,5,7,11},
      L = { 1, 2, 3, 7 },
      M  = { 10, 30, 50, 70},
      N = { 10, 20, 30, 70  },
      O = { 0,1,4,5,6,7,9},
      P = { 0,1,4,5,6,7,9,10},
      Q = { 8,9,11,12 },
      R = { 0,1,4,5,6,7,8,10,11,12},
      S = new int[0],
      T = null,
      U = { -1 },
      V = { 0 },
      W = { 100 },
      X = {};


   ////////////////  SIMPLE CONSTRUCTOR TESTS

   System.out.println("Simple Constructor Tests.\n");
   try{

      emT = new CofinFin();

      System.out.println("emT = " + emT.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "emT"

      + " threw an exception.");
      e.printStackTrace();
      emT = null;
   }


   try{

      a = new CofinFin(false, -1); 

      System.out.println("a = " + a.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'a'

      + " threw an exception.");
      e.printStackTrace();
      a = null;
   }


   try{

      b = new CofinFin(false,0);

      System.out.println("b = " + b.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'b'

      + " threw an exception.");
      e.printStackTrace();
      b = null;
   }

   try{

      c = new CofinFin(false,1);

      System.out.println("c = " + c.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'c'

      + " threw an exception.");
      e.printStackTrace();
      c = null;
   }

   try{

      d = new CofinFin(false,100);

      System.out.println("d = " + d.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'd'

      + " threw an exception.");
      e.printStackTrace();
      d = null;
   }


   try{

      f = new CofinFin(true, -1); 

      System.out.println("f = " + f.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'f'

      + " threw an exception.");
      e.printStackTrace();
      f = null;
   }


   try{

      g = new CofinFin(true,0);

      System.out.println("g = " + g.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'g'

      + " threw an exception.");
      e.printStackTrace();
      g = null;
   }

   try{

      h = new CofinFin(true,1);

      System.out.println("h = " + h.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'h'

      + " threw an exception.");
      e.printStackTrace();
      h = null;
   }

   try{

      i = new CofinFin(true,100);

      System.out.println("i = " + i.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'i'

      + " threw an exception.");
      e.printStackTrace();
      i = null;
   }



   ////////////////  ARRAY CONSTRUCTOR TESTS

   System.out.println("\nArray Constructor Tests\n");


   try{

      j = new CofinFin(false, A);

      System.out.println("j = " + j.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'j'

      + " threw an exception.");
      e.printStackTrace();
      j = null;
   }
   try{

      k = new CofinFin(false, B);

      System.out.println("k = " + k.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'k'

      + " threw an exception.");
      e.printStackTrace();
      k = null;
   }
   try{

      m = new CofinFin(false,C);

      System.out.println("m = " + m.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'm'

      + " threw an exception.");
      e.printStackTrace();
      m = null;
   }
   try{

       n= new CofinFin(false, D);

      System.out.println("n = " + n.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'n'

      + " threw an exception.");
      e.printStackTrace();
      n = null;
   }


   try{

       aw = new CofinFin(false, E);

      System.out.println("aw = " + aw.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "aw"

      + " threw an exception.");
      e.printStackTrace();
      aw = null;
   }

   try{

       ax= new CofinFin(false, F);

      System.out.println("ax = " + ax.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ax"

      + " threw an exception.");
      e.printStackTrace();
      ax = null;
   }

   try{

       ay= new CofinFin(false, G);

      System.out.println("ay = " + ay.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ay"

      + " threw an exception.");
      e.printStackTrace();
      ay = null;
   }

   try{

       az= new CofinFin(false, H);

      System.out.println("az = " + az.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "az"

      + " threw an exception.");
      e.printStackTrace();
      az = null;
   }

   try{

       ba= new CofinFin(false, I);

      System.out.println("ba = " + ba.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ba"

      + " threw an exception.");
      e.printStackTrace();
      ba = null;
   }

   try{

       bb= new CofinFin(false, J);

      System.out.println("bb = " + bb.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bb"

      + " threw an exception.");
      e.printStackTrace();
      bb = null;
   }

   try{

       bc= new CofinFin(false, K);

      System.out.println("bc = " + bc.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bc"

      + " threw an exception.");
      e.printStackTrace();
      bc = null;
   }

   try{

       bd= new CofinFin(false, L);

      System.out.println("bd = " + bd.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bd"

      + " threw an exception.");
      e.printStackTrace();
      bd = null;
   }

   try{

       be= new CofinFin(false, M);

      System.out.println("be = " + be.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "be"

      + " threw an exception.");
      e.printStackTrace();
      be = null;
   }

   try{

       bf= new CofinFin(false, N);

      System.out.println("bf = " + bf.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bf"

      + " threw an exception.");
      e.printStackTrace();
      bf = null;
   }

   try{

       bg= new CofinFin(false, O);

      System.out.println("bg = " + bg.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bg"

      + " threw an exception.");
      e.printStackTrace();
      bg = null;
   }


   try{

       o = new CofinFin(false, P);

      System.out.println("o = " + o.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "o"

      + " threw an exception.");
      e.printStackTrace();
      o = null;
   }
   try{

       p = new CofinFin(false, Q);

      System.out.println("p = " + p.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'p'

      + " threw an exception.");
      e.printStackTrace();
      p = null;
   }
   try{

      q = new CofinFin(false,R);

      System.out.println("q = " + q.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'q'

      + " threw an exception.");
      e.printStackTrace();
      q = null;
   }
   try{

       r = new CofinFin(false,S);

      System.out.println("r = " + r.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'r'

      + " threw an exception.");
      e.printStackTrace();
      r = null;
   }


   try{

      s = new CofinFin(false, T);

      System.out.println("s = " + s.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      's'

      + " threw an exception.");
      e.printStackTrace();
      s = null;
   }
   try{

      t = new CofinFin(false, U);

      System.out.println("t = " + t.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      't'

      + " threw an exception.");
      e.printStackTrace();
      t = null;
   }
   try{

      u = new CofinFin(false,V);

      System.out.println("u = " + u.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'u'

      + " threw an exception.");
      e.printStackTrace();
      u = null;
   }
   try{

       v= new CofinFin(false, W);

      System.out.println("v = " + v.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'v'

      + " threw an exception.");
      e.printStackTrace();
      v = null;
   }
   try{

       w = new CofinFin(false, X);

      System.out.println("w = " + w.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'w'

      + " threw an exception.");
      e.printStackTrace();
      w = null;
   }
   try{

       x = new CofinFin(false, W);

      System.out.println("x = " + x.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'x'

      + " threw an exception.");
      e.printStackTrace();
      x = null;
   }
   try{

       l = new CofinFin(false, X);

      System.out.println("l = " + l.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'l'

      + " threw an exception.");
      e.printStackTrace();
      l = null;
   }

   try{

      y = new CofinFin(true,A);

      System.out.println("y = " + y.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'y'

      + " threw an exception.");
      e.printStackTrace();
      y = null;
   }
   try{

       z = new CofinFin(true,B);

      System.out.println("z = " + z.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      'z'

      + " threw an exception.");
      e.printStackTrace();
      z = null;
   }

   try{

       aa = new CofinFin(true,C);

      System.out.println("aa = " + aa.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "aa"

      + " threw an exception.");
      e.printStackTrace();
      aa = null;
   }

   try{

       ab = new CofinFin(true,D);

      System.out.println("ab = " + ab.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ab"

      + " threw an exception.");
      e.printStackTrace();
      ab = null;
   }

   try{

       ac = new CofinFin(true ,E);

      System.out.println("ac = " + ac.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ac"

      + " threw an exception.");
      e.printStackTrace();
      ac = null;
   }

   try{

       ad = new CofinFin(true ,F);

      System.out.println("ad = " + ad.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ad"

      + " threw an exception.");
      e.printStackTrace();
      ad = null;
   }

   try{

       ae = new CofinFin(true ,G);

      System.out.println("ae = " + ae.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ae"

      + " threw an exception.");
      e.printStackTrace();
      ae = null;
   }
   try{

       af = new CofinFin(true ,H);

      System.out.println("af = " + af.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "af"

      + " threw an exception.");
      e.printStackTrace();
      af = null;
   }
   try{

       ag = new CofinFin(true ,I);

      System.out.println("ag = " + ag.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ag"

      + " threw an exception.");
      e.printStackTrace();
      ag = null;
   }
   try{

       ah = new CofinFin(true ,J);

      System.out.println("ah = " + ah.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ah"

      + " threw an exception.");
      e.printStackTrace();
      ah = null;
   }
   try{

       ai = new CofinFin(true ,K);

      System.out.println("ai = " + ai.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ai"

      + " threw an exception.");
      e.printStackTrace();
      ai = null;
   }
   try{

       aj = new CofinFin(true ,L);

      System.out.println("aj = " + aj.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "aj"

      + " threw an exception.");
      e.printStackTrace();
      aj = null;
   }
   try{

       ak = new CofinFin(true ,M);

      System.out.println("ak = " + ak.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ak"

      + " threw an exception.");
      e.printStackTrace();
      ak = null;
   }
   try{

       al = new CofinFin(true ,N);

      System.out.println("al = " + al.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "al"

      + " threw an exception.");
      e.printStackTrace();
      al = null;
   }
   try{

       am = new CofinFin(true ,O);

      System.out.println("am = " + am.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "am"

      + " threw an exception.");
      e.printStackTrace();
      am = null;
   }
   try{

       an = new CofinFin(true ,P);

      System.out.println("an = " + an.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "an"

      + " threw an exception.");
      e.printStackTrace();
      an = null;
   }
   try{

       ao = new CofinFin(true ,Q);

      System.out.println("ao = " + ao.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ao"

      + " threw an exception.");
      e.printStackTrace();
      ao = null;
   }
   try{

       ap = new CofinFin(true ,R);

      System.out.println("ap = " + ap.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ap"

      + " threw an exception.");
      e.printStackTrace();
      ap = null;
   }
   try{

       aq = new CofinFin(true ,S);

      System.out.println("aq = " + aq.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "aq"

      + " threw an exception.");
      e.printStackTrace();
      aq = null;
   }
   try{

       ar = new CofinFin(true ,T);

      System.out.println("ar = " + ar.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "ar"

      + " threw an exception.");
      e.printStackTrace();
      ar = null;
   }
   try{

       as = new CofinFin(true ,U);

      System.out.println("as = " + as.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "as"

      + " threw an exception.");
      e.printStackTrace();
      as = null;
   }
   try{

       at = new CofinFin(true ,V);

      System.out.println("at = " + at.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "at"

      + " threw an exception.");
      e.printStackTrace();
      at = null;
   }
   try{

       au = new CofinFin(true ,W);

      System.out.println("au = " + au.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "au"

      + " threw an exception.");
      e.printStackTrace();
      au = null;
   }

   try{

       av = new CofinFin(true ,X);

      System.out.println("av = " + av.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "av"

      + " threw an exception.");
      e.printStackTrace();
      av = null;
   }

   ////////////////  REMOVE TESTS


   System.out.println("\nRemove Tests\n");


   if (emT == null)
      System.out.println("Test 1 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 1 ");
         emT.remove(-1);
         System.out.println(" = " + emT.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (s   == null)
      System.out.println("Test 2 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 2 ");
         s.remove(-2);
         System.out.println(" = " + s.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (d   == null)
      System.out.println("Test 3 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 3 ");
         d.remove(-3);
         System.out.println(" = " + d.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (i   == null)
      System.out.println("Test 4 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 4 ");
         i.remove(-4);
         System.out.println(" = " + i.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (r   == null)
      System.out.println("Test 5 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 5 ");
         r.remove(-5);
         System.out.println(" = " + r.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (z   == null)
      System.out.println("Test 6 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 6 ");
         z .remove(-6);
         System.out.println(" = " + z.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }


   if (  aa   == null)
      System.out.println("Test 7  value not constructed.");
   else{
      try{
         System.out.print("Remove Test 7  ");
         aa.remove(0   );
         System.out.println(" = " +  aa.toString());
         aa = new CofinFin(false, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }


   if (  aa   == null)
      System.out.println("Test 8  value not constructed.");
   else{
      try{
         System.out.print("Remove Test 8  ");
         aa.remove(1   );
         System.out.println(" = " +  aa.toString());
         aa = new CofinFin(false, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  aa   == null)
      System.out.println("Test 9  value not constructed.");
   else{
      try{
         System.out.print("Remove Test 9  ");
         aa.remove(2   );
         System.out.println(" = " +  aa.toString());
         aa = new CofinFin(false, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  aa   == null)
      System.out.println("Test 10 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 10 ");
         aa.remove(3   );
         System.out.println(" = " +  aa.toString());
         aa = new CofinFin(false, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  aa   == null)
      System.out.println("Test 11 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 11 ");
         aa.remove(7   );
         System.out.println(" = " +  aa.toString());
         aa = new CofinFin(false, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  aa   == null)
      System.out.println("Test 12 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 12 ");
         aa.remove(5   );
         System.out.println(" = " +  aa.toString());
         aa = new CofinFin(false, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (  ab   == null)
      System.out.println("Test 13 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 13 ");
         ab.remove(6   );
         System.out.println(" = " +  ab.toString());
         ab = new CofinFin(false, F);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (  ab   == null)
      System.out.println("Test 14 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 14 ");
         ab.remove(1   );
         System.out.println(" = " +  ab.toString());
         ab = new CofinFin(false, F);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (  ab   == null)
      System.out.println("Test 15 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 15 ");
         ab.remove(4   );
         System.out.println(" = " +  ab.toString());
         ab = new CofinFin(false, F);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }



   if (ab == null)
      System.out.println("Test 16   value not constructed.");
   else{
      try{
         System.out.print("Remove Test 16  ");
         ab.remove(3);
         System.out.println(" = " + ab.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (s == null)
      System.out.println("Test 17   value not constructed.");
   else{
      try{
         System.out.print("Remove Test 17  ");
         s.remove(0);
         System.out.println(" = " + s.toString());
         s = new CofinFin(true,T);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }


   if (o == null)
      System.out.println("Test 18   value not constructed.");
   else{
      try{
         System.out.print("Remove Test 18  ");
         o.remove(0);
         System.out.println(" = " + o.toString());
         o = new CofinFin(true,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (o == null)
      System.out.println("Test 19   value not constructed.");
   else{
      try{
         System.out.print("Remove Test 19  ");
         o.remove(0);
         System.out.println(" = " + o.toString());
         o = new CofinFin(true,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (o == null)
      System.out.println("Test 20   value not constructed.");
   else{
      try{
         System.out.print("Remove Test 20  ");
         o.remove(1);
         System.out.println(" = " + o.toString());
         o = new CofinFin(true ,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (o == null)
      System.out.println("Test 21   value not constructed.");
   else{
      try{
         System.out.print("Remove Test 21  ");
         o.remove(100);
         System.out.println(" = " + o.toString());
         o = new CofinFin(true ,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }




   if (  ac   == null)
      System.out.println("Test 22 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 22 ");
         ac.remove(0   );
         System.out.println(" = " +  ac.toString());
         ac = new CofinFin(true, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }


   if (  ac   == null)
      System.out.println("Test 23 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 23 ");
         ac.remove(1   );
         System.out.println(" = " +  ac.toString());
         ac = new CofinFin(true, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  ac   == null)
      System.out.println("Test 24 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 24 ");
         ac.remove(2   );
         System.out.println(" = " +  ac.toString());
         ac = new CofinFin(true, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  ac   == null)
      System.out.println("Test 25 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 25 ");
         ac.remove(3   );
         System.out.println(" = " +  ac.toString());
         ac = new CofinFin(true, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  ac   == null)
      System.out.println("Test 26 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 26 ");
         ac.remove(4   );
         System.out.println(" = " +  ac.toString());
         ac = new CofinFin(true, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (  ac   == null)
      System.out.println("Test 27 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 27 ");
         ac.remove(100   );
         System.out.println(" = " +  ac.toString());
         ac = new CofinFin(true, E);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (  ad   == null)
      System.out.println("Test 28 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 28 ");
         ad.remove(6   );
         System.out.println(" = " +  ad.toString());
         ad = new CofinFin(true, L);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (  ad   == null)
      System.out.println("Test 29 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 29 ");
         ad.remove(0   );
         System.out.println(" = " +  ad.toString());
         ad = new CofinFin(true, L);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (  ad   == null)
      System.out.println("Test 30 value not constructed.");
   else{
      try{
         System.out.print("Remove Test 30 ");
         ad.remove(8   );
         System.out.println(" = " +  ad.toString());
         ad = new CofinFin(true, L);

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }



   try{
      bj = new CofinFin(false, N);
      System.out.println("bj = " + bj.toString());

   }
   catch(Exception e){
      System.out.println("Construction of bj threw an exception");
      e.printStackTrace();
      bj = null;
   }

   try{
      bk = new CofinFin(true, N);
     System.out.println("bk = " + bk.toString());
   }
   catch(Exception e){
      System.out.println("Construction of bk thew an exception");
      e.printStackTrace();
      bk = null;
   }


    ////////////////  ADD TESTS

   // construct a few explicitly
   e = new CofinFin();
   e.complement = false;
   e.finite.add(1000);

   bh = new CofinFin();
   bh.complement = true;
   bh.finite.add(1000);

   bi = new CofinFin();
   bi.complement = true;
   bi. finite.add(500);

   System.out.println("e = " + e.toString());
   System.out.println("bh = " + bh.toString());
   System.out.println("bi = " + bi.toString());


   CofinFin[] testCases = {
      a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,

      aa, ab, ac, ad, ae, af, ag, ah, ai, aj,ak, al, am, an,
      ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az,

      ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn,
      bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz,
      cc, dd, ee};


  

   System.out.println("\nAdd Tests\n");


   for (ii = 0; ii < 63; ii++){
      if (testCases[ii] == null)
         System.out.println("Set for Add test " + ii + " is null.");
      else{
         // make a copy of the current value
         CofinFin tc = new CofinFin();
         tc.complement = testCases[ii].complement;
         tc.finite.addAll(testCases[ii].finite);

         System.out.println("Testing add for " + tc.toString());
         tc.add(-2);
         System.out.println("After adding -1, new value is " + tc.toString());
         tc.add(-1);
         System.out.println("After adding -2, new value is " + tc.toString());
         for (jj = 0; jj < 100; ){
            tc.add(jj);
            System.out.println("After adding " + jj + ", new value is " + tc.toString());
            jj = 2 * jj + 1;
         }
      }
   }

      

   System.out.println("\nThese add tests are legacy.\n");

   if (emT == null)
      System.out.println("Test 1 value not constructed.");
   else{
      try{
         System.out.print("Add Test 1 ");
         emT.add(-1);
         System.out.println(" = " + emT.toString());
         
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (s   == null)
      System.out.println("Test 2 value not constructed.");
   else{
      try{
         System.out.print("Add Test 2 ");
         s.add(-2);
         System.out.println(" = " + s.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (d   == null)
      System.out.println("Test 3 value not constructed.");
   else{
      try{
         System.out.print("Add Test 3 ");
         d.add(-3);
         System.out.println(" = " + d.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (i   == null)
      System.out.println("Test 4 value not constructed.");
   else{
      try{
         System.out.print("Add Test 4 ");
         i.add(-4);
         System.out.println(" = " + i.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (r   == null)
      System.out.println("Test 5 value not constructed.");
   else{
      try{
         System.out.print("Add Test 5 ");
         r.add(-5);
         System.out.println(" = " + r.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (z   == null)
      System.out.println("Test 6 value not constructed.");
   else{
      try{
         System.out.print("Add Test 6 ");
         z.add(-6);
         System.out.println(" = " + z.toString());

      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }



   if (emT == null)
      System.out.println("Test 7   value not constructed.");
   else{
      try{
         System.out.print("Add Test 7  ");
         emT.add(0);
         System.out.println(" = " + emT.toString());
         emT = new CofinFin();
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (s == null)
      System.out.println("Test 8   value not constructed.");
   else{
      try{
         System.out.print("Add Test 8  ");
         s.add(0);
         System.out.println(" = " + s.toString());
         s = new CofinFin(true,T);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }


   if (o == null)
      System.out.println("Test 9   value not constructed.");
   else{
      try{
         System.out.print("Add Test 9  ");
         o.add(0);
         System.out.println(" = " + o.toString());
         o = new CofinFin(false,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (o == null)
      System.out.println("Test 10   value not constructed.");
   else{
      try{
         System.out.print("Add Test 10  ");
         o.add(1);
         System.out.println(" = " + o.toString());
         o = new CofinFin(false,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (w == null)
      System.out.println("Test 11   value not constructed.");
   else{
      try{
         System.out.print("Add Test 11  ");
         w.add(0);
         System.out.println(" = " + w.toString());
         w = new CofinFin(true ,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (w == null)
      System.out.println("Test 12   value not constructed.");
   else{
      try{
         System.out.print("Add Test 12  ");
         w.add(1);
         System.out.println(" = " + w.toString());
         w = new CofinFin(true ,V);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (ae == null)
      System.out.println("Test 13   value not constructed.");
   else{
      try{
         System.out.print("Add Test 13  ");
         ae.add(0);
         System.out.println(" = " + ae.toString());
         ae = new CofinFin(false, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (ae == null)
      System.out.println("Test 14   value not constructed.");
   else{
      try{
         System.out.print("Add Test 14  ");
         ae.add(10);
         System.out.println(" = " + ae.toString());
         ae = new CofinFin(false, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (ae == null)
      System.out.println("Test 15   value not constructed.");
   else{
      try{
         System.out.print("Add Test 15  ");
         ae.add(20);
         System.out.println(" = " + ae.toString());
         ae = new CofinFin(false, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (ae == null)
      System.out.println("Test 16   value not constructed.");
   else{
      try{
         System.out.print("Add Test 16  ");
         ae.add(30);
         System.out.println(" = " + ae.toString());
         ae = new CofinFin(false, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (ae == null)
      System.out.println("Test 17   value not constructed.");
   else{
      try{
         System.out.print("Add Test 17  ");
         ae.add(40);
         System.out.println(" = " + ae.toString());
         ae = new CofinFin(false, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (ae == null)
      System.out.println("Test 18   value not constructed.");
   else{
      try{
         System.out.print("Add Test 18  ");
         ae.add(50);
         System.out.println(" = " + ae.toString());
         ae = new CofinFin(false, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (bj == null)
      System.out.println("Test 19   value not constructed.");
   else{
      try{
         System.out.print("Add Test 19  ");
         bj.add(60);
         System.out.println(" = " + bj.toString());
         bj = new CofinFin(false, N);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (bj == null)
      System.out.println("Test 20   value not constructed.");
   else{
      try{
         System.out.print("Add Test 20  ");
         bj.add(70);
         System.out.println(" = " + bj.toString());
         bj = new CofinFin(false, N);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (bj == null)
      System.out.println("Test 21   value not constructed.");
   else{
      try{
         System.out.print("Add Test 21  ");
         bj.add(80);
         System.out.println(" = " + bj.toString());
         bj = new CofinFin(false, N);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }


   if (af == null)
      System.out.println("Test 22   value not constructed.");
   else{
      try{
         System.out.print("Add Test 22  ");
         af.add(0);
         System.out.println(" = " + af.toString());
         af = new CofinFin(true, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   if (af == null)
      System.out.println("Test 23   value not constructed.");
   else{
      try{
         System.out.print("Add Test 23  ");
         af.add(10);
         System.out.println(" = " + af.toString());
         af = new CofinFin(true, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (af == null)
      System.out.println("Test 24   value not constructed.");
   else{
      try{
         System.out.print("Add Test 24  ");
         af.add(20);
         System.out.println(" = " + af.toString());
         af = new CofinFin(true, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (af == null)
      System.out.println("Test 25   value not constructed.");
   else{
      try{
         System.out.print("Add Test 25  ");
         af.add(30);
         System.out.println(" = " + af.toString());
         af = new CofinFin(true, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (af == null)
      System.out.println("Test 26   value not constructed.");
   else{
      try{
         System.out.print("Add Test 26  ");
         af.add(40);
         System.out.println(" = " + af.toString());
         af = new CofinFin(true, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (af == null)
      System.out.println("Test 27   value not constructed.");
   else{
      try{
         System.out.print("Add Test 27  ");
         af.add(50);
         System.out.println(" = " + af.toString());
         af = new CofinFin(true, M);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (bk == null)
      System.out.println("Test 28   value not constructed.");
   else{
      try{
         System.out.print("Add Test 28  ");
         bk.add(60);
         System.out.println(" = " + bk.toString());
         bk = new CofinFin(true, N);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (bk == null)
      System.out.println("Test 29   value not constructed.");
   else{
      try{
         System.out.print("Add Test 29  ");
         bk.add(70);
         System.out.println(" = " + bk.toString());
         bk = new CofinFin(true, N);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }
   if (bk == null)
      System.out.println("Test 30   value not constructed.");
   else{
      try{
         System.out.print("Add Test 30  ");
         bk.add(80);
         System.out.println(" = " + bk.toString());
         bk = new CofinFin(true, N);
      }
      catch (Exception e){
         System.out.println("threw an exception.");
         e.printStackTrace();
      }
   }

   ////////////////   UNION TESTS


   System.out.println("\nUnion Tests\n");

   // set up arrays to create the sets


   String[] names = {
                "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao",
                "ap", "aq", "ar", "as", "at", "au", "av", "aw", "ax",
                "ay", "az", "ba", "bb", "bc", "bd", "be", "bf", "bg",
                "bh", "bi" };

   boolean[] fParams = {
              false, false, true, true, false, false, false, false, false,
              false, true,  true, true, true,  true,  true,  false, false,
              false, false, false, false, true,true, true,   true, true,
              true, true};


   int[][] 
   sParams = {
      {5}, {10,20,30}, {5}, {10,20,30}, { 1,2,7,8 } , { 1, 5, 10}, {  6, 7 },
      { 3,4 }, { 5, 6, 7 }, { 3,4,5 } , { 1,2,7,8 }, { 1, 5, 10}, {  6, 7 } , 
      { 3,4 }, { 5, 6, 7 }, { 3,4,5 }, { 2, 4 }, { 0,1,5,6}, { 0,2,5,6} ,  
      { 0,1,4,6} ,  { 0,2,4,6},  { 5, 6, 7},  { 0,1}, { 2, 4 },   { 0,1,5,6}, 
      { 0,2,5,6},  { 0,1,4,6},  { 0,2,4,6}, { 5, 6, 7},  { 0,1} };
  

   for (int pIndex = 0; pIndex < names.length; pIndex++){
      try{
         CofinFin temp = new CofinFin(fParams[pIndex],sParams[pIndex]);
         switch (pIndex){

            case 0  :
               ag = temp;
               break;
            case 1  :
               ah = temp;
               break;
            case 2  :
               ai = temp;
               break;
            case 3  :
               aj = temp;
               break;
            case 4  :
               ak = temp;
               break;
            case 5  :
               al = temp;
               break;
            case 6  :
               am = temp;
               break;
            case 7  :
               an = temp;
               break;
            case 8  :
               ao = temp;
               break;
            case 9  :
               ap = temp;
               break;
            case 10 :
               aq = temp;
               break;
            case 11 :
               ar = temp;
               break;
            case 12 :
               as = temp;
               break;
            case 13:
               at = temp;
               break;
            case 14 :
               au = temp;
               break;
            case 15:
               av = temp;
               break;
            case 16:
               aw = temp;
               break;
            case 17 :
               ax = temp;
               break;
            case 18 :
               ay = temp;
               break;
            case 19 :
               az = temp;
               break;
            case 20 :
               ba = temp;
               break;
            case 21 :
               bb = temp;
               break;
            case 22 :
               bc = temp;
               break;
            case 23 :
               bd = temp;
               break;
            case 24 :
               be = temp;
               break;
            case 25 :
               bf = temp;
               break;
            case 26 :
               bg = temp;
               break;
            case 27 :
               bh = temp;
               break;
            case 28 :
               bi = temp;
               break;
            default:
         }
      }
      catch(Exception e){
         System.out.println("Construction of " + names[pIndex] + " threw an exception.");
         e.printStackTrace();
      }
   }
   


   CofinFin[] 
      outerLoop =  { emT, s, ag, ai, ag, ai, aw, bc, ax, bd };
   CofinFin[][] innerLoop = {
      { emT, ag, ah, s, ai, aj },
      {  emT, ag, ah, s, ai, aj  },
      {  ak, al, am, an, ao, ap   },
      {  ak, al, am, an, ao, ap   },
      {  aq, ar, as, at, au, av    },
      {  aq, ar, as, at, au, av     },
      {  ax, ay, az, ba, ap, bb   },
      { ax, ay, az, ba, ap, bb     },
      { bd, be, bf, bg, bh, bi    },
      {  bd, be, bf, bg, bh, bi   }
   };

   for (int oIndex = 0; oIndex < outerLoop.length; oIndex++){
      CofinFin   arg1 = outerLoop[oIndex];
         for (int iIndex = 0; iIndex < innerLoop[oIndex].length; iIndex++){
            CofinFin arg2 = innerLoop[oIndex][iIndex];
            System.out.println("Test " + oIndex + ',' + iIndex);

            if (arg1 != null && arg2 != null){
               try{
                  System.out.println((arg1.union(arg2)).toString());
               }
               catch(Exception e){
                  System.out.println("First call threw an exception.");
                  e.printStackTrace();
               }
               try{
                 System.out.println((arg2.union(arg1)).toString());
               }
               catch(Exception e){
                  System.out.println("Second call threw an exception.");
                  e.printStackTrace();
               }

            }
            else
               if (arg1 == null && arg2 == null)
                   System.out.println("Both of the arguments are null.");
               else if (arg1 == null)
                  System.out.println("arg1 is null");
               else
                  System.out.println("arg2 is null");
         }
   }


   ////////////////////  INTERSECTION TESTS


   System.out.println("\nIntersection Tests\n");


        for (int oIndex = 0; oIndex < outerLoop.length; oIndex++){
              CofinFin   arg1 = outerLoop[oIndex];
           for (int iIndex = 0; iIndex < innerLoop[oIndex].length; iIndex++){
               CofinFin arg2 = innerLoop[oIndex][iIndex];
               System.out.println("Test " + oIndex + ',' + iIndex);

               if (arg1 != null && arg2 != null){
                  try{
                     System.out.println((arg1.intersect(arg2)).toString());
                  }
                  catch(Exception e){
                     System.out.println("First call threw an exception.");
                     e.printStackTrace();
                  }
                  try{
                    System.out.println((arg2.intersect(arg1)).toString());
                  }
                  catch(Exception e){
                     System.out.println("Second call threw an exception.");
                     e.printStackTrace();
                  }

               }
               else
                   if (arg1 == null && arg2 == null)
                       System.out.println("Both of the arguments are null.");
                   else if (arg1 == null)
                      System.out.println("arg1 is null");
                   else
                      System.out.println("arg2 is null");
             }
          }


   ////////////////////  COMPLEMENT TESTS


   System.out.println("\nComplement Tests\n");

   CofinFin[] compTestArgs = {

      emT, s, ag, ai, am, as, ao, au, ak, aq };


   for (int pIndex = 0; pIndex < compTestArgs.length; pIndex++){
      System.out.println("Test " + pIndex);
      
      if (compTestArgs[pIndex] != null){
         try{
            System.out.println((compTestArgs[pIndex].complement()).toString());
         }
         catch(Exception e){
            System.out.println("threw an exception.");
            e.printStackTrace();
         }
      }
      else
         System.out.println("The argument is null");
   }      


   ///////////////// IS IN TESTS

   System.out.println("\nisIn Tests\n");

   try{

      bm = new CofinFin(false, R);

      System.out.println("bm = " + bm.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bm"

      + " threw an exception.");
      e.printStackTrace();
      bm = null;
   }
   try{

      bn = new CofinFin(true,Q);

      System.out.println("bn = " + bn.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bn"

      + " threw an exception.");
      e.printStackTrace();
      bn = null;
   }


   CofinFin[] inArgs = {
      emT, s, emT, s, o, w, 
      bm, bm, bm, bn, bn, bn,
      bm, bm, bm, bn, bn, bn };

   int[] intArgs = { 
       -1, -2, 0,0,0,0,
       0,5,12,7,10,13,
       2,13,9,8,11,12};

   for (int pIndex = 0; pIndex < intArgs.length; pIndex++){
      System.out.println("Test " + pIndex);
      
      if (inArgs[pIndex] != null){
         try{
            System.out.println("" + inArgs[pIndex].isIn(intArgs[pIndex]));
         }
         catch(Exception e){
            System.out.println("threw an exception.");
            e.printStackTrace();
         }
      }
      else
         System.out.println("The argument is null");
   }      


   ///////////////// SUBSET TESTS

   System.out.println("\nSubset Tests\n");


   try{

      bo = new CofinFin(false, 4);

      System.out.println("bo = " + bo.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bo"

      + " threw an exception.");
      e.printStackTrace();
      bo = null;
   }

   try{

      bp = new CofinFin(false, 4);

      System.out.println("bp = " + bp.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bp"

      + " threw an exception.");
      e.printStackTrace();
      bp = null;
   }

   int[] tmp1= { 0,1},  tmp2 = {0,2};

   try{

      bq = new CofinFin(true, tmp1);

      System.out.println("bq = " + bq.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "bq"

      + " threw an exception.");
      e.printStackTrace();
      bq = null;
   }

   try{

      br = new CofinFin(true, tmp2);

      System.out.println("br = " + br.toString());

   }
   catch (Exception e){
      System.out.println("Construction of " +

      "br"

      + " threw an exception.");
      e.printStackTrace();
      br = null;
   }

   aa.complement = false;
   aa.finite.clear();
   aa.finite.add(3);


   CofinFin[] 
      subsetArgs1 = { 
         emT, emT, emT, emT,
         s, s, s, s, s,
         c, c, c, c, c, c, 
         h, h, h, h, h, h, h, 

         an, an, an, an,

         bo, bo, bo, bo, bo,

         bq, bq, bq, bq, bq
          },

      subsetArgs2 = {
         emT, b, s, aw,
         emT, b, s, w, br,
         b, q, an, w, bq, br,
         an, b, q, h,  w, bq, s, 

         b, aw, bp, aa,

         bq, s, emT, an,  c,

         w, s, aa, h, br

          };


   for (int oIndex = 0; oIndex < subsetArgs1.length; oIndex++){
      CofinFin   arg1 = subsetArgs1[oIndex];
      CofinFin arg2 = subsetArgs2[oIndex];
      System.out.println("Test " + oIndex);

        if (arg1 != null && arg2 != null){
           try{
              System.out.println("" + (arg1.isSubsetOf(arg2)));
           }
           catch(Exception e){
              System.out.println("First call threw an exception.");
              e.printStackTrace();
           }
           try{
             System.out.println("" + (arg2.isSubsetOf(arg1)));
           }
           catch(Exception e){
              System.out.println("Second call threw an exception.");
              e.printStackTrace();
           }

        }
        else
           if (arg1 == null && arg2 == null)
              System.out.println("Both of the arguments are null.");
           else if (arg1 == null)
              System.out.println("arg1 is null");
           else
              System.out.println("arg2 is null");
           
   }


   ///////////////// EQUALS  TESTS

   System.out.println("\nEquals Tests\n");

   for (int oIndex = 0; oIndex < subsetArgs1.length; oIndex++){
      CofinFin   arg1 = subsetArgs1[oIndex];
      CofinFin arg2 = subsetArgs2[oIndex];
      System.out.println("Test " + oIndex);

      if (arg1 != null && arg2 != null){
         try{
            System.out.println("" + (arg1.equals(arg2)));
         }
         catch(Exception e){
            System.out.println("First call threw an exception.");
            e.printStackTrace();
         }
         try{
            System.out.println("" + (arg2.equals(arg1)));
         }
         catch(Exception e){
            System.out.println("Second call threw an exception.");
            e.printStackTrace();
         }

      }
      else
         if (arg1 == null && arg2 == null)
            System.out.println("Both of the arguments are null.");
         else if (arg1 == null)
            System.out.println("arg1 is null");
         else
            System.out.println("arg2 is null");
        
   }

   ///////////////   MAXIMUM TESTS

   System.out.println("\nMaximum Tests\n");

   for (ii = 0; ii < 63; ii++){
      System.out.println("Maximum test # " + ii);
      try{
         System.out.println("Max value is " + testCases[ii].maximum());
      }
      catch (Exception e){
         System.out.println("The call threw an exception with message \'" +
         e.getMessage() + '\'');
      }
   }

   ///////////////   MINIMUM TESTS

   System.out.println("\nMinimum Tests\n");

   for (ii = 0; ii < 63; ii++){
      System.out.println("Minimum test # " + ii);
      try{
         System.out.println("Min value is " + testCases[ii].minimum());
      }
      catch (Exception e){
         System.out.println("The call threw an exception with message \'" +
         e.getMessage() + '\'');
      }
   }

   

   

// these were older tests;
// the code won't catch any exceptions; 
// if you pass all the other tests, uncomment this code  see if
// it passes these tests as well.

/***


   // start of older tests
   System.out.println("\n\nStart of older tests.\n\n");
  
   b = new CofinFin(false,1); // { 1 }
   c = new CofinFin();   // empty
   d = c.complement();   // all natural numbers
   e = new CofinFin(true, A); // all natural numbers
   f = new CofinFin(false, A); // empty
   g = new CofinFin(true,B); // { 4, 5, ... }
   h = new CofinFin(false,B); // { 0,1,2,3 }
   j = new CofinFin(true, C); // { 0,1,2,3,6,7,...}
   k = new CofinFin(false,C); // { 4,5 }
   m = new CofinFin(true,D);  // { 0,1,4,6,8,9,10,12,14,15,...}
   n = new CofinFin(false,D); // { 2,3,5,7,11,13 }
   o = new CofinFin(true,E);  // { 1,3,5,7,9,11,13,15,16,17,... }
   p = new CofinFin(false,E); // { 0,2,4,6,8,10,12,14}
   q = new CofinFin(true,F);  // { 0,2,4,6,8,10,12,14,15,16, ... }
   r = new CofinFin(false,F); // { 1,3,5,7,9,11,13}
   s = new CofinFin(false,G);
   t = new CofinFin(false,H);
   u = new CofinFin(false,I);
   v = new CofinFin(false,J);
   w = new CofinFin(false,0);
   x = new CofinFin(false,K);
   y = new CofinFin(true,L);
   z = new CofinFin(true,M);
   aa = new CofinFin(true,N);
   bb = new CofinFin(false, O);
   cc = new CofinFin(false, P);
   dd = new CofinFin(false,Q);
   ee = new  CofinFin(false,R);

   // toString
   System.out.println("toString tests\n" + a + '\n' + b + '\n' + c + '\n' + d + '\n'
   + e + '\n' + f
   + '\n' + g + '\n' + h + '\n' + j + '\n' + k + '\n' + m + '\n' + n
   + '\n' + o + '\n' + p + '\n' + q + '\n' + r);

   // complement
   System.out.println("\n\ncomplement tests\n" + a.complement() + '\n' + b.complement() + '\n' +
   c.complement() + '\n' + d.complement() + '\n' + e.complement() + '\n' + 
   f.complement() + '\n' + g.complement() + '\n' + h.complement() + '\n' +
   j.complement() + '\n' + k.complement() + '\n' + m.complement() + '\n' +
   n.complement() + '\n' + o.complement() + '\n' + p.complement() + '\n' +
   q.complement() + '\n' + r.complement());


   // union
   System.out.println("\n\nunion tests");
   System.out.println("" + "\n\n" +  c.union(a) + '\n' +
   a.union(c) + '\n' +
   c.union(h) + '\n' +
   h.union(c) + '\n' +
   d.union(a) + '\n' +
   a.union(d) + '\n' +
   d.union(b) + '\n' +  
   p.union(r) + '\n' +
   h.union(n) + '\n' +
   n.union(h) + '\n' +
   n.union(o) + '\n' +
   o.union(n) + '\n' +
   m.union(p) + '\n' +
   p.union(m) + '\n' +
   g.union(o) + '\n' +
   o.union(g) + '\n' +
   j.union(m) + '\n' +
   m.union(j) + '\n' +
   e.union(f) + '\n' +
   f.union(e) + '\n' +
   c.union(n) + '\n' +
   n.union(c) + '\n' +
   p.union(q) + '\n' +
   q.union(p) + '\n' +
   s.union(t) + '\n' +
   t.union(s) + '\n' +
   n.union(t) + '\n' +
   t.union(n) + '\n' +
   r.union(u) + '\n' +
   u.union(r) + '\n' +
   u.union(v) + '\n' +
   v.union(u) + '\n' +
   u.union(h) + '\n' +
   h.union(u) + '\n' +
   k.union(s) + '\n' +
   s.union(k) + '\n' +
   t.union(p) + '\n' +
   p.union(t) + '\n' +
   w.union(a) + '\n' +
   a.union(w) + '\n' +
   c.union(a) + '\n' +
   a.union(c) + '\n' +
   x.union(m) + '\n' +
   m.union(x) + '\n' +
   k.union(m) + '\n' +
   m.union(k) + '\n' +
   u.union(o) + '\n' +
   o.union(u) + '\n' +
   cc.union(y) + '\n' +
   y.union(cc) + '\n' +
   bb.union(z) + '\n' +
   z.union(bb) + '\n' +
   dd.union(aa) + '\n' +
   aa.union(dd) + '\n' +
   ee.union(aa) + '\n' +
   aa.union(ee) + '\n' +
   d.union(m) + '\n' +
   m.union(d) + '\n' +
   d.union(e) + '\n' +
   e.union(d) + '\n' +
   q.union(m) + '\n' +
   m.union(q) + '\n' +
   g.union(o) + '\n' +
   o.union(g));




   // intersect
   System.out.println("\n\nintersect tests\n");
   System.out.println("" + c.intersect(a) + '\n' +
   a.intersect(c) + '\n' +
   c.intersect(h) + '\n' +
   h.intersect(c) + '\n' +
   d.intersect(a) + '\n' +
   a.intersect(d) + '\n' +
   d.intersect(b) + '\n' +  
   p.intersect(r) + '\n' +
   h.intersect(n) + '\n' +
   n.intersect(h) + '\n' +
   n.intersect(o) + '\n' +
   o.intersect(n) + '\n' +
   m.intersect(p) + '\n' +
   p.intersect(m) + '\n' +
   g.intersect(o) + '\n' +
   o.intersect(g) + '\n' +
   j.intersect(m) + '\n' +
   m.intersect(j) + '\n' +
   e.intersect(f) + '\n' +
   f.intersect(e) + '\n' +
   c.intersect(n) + '\n' +
   n.intersect(c) + '\n' +
   p.intersect(q) + '\n' +
   q.intersect(p) + '\n' +
   s.intersect(t) + '\n' +
   t.intersect(s) + '\n' +
   n.intersect(t) + '\n' +
   t.intersect(n) + '\n' +
   r.intersect(u) + '\n' +
   u.intersect(r) + '\n' +
   u.intersect(v) + '\n' +
   v.intersect(u) + '\n' +
   u.intersect(h) + '\n' +
   h.intersect(u) + '\n' +
   k.intersect(s) + '\n' +
   s.intersect(k) + '\n' +
   t.intersect(p) + '\n' +
   p.intersect(t) + '\n' +
   w.intersect(a) + '\n' +
   a.intersect(w) + '\n' +
   c.intersect(a) + '\n' +
   a.intersect(c) + '\n' +
   x.intersect(m) + '\n' +
   m.intersect(x) + '\n' +
   k.intersect(m) + '\n' +
   m.intersect(k) + '\n' +
   u.intersect(o) + '\n' +
   o.intersect(u) + '\n' +
   cc.intersect(y) + '\n' +
   y.intersect(cc) + '\n' +
   bb.intersect(z) + '\n' +
   z.intersect(bb) + '\n' +
   dd.intersect(aa) + '\n' +
   aa.intersect(dd) + '\n' +
   ee.intersect(aa) + '\n' +
   aa.intersect(ee) + '\n' +
   d.intersect(m) + '\n' +
   m.intersect(d) + '\n' +
   d.intersect(e) + '\n' +
   e.intersect(d) + '\n' +
   q.intersect(m) + '\n' +
   m.intersect(q) + '\n' +
   g.intersect(o) + '\n' +
   o.intersect(g));






   // equals
   System.out.println("\n\nequals tests\n" +  c.equals(a) + '\n' +
   a.equals(a) + '\n' +
   b.equals(b) + '\n' +
   c.equals(c) + '\n' +
   d.equals(e) + '\n' +
   a.equals(d) + '\n' +
   d.equals(b) + '\n' +  
   p.equals(r) + '\n' +
   h.equals(n) + '\n' +
   n.equals(h) + '\n' +
   n.equals(o) + '\n' +
   o.equals(n) + '\n' +
   m.equals(p) + '\n' +
   p.equals(m) + '\n' +
   g.equals(o) + '\n' +
   o.equals(g) + '\n' +
   j.equals(m) + '\n' +
   m.equals(j) + '\n' +
   e.equals(f) + '\n' +
   f.equals(e));

   // subset
   System.out.println("\n\nsubset tests\n" +  c.isSubsetOf(a) + '\n' +
   a.isSubsetOf(a) + '\n' +
   b.isSubsetOf(b) + '\n' +
   c.isSubsetOf(c) + '\n' +
   d.isSubsetOf(e) + '\n' +
   a.isSubsetOf(d) + '\n' +
   d.isSubsetOf(b) + '\n' +  
   p.isSubsetOf(r) + '\n' +
   h.isSubsetOf(n) + '\n' +
   n.isSubsetOf(h) + '\n' +
   n.isSubsetOf(o) + '\n' +
   o.isSubsetOf(n) + '\n' +
   m.isSubsetOf(p) + '\n' +
   p.isSubsetOf(m) + '\n' +
   g.isSubsetOf(o) + '\n' +
   o.isSubsetOf(g) + '\n' +
   j.isSubsetOf(m) + '\n' +
   m.isSubsetOf(j) + '\n' +
   e.isSubsetOf(f) + '\n' +
   c.isSubsetOf(f) + '\n' +
   c.isSubsetOf(b) + '\n' +
   h.isSubsetOf(c) + '\n' +
   h.isSubsetOf(bb) + '\n' +
   h.isSubsetOf(n) + '\n' +
   k.isSubsetOf(p) + '\n' +
   x.isSubsetOf(r) + '\n' +
   y.isSubsetOf(h) + '\n' +
   z.isSubsetOf(ee) + '\n' +
   y.isSubsetOf(z) + '\n' +
   z.isSubsetOf(y) + '\n' +
   y.isSubsetOf(m) + '\n' +
   m.isSubsetOf(y) + '\n' +
   x.isSubsetOf(m) + '\n' +
   u.isSubsetOf(q) + '\n' +
   h.isSubsetOf(m) + '\n' +
   r.isSubsetOf(o) + '\n' +
   f.isSubsetOf(e));



   // mutators and isIn
   System.out.println("\n\nisIn tests\n" +  a.isIn(0) + '\n' +
   a.isIn(1) + '\n' +
   b.isIn(2) + '\n' +
   c.isIn(3) + '\n' +
   d.isIn(4) + '\n' +
   a.isIn(5) + '\n' +
   d.isIn(6) + '\n' +  
   p.isIn(7) + '\n' +
   h.isIn(8) + '\n' +
   n.isIn(9) + '\n' +
   n.isIn(10) + '\n' +
   o.isIn(11) + '\n' +
   m.isIn(12) + '\n' +
   p.isIn(13) + '\n' +
   g.isIn(14) + '\n' +
   o.isIn(15) + '\n' +
   j.isIn(16) + '\n' +
   m.isIn(17) + '\n' +
   e.isIn(18) + '\n' +
   f.isIn(19));


   // remove
   System.out.println("\n\nremove tests");
   b.remove(1);
   System.out.println("b contains 1 = " + b.isIn(1));
   r.remove(1);
   System.out.println("r contains 1 = " + r.isIn(1));
   n.remove(13);
   System.out.println("n contains 13 = " + n.isIn(13));
   p.remove(8);
   System.out.println("p contains 8 = " + p.isIn(8));
   j.remove(2);
   System.out.println("j contains 2 = " + j.isIn(2));
   m.remove(6);
   System.out.println("m contains 6 = " + m.isIn(6));
   q.remove(14);
   System.out.println("q contains 14 = " + q.isIn(14));
   a.remove(6);
   System.out.println("a contains 6 = " + a.isIn(6));
   d.remove(10);
   System.out.println("d contains 10 = " + d.isIn(10));

   // display results
   System.out.println("" + b + '\n' + r + '\n' + n + '\n' + p + '\n'
   + j + '\n' + m
   + '\n' + q + '\n' + a + '\n' + d);

   // add in the just removed items and repeat the output
   System.out.println("\n\nadd tests");

   b.add(1);
   System.out.println("b contains 1 = " + b.isIn(1));
   r.add(1);
   System.out.println("r contains 1 = " + r.isIn(1));
   n.add(13);
   System.out.println("n contains 13 = " + n.isIn(13));
   p.add(8);
   System.out.println("p contains 8 = " + p.isIn(8));
   j.add(2);
   System.out.println("j contains 2 = " + j.isIn(2));
   m.add(6);
   System.out.println("m contains 6 = " + m.isIn(6));
   q.add(14);
   System.out.println("q contains 14 = " + q.isIn(14));
   a.add(6);
   System.out.println("a contains 6 = " + a.isIn(6));
   d.add(10);
   System.out.println("d contains 10 = " + d.isIn(10));
   k.add(6);
   System.out.println("k contains 6 = " + k.isIn(6));
   h.add(8);
   System.out.println("h contains 8 = " + h.isIn(8));


   // display results
   System.out.println("" + b + '\n' + r + '\n' + n + '\n' + p + '\n'
   + j + '\n' + m
   + '\n' + q + '\n' + a + '\n' + d + '\n' + k + '\n' + h);







   a.add(0);
   a.remove(1);
   a.remove(5);
   b.add(2);
   c.add(3);
   d.remove(6);
   p.add(7);
   p.add(13);
   h.add(8);
   n.add(10);
   n.add(9);
   o.remove(11);
   o.remove(15);
   m.add(12);
   m.add(17);
   g.add(14);
   j.remove(16);
   e.remove(18);
   f.add(19);

   System.out.println("\n\nmore mutator tests\n" +  a.isIn(0) + '\n' +
   a.isIn(1) + '\n' +
   b.isIn(2) + '\n' +
   c.isIn(3) + '\n' +
   d.isIn(4) + '\n' +
   a.isIn(5) + '\n' +
   d.isIn(6) + '\n' +  
   p.isIn(7) + '\n' +
   h.isIn(8) + '\n' +
   n.isIn(9) + '\n' +
   n.isIn(10) + '\n' +
   o.isIn(11) + '\n' +
   m.isIn(12) + '\n' +
   p.isIn(13) + '\n' +
   g.isIn(14) + '\n' +
   o.isIn(15) + '\n' +
   j.isIn(16) + '\n' +
   m.isIn(17) + '\n' +
   e.isIn(18) + '\n' +
   f.isIn(19));

   // complement and isIn
   // should see just the opposite values from the previous bunch, no?
   System.out.println("" + "\n\n" +  a.complement().isIn(0) + '\n' +
   a.complement().isIn(1) + '\n' +
   b.complement().isIn(2) + '\n' +
   c.complement().isIn(3) + '\n' +
   d.complement().isIn(4) + '\n' +
   a.complement().isIn(5) + '\n' +
   d.complement().isIn(6) + '\n' +  
   p.complement().isIn(7) + '\n' +
   h.complement().isIn(8) + '\n' +
   n.complement().isIn(9) + '\n' +
   n.complement().isIn(10) + '\n' +
   o.complement().isIn(11) + '\n' +
   m.complement().isIn(12) + '\n' +
   p.complement().isIn(13) + '\n' +
   g.complement().isIn(14) + '\n' +
   o.complement().isIn(15) + '\n' +
   j.complement().isIn(16) + '\n' +
   m.complement().isIn(17) + '\n' +
   e.complement().isIn(18) + '\n' +
   f.complement().isIn(19));

   // end of old tests

***/


}
}
