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


        if(sc.lookahead().getTokenType() == Token.BEGIN)
            doBegin();
        else
            throw new Exception("Missing Begin token");

         System.out.println("    public static void main(String[] args){");
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

            System.out.printf("Token type: %s          Token string value: %s%n",
                    tokenType,
                    tokenStringValue);
            sc.consume();
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
            // Neither nat or set found, no variable definitions
            return;
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
                throw new Exception("Unexpected token in doNat(): " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()] + "  " + sc.lookahead().getTokenType());
            }

            String natVariableName = sc.lookahead().getTokenString();
            natVariables.add(natVariableName);
            sc.consume();

            // no comma, last of nat variables
            if(sc.lookahead().getTokenType() != Token.COMMA) {
                break;
            } else {
                // consume comma
                sc.consume();
            }

        }

        // consume semicolon

        if(sc.lookahead().getTokenType() != Token.SEMICOLON) {
            throw new Exception("Unexpected token in doNat(): " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()] + "  " + sc.lookahead().getTokenType());
        }

        sc.consume();

        // output code to declare nat variables

        for(String varName : natVariables) {
            System.out.println("    private static int " + varName + " = 0;");
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
            sc.consume();

            // no comma, last of nat variables
            if(sc.lookahead().getTokenType() != Token.COMMA) {
                break;
            } else {
                // consume comma
                sc.consume();
            }

        }

        // consume semicolon

        if(sc.lookahead().getTokenType() != Token.SEMICOLON) {
            throw new Exception("Unexpected token: " + Token.TOKEN_LABELS[sc.lookahead().getTokenType()]);
        }

        sc.consume();

        // output code to declare nat variables

        for(String varName : privateSetVariables) {
            System.out.println("    private static Cofin " + varName + " = null;");
            setVariables.put(varName, null);
        }
    }


    private static void doBegin() throws Exception {
        sc.consume();

        TreeSet<Integer> calculationSet = new TreeSet<Integer>();
        calculationSet.add(Token.COMPLEMENT);
        calculationSet.add(Token.IF);
        calculationSet.add(Token.INTERSECTION);
        calculationSet.add(Token.SETDIFFERENCE);
        calculationSet.add(Token.UNION);

        int lookAheadType = sc.lookahead().getTokenType();
        String varName = null;
        if (lookAheadType == Token.ID) {
            varName = sc.lookahead().getTokenString();
            sc.consume();
        }
        else {
            int x = 0;
            //its not doing assignments or there's an error. Still needs to be handled
        }
        lookAheadType = sc.lookahead().getTokenType();

        String wasAssigned = "";

        while (!calculationSet.contains(lookAheadType)) {
            if (varName == null)
                break;
            if (naturalVariables.containsKey(varName))
                assignNat(varName);
            else if (setVariables.containsKey(varName))
                wasAssigned = assignSet(varName, calculationSet);
            else
                throw new Exception("Variable not declared.");
            if (!wasAssigned.equals("$")){
                throw new Exception("Something went wrong...");
            }
            lookAheadType = sc.lookahead().getTokenType();
            if (lookAheadType == Token.ID) {
                varName = sc.lookahead().getTokenString();
                sc.consume();
                lookAheadType = sc.lookahead().getTokenType();
            }
            else
                break;

        }

    }

    //Not completely done!!!
    //so far...
    //this takes the sc after the varName is consumed
    //it checks for the assignment token and looks till it finds a semi colon or a "calculation" token
    //assuming it is an assignment it does the assignment
    //(Though for the moment it can't handle empty string. I try to fix that sometime tonight.)
    //otherwise there are some weird returns to handle other situations
    //if it hits a "calculation" token it returns the previous variable so we don't loose it
    //and doesn't consume the token so if it is a calculation we should be able to proceed accordingly.
    // it might be doing other weird stuff, haven't full tested it yet

    //occasionally throwing a variable not assigned error...not sure why yet...

    private static String assignSet(String varName, TreeSet<Integer> calculationSet) throws Exception {
        int la = sc.lookahead().getTokenType();
        String tempName;

        if(la == Token.ASSIGN) {
            sc.consume();
            la = sc.lookahead().getTokenType();
            if (calculationSet.contains(la))
                return null;
            if (la == Token.ID) {
                tempName = sc.lookahead().getTokenString();
                if (setVariables.containsKey(tempName)) {
                    if (setVariables.get(tempName) == null)
                        throw new Exception("Variable " + varName + " not yet assigned.");
                    sc.consume();
                    la = sc.lookahead().getTokenType();
                    if (calculationSet.contains(la))
                        return tempName;
                    else if (la == Token.SEMICOLON) {
                        System.out.println("        " + varName + " = " + tempName + ";");
                        sc.consume();
                        return "$";
                    }
                    else
                        throw new Exception("Semicolon expected");

                }
                else if (naturalVariables.containsKey(tempName)) {
                    if (naturalVariables.get(tempName) == null)
                        throw new Exception("Variable " + varName + " not yet assigned.");
                    sc.consume();
                    la = sc.lookahead().getTokenType();
                    if (la == Token.SEMICOLON) {
                        System.out.println("        " + varName + " = new Cofin(false, " + tempName + ");");
                        sc.consume();
                        return "$";
                    }
                    else
                        throw new Exception("Semicolon Expected");

                }
                else
                    throw new Exception("Variable " + tempName + " not declared.");
            }
            String comp = "false";
            ArrayList<String> constructorValues= new ArrayList<String>();
            if (la == Token.CMP) {
                comp = "true";
                sc.consume();
                la = sc.lookahead().getTokenType();
            }
            if (la == Token.LEFTBRACE) {
                sc.consume();
                la = sc.lookahead().getTokenType();
                String curr;
                while (la == Token.NATCONST) {
                    curr = sc.lookahead().getTokenString();
                    constructorValues.add(curr);
                    sc.consume();
                    la = sc.lookahead().getTokenType();
                    if (la != Token.COMMA) {
                        break;
                    }
                    sc.consume();
                    la = sc.lookahead().getTokenType();
                }
                if (la != Token.RIGHTBRACE)
                    throw new Exception("Right brace expected.");
                sc.consume();
                la = sc.lookahead().getTokenType();
                if (la != Token.SEMICOLON)
                    throw new Exception("Semicolon expected.");
                sc.consume();
                System.out.print("        int[] $" + varName + " = {");
                for (int i = 0; i < constructorValues.size()-1; i++) {
                    System.out.print(constructorValues.get(i) + ", ");
                }
                System.out.println(constructorValues.get(constructorValues.size()-1) + "};");
                System.out.println("        " + varName + " = new Confin(" + comp + ", $" + varName + ");");
                return "$";
            }

        }

        return "Something fishy...";

    }

    //takes the sc if its encountered a nat variable name but before the name has been consumed.
    //returns the sc after consuming the semicolon after the assignment.
    //mostly working as far as I know...

    private static void assignNat(String varName) throws Exception {
        sc.consume();
        String natValue;
        int la = sc.lookahead().getTokenType();
        if (la == Token.ASSIGN) {
            sc.consume();
            la = sc.lookahead().getTokenType();
            if (la == Token.NATCONST)
                natValue =sc.lookahead().getTokenString();
            else if (la == Token.ID) {
                natValue = sc.lookahead().getTokenString();
                if (!naturalVariables.containsKey(natValue))
                    throw new Exception("Variable " + natValue + " not declared.");
                else if (naturalVariables.get(natValue) == null)
                    throw new Exception("Variable " + varName + " not yet assigned.");
            }
            else
                throw new Exception("Constant value expected.");
            System.out.println("        " + varName + " = " + natValue + ";");
            naturalVariables.put(varName, Integer.getInteger(natValue));
            sc.consume();
            la = sc.lookahead().getTokenType();
            if (la != Token.SEMICOLON)
                throw new Exception("Semicolon expected.");
            sc.consume();
            return;
        }
        else
            throw new Exception ("Assignment expected");

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
