package au.com.autogeneral.join.angapi.tasks.service;

import java.util.Stack;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.tasks.model.BalanceTestResult;

@Service
public class TasksServiceImpl extends TasksService {

    @Override
    public BalanceTestResult validateBrackets(@NotNull @Size(min = 1, max = 100) String input)
            throws NotFoundException {
        return new BalanceTestResult(input, isParenthesisMatch(input));
    }

    private Boolean isParenthesisMatch(String input) {
        if (input.charAt(0) == '{')
            return false;

        Stack<Character> stack = new Stack<Character>();

        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);

            if (c == '(')
                stack.push(c);
            else if (c == '{')
                stack.push(c);
            else if (c == ')')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            else if (c == '}')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
        }
        
        return stack.empty();
    }

}
