package au.com.autogeneral.join.angapi.todo.error;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItemNotFoundError
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItemNotFoundError {
    
    public static final String ERROR_NAME = "NotFoundError";

    @ApiModelProperty(value = "")
    private List<TodoItemNotFoundErrorDetails> details = null;

    @ApiModelProperty(example = "NotFoundError", value = "")
    private String name = null;

    public TodoItemNotFoundError addDetailsItem(TodoItemNotFoundErrorDetails detailsItem) {
        if (this.details == null) {
            this.details = new ArrayList<TodoItemNotFoundErrorDetails>();
        }
        this.details.add(detailsItem);
        return this;
    }
}
