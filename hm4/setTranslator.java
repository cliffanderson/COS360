import java.util.*;
import java.io.*;
/*

A template for the translator part of the project.

You will need to add more static variables and also methods
for each of the grammar variables, and modify the program method below.

Modified 11/20/16

1. changed PrintStream to PrintWriter
2. changed to have the main method only print the exception's error
   message to standard error when an exception is thrown.

Modified 10/23/17

1. changed main to use the setScannerSolution class
2. did the initial test for the lookahead being program
   and threw the right error message


*/
public class setTranslator{

   private static setScanner sc;

   // this should be created if the parse gets as far as the identifier that
   // follows "program"
   private static PrintWriter dest;

   private static void program(){
   // attempts the translation of the source file 
   // into a Java source file 
   // YOU HAVE TO CODE THIS

   }


// you should not modify the main method
public static void main(String[] args) throws Exception{

   if (args.length == 0)
      sc = new setScannerSolution(new Scanner(System.in));
   else
      sc = new setScannerSolution(new Scanner(new File(args[0])));

   Token currTok = sc.lookahead();

   try{
      if (Token.programSet.contains(currTok.getTokenType())){
         program();
         // add a comment  indicating a successful parse
         if (dest != null){
            dest.println("\n// Successful parse.");
            dest.close();
         }
      }
      else
         // you should write a method to take the set of tokens that would
         // be okay and the line number to create and throw the exception with
         // the right error message for the other error messages
         throw new Exception("[line " + currTok.getLineNum() + "]: \"program\" expected.");
   }
   catch (Exception e){
      // if the translation throws an exception, it is written to standard error
      System.err.println(e.getMessage());
   }
}
}
