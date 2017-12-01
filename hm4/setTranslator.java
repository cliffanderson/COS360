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


        if(sc.lookahead().getTokenType() == Token.BEGIN){
            doBegin();
        }
        else
            throw new Exception("Missing Begin token");


        if(sc.lookahead().getTokenType() == Token.END) {
            doEnd();
        }
        else
            throw new Exception("End token expected.");

        while(sc.lookahead().getTokenType() != Token.PERIOD) {
            sc.consume();
            if (sc.lookahead().getTokenType() == Token.EOF)
                throw new Exception ("Period token expected.");

        }
        if (sc.lookahead().getTokenType() == Token.PERIOD) {
            System.out.println("   }");
            System.out.println("}");
            sc.consume();
            if(sc.lookahead().getTokenType() == Token.EOF)
                sc.consume();
            else
                throw new Exception("Nothing allowed after period.");
        }




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
            System.out.println("    private static CofinFin " + varName + " = new CofinFin();");
            setVariables.put(varName, null);
        }
    }


    private static void doBegin() throws Exception {
        System.out.println("    public static void main(String[] args){");
        sc.consume(); //consume begin token

        TreeSet<Integer> calculationSet = new TreeSet<Integer>();
        calculationSet.add(Token.COMPLEMENT);
        calculationSet.add(Token.IF);
        calculationSet.add(Token.INTERSECTION);
        calculationSet.add(Token.SETDIFFERENCE);
        calculationSet.add(Token.UNION);

        int lookAheadType = sc.lookahead().getTokenType();
        String varName = null;
        //check that the first token after begin is an id
        //keep it in the temp variable and consume the token
        if (lookAheadType == Token.ID) {
            varName = sc.lookahead().getTokenString();
            sc.consume();
        }
        //if it's not it may still be valid it's just doing somehting else besides assign
        //which wasn't my concern for the moment
        else {
            int x = 0;
            //its not doing assignments or there's an error. Still needs to be handled
        }
        //get the next token, should be an assign or a set calculation (union, intersect....)
        lookAheadType = sc.lookahead().getTokenType();

        String wasAssigned = "";

        //while were still in the assign section of begin
        //we haven't tried to do if statements and some sets will be calculated
        while (Token.IF != lookAheadType) {
            //if the token after begin wasn't an ID the varName never got assigned
            //and we can skip this whole assign section
            if (varName == null)
                break;
            if (naturalVariables.containsKey(varName))
                assignNat(varName);
            else if (setVariables.containsKey(varName))
                wasAssigned = assignSet(varName, calculationSet);
            else
                //if we get here we have an id but it wasn't declared
                throw new Exception("Variable not declared.");
            if (!wasAssigned.startsWith("$")){
                break;
            }
            //so if we get to here we had some sort of successful assignment
            if(!wasAssigned.equals("$")) {
                System.out.println(wasAssigned);
            }
            //we set ourselves up for the next one.
            lookAheadType = sc.lookahead().getTokenType();
            if (lookAheadType == Token.ID) {
                varName = sc.lookahead().getTokenString();
                sc.consume();
                lookAheadType = sc.lookahead().getTokenType();
            }
            else
                break;

        }
        /***************************************************************************************/
        //This now lets us know if we skipped a set assignment, this would mean that my calculation in doAssign went ary
        if(!wasAssigned.equals(""))
            System.out.println("//Skipped some stuff...");

        //this just skips to the end so we can have something to print.
        while(lookAheadType != Token.END) {
            sc.consume();
            lookAheadType = sc.lookahead().getTokenType();
            if (lookAheadType == Token.EOF)
                throw new Exception("End token expected.");
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
        // checking for assignment token
        if(la == Token.ASSIGN) {
            sc.consume();
            la = sc.lookahead().getTokenType();
            //if the token after the assignment is the complement "-" then we don't want this method
            //we have only consumed the assign token so we haven't lost anything
            if (calculationSet.contains(la))
                return null;
            //if we get here we have assign equals a var name, which may be valid for now...
            //s = t; for example
            if (la == Token.ID) {
                //so get the next var name and check that it has been declared and assigned
                tempName = sc.lookahead().getTokenString();
                if (setVariables.containsKey(tempName)) {
                    if (setVariables.get(tempName) == null)
                        throw new Exception("Variable " + varName + " not yet assigned.");
                    sc.consume();
                    la = sc.lookahead().getTokenType();
                    //if we get here we have at least something like s=t but it may also be s=t+u;
                    //so if the next token is part of that "calculations set"
                    //then return the second variable name so we don't loose it and we can handle it later...
                    if (calculationSet.contains(la)) {
                        String setCalc = tempName, tempVar;
                        while (sc.lookahead().getTokenType() != Token.SEMICOLON || sc.lookahead().getTokenType() != Token.END)
                            if (la == Token.UNION) {
                                sc.consume();
                                if(sc.lookahead().getTokenType() == Token.ID)   {
                                    tempVar = "$" + setCalc + "v1";
                                    setCalc = tempVar + " = " + varName + ";\n";
                                    setCalc = setCalc + tempVar + " = " + varName + ".union(" + sc.lookahead().getTokenString() +");\n" + varName + " = " +tempVar + ";\n";
                                    return setCalc;
                                } else {//No ID Token to calculate from
                                    throw new Exception("Invalid calculation format");
                                }

                            } else if (la == Token.INTERSECTION) {

                            } else if (la == Token.COMPLEMENT) {

                            } else if (la == Token.SETDIFFERENCE) {

                            } else { //Not a calculation token we're set up to handle
                                throw new Exception("Unrecognized set calculation token.");
                            }
                        return setCalc;
                        //if it's a semi colon we have everything we need, so print. Yay!

                    }
                    else if (la == Token.SEMICOLON) {
                        System.out.println("        " + varName + " = " + tempName + ";");
                        sc.consume();
                        setVariables.put(varName, setVariables.get(tempName));
                        return "$";
                    }
                    else
                        throw new Exception("Semicolon expected");

                }
                //here, and I think this is a valid option, we have something like s=c
                //where c is a nat value.
                //so check that c is assigned and create a cofin based on that.
                else if (naturalVariables.containsKey(tempName)) {
                    if (naturalVariables.get(tempName) == null)
                        throw new Exception("Variable " + varName + " not yet assigned.");
                    sc.consume();
                    la = sc.lookahead().getTokenType();
                    if (la == Token.SEMICOLON) {
                        System.out.println("        " + varName + " = new CofinFin(false, " + tempName + ");");
                        setVariables.put(varName, new CofinFin(false, naturalVariables.get(tempName)));
                        sc.consume();
                        return "$";
                    }
                    else
                        throw new Exception("Semicolon Expected");

                }
                else
                    throw new Exception("Variable " + tempName + " not declared.");
            }
            //if we get to here we have s = ...something. It's not a var name and it's not a calculation
            //we're hoping it's either a list of values or cmp followed by a list of values
            String comp = "false";
            ArrayList<String> constructorValues= new ArrayList<String>();
            //check for cmp first
            if (la == Token.CMP) {
                comp = "true";
                sc.consume();
                la = sc.lookahead().getTokenType();
            }
            //check for left brace and a list
            if (la == Token.LEFTBRACE) {
                sc.consume();
                la = sc.lookahead().getTokenType();
                String curr;
                //while there are numbers in the list, add them to our constructor list
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
                //we expect a right brace and then semicolon
                if (la != Token.RIGHTBRACE)
                    throw new Exception("Right brace expected.");
                sc.consume();
                la = sc.lookahead().getTokenType();
                if (la != Token.SEMICOLON)
                    throw new Exception("Semicolon expected.");
                sc.consume();
                //if we get to here the assignment went well...print! Yay!
                //construclorValues is for the print statments
                //a if for our own internal tracking
                //if constructor values is null there was an empty list
                if (!constructorValues.isEmpty()) {
                    System.out.print("        int[] $" + varName + " = {");
                    int[] a = new int[constructorValues.size()];
                    for (int i = 0; i < constructorValues.size()-1; i++) {
                        System.out.print(constructorValues.get(i) + ", ");
                        a[i]=Integer.parseInt(constructorValues.get(i));
                    }
                    System.out.println(constructorValues.get(constructorValues.size()-1) + "};");
                    System.out.println("        " + varName + " = new CofinFin(" + comp + ", $" + varName + ");");
                    setVariables.put(varName, new CofinFin(Boolean.getBoolean(comp), a));
                    return "$"; //The dollar sign is an arbitrary return value just to say the assngment worked.
                    //if it's something else then something else happened...
                }
                else {
                    System.out.println("        " + varName + " = new CofinFin(" + comp + ", 0);");
                    setVariables.put(varName, new CofinFin(Boolean.getBoolean(comp), 0));
                    return "$";
                }

            }

        }
        //if we got to here something went wrong... I dunno what though...
        return "Something fishy...";

    }

    //takes the sc if its encountered a nat variable name but before the name has been consumed.
    //returns the sc after consuming the semicolon after the assignment.
    //mostly working as far as I know...

    private static void assignNat(String varName) throws Exception {
        String natValue;
        //get token after var name
        int la = sc.lookahead().getTokenType();
        //it should be assign...
        if (la == Token.ASSIGN) {
            sc.consume();
            la = sc.lookahead().getTokenType();
            //get the next token, it should be either a constant or another nat var
            if (la == Token.NATCONST)
                natValue =sc.lookahead().getTokenString();
            else if (la == Token.ID) {
                natValue = sc.lookahead().getTokenString();
                //if its an id it should be a declared and assigned nat value
                if (!naturalVariables.containsKey(natValue))
                    throw new Exception("Variable " + natValue + " not declared.");
                else if (naturalVariables.get(natValue) == null)
                    throw new Exception("Variable " + varName + " not yet assigned.");
            }
            else
                throw new Exception("Constant value expected.");
            //if we get to here we have had a var name, assigned to a constant or var so we can print
            System.out.println("        " + varName + " = " + natValue + ";");
            naturalVariables.put(varName, Integer.getInteger(natValue));
            sc.consume();
            la = sc.lookahead().getTokenType();
            //make sure there is a semicolon at the end
            if (la != Token.SEMICOLON)
                throw new Exception("Semicolon expected.");
            sc.consume();
            return;
        }
        else
            throw new Exception ("Assignment expected");

    }

    //at the end is the print statment.
    //We are either printing a previously declared and assigned var or the empty string
    //so we should get End then a var or {} then the . to end the program
    // the var may include calculations, I'm ignoring those for now...

    private static void doEnd() throws Exception {
        sc.consume();
        int la = sc.lookahead().getTokenType();
        if (la == Token.ID) {
            String varName = sc.lookahead().getTokenString();
            if(setVariables.containsKey(varName) && setVariables.get(varName) != null) {
                System.out.println("        System.out.println(" + varName + ".toString());");
            }
            else if (naturalVariables.containsKey(varName) && naturalVariables.get(varName) != null) {
                System.out.println("        System.out.println(" + varName + ");");
            }
            else
                throw new Exception("Variable " + varName + "may not have been declared or assigned.");
        }
        else if (la == Token.LEFTBRACE) {
            System.out.println("        System.out.println(new CofinFin());");
            sc.consume();
            if(sc.lookahead().getTokenType() != Token.RIGHTBRACE)
                throw new Exception("Right brace expected.");
        }
        else
            throw new Exception("Something else fishy...");

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
