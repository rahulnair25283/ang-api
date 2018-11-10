package au.com.autogeneral.join.angapi.tasks.service;

import java.util.Stack;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Validates an expression for balanced parenthesis
 * 
 * @author rahulnair
 *
 */
public class ExpressionValidator {

    /**
     * This method checks if the given and input expression has balanced parenthesis i.e. a closing
     * parenthesis for every open parenthesis
     * 
     * @param input
     *            the input expression containing parenthesis
     * @return true if the expression has balanced parenthesis, and false otherwise
     */
    public Boolean hasBalancedParenthesis(@NotNull @Size(min = 1, max = 100) String input) {

        if (input.length() == 1)
            return false;

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            char character = input.charAt(i);
            if (character == '{' || character == '(' || character == '[') {
                characterStack.push(character);
            }

            if (character == '}' || character == ')' || character == ']') {
                if (characterStack.isEmpty()) {
                    return false;
                }

                else if (!isMatchingPair(characterStack.pop(), character)) {
                    return false;
                }
            }
        }

        if (characterStack.isEmpty())
            return true;
        else {
            return false;
        }
    }

    private boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

}
