package au.com.autogeneral.join.angapi.todo.domain;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepo extends CrudRepository<TodoItem, BigDecimal> {
}
