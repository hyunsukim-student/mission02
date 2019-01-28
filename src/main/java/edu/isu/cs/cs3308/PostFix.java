package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.LinkedStack;
import sun.awt.image.ImageWatched;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {

    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param postfix A string representing an postfix notation expression where
     * each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */

    public static int evalPostFix(String infix) {
        LinkedStack stack = new LinkedStack();
        if(infix == null){
            return 0;
        }else{
            for(int i = 0; i < infix.length(); i++){
                char a = infix.charAt(i);
                if((a == '^') || (a == '*') || (a == '/') || (a == '+') || (a == '-')){
                    int b =evalOperator((int)stack.pop(), (int)stack.pop(), a);
                    stack.push(b);
                }else if ((a >= '0') || (a <= '9'))
                {
                    stack.push((int)(a - '0'));
                }
            }
            return (int)stack.pop();
        }
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    private static int evalOperator(int val1, int val2, char val3)
    {
        switch (val3)
        {
            case '+':
                return val2 + val1;
            case '-':
                return val2 - val1;
            case '*':
                return val2 * val1;
            case '/':
                return val2 / val1;
            case '^':
                return val2 ^ val1;
            default:
                return -1;
        }
    }
}
