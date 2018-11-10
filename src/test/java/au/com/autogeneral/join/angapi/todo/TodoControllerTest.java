package au.com.autogeneral.join.angapi.todo;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.autogeneral.join.angapi.todo.service.TodoService;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItem;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemAddRequest;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TodoService todoService;

    @Test
    public void shouldCreateATodoItem() throws Exception {

        Date now = new Date();
        String text = "buy groceries";

        TodoItemAddRequest body = new TodoItemAddRequest(text);
        given(todoService.create(body))
                .willReturn(new TodoItem(BigDecimal.ONE, text, false, now.toString()));

        mockMvc.perform(post("/todo").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(body))).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.text", is(text)))
                .andExpect(jsonPath("$.isCompleted", is(false)))
                .andExpect(jsonPath("$.createdAt", is(now.toString())));

    }

    @Test
    public void shouldThrow400ErrorIfTodoItemTextIsLongerThan50Characters() throws Exception {

        String text = "buy groceries and do more things so that the text length is more than 50 characters";

        TodoItemAddRequest body = new TodoItemAddRequest(text);
        given(todoService.create(body))
                .willReturn(new TodoItem(BigDecimal.ONE, text, false, new Date().toString()));

        mockMvc.perform(post("/todo").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(body))).andExpect(status().isBadRequest());
    }

}
