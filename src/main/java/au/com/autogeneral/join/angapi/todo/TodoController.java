package au.com.autogeneral.join.angapi.todo;

import java.math.BigDecimal;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.error.TodoItemNotFoundError;
import au.com.autogeneral.join.angapi.todo.error.TodoItemValidationError;
import au.com.autogeneral.join.angapi.todo.model.TodoItemUpdateRequest;
import au.com.autogeneral.join.angapi.todo.model.TodoItem;
import au.com.autogeneral.join.angapi.todo.model.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/todo")
@Api(value = "todo", description = "To Do List endpoints")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a to do item", notes = "", response = TodoItem.class, tags = {
            "todo", })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = TodoItem.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Validation error", response = TodoItemValidationError.class) })
    @ResponseBody
    public TodoItem create(
            @ApiParam(value = "", required = true) RequestEntity<TodoItemAddRequest> requestEntity)
            throws NotFoundException {
        return todoService.create(requestEntity.getBody());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a specific item by id", notes = "", response = TodoItem.class, tags = {
            "todo", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = TodoItem.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Validation error", response = TodoItemValidationError.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found Error", response = TodoItemNotFoundError.class) })
    @ResponseBody
    public TodoItem get(@ApiParam(value = "id", required = true) @PathVariable("id") BigDecimal id)
            throws NotFoundException {
        return todoService.get(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modify an item", notes = "", response = TodoItem.class, tags = {
            "todo", })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = TodoItem.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Validation error", response = TodoItemValidationError.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found Error", response = TodoItemNotFoundError.class) })
    public TodoItem todoIdPatch(
            @ApiParam(value = "id", required = true) @PathParam("id") BigDecimal id,
            @ApiParam(value = "", required = true) RequestEntity<TodoItemUpdateRequest> requestEntity)
            throws NotFoundException {
        return todoService.update(requestEntity.getBody());
    }
}
