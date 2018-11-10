package au.com.autogeneral.join.angapi.todo.transfer;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

/**
 * ToDoItemUpdateRequest
 */
@Value
@NonFinal
@FieldDefaults(makeFinal = false)
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemUpdateRequest {
    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")
    @Size(min = 1, max = 50)
    private String text = null;

    @ApiModelProperty(example = "true", value = "")
    private Boolean isCompleted = null;

}
