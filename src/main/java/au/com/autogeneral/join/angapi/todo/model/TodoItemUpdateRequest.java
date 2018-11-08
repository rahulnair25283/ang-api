package au.com.autogeneral.join.angapi.todo.model;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItemUpdateRequest
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItemUpdateRequest {
    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")
    @Size(min = 1, max = 50)
    private String text = null;

    @ApiModelProperty(example = "true", value = "")
    private Boolean isCompleted = null;

}
