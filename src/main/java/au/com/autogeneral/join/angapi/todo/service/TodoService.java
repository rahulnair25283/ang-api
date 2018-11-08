package au.com.autogeneral.join.angapi.todo.service;

import java.math.BigDecimal;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.model.TodoItem;
import au.com.autogeneral.join.angapi.todo.model.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.model.TodoItemUpdateRequest;

public abstract class TodoService {

    public abstract TodoItem create(TodoItemAddRequest body) throws NotFoundException;

    public abstract TodoItem get(BigDecimal id) throws NotFoundException;

    public abstract TodoItem update(TodoItemUpdateRequest body) throws NotFoundException;
}
