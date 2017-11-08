COS 360   Team Homework Exercise #4


Translater Code Due Date: 12/2/17 @ 8 AM

This project involves writing a translator from a made up 
imperative language for programs that use CofinFin sets to
Java code that performs the operations of the language.  

In this archive file are the following

1. Token.java  - a class of the tokens/terminals for the grammar
2. setScannerSolution.java - an implementation of a scanner/lexical analyzer for those
                          tokens that you can use

3. the discussion of the problem, READMEF17.txt, the file you are reading
4. a skeleton for the translator, setTranslator.java
6. some test data files(g1.txt to g46.txt), what my solution produces for their
   translations(g1.java to g46.java) and the results from running those 46
   translations, in all.txt
7. additional discussion of the grammar and suggestions for the translator in
   grammar.txt

Your task is to code a predictive parser and code generator in a Java class
setTranslator.java for this language.  The target language is Java itself,
using the CofinFin.java class for the set variables.


This is a substantial coding project.

The template I gave you has a main method that should not be changed.  It
creates an instance of setScannerSolution to fetch tokens from either standard in
or a file given on the command line.  If the first token is program, then it
calls the method of the grammar variable <program>, which you must write to
continue the parse.  

When you process an input source program in this language, you
maintain within your overall translator program a number of global
(in Java, that means static) data variables and structures that record 
information you've seen as you scan the source so that you can
refer to it later.  I discuss these below as they come up.

The translator will emit code for the result of the translation.  Our target
language is Java, so what you emit needs to be correct Java code.  You should
emit it into a file with the .java extension that has the same name as
the identifier after the reserved word program.


There are only two kinds of variables in the source language:
natural number variables and set variables.  The former should be
declared as int variables in the target language(Java) and the latter 
should be declared as CofinFin variables.  We do have expressions 
of type boolean and the one boolean operator, negation, but no 
variables of type boolean and no other boolean operators.  

We also do not have any arithmetic operators.  The only expressions
we have for natural numbers are variables and constants.

The notion of the source language is that it calculates CofinFin 
values and at the very end one such value will be printed using the
toString method of that class.  The shortest legal program is

program s
var
begin
end
{}.

which should generate a Java class source codefile, s.java,
as something like the following.

public class s{

   public static void main(String[] args){

      CofinFin $sv1 = new CofinFin(false,new int[] {});
      System.out.println($sv1.toString());
   }
}

Actually, you don't have to do any indentation, but it's not that difficult
to do it, any you may want to.  Just keep track of the current margin, and whenever
you emit code to a line, emit enough blanks to indent.

I do want each Java statement to begin a new line and there should be at least one
blank line after each of the following  three parts in the target result, if there is
a successful parse.


1. public class pname{

2. the last static declaration before the main method

3. public static void main(String[] args){

If you can process declarations(all static CofinFin variables should be initialized to the
empty set) and process the set valued expressions, so that the <out> part evaluates and
prints something, that is worth 80 points.  If you can do the assignment statements for
the two types of values, nat and set, then that is worth another 5 points, and if you
can do the if statements, that is worth another 16 points.

There is more information on the syntax and the error reporting I want you to do in the
companion grammar.txt file.

Below is an example source program.  The overall structure has nine parts.

program id
var
natDeclarations(optional)
setDeclaratins(optional)
begin
statementList
end
setExpression
.


program p17

var

nat i,j,k;

set w,s,t,v;

begin
   s := {};
   t := s;
   i := 1;
   w := s * t \ CMP {} + -CMP {1,2};
   v := w;
   j := i;

   if 0 in s then
      t := {1}
   endif;

   if i in CMP{0,1,2,3} then
      s := s +{2}
   endif;

   if {} <= s then
      t := t * {5};
      w := w \ t
   endif;

   if w <= CMP{} then
      s := s + {4}
   endif;

   if {} = s then
      t := t + {9}
   endif;

   if w = CMP{} then
      s := t \ {8}
   else
      if CMP{} = {0,1} then
        t := t + {11}
      endif
   endif;

   w := t \ - s + t \ CMP {0} + {10,20,30,2}
end

s + t \ w * {1,2,3,4}
.


Note that ; is a separator for a list of statements, but is not required
after the last statement in a list.  In particular, there are no semicolons
before else, endif, or end.  Statement lists are bracketed by one of the 
pairs begin-end, then-endif, then-else, or else-endif.

Predictive parsing translation typically has a function/method for each
grammar variable.  The method will be called when the leftmost derivation
that is in process has its variable as the next symbol (on top of the stack)
and the lookahead matches one of its rhs's lookahead sets.  

Generally, whenever the method V() for grammar variable V is called, the
parser should first check that the lookahead is in the the lookahead sets
for one of the rhs's of V.  If that is not the case, then the parser should
throw an exception with an error message of the form

[line ln]: tokenlist expected.

This is discussed in more detail in the grammar.txt file.

Similarly, if the next parsing operation is a matching operation with a specific
token tk, and the lookahead token does NOT match tk, then the parser should
throw an exception with a message as described in grammar.txt.

[line ln]: tk's label as you obtain it from TOKEN_LABELS is expected.

There are other error conditions involving identifiers that are explained there
as well. If an exception is thrown because of one of the errors, that ends the
parse.

