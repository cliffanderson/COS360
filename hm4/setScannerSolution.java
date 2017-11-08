import java.util.*;
/*

A class to perform the lexical analysis for the translation project.

It contains instance specific data members

1. src: the Scanner origin of the source code text
2. currToken: the current token
3. currLine: a char array of a line from src from which currToken was drawn
4. currPos: the position within currLine from which the next token will be searched for
5. currLineNumber: the index of currLine within the src, with the first line regarded as at index 1
6. atEOF: boolean 

Class invariants

1. src is not null
2. currToken is not null
3. currLine is not null; if there is no next line, it will be set to the empty array;
   we can imagine that even an empty file has one line on it that contains the end of file
   marker
4. 0 <= currPos <= currLine.length
5. currLineNumber >= 1
6. atEOF iff currToken is the EOF token

It provides methods

1. getting methods for all data members except src and currLine(the getter for
   currToken is the lookahead method)
2. void consume(): fetches the next token from src into currToken and updates the
   other data members
3. Token lookahead(): returns currToken


*****************************************************************************************/

public class setScannerSolution{

   private Scanner src;
   private Token currToken;
   // NOTE: NO TOKEN CAN CROSS A LINE BOUNDARY
   private boolean atEOF = false;
   private int
      currLineNumber,
      currLineLen;
   private char[] currLine = {};
   private int currPos; // 0 <= currPos <= currLine.length
                        // to record where we are on the current line

   // creates an instance of this scanner class from a Java scanner
   public setScannerSolution(Scanner sc)throws Exception{
      if (sc == null)
         throw new Exception("Null Scanner passed to setScannerSolution constructor.");

      src = sc;
      // load currToken with the first token
      this.consume();
   }

   // returns the current token w/o advancing
   public Token lookahead(){
      return currToken;
   }

   public int getCurrLineNum(){
      return currLineNumber;
   }

   public int getCurrPos(){
      return currPos;
   }

   private void skipWS(){
      boolean onWS = true;

      while (!atEOF && onWS)
         if (currPos == currLineLen)
            if (src.hasNextLine()){
               currLine = src.nextLine().toCharArray();
               currPos = 0;
               currLineLen = currLine.length;
               currLineNumber++;
            }
            else{
               // make the current token EOF
               atEOF = true;
               ++currLineNumber;
               currToken = new Token(Token.EOF,currLineNumber);
               currPos = 0;
               currLine = new char[0];
            }
         else
            if (Character.isWhitespace(currLine[currPos]))
               currPos++;
            else
               onWS = false;
   }

         


