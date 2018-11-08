package au.com.autogeneral.join.angapi.tasks.service;

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
        return null;
    }

}
