import java.util.*;
/**

TEMPLATE FILE FOR THE INDIVIDUAL PART OF THIS PROJECT

Your name:  Cliff Anderson


*********************************************************/


public class CF {

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
   
   public CF() {
      // / constructs the rep of the empty set
      finite = new TreeSet<Integer>();
      
   }

    public CF(boolean comp, int n) {
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
        this.complement = comp;
        if(n < 0)
            this.finite = new TreeSet<Integer>();
        else {
            this.finite = new TreeSet<Integer>();
            this.finite.add(n);
        }
    }


   // YOU WILL NEED TO GET THE CODE FOR THIS CONSTRUCTOR   
   public CF(boolean comp, int[] A) {
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
       this.complement = comp;
       if(A != null) {
           this.finite = new TreeSet<Integer>();
           for (int i = 0; i < A.length; i++)
               if(A[i] >= 0)
                   this.finite.add(A[i]);
       }
       else
           this.finite = new TreeSet<Integer>();

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
   
   

    public CF setDifference(CF other){
    /***

        YOU MUST CODE THIS.
    ***/
/**

  Creates a new CF object and loads it with the
  result of subtracting of the members of other from the
  members of this.



 advice from nick:

 x = this - other
 y = other - this

 result is x union y

**/

    CF result = new CF();

    // for elements in this
    // if not in other, add to result


    if (this.complement && other.complement) {
        result.complement = false;

        // in second   if not in first, add
        for(int i : other.finite) {
            if(! this.finite.contains(i)) {
                result.finite.add(i);
            }
        }
    } else if (other.complement) {
        for (int i : this.finite) {
            if (other.finite.contains(i)) {
                result.finite.add(i);
            }
        }

    } else if(this.complement) {
        result.complement = true;
        result.finite.addAll(this.finite);
        result.finite.addAll(other.finite);

    } else {
        for (int i : this.finite) {
            if (!other.finite.contains(i)) {
                result.finite.add(i);
            }
        }
    }

    return result;
}
private static  // they will be initialized to null
   CF
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
      A = { 0, 1   },
      B = { 0, 1, 2, 3 },
	  C =  { 0,  1, 2 }  , 
      D = { 2, 3, 5, 7 },
      E = { 1, 3, 5, 7 },
      F = { 1, 2, 3, 4, 5 },
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
      T = { 100, 200, 300, 400, 500 },
	U = { 100, 300, 500},
      V = { 0 },
      W = { 100 },
      X = {};

   // YOU WILL NEED TO GET THE CONSTRUCTOR FROM THE TEAM PROJECT
      
   a = new CF(false,A );
   b = new CF(false,B );
   c = new CF(false,C );
   d = new CF(false,D );
   e = new CF(false,E );
   f = new CF(false,F );
   g = new CF(false,G );
   h = new CF(false,H );
   i = new CF(false,I );
   j = new CF(false,J );
   k = new CF(false,K );
   l = new CF(false,L );
   m = new CF(false,M );
   n = new CF(false,N );
   o = new CF(false,O );
   p = new CF(false,P );
   q = new CF(false,Q );
   r = new CF(false,R );
   s = new CF(false,S );
   t = new CF(false,T );
   u = new CF(false,U );
   v = new CF(false,V );
   w = new CF(false,W );
   x = new CF(false,X );
   y = new CF(true,A );
   z = new CF(true,B );
   

   aa = new CF(true,C );
   ab = new CF(true,D );
   ac = new CF(true,E );
   ad = new CF(true,F );
   ae = new CF(true,G );
   af = new CF(true,H );
   ag = new CF(true,I );
   ah = new CF(true,J );
   ai = new CF(true,K );
   aj = new CF(true,L );
   ak = new CF(true,M );
   al = new CF(true,N );
   am = new CF(true,O );
   an = new CF(true,P );
   
   ao = new CF(true,Q );
   ap = new CF(true,R );
   aq = new CF(true,S );
   ar = new CF(true,T );
   as = new CF(true,U );
   at = new CF(true,V );
   au = new CF(true,W );
   av = new CF(true,X );


   CF[] testCases = {
      a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,

      aa, ab, ac, ad, ae, af, ag, ah, ai, aj,ak, al, am, an,
      ao, ap, aq, ar, as, at, au, av};

   System.out.println("\nSet Difference Tests\n");
   
   for (ii = 0; ii < testCases.length; ii++){
       CF minuend = testCases[ii];
       for (jj = 0; jj < testCases.length; jj++){
	   CF subtrahend = testCases[jj];
	   System.out.println("" + minuend + " \\ " +
           subtrahend + " = " + minuend.setDifference(subtrahend));
       }
   }

}
}
