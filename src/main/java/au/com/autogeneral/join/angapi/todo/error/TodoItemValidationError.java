package au.com.autogeneral.join.angapi.todo.error;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoItemValidationError
 */
public class TodoItemValidationError {
    @JsonProperty("details")
    private List<TodoItemValidationErrorDetails> details = null;

    @JsonProperty("name")
    private String name = null;

    public TodoItemValidationError details(List<TodoItemValidationErrorDetails> details) {
        this.details = details;
        return this;
    }

    public TodoItemValidationError addDetailsItem(TodoItemValidationErrorDetails detailsItem) {
        if (this.details == null) {
            this.details = new ArrayList<TodoItemValidationErrorDetails>();
        }
        this.details.add(detailsItem);
        return this;
    }

    /**
     * Get details
     * 
     * @return details
     **/
    @JsonProperty("details")
    @ApiModelProperty(value = "")
    public List<TodoItemValidationErrorDetails> getDetails() {
        return details;
    }

    public void setDetails(List<TodoItemValidationErrorDetails> details) {
        this.details = details;
    }

    public TodoItemValidationError name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    @JsonProperty("name")
    @ApiModelProperty(example = "ValidationError", value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoItemValidationError toDoItemValidationError = (TodoItemValidationError) o;
        return Objects.equals(this.details, toDoItemValidationError.details)
                && Objects.equals(this.name, toDoItemValidationError.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ToDoItemValidationError {\n");

        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
