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
Modified 11/11/17
1. changed the sc declaration to be setScannerSolution instead
   of setScanner
 */
public class setTranslator{

    private static setScannerSolution sc;

    // this should be created if the parse gets as far as the identifier that
    // follows "program"
    private static PrintWriter dest;

    private static Map<String, Integer> naturalVariables = new HashMap<String, Integer>();
    private static Map<String, CofinFin> setVariables = new HashMap<String, CofinFin>();


    public static void program() throws Exception {

        System.out.println("program()");

        String tokenType = "";

        if(sc.lookahead().getTokenType() != Token.PROGRAM) {
            throw new Exception("Error: program must start with a program token");
        }

        // handle program token
        doProgram();

        // next token must be var
        if(sc.lookahead().getTokenType() != Token.VAR) {
            throw new Exception("Missing var token");
        }

        // handle var token
        doVar();


//        else {
//            sc.consume();
//            if(sc.lookahead().getTokenType() != Token.ID) {
//                System.err.println("Error: must name the program");
//                throw new Exception("");
//            } else {
//                String programName = sc.lookahead().getTokenString();
//                System.out.println("public class " + programName + " {");
//                sc.consume();
//            }
//        }

        // main loop for parsing
        while(! tokenType.equals("eof")) {
            tokenType = Token.TOKEN_LABELS[sc.lookahead().getTokenType()];
            String tokenStringValue = sc.lookahead().getTokenString();
            if(tokenType.equals("\"var\"")){
                System.out.print("");
                sc.consume();
                tokenType = Token.TOKEN_LABELS[sc.lookahead().getTokenType()];
            }
            else if(tokenType.equals("\"set\"")){
                while(!tokenType.equals("\"begin\"")){
                    tokenType = Token.TOKEN_LABELS[sc.lookahead().getTokenType()];
                    tokenStringValue = sc.lookahead().getTokenString();
                    if(tokenType.equals("identifier")){
                        System.out.println("    private static CofinFin " + tokenStringValue + " = new CofinFin();");
                        sc.consume();
                    }
                    else
                        sc.consume();
                }
                System.out.println("    public static void main(String[] args) {");
            }

            else{
                if(tokenType.equals("\"begin\"")){
                    System.out.println("    public static void main(String[] args) {"); 
                    sc.consume();
                }
                else
                    System.out.printf("Token type: %s          Token string value: %s%n",
                            tokenType,
                            tokenStringValue);
                sc.consume();                   
            }
        }
    }

    // there should be an ID token for the program name
    private static void doProgram() throws Exception {
        // consume program token
        sc.consume();

        if(sc.lookahead().getTokenType() != Token.ID) {
            throw new Exception("Name of program not found");
        }

        String programName = sc.lookahead().getTokenString();

        System.out.println("public class " + programName + " {");
        System.out.println("    public static void main(String[] args) {");

        //consume ID token
        sc.consume();
    }

    private static void doVar() throws Exception {
        // consume var token
        sc.consume();

        // handle OPTIONAL nat and set tokens and their values
        boolean natDone = false, setDone = false;

        if(sc.lookahead().getTokenType() == Token.SET) {
            doSet();
            setDone = true;
        } else if(sc.lookahead().getTokenType() == Token.NAT) {
            doNat();
            natDone = true;
        } else {
            throw new Exception("Unexpected token type: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
        }

        // nat or set is now done. Now time to do the other
        if(sc.lookahead().getTokenType() == Token.SET) {
            // if set has already been done, throw expection
            // otherwise doSet
            if(setDone) {
                throw new Exception("Duplicate set token found");
            } else {
                doSet();
            }
        } else if(sc.lookahead().getTokenType() == Token.NAT) {
            // if nat has already been done, throw expection
            // otherwise doNat
            if(natDone) {
                throw new Exception("Duplicate nat token found");
            } else {
                doNat();
            }
        } else {
            throw new Exception("Unexpected token type: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
        }

    }

    private static void doNat() throws Exception {
        // consume nat
        sc.consume();

        List<String> natVariables = new ArrayList<String>();

        // while not semicolon
            // consume ID and create nat
            // if not comma, break;

        while(sc.lookahead().getTokenType() != Token.SEMICOLON) {
            if(sc.lookahead().getTokenType() != Token.ID) {
                throw new Exception("Unexpected token: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
            }

            String natVariableName = sc.lookahead().getTokenString();
            natVariables.add(natVariableName);

            // no comma, last of nat variables
            if(sc.lookahead().getTokenType() != Token.COMMA) {
                break;
            }

        }

        // consume semicolon

        if(sc.lookahead().getTokenType() != Token.SEMICOLON) {
            throw new Exception("Unexpected token: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
        }

        sc.consume();

        // output code to declare nat variables

        for(String varName : natVariables) {
            System.out.println("        int " + varName + " = 0;");
            naturalVariables.put(varName, 0);
        }
    }

    private static void doSet() throws Exception {
        // consume set
        sc.consume();

        List<String> privateSetVariables = new ArrayList<String>();

        // while not semicolon
        // consume ID and create nat
        // if not comma, break;

        while(sc.lookahead().getTokenType() != Token.SEMICOLON) {
            if(sc.lookahead().getTokenType() != Token.ID) {
                throw new Exception("Unexpected token: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
            }

            String setVariableName = sc.lookahead().getTokenString();
            privateSetVariables.add(setVariableName);

            // no comma, last of nat variables
            if(sc.lookahead().getTokenType() != Token.COMMA) {
                break;
            }

        }

        // consume semicolon

        if(sc.lookahead().getTokenType() != Token.SEMICOLON) {
            throw new Exception("Unexpected token: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
        }

        sc.consume();

        // output code to declare nat variables

        for(String varName : privateSetVariables) {
            System.out.println("        Cofin " + varName + " = null;");
            setVariables.put(varName, null);
        }
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
