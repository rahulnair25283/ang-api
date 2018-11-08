package au.com.autogeneral.join.angapi.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.tasks.model.BalanceTestResult;
import au.com.autogeneral.join.angapi.tasks.service.TasksService;
import au.com.autogeneral.join.angapi.todo.error.TodoItemValidationError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tasks")
@Api(value = "tasks", description = "General algorithmic tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @RequestMapping(path = "/validateBrackets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Checks if brackets in a string are balanced", notes = "Brackets in a string are considered to be balanced if the following criteria are met: - For every opening bracket (i.e., **`(`**, **`{`**, or **`[`**), there is a matching closing bracket (i.e., **`)`**, **`}`**, or **`]`**) of the same type (i.e., **`(`** matches **`)`**, **`{`** matches **`}`**, and **`[`** matches **`]`**). An opening bracket must appear before (to the left of) its matching closing bracket. For example, **`]{}[`** is not balanced. - No unmatched braces lie between some pair of matched bracket. For example, **`({[]})`** is balanced, but **`{[}]`** and **`[{)]`** are not balanced.", response = BalanceTestResult.class, tags = {
            "tasks", })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = BalanceTestResult.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Validation error", response = TodoItemValidationError.class) })
    public BalanceTestResult tasksValidateBracketsGet(
            @ApiParam(value = "Input string (max length 100)", required = true) @RequestParam("input") String input)
            throws NotFoundException {
        return tasksService.validateBrackets(input);
    }
}
