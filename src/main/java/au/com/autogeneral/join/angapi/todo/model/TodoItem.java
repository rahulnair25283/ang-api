package au.com.autogeneral.join.angapi.todo.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * ToDoItem
 */
@Value
@FieldDefaults(makeFinal = false)
@AllArgsConstructor
public class TodoItem {

    @ApiModelProperty(example = "42.0", value = "")
    private BigDecimal id = null;

    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")
    private String text = null;

    @ApiModelProperty(example = "false", value = "")
    private Boolean isCompleted = null;

    @ApiModelProperty(example = "2017-10-13T01:50:58.735Z", value = "")
    private String createdAt = null;
}
