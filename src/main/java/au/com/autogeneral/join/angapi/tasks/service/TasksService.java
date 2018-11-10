package au.com.autogeneral.join.angapi.tasks.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.tasks.model.BalanceTestResult;

/**
 * This service has a method that validates brackets in an expression.
 * 
 * @author rahulnair
 *
 */
public abstract class TasksService {

    public abstract BalanceTestResult validateBrackets(
            @NotNull @Size(min = 1, max = 100) String input) throws NotFoundException;
}
