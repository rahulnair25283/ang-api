package au.com.autogeneral.join.angapi.todo.service;

import java.math.BigDecimal;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItem;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemUpdateRequest;

/**
 * This service has methods that manage a todo list
 * 
 * @author rahulnair
 *
 */
public abstract class TodoService {

    /**
     * Creates a todo item
     * 
     * @param body
     *            the request object containing details of the todo item to be created
     * @return {@link TodoItem} the created todo item
     */
    public abstract TodoItem create(TodoItemAddRequest body);

    /**
     * Retrieves a todo item given the id of the item
     * 
     * @param id
     *            the unique id of the todo item
     * @return {@link TodoItem} the todo item
     * @throws NotFoundException
     *             thrown if a todo item with the given id is not found
     */
    public abstract TodoItem get(BigDecimal id) throws NotFoundException;

    /**
     * Updates a todo item given the id of the item and details to be updated
     * 
     * @param id
     *            the unique id of the todo item
     * @param body
     *            the request object containing details of the todo item to be updated
     * @return {@link TodoItem} the updated todo item
     * @throws NotFoundException
     *             thrown if a todo item with the given id is not found
     */
    public abstract TodoItem update(BigDecimal id, TodoItemUpdateRequest body)
            throws NotFoundException;
}
