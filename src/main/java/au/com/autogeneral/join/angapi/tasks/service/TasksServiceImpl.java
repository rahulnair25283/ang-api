package au.com.autogeneral.join.angapi.tasks.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import au.com.autogeneral.join.angapi.tasks.model.BalanceTestResult;

@Service
public class TasksServiceImpl extends TasksService {

    private ExpressionValidator expressionValidator = new ExpressionValidator();

    @Override
    public BalanceTestResult validateBrackets(@NotNull @Size(min = 1, max = 100) String input) {
        return new BalanceTestResult(input, expressionValidator.hasBalancedParenthesis(input));
    }
}
