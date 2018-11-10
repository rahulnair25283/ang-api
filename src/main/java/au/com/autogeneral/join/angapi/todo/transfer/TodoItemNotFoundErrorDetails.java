package au.com.autogeneral.join.angapi.todo.transfer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItemNotFoundErrorDetails
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItemNotFoundErrorDetails {
    @ApiModelProperty(value = "")
    private String message = null;
}
