(*

COS 360                  Programming Languages

Prof Briggs              Team ML Problems

Due date: 12/16/17 @ 8 AM

Please code the following functions as specified.  At present they have
stub definitions that force the types to be right but are not correct.

There are some test cases built into the code here and you should not 
add any to this source file.  If you want to do additional testing, you should 
do it in a file other than this one.  You should complete the definitions and submit this
file to Blackboard.

The functions you are asked to code are

1. somePairWorks
2. worksForAll
3. someListWorks
4. isEmpty
5. containsLambda
6. containsMoreThanLambda
7. isInfinite
8. isIn
9. Within one big, mutually recursive function definition: S, L, X, Q, E, W, N, and B
10. evaluateExpression

ALL THE FUNCTIONS YOU NEED TO DEFINE ARE CURRENTLY DEFINED WITH INCORRECT STUBS SO THAT
THIS FILE CAN BE PROCESSED BY ML AS IT IS. YOU WILL  NEED TO REPLACE THE STUB CODE WITH
CORRECT CODE.

*)

(*

1.

Write a curried polymorphic function, somePairWorks, that takes three arguments.
The first is a function f from 'a to boolean, the second is a function g from
'b to boolean, and the third is a list of 'a * 'b pairs, like

[]
[(a1,b1)]
[(a1,b1), (a1,b2), (a3,b3)]
etc.

It should return true when there is at least one pair (x,y) on the list such that
both f x and g y are true.

*)

fun somePairWorks f g L =
   if null L then
      false 
   else
      let
         val (a,b) = hd L
         val x = f a
         val y = g b
         val z = x andalso y
      in
         if z = true then
		true
	 else
            somePairWorks f g (tl L)
      end;

(*  a few test cases *)
somePairWorks (fn n => n > 0) (fn s => s = "")  [];
somePairWorks (fn n => n > 0) (fn s => s = "")  [(1,"cat"), (0, "")];
somePairWorks (fn n => n > 0) (fn s => s = "")  [(1,"")];
somePairWorks (fn n => n > 0) (fn s => s = "")  [(~1,""),(0,"a"), (3,"cat")];
somePairWorks (fn n => n > 0) (fn s => s = "")  [(~1,""),(0,"a"), (3,"cat"),(1,"")];
somePairWorks (fn n => n > 0) (fn s => s = "")  [(1,""),(~1,""),(0,"a"), (3,"cat")];
somePairWorks (fn s => s <> "")(fn n => n = 0) [("", ~1), ("", 0), ("a", 2), ("", 0), ("b", 4), ("art", 6)];
somePairWorks (fn s => s <> "")(fn n => n = 0) [("", 0),("", ~1), ("", 0), ("a", 2), ("", 0), ("b", 4), ("art", ~1)];
somePairWorks (fn s => s <> "")(fn n => n = 0) [("", ~1), ("", 0), ("a", 2), ("", 0), ("b", 4), ("art", 0), ("",0)];


(*

2.  Write a curried polymorphic function, worksForAll, that takes two arguments,
    f, a function from 'a to boolean, and L, an 'a list.

    It should return true when f x is true for EVERY value x in the list, which is
    equivalent to there DOES NOT EXIST a value x on the list for which f x is false.

    Consider what that implies for the empty list.

*)

fun worksForAll f L =
   if null L then
      true
   else
      let
        val a = hd L;
        val x = f a; 
      in
        if x = false then
               false
        else
           worksForAll f (tl L)
      end;  

(* some test cases *)

