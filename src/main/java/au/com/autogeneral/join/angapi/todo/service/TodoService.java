package au.com.autogeneral.join.angapi.todo.service;

import java.math.BigDecimal;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItem;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemUpdateRequest;

public abstract class TodoService {

    public abstract TodoItem create(TodoItemAddRequest body);

    public abstract TodoItem get(BigDecimal id) throws NotFoundException;

    public abstract TodoItem update(BigDecimal id, TodoItemUpdateRequest body) throws NotFoundException;
}
