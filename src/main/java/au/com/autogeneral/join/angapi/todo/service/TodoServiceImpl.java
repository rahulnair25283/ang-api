package au.com.autogeneral.join.angapi.todo.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.domain.TodoItem;
import au.com.autogeneral.join.angapi.todo.domain.TodoItemRepo;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemUpdateRequest;

@Service
public class TodoServiceImpl extends TodoService {

    @Autowired
    private TodoItemRepo todoItemRepo;

    @Override
    public au.com.autogeneral.join.angapi.todo.transfer.TodoItem create(TodoItemAddRequest body) {
        return TodoItemMapper.fromDomain(todoItemRepo.save(new TodoItem(body.getText())));
    }

    @Override
    public au.com.autogeneral.join.angapi.todo.transfer.TodoItem get(BigDecimal id)
            throws NotFoundException {
        try {
            TodoItem todoItem = todoItemRepo.findById(id).get();
            return TodoItemMapper.fromDomain(todoItem);

        } catch (NoSuchElementException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public au.com.autogeneral.join.angapi.todo.transfer.TodoItem update(BigDecimal id,
            TodoItemUpdateRequest body) throws NotFoundException {
        try {
            TodoItem todoItem = todoItemRepo.findById(id).get();

            todoItem.setText(body.getText());
            todoItem.setIsCompleted(body.getIsCompleted());

            todoItem = todoItemRepo.save(todoItem);
            return TodoItemMapper.fromDomain(todoItem);
        } catch (NoSuchElementException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