worksForAll (fn n => n > 0) [];
worksForAll (fn n => n > 0) [0];
worksForAll (fn n => n > 0) [1];
worksForAll (fn n => n > 0) [0,~1];
worksForAll (fn n => n > 0) [1,2,3,4,5,6,7,8,9];
worksForAll (fn n => n > 0) [1,2,3,4,5,6,7,8,9,0];
worksForAll (fn n => n > 0) [0,1,2,3,4,5,6,7,8,9];
worksForAll (fn n => n > 0) [1,2,3,4,5,0,6,7,8,9];
worksForAll (fn s => s <> "")[];
worksForAll (fn s => s <> "")[""];
worksForAll (fn s => s <> "")["1"];
worksForAll (fn s => s <> "")["", "~1"];
worksForAll (fn s => s <> "")["1", "2", "3", "4", "5", "6", "7", "8", "9"];
worksForAll (fn s => s <> "")["1", "2", "3", "4", "5", "6", "7", "8", "9", ""];
worksForAll (fn s => s <> "")["", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
worksForAll (fn s => s <> "")["1", "2", "3", "4", "5", "", "6", "7", "8", "9"];


(*

3.

Define a curried polymorphic function, someListWorks, that takes two arguments,
f, a function from 'a to boolean and L, a list of 'a lists, which in ML is given
by 'a list list.

The function should return true if there is at least one of the lists in L such
that f maps every value on it to true.

Hint: recurse on L with the worksForAll function and f.



*)

fun someListWorks f L =
   if null L then
      false                                        (* Should be false if no lists are in the list L *)
   else
      let
         val firstOnL = hd L                       (* First list from the list L *)
      in
         if worksForAll f ( firstOnL) = true then  (* If the first list maps to all true, then we're done and we return true *)
           true   
         else                                      (* Else we move on to the next list *)
            someListWorks f (tl L)
      end;

(*

The following defines a datatype for regular expressions.  Recall the
recursive definition of regular expressions over an alphabet Sigma

Basis
  1. the empty set is a regular expression
  2. for sigma in Sigma, sigma is a regular expression
Induction/Recursion: if e1 and e2 are regular expressions
  1. (e1 e2), the concatenation, is a regular expression
  2. (e1 + e2), the union, is a regular expression
  3. (e1 * ), the iteration, is a regular expression

This ML definition follows that, using char for Sigma.

*)
datatype RE = emptyset | atom of char | conc of RE * RE | union of RE * RE | star of RE;

(*

The following defines a number of RE instances, including
expressions for the second part of the regular expression exercise.

*)
val a = atom #"a";   (*  a   *)
val b = atom #"b";   (*  b   *)
val space = atom #" ";  (* ' ' *)
val arbWS = star space; (*  ' '*  *)
val nonEmptyWS = conc(space, arbWS);   (*  ' '+  *)
val aStarBStar = conc(star a, star b);  (*  a*b*   *)
val justLambda = star(emptyset);   (* contains just the empty string *) 
val aPlusBPlus = conc(conc(a ,star a), conc(b, star b)); (* a+b+ *)
val aOrB = union(a, b); (* a|b  *)
val allABPairs = conc(aOrB, aOrB);   (* (a|b)(a|b)  *)
val twoEmpties = union(emptyset,emptyset);   (* still empty! (or is it half-empty?) *)
val firstEmpty = union(emptyset,a); 
val secondEmpty = union(b, emptyset);
val leftConcEmpty = conc(twoEmpties, a);
val rightConcEmpty = conc(b, twoEmpties);
val bothConcEmpty = conc(emptyset, emptyset);
val inffirstEmpty = union(emptyset,aStarBStar); 
val infsecondEmpty = union(aPlusBPlus, emptyset);
val infleftConcEmpty = conc(twoEmpties, arbWS);
val infrightConcEmpty = conc(nonEmptyWS, twoEmpties);
val aStar = star a;  (* a*  *)


val Digit = union(atom #"0", union(atom #"1", union(atom #"2", union(atom #"3", 
    union(atom #"4", union(atom #"5", union(atom #"6", union(atom #"7", union(atom #"8", 
    atom #"9")))))))));
val Unsigned = conc(Digit, star(Digit));
val Signed = conc(union(star(emptyset),atom #"-"),Unsigned);
val Mantissa = conc(Signed, conc(atom #".", Unsigned));
val Exponent = conc(atom #"e", Signed);
val hasExponent = conc(union(Mantissa,Signed),Exponent);
val FloatingPoint = union(Mantissa,hasExponent);



(*


4. 

Write a function, isEmpty, that takes a single RE argument and returns true if the
set of strings it denotes is empty(which is different from it being just emptyset,
which is what the stub below codes; you have to recursively determine whether the 
given RE denotes a nonempty set of strings) and false if it is not empty.

As an example of how pattern matching is used with the RE datatype, here is a 
function that constructs the RE that denotes the language that is the reverse of 
the language denoted by the input RE

fun reverseRE (union(x,y)) = union(reverseRE x, reverseRE y) |
    reverseRE (conc(x,y))  = conc(reverseRE y, reverseRE x)  |
    reverseRE (star x)     = star(reverseRE x) |
    reverseRE e = e  (* because the reversed language of the basis cases are just
                          themselves *)
;

It's easy enough to determine when the basis cases are empty, but for the others,
you will need to consider the emptiness of the subexpressions affects the
emptiness of the whole expression.

*)

fun isEmpty (emptyset) = true
|   isEmpty (atom _) = false
|   isEmpty (star _) = false
|   isEmpty (conc(x,y)) = isEmpty x orelse isEmpty y
|   isEmpty (union(x,y)) = isEmpty x andalso isEmpty y

;

(* some tests *)

isEmpty a;
isEmpty b;
isEmpty aStarBStar;
isEmpty justLambda;
isEmpty aPlusBPlus;
isEmpty aOrB;
isEmpty allABPairs;
isEmpty twoEmpties;
isEmpty firstEmpty;
isEmpty secondEmpty;
isEmpty leftConcEmpty;   
isEmpty rightConcEmpty;    
isEmpty bothConcEmpty;    
isEmpty space;        
isEmpty arbWS;        
isEmpty nonEmptyWS;        
isEmpty Digit;
isEmpty Unsigned;
isEmpty Signed;
isEmpty Mantissa;
isEmpty Exponent;
isEmpty hasExponent;
isEmpty FloatingPoint;
isEmpty inffirstEmpty;         
isEmpty infsecondEmpty;         
isEmpty infleftConcEmpty;         
isEmpty infrightConcEmpty;



(*


5.

Write a function, containsLambda, that takes a single RE argument e and
returns true if the language that e denotes contains the empty string and
false if it does not contain the empty string.

RECALL Lambda is NOT a symbol.

Again, the basis cases are easy enough, but for each of the three non
basis cases, what are the conditions for Lambda being in them based
on Lambda being in the subexpressions?

*)

fun containsLambda (emptyset) = false
| containsLambda (atom _) = false
| containsLambda (conc (x,y)) = containsLambda x andalso containsLambda y
| containsLambda (union(x,y)) =
    if x = emptyset then
        containsLambda y
    else if y = emptyset then
        containsLambda x
    else
        containsLambda x andalso containsLambda y
| containsLambda (star _) = true

;

(* some tests *)

containsLambda a;
containsLambda b;
containsLambda aStarBStar;
containsLambda justLambda;
containsLambda aPlusBPlus;
containsLambda aOrB;
containsLambda allABPairs;
containsLambda twoEmpties;
containsLambda firstEmpty;
containsLambda secondEmpty;
containsLambda leftConcEmpty;   
containsLambda rightConcEmpty;    
containsLambda bothConcEmpty;    
containsLambda space;        
containsLambda arbWS;        
containsLambda nonEmptyWS;        
containsLambda Digit;
containsLambda Unsigned;
containsLambda Signed;
containsLambda Mantissa;
containsLambda Exponent;
containsLambda hasExponent;
containsLambda FloatingPoint;
containsLambda inffirstEmpty;         
containsLambda infsecondEmpty;         
containsLambda infleftConcEmpty;         
containsLambda infrightConcEmpty;

(*


6.

Write a function, containsMoreThanLambda, that takes a single RE argument e and
returns true if the language that e denotes contains some nonempty string s
and false if it is either empty or contains only the empty string.


The basis cases are easy, but for each of the three non basis cases,
what are equivalent conditions for the result of the regular operator
to contain a nonempty string?

(L * ) contains a nonempty string s iff ??
(L1 + L2) contains a nonempty string s iff ??
(L1 L2) contains a nonempty string s iff ??

It's a little tricky.

*)

fun containsMoreThanLambda (emptyset) = false
| containsMoreThanLambda (atom _) = true
| containsMoreThanLambda (conc(x,y)) = containsMoreThanLambda x andalso containsMoreThanLambda y
| containsMoreThanLambda (union(x,y)) = containsMoreThanLambda x orelse containsMoreThanLambda y
| containsMoreThanLambda (star(x)) = containsMoreThanLambda x

;

(* some tests *)

containsMoreThanLambda a;
containsMoreThanLambda b;
containsMoreThanLambda aStarBStar;
containsMoreThanLambda justLambda;
containsMoreThanLambda aPlusBPlus;
containsMoreThanLambda aOrB;
containsMoreThanLambda allABPairs;
containsMoreThanLambda twoEmpties;
containsMoreThanLambda firstEmpty;
containsMoreThanLambda secondEmpty;
containsMoreThanLambda leftConcEmpty;   
containsMoreThanLambda rightConcEmpty;    
containsMoreThanLambda bothConcEmpty;    
containsMoreThanLambda space;        
containsMoreThanLambda arbWS;        
containsMoreThanLambda nonEmptyWS;        
containsMoreThanLambda Digit;
containsMoreThanLambda Unsigned;
containsMoreThanLambda Signed;
containsMoreThanLambda Mantissa;
containsMoreThanLambda Exponent;
containsMoreThanLambda hasExponent;
containsMoreThanLambda FloatingPoint;
containsMoreThanLambda inffirstEmpty;         
containsMoreThanLambda infsecondEmpty;         
containsMoreThanLambda infleftConcEmpty;         
containsMoreThanLambda infrightConcEmpty;



(*


7.

Write a function, isInfinite, that takes a single RE argument e and
returns true if the language that e denotes contains infinitely many strings
and false if it contains only finitely many strings.

Same plan goes here: deal with basis cases, and then consider the three
constructors.  You will need to check more than just isInfinite on the
subExpressions.

Again, this gets a little tricky, so you want to consider each case 
very carefully and determine equivalent conditions for

isInfinite L

involving only the subexpressions of L, when L is not a basis case.
Clearly, the basis cases are not infinite.

*)


fun isInfinite emptyset = true |
    isInfinite   _ = false
;

(* some tests *)

isInfinite a;
isInfinite b;
isInfinite aStarBStar;
isInfinite justLambda;
isInfinite aPlusBPlus;
isInfinite aOrB;
isInfinite allABPairs;
isInfinite twoEmpties;
isInfinite firstEmpty;
isInfinite secondEmpty;
isInfinite leftConcEmpty;   
isInfinite rightConcEmpty;    
isInfinite bothConcEmpty;    
isInfinite space;        
isInfinite arbWS;        
isInfinite nonEmptyWS;        
isInfinite Digit;
isInfinite Unsigned;
isInfinite Signed;
isInfinite Mantissa;
isInfinite Exponent;
isInfinite hasExponent;
isInfinite FloatingPoint;
isInfinite inffirstEmpty;         
isInfinite infsecondEmpty;         
isInfinite infleftConcEmpty;         
isInfinite infrightConcEmpty;

(*

The next function definition is for an auxiliary function you will
need below.

It takes a string s.  If s has fewer than 2 characters,
it returns the empty list, else it returns a list of all pairs
(x,y)  where neither x nor y is the empty string and x ^ y = s

For example, if s were "cat", it would return

[("c","at"), ("ca","t")]

If s were "buzz", it would return

[("b","uzz"), ("bu","zz"), ("buz","z")]

*)

fun allTwoSplits (s:string) =
  let
     val n = size s 
  in
     if n < 2 then
        []
     else
        let
           val S = explode s
           (*

               fromTo lo hi = [] if lo > hi
                              [ lo, (lo + 1), ..., hi ]  else

           *)
           val rec fromTo = fn lo => fn hi => if lo > hi then
                                                 []
                                              else
                                                 lo :: (fromTo (lo + 1) hi)
           val firstSizes = fromTo 1 (n - 1)
           (*
               take amt L = []  if null L or amt <= 0
                            L   if amt >= length of L
                            L'  where L' is the first amt items from L, else
           *)
           val rec take = fn amt => fn [] => [] |
                                       x::L => if amt > 0 then
                                                  x::(take (amt-1) L)
                                               else
                                                  []
           val rec allBut = fn amt => fn [] => [] |
                                      x::L =>  if amt > 0 then
                                                  allBut (amt - 1) L
                                               else
                                                  x::L
           val rec oneSplit = fn amt => (implode(take amt S), implode(allBut amt S))
        in
           map oneSplit firstSizes
        end
   end;

allTwoSplits "";
allTwoSplits "a";
allTwoSplits "ab";
allTwoSplits "abcdefg";
       

               

(*

8.

Write a curried function, isIn that takes two arguments.  The first is an RE value e and the
second is a string value s, and the function should return true when s is in the language that
the regular expression e denotes.

This fairly complicated, so I will set up the patterns, fill them in with stubs, and give you some
hints on how to code them.

THE RECURSION IN THIS ONE CAN TAKE A LONG TIME.  Try to deal with simple cases first and avoid 
making a recursive call if it cannot work. 


*)


fun isIn emptyset s = s = "" | (* replace with the obvious correct value;
                                  how many strings s are in the empty set? *)

      isIn (atom c) s   =  true | (* here you need to test that s is one character and that
                                     character is same as c; (hd (explode s)) will give you the
                                     first character of s as a char value, provided s is not ""
                                   *)

      isIn (union (e1,e2)) s = true | (* basic logic: x is in the union of A and B iff ... *)


      isIn (conc (e1,e2)) s = true | 
         (*

            The plot thickens!  By definition, s is in (e1)(e2) iff s can be split in two pieces
            x and y such that xy = s and x is in e1 and y is in e2.  We want to deal the anomalous
            cases where any of x or y or s is the empty string

            s is empty: you will need use the containsLambda function you defined; when is
                        the empty string in conc (e1,e2)?

            x is empty:  check if e1 contains Lambda and s (which equals y when x is "") is in e2

            y is empty: the mirror image of the previous case

            With those cases considered, if none of them put s in conc(e1,e2), then we must split
            s into two nonempty pieces x and y such that x is in e1 and y is in e2.  If length of s
            is < 2, this is impossible, so return false.  Otherwise use allTwoSplits to get a list
            of all the (x,y) pairs of breaks of s, and your somePairWorks function from above, with
            (isIn e1), (isIn e2) and the list of the (x,y) pairs.

         *)
      isIn (eStar as (star e)) s = true 
       (* 

          Like the last, only a little more complicated since the breakdowns can be into more than
          two pieces.

          Clearly, if  s = "" then the answer is true.  Also, if s is in the language of e, then it
          is in  e*, and that should be checked next.

          If neither of those cases shows s in (star e), and the length of s is 1, then s cannot
          be in (star e), because it cannot be broken into pieces, so return false.

          Once those cases have been dealt with and do not resolve the issue, you can use allTwoSplits
          to obtain a list of all the ways to split s into a pair of non-empty strings, (x, y).   For
          such a pair,  

          if (isIn e x) then 
             if (isIn (star e) y) then
                true
             else
                recurse on the list of the pairs

          will be a more efficient approach than I suggested before, as it stops the expansion when
          x in not in e. For a length n > 1 string s, there will be n-1 ways to break it into pairs, 
          but 2^(n-1) - 1 ways to split it into >= 2 nonempty strings whose concatenation is s.  
          There may be some where this alternative is still not efficient, but my solution is running
          much more quickly with this version

          With a judicious choice of the f and g functions to pass in, somePairWorks should be just
          the ticket for this one, too.
       *)
;



isIn a "a";
isIn a "b";
isIn (conc(arbWS,conc(a,conc(arbWS,conc(b,arbWS))))) " a b ";
isIn (conc(arbWS,conc(a,conc(arbWS,conc(b,arbWS))))) "ab";
isIn (conc(arbWS,conc(a,conc(arbWS,conc(b,arbWS))))) "ba";
isIn (conc(justLambda,allABPairs)) "aa";
isIn (conc(justLambda,allABPairs)) "ab";
isIn (conc(justLambda,allABPairs)) "ba";
isIn (conc(justLambda,allABPairs)) "bb";
isIn (conc(allABPairs,justLambda)) "aa";
isIn (conc(allABPairs,justLambda)) "ab";
isIn (conc(allABPairs,justLambda)) "ba";
isIn (conc(allABPairs,justLambda)) "bb";
isIn arbWS "";
isIn nonEmptyWS "";
isIn nonEmptyWS " ";
isIn nonEmptyWS "     ";
isIn aStarBStar "";
isIn aStarBStar "b";
isIn aStarBStar "bbb";
isIn aStarBStar "a";
isIn aStarBStar "aaa";
isIn aStarBStar "bba";
isIn aStarBStar "aaabbb";
isIn justLambda "";
isIn justLambda "b";
isIn justLambda "a";
isIn allABPairs "b";
isIn allABPairs "ab";
isIn allABPairs "ba";
isIn allABPairs "aa";
isIn allABPairs "bb";
isIn allABPairs "a";
isIn allABPairs "aba";
val ShowABreak = "*****************************************";

isIn a "aaaaaaaaaab";      
isIn b "aaaaaaaaaab";      
isIn space "aaaaaaaaaab";      
isIn arbWS "aaaaaaaaaab";      
isIn nonEmptyWS "aaaaaaaaaab";      
isIn aStarBStar "aaaaaaaaaab";      
isIn justLambda "aaaaaaaaaab";      
isIn aPlusBPlus "aaaaaaaaaab";      
isIn aOrB "aaaaaaaaaab";      
isIn allABPairs "aaaaaaaaaab";      
isIn twoEmpties "aaaaaaaaaab";      
isIn firstEmpty "aaaaaaaaaab";      
isIn secondEmpty "aaaaaaaaaab";      
isIn leftConcEmpty "aaaaaaaaaab";      
isIn rightConcEmpty "aaaaaaaaaab";      
isIn bothConcEmpty "aaaaaaaaaab";      
isIn inffirstEmpty "aaaaaaaaaab";      
isIn infsecondEmpty "aaaaaaaaaab";      
isIn infleftConcEmpty "aaaaaaaaaab";      
isIn infrightConcEmpty "aaaaaaaaaab";      
isIn aStar "aaaaaaaaaab";      


val test2 = [
         "-123",
         "1.2",
         "0.0",
         "-0.0",
         "1.-00",
         "-1.-00",
         "1.9",
         "2.8",
         "3.7",
         "4.6",

         "5.5",
         "6.4",
         "7.3",
         "8.2",
         "9.1",
         "-1.9",
         "-2.8",
         "-3.7",
         "-4.6",
         "-5.5",

         "-6.4",
         "-7.3",
         "-8.2",
         "-9.1",
         "1e0",
         "2e1",
         "3e2",
         "4e3",
         "5e4",
         "6e5",

         "7e6",
         "8e7",
         "9e8",
         "0e9",
         "-1e0",
         "-2e1",
         "-3e2",
         "-4e3",
         "-5e4",
         "-6e5",

         "-7e6",
         "-8e7",
         "-9e8",
         "-0e9",
         "-1e-0",
         "-2e-1",
         "-3e-2",
         "-4e-3",
         "-5e-4",
         "-6e-5",

         "-7e-6",
         "-8e-7",
         "-9e-8",
         "-0e-9",
         "1e-0",
         "2e-1",
         "3e-2",
         "4e-3",
         "5e-4",
         "6e-5",

         "7e-6",
         "8e-7",
         "9e-8",
         "0e-9",
         "1.9e01",
         "2.8e02",
         "3.7e03",
         "4.6e04",
         "5.5e05",
         "6.4e06",

         "7.3e07",
         "8.2e08",
         "9.1e09",
         "-1.9e01",
         "-2.8e02",
         "-3.7e03",
         "-4.6e04",
         "-5.5e05",
         "-6.4e06",
         "-7.3e07",

         "-8.2e08",
         "-9.1e09",
         "1.9e-01",
         "2.8e-02",
         "3.7e-03",
         "4.6e-04",
         "5.5e-05",
         "6.4e-06",
         "7.3e-07",
         "8.2e-08",

         "9.1e-09",
         "-1.9e-01",
         "-2.8e-02",
         "-3.7e-03",
         "-4.6e-04",
         "-5.5e-05",
         "-6.4e-06",
         "-7.3e-07",
         "-8.2e-08",
         "-9.1e-09",

         " 1.9e01",
         " 2.8e02",
         " 3.7e03",
         " 4.6e04",
         " 5.5e05",
         " 6.4e06",
         "\n7.3e07",
         " +8.2e08",
         " +9.1e09",
         "-1.9e01 ",

         "-2.8e02 ",
         "-3.7e03 ",
         "-4.6e04 ",
         "-5.5e05 ",
         "-6.4e06 ",
         "-7.3e07 ",
         "-8.2e08 ",
         "-9.1e09 ",
         "1.9 e-01",
         "2.8 e-02",

         "3.7 e-03",
         "4.6 e-04",
         "5.5 e-05",
         "6.4 e-06",
         "7.3e -07",
         "8.2e -08",
         "9.1e -09",
         "-1.9e -01",
         "-2.8e -02",
         "-3.7e -03",

         "-4.6e -04",
         "-5.5e -05",
         "-6.4e -06",
         "-7.3e -07",
         "-8.2e -08",
         "-9.1e -09",
         "0.0",
         "-0.89",
         "12e-200",
         "-0 .314159e1",

         "1e00",
         "-1. 2",
         "10e--12",
         "12",
         "-0 1 2 3 4 5 6 7 8 . 9",
         "123.",
         "7e",
         ".2",
         "1.",
         "-.3",

         " 1.2",
         " -0.89",
         " 12e-200",
         " -0.314159e1",
         " 1e00",
         " --1.2",
         " 10e--12",
         " 12",
         "-89",
         " 7e",

         " .2",
         " -.3",
         "1.2 ",
         "-0.89 ",
         "12e-200 ",
         "-0.314159e1 ",
         "1e00 ",
         "--1.2 ",
         "10e--12 ",
         "12 ",

         "-89 ",
         "7e ",
         ".2 ",
         "-.3 ",
         "1.2 ",
         "-0.89 ",
         "12e-200 ",
         "-0.314159e1 ",
         "1e00 ",
         "--1.2 ",

         "10e--12 ",
         "12 ",
         "-89 ",
         "7e ",
         ".2 ",
         "-.3 ",
         "   +  "
];

(*

these should be right, but if you see any discrepancies, tell me

*)
val test2CorrectResults = [
false,
true,
true,
true,
false,
false,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
true,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
true,
true,
true,
false,
true,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false,
false
];

length test2;
length test2CorrectResults;


fun identifyErrorIndices (n:int) L1 L2 =
   if null L1 orelse null L2 then
      []
   else
      let
        val amatch = hd L1 = hd L2
        val res = identifyErrorIndices (n+1) (tl L1) (tl L2)
      in
         if amatch then
            res
         else
            n::res
      end
;

identifyErrorIndices 1 (map (isIn FloatingPoint) test2) test2CorrectResults;


(*


9. 

This is an exercise in writing a simple recursive descent parser.

The following is a grammar for lists of binary numerals in which such lists can be nested, as in
(note the spaces after the commas, commas must be followed by a space)

(101, (), (0, 1, 10, 11), 110, 111, ((((1001)))))

We are adding a final $ to stand for the end of file/end of token sequence.  The start symbol is S.
The terminal alphabet is

(  )  0  1  ,  $  ' '

where the last pair of single quotes stand for the space character.  Note that each terminal is a
single character, so we will not need a scanner to tokenize a string.

The variable set is

S  the start symbol
N  for binary numeral
B  for bit sequence
L  for list
E   for list item, which might be a binary numeral, or another list
X  for list suffix
Q for a non empty sequence of items separated by 
W for the suffix of a non empty sequence(this is needed to deal with a single item list sequence, as in
    (1001)  versus a multi item list sequencce, as in (1, 10, 11)

The productions with their lookahead sets are given below.  The lookahead sets for each rhs are just
listed but if a variable has more than one rhs, the lists are separated by vertical bars(|).  Within the
list of terminals for the lookahead set, an unquoted space is used as a separator.  A quoted space
is part of the grammar and refers to the single space character that is one of the terminals.
Other ws in the productions is not significant.  A pair of double quotes, "", is used to refer to the empty
string.


S ::= L $
(

L ::= ( X
(

X ::= ) | Q
)  |  (  0 1

Q ::= E W
( 0 1

E ::= L | N
(  |  0 1

W ::= )  | , ' ' Q
) | ,

N ::= 0 |  1 B
0 | 1

B ::=  "" | 1 B | 0 B
, ) | 1 | 0


Your task is to write a recursive descent parser for this grammar that takes an input string input
and returns true if the string parses and false if it does not.  

I will do some of the pieces for you.  


If we construct a directed graph whose nodes are grammar variables, with an edge from x to y iff
there is an occurrence of y on some rhs for x, then it is

                   +-----+
                   |     |
                   V     |
S --> L  --> X --> Q --> W
      A            |           +---+
      |            |           |   |
      |            V           V   |
      +----------- E --> N --> B --+

If variable x has variable y on a rhs, this means the method for x will need
to call the method for y, and a cycle identifies a sequence of calls that is 
ultimately recursive.

If we group nodes in the same strongly connected component and perform the
kind of collapse we referred to in the First and Follow set calculations, we
obtain
                                  +---+
                                  |   |
                                  V   |
S --> { L, X, Q, W, E } --> N --> B --+

and we see that the only functions that actually need to use the
mutually recursive

fun ...
and
...
and
...
;

construct are L, X, Q, W, and E.

Although I do not want you to do this for this exercise, it may be more 
efficient to define the functions in the order

fun COMMA_MATCHER = (matcherGenerator #",");
(* do same for all the terminals *)

fun B clist = ...

fun N clist = ...

fun L clist =  ...
    and
    X clist = ...
...
;

fun S clist = ...

If you were to code it that way, it would produce extra output 
beyond what this current version does, and for that reason I 
do not want you to do it.

An optimizing translator may perform these transformations, but it's
hard to know.


*)

        

(* define an exception for failing to parse  *)

exception parserFailure;

(* 
   define a matcher generator; it takes a single character c, and 
   returns a function that takes a list of characters, and if the
   list begins with the input c, returns the rest of the list, else 
   throws the parserFailure exception
*)

fun matcherGenerator (c:char) =
   fn [] => raise parserFailure |
      x::L => if x = c then
                    L
                 else
                    raise parserFailure
;

(*

   define a collection of mutually recursive functions, one for
   each variable of the grammar.  Each function takes a list of
   characters as input.  If a prefix of the list of characters
   matches a string that the variable would generate, it returns
   the list with the longest such prefix removed.  For example,  N derives

   1001

   so if the function for N were given

   [ #"1", #"0", #"0", #"1", #"a", #"b", #"c", #"d" ]

   is should return

   [  #"a", #"b", #"c", #"d" ]

   Although N also derives 10, it should not return

   [ #"0", #"1", #"a", #"b", #"c", #"d" ]

   because 10 is not the longest prefix that is in the language that N
   generates.


   On the other hand, if no prefix of the list generates
   a string that would be in the language the variable
   generates, the function should raise parserFailure.

   It is really quite simple to do this.  Recall the technique for
   defining mutually recursive functions that is given in mlExmpls3.ml
   and illustrated with takeOdds and takeEvens.  You use that
   here for the functions of the grammar variables.

   AT THIS TIME, THEY ALL JUST RETURN THE INPUT LIST.

   THIS IS THE PART THAT YOU MUST CODE TO ACCOMPLISH #9.

   There is a discussion of how you should proceed below.

*)

fun
   S clist = clist
and
   L clist = clist
and
   X clist = clist
and
   Q clist = clist
and
   E clist = clist
and
   W clist = clist
and
   N clist = clist
and
   B clist = clist
;


(*

HOW YOU SHOULD PROCEED.

It's really not hard at all.

Suppose you have grammar variable variable Y with productions

Y ::= rhs1 | rhs2 | ... | rhsn

where rhsM has lookahead set TM

The function for Y proceeds

Y clist = 

if null clist then
   raise parserFailure
else
   let
      val lookahead = hd clist
   in
      if lookahead is one of the values in T1 then
         call function for rhs1 on clist
      else if lookahead is one of the ones in T2 then
         call function for rhs2 on clist
      ...
      else if lookahead is one of the ones in Tn
         call function for rhsn on clist
      else (* the lookahead is not right for any of the rhs's *)
         raise parserFailure
   end

What is the function for rhsM?  Suppose rhsM is 

Z1 Z2 ... Zk

In an imperative language we would do calls

Z1();
Z2();
...
Zk();

where Zj() is the function for variable Zj, if Zj is a variable,
or just match operation for Zj, if Zj is a terminal.  To achieve
that ordering in a functional language, however, we need to
COMPOSE the functions in reverse order and apply them
to the input clist

(Zk o ... o Z2 o Z1) clist

which amounts to the expression

Zk( ... (Z2 (Z1 clist))..)

If all return w/o raising the exception, then they will consume the 
appropriate prefix of clist and return what is left.  Since none of them
handle the exception, if one raises the exception, it will propagate
through the others.

When Zi is a variable, then the function is just the one being defined
in this mutually recursive collection.  When Zi is a terminal, then the 
function for Zi is

(matcherGenerator Zi)

Note, if the Java character literal is 'c', then the ML analog is #"c".

Now, you may ask yourself, "Variable B generates the empty string, and
the empty string is a prefix of any string, so shouldn't the function for
B always just return clist itself?".  A fair question.

First, we do want the longest prefix that matches, so 
although the empty string does match, we should try to match 
with the nonempty alternatives if we can.  Second, although the empty
string is always a prefix that matches, in the context of the parse, 
if the lookahead is not in the the lookahead set for the "" rhs of B,
then the parse matching the empty string will fail, and we prefer to 
detect that sooner rather than later. So you should always test that 
the lookahead character is in the lookahead set for the rhs for each case.  

Note if the rhs is the empty string, "", then the function for that rhs
does not consume any of the characters of clist.

With this approach, you read the function definitions directly off the
grammar.  It would not be terribly difficult the automatically generate
the whole parser from the grammar, and indeed such tools exist.

Note that #' ' is the ML literal for the space character.

*)



(*

This final definition will then complete the task once the grammar
variable functions are defined.

*)


fun parse s =
(*

attempts to parse s by calling the start symbol on the list of
characters in s.  If the call returns [], s parsed.  If it returns a nonempty
list, or throws and exception, s failed to parse.

*)
   null (S (explode s)) handle parserFailure  => false;


(*

you can test it on the following


  should fail for these

*)

val e1 = "";
val e2 = "$";
val e3 = "1";
val e4 = "0";
val e5 = "2";
val e6 = ",";
val e7 = "(";
val e8 = ")";
val e9 = " ";
val e10 = "a";
val e11 = "()";
val e12 = "(1)";
val e13 = "(0, 1)";
val e14 = "((), ";
val e15 = "((), 0";
val e16 = "((), 1";
val e17 = "(0, ";
val e18 = "(0, 0";
val e19 = "(0, 1";
val e20 = "(1, ";
val e21 = "(1, 0";
val e22 = "(1, 1";
val e23 = "(00)$";
val e24 = "(0,1)$";
val e25 = "()$ ";
val e26 = "((),())$";
val e27 = "((),0)$";
val e28 = "((),1)$";
val e29 = "(0,())$";
val e30 = "(0,0)$";
val e31 = "(0,1)$";
val e32 = "(1,())$";
val e33 = "(1,0)$";
val e34 = "(((1)),1)$";
val e35 = "((1),(0))$";
val e36 = "((),(1))$";
val e37 = "((0),())$";
val e38 = "((),())$";
val e39 = "(1,())$";
val e40 = "((),(1))$";
val e41 = "($)$";
val e42 = "(,)$";
val e43 = "(0($";
val e44 = "( )$";
val e45 = "(1 11 111)$";
val e46 = "(1 11 111 )$";
val e47 = "(1, 10, 11, )$";
val e48 = "(1, 10, 11,)$";
val e49 = "((((())))$";
val e50 = "(((((((()))))))))$";

val errTests = [
e1,
e2,
e3,
e4,
e5,
e6,
e7,
e8,
e9,
e10,
e11,
e12,
e13,
e14,
e15,
e16,
e17,
e18,
e19,
e20,
e21,
e22,
e23,
e24,
e25,
e26,
e27,
e28,
e29,
e30,
e31,
e32,
e33,
e34,
e35,
e36,
e37,
e38,
e39,
e40,
e41,
e42,
e43,
e44, 
e45,
e46,
e47,
e48,
e49,
e50
];

(*

this expression will produce a list of the numbers of tests components of the error test
vector the parser made a mistake on; of course, you want it to return the empty list;

*)

let
   val resultList = map parse errTests 
   val  rec indicesOfTrue  = fn (n:int) =>
        (fn          [] => [] |
            (true::L) => n :: (indicesOfTrue (n + 1) L) |
            (false::L) => indicesOfTrue (n+1) L
        )
in
   indicesOfTrue 1 resultList
end;
  
(*

the following should parse

*)
val s1 = "()$";
val s2 = "(0)$";
val s3 = "(1)$";
val s4 = "(11011010)$";
val s5 = "(11)$";
val s6 = "(10)$";
val s7 = "(0, 1)$";
val s8 = "(1, 0)$";
val s9 = "(0, 1, 10, 11, 100, 101, 110, 111, 1000)$";
val s10 = "(1, 1, 1)$";
val s11 = "((), ())$";
val s12 = "((), 0)$";
val s13 = "(1, ())$";
val s14 = "((1), (()))$";
val s15 = "((11), (0))$";
val s16 = "(((1010)), 1)$";
val s17 = "(((1010)), ((0)))$";
val s18 = "(1001, ((0)))$";
val s19 = "(1, 11, 111)$";
val s20 = "(1, 11, (1100))$";
val s21 = "(1, 11, ((111)))$";
val s22 = "(1, (11), 111)$";
val s23 = "(1, (11), (111))$";
val s24 = "(1, (11), ((111)))$";
val s25 = "(1, ((11)), 111)$";
val s26 = "(1, ((11)), (111))$";
val s27 = "(1, ((11)), ((111)))$";
val s28 = "((1), 11, 111)$";
val s29 = "((1), 11, (1100))$";
val s30 = "((1), 11, ((111)))$";
val s31 = "((1), (11), 111)$";
val s32 = "((1), (11), (111))$";
val s33 = "((1), (11), ((111)))$";
val s34 = "((1), ((11)), 111)$";
val s35 = "((1), ((11)), (111))$";
val s36 = "((1), ((11)), ((111)))$";
val s37 = "(((1)), 11, 111)$";
val s38 = "(((1)), 11, (1100))$";
val s39 = "(((1)), 11, ((111)))$";
val s40 = "(((1)), (11), 111)$";
val s41 = "(((1)), (11), (111))$";
val s42 = "(((1)), (11), ((111)))$";
val s43 = "(((1)), ((11)), 111)$";
val s44 = "(((1)), ((11)), (111))$";
val s45 = "(((1)), ((11)), ((111)))$";
val s46 = "((), (0), (1, 10), (0, (), 1), 11, (((((100))))))$";
val s47 = "((1, ()), (((10)), 0), (((1, 10))), ((((0, (), 1)))), 11, (((((100))))))$";
val s48 = "((((0))), ((1, (10, 11, 100)), ((1, 10, 110), 111), (1, (10, 110), 111), ((1, 10, 110, 111)), ((1, 10), (110, 111))))$";
(*                           12   3                 32 45               5       4  6   7           7        6 89                        98 0a      a  b             b01 *)
val s49 = "((((0))), ((1, (10, 11, 100)), ((1, 10, 110), 111), (1, (10, 110), 111), ((1, 10, 110, 111))), ((1, 10), (110, 111)))$";
val s50 = "((((0))), (1, (10, 11, 100)), (((1, 10, 110), 111), (1, (10, 110), 111), ((1, 10, 110, 111))), ((1, 10), (110, 111)))$";

val correctTests = [
s1,
s2,
s3,
s4,
s5,
s6,
s7,
s8,
s9,
s10,
s11,
s12,
s13,
s14,
s15,
s16,
s17,
s18,
s19,
s20,
s21,
s22,
s23,
s24,
s25,
s26,
s27,
s28,
s29,
s30,
s31,
s32,
s33,
s34,
s35,
s36,
s37,
s38,
s39,
s40,
s41,
s42,
s43,
s44, 
s45,
s46,
s47,
s48,
s49,
s50
];

(*

this expression will produce a list of the numbers of tests components of the correct test
vector the parser made a mistake on; of course, you want it to return the empty list;

*)

let
   val resultList = map parse correctTests 
   val  rec indicesOfTrue  = fn (n:int) =>
        (fn          [] => [] |
            (false::L) => n :: (indicesOfTrue (n + 1) L) |
            (true::L) => indicesOfTrue (n+1) L
        )
in
   indicesOfTrue 1 resultList
end;
  
(*

The following definitions are to accommodate integer expressions involving
constants, variables, +, -, *, div, and mod

First, an enumeration type for the five binary operators

*)
datatype BinaryOps = ADD | SUBTRACT | MULT | DIV | MOD;

(*

Next, the type proper.  Because we only have a single unary operator, 
negation(~), the Negation tag itself is enough to tell us what operation to use.

*)

datatype Expression = Variable of string | Constant of int |
                      BinaryExp of BinaryOps * Expression * Expression |
                      Negation of Expression;

exception UndefinedVariable of string;
exception DivisionByZero;

(*

Define a function

evaluateExpression

with signature

(string * int) list -> Expression -> int

whose first parameter is a list of (s, v) pairs that should be interpreted
as values v of a variable s.  In a lookup of the value of s, use the v of the
first pair on the list that has s as its first member.

The function should recurse on the structure of the Expression input and 
raise the exception DivisionByZero if the second input to a DIV or MOD expression
evaluates to 0, and raise the (UndefinedVariable s) expression if during the
course of evaluation it looks up the value of variable s and does not find
a pair in the (string * int) list with first member s.

At this time I have not worked up test cases for this, but I will.  I just wanted to
get it out there.

*)

(*

   I'll code the look up operation put in some code to test the
   companion function, evaluate expression.  This will return the integer second
   component of the first pair in the list that matches the string at the first component,
   or raise the exception if it does not find a pair whose first component matches the string.

*)
fun lookup nil (s:string) = raise UndefinedVariable(s) |
    lookup ((name, value) :: L) s = if name = s then
                                     value + 0 (* to force that it be int *)
                                  else
                                     lookup L s
;

(*

This is just stub code that you need to fix.

Note, in my code, whenever the binary operator was DIV or MOD, I used let-in-end
to first evaluate the right subexpression to see if it was 0.  If it was, I raised
the exception w/o evaluating the left.  If you evaluate the left first, you might
throw some other exception from mine, which would make your results different from
mine. 

*)
fun evaluateExpression L (Constant n) = raise DivisionByZero |
    evaluateExpression L  (BinaryExp (ADD, left, right)) = lookup L "cat" |
    evaluateExpression L _ = raise DivisionByZero
;
                    
                       
(*

a function to call evaluateExpression and handle any exceptions.
To have the codomain be a single type, it converts the int values to string.

*)

fun runEvaluateExpression L E =
   let
      val s = Int.toString (evaluateExpression L E) handle
                 UndefinedVariable t => "Eval Error: the variable " ^ t ^ " is undefined." |
                 DivisionByZero => "Eval Error: division by zero."
   in
      s
   end;


val e9 = Variable "n1";
val e10 = Variable "n2";
val e11 = Variable "n3";
val e12 = Variable "n4";
val e13 = Variable "n5";
val e14 = Variable "n6";
val e15 = Variable "n7";
val e16 = Variable "n8";
val e17 = Variable "n9";
val e18 = Variable "n10";
val e19 = Variable "n11";
val e20 = Variable "n12";


val sameAsConst = [("n1",~1), ("n2",0), ("n3",1), ("n4",~2), ("n5",~3), 
                  ("n6",2), ("n7",3), ("n8",10), 
                  ("n9",43), ("n10",~43), ("n11", 5), ("n12",~5)];

(*  some expressions with constant leaves *)
val e1 = Constant ~1;
val e2 = Constant 0
val e3 = Constant 1;
val e4 = Constant ~2
val e5 = Constant ~3
val e6 = Constant 2
val e7 = Constant 3
val e8 = Constant 10;

val e21 = BinaryExp (ADD,e1,e2);
val e22 = BinaryExp (ADD,e1,e5);
val e23 = BinaryExp (ADD,e1,e8);
val e24 = BinaryExp (ADD,e1,e3);
val e25 = BinaryExp (ADD,e8,e8);
val e26 = BinaryExp (SUBTRACT,e1,e2);
val e27 = BinaryExp (SUBTRACT,e2,e1);
val e28 = BinaryExp (SUBTRACT,e8,e8);
val e29 = BinaryExp (SUBTRACT,e8,e7);
val e30 = BinaryExp (SUBTRACT,e7,e8);
val e31 = BinaryExp (MULT,e1,e2);
val e32 = BinaryExp (MULT,e2,e3);
val e33 = BinaryExp (MULT,e1,e8);
val e34 = BinaryExp (MULT,e8,e3);
val e35 = BinaryExp (MULT,e8,e5);
val e36 = BinaryExp (MULT,e5,e7);
val e37 = BinaryExp (MULT,e4,e5);

val e38 = BinaryExp (DIV,e1,e2);
val e39 = BinaryExp (DIV,e2,e3);
val e40 = BinaryExp (DIV,e1,e8);
val e41 = BinaryExp (DIV,e8,e3);
val e42 = BinaryExp (DIV,e8,e5);
val e43 = BinaryExp (DIV,e5,e7);
val e44 = BinaryExp (DIV,e4,e5);
val e45 = BinaryExp (DIV,e1,e2);
val e46 = BinaryExp (DIV,(Constant 43),(Constant ~5));
val e47 = BinaryExp (DIV,(Constant 43),(Constant 5));
val e48 = BinaryExp (DIV,(Constant ~43),(Constant ~5));
val e49 = BinaryExp (DIV,(Constant ~43),(Constant 5));
val e50 = BinaryExp (MOD,e1,e2);
val e51 = BinaryExp (MOD,e2,e3);
val e52 = BinaryExp (MOD,e1,e8);
val e53 = BinaryExp (MOD,e8,e3);
val e54 = BinaryExp (MOD,e8,e5);
val e55 = BinaryExp (MOD,e5,e7);
val e56 = BinaryExp (MOD,e4,e5);
val e57 = BinaryExp (MOD,e1,e2);
val e58 = BinaryExp (MOD,(Constant 43),(Constant ~5));
val e59 = BinaryExp (MOD,(Constant 43),(Constant 5));
val e60 = BinaryExp (MOD,(Constant ~43),(Constant ~5));
val e61 = BinaryExp (MOD,(Constant ~43),(Constant 5));
val e62 = Negation (BinaryExp (ADD,e1,e2));
val e63 = Negation (BinaryExp (ADD,e1,e5));
val e64 = Negation (BinaryExp (ADD,e1,e8));
val e65 = Negation (BinaryExp (ADD,e1,e3));
val e66 = Negation (BinaryExp (ADD,e8,e8));
val e67 = Negation (BinaryExp (SUBTRACT,e1,e2));
val e68 = Negation (BinaryExp (SUBTRACT,e2,e1));
val e69 = Negation (BinaryExp (SUBTRACT,e8,e8));
val e70 = Negation (BinaryExp (SUBTRACT,e8,e7));
val e71 = Negation (BinaryExp (SUBTRACT,e7,e8));
val e72 = Negation (BinaryExp (MULT,e1,e2));
val e73 = Negation (BinaryExp (MULT,e2,e3));
val e74 = Negation (BinaryExp (MULT,e1,e8));
val e75 = Negation (BinaryExp (MULT,e8,e3));
val e76 = Negation (BinaryExp (MULT,e8,e5));
val e77 = Negation (BinaryExp (MULT,e5,e7));
val e78 = Negation (BinaryExp (MULT,e4,e5));
val e79 = Negation (BinaryExp (DIV,e1,e2));
val e80 = Negation (BinaryExp (DIV,e2,e3));
val e81 = Negation (BinaryExp (DIV,e1,e8));
val e82 = Negation (BinaryExp (DIV,e8,e3));
val e83 = Negation (BinaryExp (DIV,e8,e5));
val e84 = Negation (BinaryExp (DIV,e5,e7));
val e85 = Negation (BinaryExp (DIV,e4,e5));
val e86 = Negation (BinaryExp (DIV,e1,e2));
val e87 = Negation (BinaryExp (DIV,(Constant 43),(Constant ~5)));
val e88 = Negation (BinaryExp (DIV,(Constant 43),(Constant 5)));
val e89 = Negation (BinaryExp (DIV,(Constant ~43),(Constant ~5)));
val e90 = Negation (BinaryExp (DIV,(Constant ~43),(Constant 5)));
val e91 = Negation (BinaryExp (MOD,e1,e2));
val e92 = Negation (BinaryExp (MOD,e2,e3));
val e93 = Negation (BinaryExp (MOD,e1,e8));
val e94 = Negation (BinaryExp (MOD,e8,e3));
val e95 = Negation (BinaryExp (MOD,e8,e5));
val e96 = Negation (BinaryExp (MOD,e5,e7));
val e97 = Negation (BinaryExp (MOD,e4,e5));
val e98 = Negation (BinaryExp (MOD,e1,e2));
val e99 = Negation (BinaryExp (MOD,(Constant 43),(Constant ~5)));
val e100 = Negation (BinaryExp (MOD,(Constant 43),(Constant 5)));
val e101 = Negation (BinaryExp (MOD,(Constant ~43),(Constant ~5)));
val e102 = Negation (BinaryExp (MOD,(Constant ~43),(Constant 5)));

(*  use the variables *)

val e103 = BinaryExp (ADD,e1,e2);
val e104 = BinaryExp (ADD,e1,e5);
val e105 = BinaryExp (ADD,e1,e8);
val e106 = BinaryExp (ADD,e1,e3);
val e107 = BinaryExp (ADD,e8,e8);
val e108 = BinaryExp (SUBTRACT,e1,e2);
val e109 = BinaryExp (SUBTRACT,e2,e1);
val e110 = BinaryExp (SUBTRACT,e8,e8);
val e111 = BinaryExp (SUBTRACT,e8,e7);
val e112 = BinaryExp (SUBTRACT,e7,e8);
val e113 = BinaryExp (MULT,e1,e2);
val e114 = BinaryExp (MULT,e2,e3);
val e115 = BinaryExp (MULT,e1,e8);
val e116 = BinaryExp (MULT,e8,e3);
val e117 = BinaryExp (MULT,e8,e5);
val e118 = BinaryExp (MULT,e5,e7);
val e119 = BinaryExp (MULT,e4,e5);

val e120 = BinaryExp (DIV,e1,e2);
val e121 = BinaryExp (DIV,e2,e3);
val e122 = BinaryExp (DIV,e1,e8);
val e123 = BinaryExp (DIV,e8,e3);
val e124 = BinaryExp (DIV,e8,e5);
val e125 = BinaryExp (DIV,e5,e7);
val e126 = BinaryExp (DIV,e4,e5);
val e127 = BinaryExp (DIV,e1,e2);
val e128 = BinaryExp (DIV,(e17),(e20));
val e129 = BinaryExp (DIV,(e17),(e19));
val e130 = BinaryExp (DIV,(e18),(e20));
val e131 = BinaryExp (DIV,(e18),(e19));

val e132 = BinaryExp (MOD,e1,e2);
val e133 = BinaryExp (MOD,e2,e3);
val e134 = BinaryExp (MOD,e1,e8);
val e135 = BinaryExp (MOD,e8,e3);
val e136 = BinaryExp (MOD,e8,e5);
val e137 = BinaryExp (MOD,e5,e7);
val e138 = BinaryExp (MOD,e4,e5);
val e139 = BinaryExp (MOD,e1,e2);
val e140 = BinaryExp (MOD,(e17),(e20));
val e141 = BinaryExp (MOD,(e17),(e19));
val e142 = BinaryExp (MOD,(e18),(e20));
val e143 = BinaryExp (MOD,(e18),(e19));

val e144 = Negation (BinaryExp (ADD,e1,e2));
val e145 = Negation (BinaryExp (ADD,e1,e5));
val e146 = Negation (BinaryExp (ADD,e1,e8));
val e147 = Negation (BinaryExp (ADD,e1,e3));
val e148 = Negation (BinaryExp (ADD,e8,e8));
val e149 = Negation (BinaryExp (SUBTRACT,e1,e2));
val e150 = Negation (BinaryExp (SUBTRACT,e2,e1));
val e151 = Negation (BinaryExp (SUBTRACT,e8,e8));
val e152 = Negation (BinaryExp (SUBTRACT,e8,e7));
val e153 = Negation (BinaryExp (SUBTRACT,e7,e8));
val e154 = Negation (BinaryExp (MULT,e1,e2));
val e155 = Negation (BinaryExp (MULT,e2,e3));
val e156 = Negation (BinaryExp (MULT,e1,e8));
val e157 = Negation (BinaryExp (MULT,e8,e3));
val e158 = Negation (BinaryExp (MULT,e8,e5));
val e159 = Negation (BinaryExp (MULT,e5,e7));
val e160 = Negation (BinaryExp (MULT,e4,e5));

val e161 = Negation (BinaryExp (DIV,e1,e2));
val e162 = Negation (BinaryExp (DIV,e2,e3));
val e163 = Negation (BinaryExp (DIV,e1,e8));
val e164 = Negation (BinaryExp (DIV,e8,e3));
val e165 = Negation (BinaryExp (DIV,e8,e5));
val e166 = Negation (BinaryExp (DIV,e5,e7));
val e167 = Negation (BinaryExp (DIV,e4,e5));
val e168 = Negation (BinaryExp (DIV,e1,e2));
val e169 = Negation (BinaryExp (DIV,(e17),(e20)));
val e170 = Negation (BinaryExp (DIV,(e17),(e19)));
val e171 = Negation (BinaryExp (DIV,(e18),(e20)));
val e172 = Negation (BinaryExp (DIV,(e18),(e19)));

val e173 = Negation (BinaryExp (MOD,e1,e2));
val e174 = Negation (BinaryExp (MOD,e2,e3));
val e175 = Negation (BinaryExp (MOD,e1,e8));
val e176 = Negation (BinaryExp (MOD,e8,e3));
val e177 = Negation (BinaryExp (MOD,e8,e5));
val e178 = Negation (BinaryExp (MOD,e5,e7));
val e179 = Negation (BinaryExp (MOD,e4,e5));
val e180 = Negation (BinaryExp (MOD,e1,e2));
val e181 = Negation (BinaryExp (MOD,(e17),(e20)));
val e182 = Negation (BinaryExp (MOD,(e17),(e19)));
val e183 = Negation (BinaryExp (MOD,(e18),(e20)));
val e183 = Negation (BinaryExp (MOD,(e18),(e19)));


runEvaluateExpression [] e1;
runEvaluateExpression [] e2;
runEvaluateExpression [] e3;
runEvaluateExpression [] e4;
runEvaluateExpression [] e5;
runEvaluateExpression [] e6;
runEvaluateExpression [] e7;
runEvaluateExpression [] e8;
runEvaluateExpression [] e9;
runEvaluateExpression [] e10;
runEvaluateExpression [] e11;
runEvaluateExpression [] e12;
runEvaluateExpression [] e13;
runEvaluateExpression [] e14;
runEvaluateExpression [] e15;
runEvaluateExpression [] e16;
runEvaluateExpression [] e17;
runEvaluateExpression [] e18;
runEvaluateExpression [] e19;
runEvaluateExpression [] e20;
runEvaluateExpression [] e21;
runEvaluateExpression [] e22;
runEvaluateExpression [] e23;
runEvaluateExpression [] e24;
runEvaluateExpression [] e25;
runEvaluateExpression [] e26;
runEvaluateExpression [] e27;
runEvaluateExpression [] e28;
runEvaluateExpression [] e29;
runEvaluateExpression [] e30;
runEvaluateExpression [] e31;
runEvaluateExpression [] e32;
runEvaluateExpression [] e33;
runEvaluateExpression [] e34;
runEvaluateExpression [] e35;
runEvaluateExpression [] e36;
runEvaluateExpression [] e37;
runEvaluateExpression [] e38;
runEvaluateExpression [] e39;
runEvaluateExpression [] e40;
runEvaluateExpression [] e41;
runEvaluateExpression [] e42;
runEvaluateExpression [] e43;
runEvaluateExpression [] e44;
runEvaluateExpression [] e45;
runEvaluateExpression [] e46;
runEvaluateExpression [] e47;
runEvaluateExpression [] e48;
runEvaluateExpression [] e49;
runEvaluateExpression [] e50;
runEvaluateExpression [] e51;
runEvaluateExpression [] e52;
runEvaluateExpression [] e53;
runEvaluateExpression [] e54;
runEvaluateExpression [] e55;
runEvaluateExpression [] e56;
runEvaluateExpression [] e57;
runEvaluateExpression [] e58;
runEvaluateExpression [] e59;
runEvaluateExpression [] e60;
runEvaluateExpression [] e61;
runEvaluateExpression [] e62;
runEvaluateExpression [] e63;
runEvaluateExpression [] e64;
runEvaluateExpression [] e65;
runEvaluateExpression [] e66;
runEvaluateExpression [] e67;
runEvaluateExpression [] e68;
runEvaluateExpression [] e69;
runEvaluateExpression [] e70;
runEvaluateExpression [] e71;
runEvaluateExpression [] e72;
runEvaluateExpression [] e73;
runEvaluateExpression [] e74;
runEvaluateExpression [] e75;
runEvaluateExpression [] e76;
runEvaluateExpression [] e77;
runEvaluateExpression [] e78;
runEvaluateExpression [] e79;
runEvaluateExpression [] e80;
runEvaluateExpression [] e81;
runEvaluateExpression [] e82;
runEvaluateExpression [] e83;
runEvaluateExpression [] e84;
runEvaluateExpression [] e85;
runEvaluateExpression [] e86;
runEvaluateExpression [] e87;
runEvaluateExpression [] e88;
runEvaluateExpression [] e89;
runEvaluateExpression [] e90;
runEvaluateExpression [] e91;
runEvaluateExpression [] e92;
runEvaluateExpression [] e93;
runEvaluateExpression [] e94;
runEvaluateExpression [] e95;
runEvaluateExpression [] e96;
runEvaluateExpression [] e97;
runEvaluateExpression [] e98;
runEvaluateExpression [] e99;
runEvaluateExpression [] e100;
runEvaluateExpression [] e101;
runEvaluateExpression [] e102;
runEvaluateExpression [] e103;
runEvaluateExpression [] e104;
runEvaluateExpression [] e105;
runEvaluateExpression [] e106;
runEvaluateExpression [] e107;
runEvaluateExpression [] e108;
runEvaluateExpression [] e109;
runEvaluateExpression [] e110;
runEvaluateExpression [] e111;
runEvaluateExpression [] e112;
runEvaluateExpression [] e113;
runEvaluateExpression [] e114;
runEvaluateExpression [] e115;
runEvaluateExpression [] e116;
runEvaluateExpression [] e117;
runEvaluateExpression [] e118;
runEvaluateExpression [] e119;
runEvaluateExpression [] e120;
runEvaluateExpression [] e121;
runEvaluateExpression [] e122;
runEvaluateExpression [] e123;
runEvaluateExpression [] e124;
runEvaluateExpression [] e125;
runEvaluateExpression [] e126;
runEvaluateExpression [] e127;
runEvaluateExpression [] e128;
runEvaluateExpression [] e129;
runEvaluateExpression [] e130;
runEvaluateExpression [] e131;
runEvaluateExpression [] e132;
runEvaluateExpression [] e133;
runEvaluateExpression [] e134;
runEvaluateExpression [] e135;
runEvaluateExpression [] e136;
runEvaluateExpression [] e137;
runEvaluateExpression [] e138;
runEvaluateExpression [] e139;
runEvaluateExpression [] e140;
runEvaluateExpression [] e141;
runEvaluateExpression [] e142;
runEvaluateExpression [] e143;
runEvaluateExpression [] e144;
runEvaluateExpression [] e145;
runEvaluateExpression [] e146;
runEvaluateExpression [] e147;
runEvaluateExpression [] e148;
runEvaluateExpression [] e149;
runEvaluateExpression [] e150;
runEvaluateExpression [] e151;
runEvaluateExpression [] e152;
runEvaluateExpression [] e153;
runEvaluateExpression [] e154;
runEvaluateExpression [] e155;
runEvaluateExpression [] e156;
runEvaluateExpression [] e157;
runEvaluateExpression [] e158;
runEvaluateExpression [] e159;
runEvaluateExpression [] e160;
runEvaluateExpression [] e161;
runEvaluateExpression [] e162;
runEvaluateExpression [] e163;
runEvaluateExpression [] e164;
runEvaluateExpression [] e165;
runEvaluateExpression [] e166;
runEvaluateExpression [] e167;
runEvaluateExpression [] e168;
runEvaluateExpression [] e169;
runEvaluateExpression [] e170;
runEvaluateExpression [] e171;
runEvaluateExpression [] e172;
runEvaluateExpression [] e173;
runEvaluateExpression [] e174;
runEvaluateExpression [] e175;
runEvaluateExpression [] e176;
runEvaluateExpression [] e177;
runEvaluateExpression [] e178;
runEvaluateExpression [] e179;
runEvaluateExpression [] e180;
runEvaluateExpression [] e181;
runEvaluateExpression [] e182;
runEvaluateExpression [] e183;


runEvaluateExpression sameAsConst e9;
runEvaluateExpression sameAsConst e10;
runEvaluateExpression sameAsConst e11;
runEvaluateExpression sameAsConst e12;
runEvaluateExpression sameAsConst e13;
runEvaluateExpression sameAsConst e14;
runEvaluateExpression sameAsConst e15;
runEvaluateExpression sameAsConst e16;
runEvaluateExpression sameAsConst e17;
runEvaluateExpression sameAsConst e18;
runEvaluateExpression sameAsConst e19;
runEvaluateExpression sameAsConst e20;
runEvaluateExpression sameAsConst e103;
runEvaluateExpression sameAsConst e104;
runEvaluateExpression sameAsConst e105;
runEvaluateExpression sameAsConst e106;
runEvaluateExpression sameAsConst e107;
runEvaluateExpression sameAsConst e108;
runEvaluateExpression sameAsConst e109;
runEvaluateExpression sameAsConst e110;
runEvaluateExpression sameAsConst e111;
runEvaluateExpression sameAsConst e112;
runEvaluateExpression sameAsConst e113;
runEvaluateExpression sameAsConst e114;
runEvaluateExpression sameAsConst e115;
runEvaluateExpression sameAsConst e116;
runEvaluateExpression sameAsConst e117;
runEvaluateExpression sameAsConst e118;
runEvaluateExpression sameAsConst e119;
runEvaluateExpression sameAsConst e120;
runEvaluateExpression sameAsConst e121;
runEvaluateExpression sameAsConst e122;
runEvaluateExpression sameAsConst e123;
runEvaluateExpression sameAsConst e124;
runEvaluateExpression sameAsConst e125;
runEvaluateExpression sameAsConst e126;
runEvaluateExpression sameAsConst e127;
runEvaluateExpression sameAsConst e128;
runEvaluateExpression sameAsConst e129;
runEvaluateExpression sameAsConst e130;
runEvaluateExpression sameAsConst e131;
runEvaluateExpression sameAsConst e132;
runEvaluateExpression sameAsConst e133;
runEvaluateExpression sameAsConst e134;
runEvaluateExpression sameAsConst e135;
runEvaluateExpression sameAsConst e136;
runEvaluateExpression sameAsConst e137;
runEvaluateExpression sameAsConst e138;
runEvaluateExpression sameAsConst e139;
runEvaluateExpression sameAsConst e140;
runEvaluateExpression sameAsConst e141;
runEvaluateExpression sameAsConst e142;
runEvaluateExpression sameAsConst e143;
runEvaluateExpression sameAsConst e144;
runEvaluateExpression sameAsConst e145;
runEvaluateExpression sameAsConst e146;
runEvaluateExpression sameAsConst e147;
runEvaluateExpression sameAsConst e148;
runEvaluateExpression sameAsConst e149;
runEvaluateExpression sameAsConst e150;
runEvaluateExpression sameAsConst e151;
runEvaluateExpression sameAsConst e152;
runEvaluateExpression sameAsConst e153;
runEvaluateExpression sameAsConst e154;
runEvaluateExpression sameAsConst e155;
runEvaluateExpression sameAsConst e156;
runEvaluateExpression sameAsConst e157;
runEvaluateExpression sameAsConst e158;
runEvaluateExpression sameAsConst e159;
runEvaluateExpression sameAsConst e160;
runEvaluateExpression sameAsConst e161;
runEvaluateExpression sameAsConst e162;
runEvaluateExpression sameAsConst e163;
runEvaluateExpression sameAsConst e164;
runEvaluateExpression sameAsConst e165;
runEvaluateExpression sameAsConst e166;
runEvaluateExpression sameAsConst e167;
runEvaluateExpression sameAsConst e168;
runEvaluateExpression sameAsConst e169;
runEvaluateExpression sameAsConst e170;
runEvaluateExpression sameAsConst e171;
runEvaluateExpression sameAsConst e172;
runEvaluateExpression sameAsConst e173;
runEvaluateExpression sameAsConst e174;
runEvaluateExpression sameAsConst e175;
runEvaluateExpression sameAsConst e176;
runEvaluateExpression sameAsConst e177;
runEvaluateExpression sameAsConst e178;
runEvaluateExpression sameAsConst e179;
runEvaluateExpression sameAsConst e180;
runEvaluateExpression sameAsConst e181;
runEvaluateExpression sameAsConst e182;
runEvaluateExpression sameAsConst e183;
