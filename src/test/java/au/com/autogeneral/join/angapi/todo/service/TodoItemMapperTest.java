package au.com.autogeneral.join.angapi.todo.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import au.com.autogeneral.join.angapi.todo.domain.TodoItem;

@RunWith(MockitoJUnitRunner.class)
public class TodoItemMapperTest {

    @Test
    public void shouldMapFromDomain() {
        
        String text = "Buy milk";
        Date createdAt = new Date();

        assertThat(TodoItemMapper.fromDomain(new TodoItem(BigDecimal.ONE, text, false, createdAt)),
                is(new au.com.autogeneral.join.angapi.todo.transfer.TodoItem(BigDecimal.ONE, text,
                        false, createdAt.toString())));
    }

}
