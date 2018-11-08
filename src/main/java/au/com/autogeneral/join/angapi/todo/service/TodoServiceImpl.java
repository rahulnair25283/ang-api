package au.com.autogeneral.join.angapi.todo.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.model.TodoItem;
import au.com.autogeneral.join.angapi.todo.model.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.model.TodoItemUpdateRequest;

@Service
public class TodoServiceImpl extends TodoService {

    @Override
    public TodoItem create(TodoItemAddRequest body) throws NotFoundException {
        return new TodoItem(BigDecimal.ONE, "hello", false, new Date().toString());
    }

    @Override
    public TodoItem get(BigDecimal id) throws NotFoundException {
        return new TodoItem(BigDecimal.ONE, "hello", false, new Date().toString());
    }

    @Override
    public TodoItem update(TodoItemUpdateRequest body) throws NotFoundException {
        return null;
    }

}
