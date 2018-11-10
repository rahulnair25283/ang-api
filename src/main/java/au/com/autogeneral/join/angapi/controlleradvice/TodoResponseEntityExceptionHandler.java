package au.com.autogeneral.join.angapi.controlleradvice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.collect.Lists;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemNotFoundError;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemNotFoundErrorDetails;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemValidationError;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemValidationErrorDetails;

/**
 * Centralized exception handler that extends {@link ResponseEntityExceptionHandler}.
 * 
 * @author rahulnair
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class TodoResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleTodoNotFoundException(Exception ex,
            WebRequest request) {

        TodoItemNotFoundError error = new TodoItemNotFoundError(
                Lists.newArrayList(new TodoItemNotFoundErrorDetails("Item not found.")),
                TodoItemNotFoundError.ERROR_NAME);

        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        TodoItemValidationError error = new TodoItemValidationError(
                Lists.newArrayList(new TodoItemValidationErrorDetails("params", "text",
                        "Must be between 1 and 50 chars long", "")),
                TodoItemValidationError.ERROR_NAME);

        return new ResponseEntity<Object>(error, status);
    }

}