   public void consume(){
   /*

     if the current token is already EOF this
     operation has no effect.

     skip over WS in src until either reaches end of file
     or a non WS char
       
     if reaches eof w/o seeing nonWS loads 
         currToken with EOF
     else
         scans the src from the current non-ws position and
         loads currToken with the longest prefix that
         matches a token definition; if no prefix matches,
         loads currToken with UNRECOGNIZED; UNRECOGNIZED will 
         consume non-ws characters until ws of end of file;

     The thing to be mindful of is when one token's definition
     is in effect a prefix of another's.  Proper prefixes of 
     reserved words and "not" and "in" are identifiers, and
     "not", "in", and reserved words, if followed immediately
     by letters or digits are identifiers. No other tokens
     have non-empty common prefixes.

   */
  
      if (!atEOF){  // once we reach eof, nothing more to do
         skipWS();
         if (!atEOF){
            StringBuilder b = new StringBuilder();
            String s;

            char c = currLine[currPos++];

            if (Character.isLetter(c)){
               b.append(c);
               
               while (currPos < currLineLen && 
                      Character.isLetterOrDigit(currLine[currPos]))
                  b.append(currLine[currPos++]);
                  
               s = b.toString();

               // check for reserved words
               if (s.equals("program"))
                  currToken = new Token(Token.PROGRAM,  currLineNumber);
               else if (s.equals("var"))
                  currToken = new Token(Token.VAR,  currLineNumber);
               else if (s.equals("begin"))
                  currToken = new Token(Token.BEGIN,  currLineNumber);
               else if (s.equals("end"))
                  currToken = new Token(Token.END,  currLineNumber);
               else if (s.equals("if"))
                  currToken = new Token(Token.IF,  currLineNumber);
               else if (s.equals("else"))
                  currToken = new Token(Token.ELSE,  currLineNumber);
               else if (s.equals("endif"))
                  currToken = new Token(Token.ENDIF,  currLineNumber);
               else if (s.equals("nat"))
                  currToken = new Token(Token.NAT,  currLineNumber);
               else if (s.equals("set"))
                  currToken = new Token(Token.SET,  currLineNumber);
               else if (s.equals("not"))
                  currToken = new Token(Token.NOT,  currLineNumber);
               else if (s.equals("in"))
                  currToken = new Token(Token.IS_IN,  currLineNumber);
               else if (s.equals("then"))
                  currToken = new Token(Token.THEN,  currLineNumber);
               else if (s.equals("CMP"))
                  currToken = new Token(Token.CMP,  currLineNumber);
               else // an identifier
                  currToken = new Token(Token.ID, currLineNumber, s);
            }
            else if (c == '0')
               currToken = new Token(Token.NATCONST, currLineNumber, "0");
            else if (Character.isDigit(c)){
               b.append(c);

               while (currPos < currLineLen && 
                      Character.isDigit(currLine[currPos]))
                  b.append(currLine[currPos++]);
                  
               s = b.toString();
               currToken = new Token(Token.NATCONST,currLineNumber, s);
            }
            else // not a letter or a digit;

               switch (c){

                  // deal with single char tokens first
                  case ';' :
                     currToken = new Token(Token.SEMICOLON,  currLineNumber);
                     break;
                  case '(' :
                     currToken = new Token(Token.LEFTPAREN,  currLineNumber);
                     break;
                  case ')' :
                     currToken = new Token(Token.RIGHTPAREN,  currLineNumber);
                     break;
                  case '{' :
                     currToken = new Token(Token.LEFTBRACE,  currLineNumber);
                     break;
                  case '}' :
                     currToken = new Token(Token.RIGHTBRACE,  currLineNumber);
                     break;
                  case '.' :
                     currToken = new Token(Token.PERIOD,  currLineNumber);
                     break;
                  case ',' :
                     currToken = new Token(Token.COMMA,  currLineNumber);
                     break;
                  case '=' :
                     currToken = new Token(Token.EQUALS,  currLineNumber);
                     break;
                  case '-' :
                     currToken = new Token(Token.COMPLEMENT,  currLineNumber);
                     break;
                  case '*' :
                     currToken = new Token(Token.INTERSECTION,  currLineNumber);
                     break;
                  case '+' :
                     currToken = new Token(Token.UNION,  currLineNumber);
                     break;
                  case '\\' :
                     currToken = new Token(Token.SETDIFFERENCE,  currLineNumber);
                     break;
                  case '<':
                  case ':':
                     // both need the '='
                     if (currPos == currLineLen || currLine[currPos] != '='){
                        b.append(c);
           
                        // advance to next ws or end of line, adding to the UNRECOGNIZED
                        while (currPos < currLineLen && !Character.isWhitespace((c = currLine[currPos]))){
                           b.append(c);
                           currPos++;
                        }
                        currToken = new Token(Token.UNRECOGNIZED, currLineNumber, b.toString());
                     }
                     else{
                        currPos++;
                        if (c == '<')
                           currToken = new Token(Token.SUBSET,  currLineNumber);
                        else
                           currToken = new Token(Token.ASSIGN,  currLineNumber);
                     }
                     break;
                  default:
                     { 
                       // construct an UNRECOGNIZED token
                       b.append(c);
                       /*
                          loop invariant:

                          b has all characters from the first non-WS character of this call
                          up to the character at currLine[currPos-1] and all were non-WS and 
                          currPos <= currLineLen

                          we add and advance if we are not at the end of the current line and the
                          current character is still not WS
                       */
                       while (currPos < currLineLen && !Character.isWhitespace((c = currLine[currPos]))){
                          b.append(c);
                          currPos++;
                       }
                       currToken = new Token(Token.UNRECOGNIZED, currLineNumber, b.toString());
                     }
                     break;
               }
         }
      }
   }
   // for testing
   public static void main(String[] args)throws Exception{
      Token tk;

      
      setScannerSolution lex = new setScannerSolution(new Scanner(System.in));

      int tNum = 0;
      tk = lex.lookahead();
      while (tk.getTokenType() != Token.UNRECOGNIZED){
         System.out.println("Token #" + (++tNum) + " = " + tk);
         lex.consume();
         tk = lex.lookahead();
      }
   }
          
   
}

