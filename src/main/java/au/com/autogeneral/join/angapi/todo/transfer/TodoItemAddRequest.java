package au.com.autogeneral.join.angapi.todo.transfer;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItemAddRequest
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItemAddRequest {

    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")
    @Size(min = 1, max = 50)
    private String text = null;
}
