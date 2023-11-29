package Lab3Calculator.calculatorIntelliJ.src;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Double.NaN;
import static java.lang.Math.pow;
import static java.lang.System.*;


/*
 *   A calculator for rather simple arithmetic expressions
 *
 *   This is not the program, it's a class declaration (with methods) in it's
 *   own file (which must be named Calculator.java)
 *
 *   NOTE:
 *   - No negative numbers implemented
 */
public class Calculator {
    // Here are the only allowed instance variables!
    // Error messages (more on static later)
    final static String MISSING_OPERAND = "Missing or bad operand";
    final static String DIV_BY_ZERO = "Division with 0";
    final static String MISSING_OPERATOR = "Missing operator or parenthesis";
    final static String OP_NOT_FOUND = "Operator not found";

    // Definition of operators
    final static String OPERATORS = "+-*/^";
    final static String NUMBERS = "1234567890";

    private Stack<String> stack;
    private List<String> postfix;
    // Method used in REPL
    double eval(String expr) {
        if (expr.length() == 0) {
            return NaN;
        }
        List<String> tokens = tokenize(expr);
        List<String> postfix = i2p(tokens);
        return evalPostfix(postfix);
    }

    // ------  Evaluate RPN expression -------------------

    double evalPostfix(List<String> postfix) {
        Stack<Double> stock = new Stack<>();

        for(String s : postfix){
            try{
                stock.push(Double.parseDouble(s));
            }
            catch (NumberFormatException e){
                if(stock.size() > 1) {
                    stock.push(applyOperator(s, stock.pop(), stock.pop()));
                }
            }
        }
        if(stock.size() > 1){
            throw new IllegalArgumentException("ladskfj");
        }
        return stock.peek();
    }

    double applyOperator(String op, double d1, double d2) {
        switch (op) {
            case "+":
                return d1 + d2;
            case "-":
                return d2 - d1;
            case "*":
                return d1 * d2;
            case "/":
                if (d1 == 0) {
                    throw new IllegalArgumentException(DIV_BY_ZERO);
                }
                return d2 / d1;
            case "^":
                return pow(d2, d1);
        }
        throw new RuntimeException(OP_NOT_FOUND);
    }

    public boolean isOP(String op){
        if(OPERATORS.contains(op)){
            return true;
        }
        return false;
    }

    // ------- Infix 2 Postfix ------------------------

    public boolean isHigherPrecedence(String op, String stackOp){
        return (isLeftAssoc(op) && getPrecedence(op) <= getPrecedence(stackOp) ||
                (isRightAssoc(op) && getPrecedence(op) < getPrecedence(stackOp)));
    }
    public boolean isLeftAssoc(String op){
        return getAssociativity(op) == Assoc.LEFT;
    }
    public boolean isRightAssoc(String op){
        return getAssociativity(op) == Assoc.RIGHT;
    }
    public boolean isLBracket(String op){
        return "(".equals(op);
    }

    public void krobban(String s){
        while(!this.stack.isEmpty() && isOP(stack.peek()) && isHigherPrecedence(s, stack.peek())){
            this.postfix.add(this.stack.pop());
        }
    }

    List<String> i2p(List<String> infix){
        this.stack = new Stack<>();
        this.postfix = new LinkedList<>();

        for(String s : infix){
            if(isOP(s)){
                krobban(s);
                stack.push(s);
            }
            else if(isLBracket(s)){
                stack.push(s);
            }
            else if(s.equals(")")){
                while(!stack.isEmpty() && !isLBracket(stack.peek())){
                    postfix.add(stack.pop());
                }
                stack.remove(stack.lastIndexOf("("));
            }
            else{
                postfix.add(s);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek().equals("(")){
                throw new IllegalArgumentException("INVALID EXPRESSION");
            }
            postfix.add(stack.pop());
        }
//        out.println(stack.toString());
//        out.println(postfix.toString());
        return postfix;
    }

    int getPrecedence(String op) {
        if ("+-".contains(op)) {
            return 2;
        } else if ("*/".contains(op)) {
            return 3;
        } else if ("^".contains(op)) {
            return 4;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }
    Assoc getAssociativity(String op) {
        if ("+-*/".contains(op)) {
            return Assoc.LEFT;
        } else if ("^".contains(op)) {
            return Assoc.RIGHT;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    enum Assoc {
        LEFT,
        RIGHT
    }
    // ---------- Tokenize -----------------------
    // List String (not char) because numbers (with many chars)
    List<String> tokenize(String expr) {
        String[] arr = (expr.replaceAll(" ","")).split("");  // trims the spaces of each object and splits the acquired string
        List<String> res = new LinkedList<String>();
        StringBuilder tmp = new StringBuilder();    // tmp is used to make numbers of any size

        for (int i = 0; i < arr.length; i++) {
            if (NUMBERS.contains(arr[i])) {
                tmp.append(arr[i]);   // used to make longer numbers
            } else {
                if (!tmp.isEmpty()) {   // when a long number has ended, it gets added
                    res.add(tmp.toString());
                    tmp = new StringBuilder();
                }
                if (!arr[i].equals(" ")) {
                    res.add(arr[i]); // just adds everything else
                }
            }
        }
        // Adds tmp if last char is a number.
        if(!tmp.isEmpty()) {
            res.add(tmp.toString());
        }
        return res;
    }
}
