package au.com.autogeneral.join.angapi.todo.transfer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItemValidationErrorDetails
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItemValidationErrorDetails {

    @ApiModelProperty(value = "")
    private String location = null;

    @ApiModelProperty(value = "")
    private String param = null;

    @ApiModelProperty(value = "")
    private String msg = null;

    @ApiModelProperty(value = "")
    private String value = null;
}