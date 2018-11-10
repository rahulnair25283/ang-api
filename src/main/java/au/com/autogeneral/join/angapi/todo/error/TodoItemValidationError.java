package au.com.autogeneral.join.angapi.todo.error;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItemValidationError
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItemValidationError {

    public static final String ERROR_NAME = "ValidationError";

    @ApiModelProperty(value = "")
    private List<TodoItemValidationErrorDetails> details = null;

    @ApiModelProperty(example = "ValidationError", value = "")
    private String name = null;

    public TodoItemValidationError addDetailsItem(TodoItemValidationErrorDetails detailsItem) {
        if (this.details == null) {
            this.details = new ArrayList<TodoItemValidationErrorDetails>();
        }
        this.details.add(detailsItem);
        return this;
    }
}
