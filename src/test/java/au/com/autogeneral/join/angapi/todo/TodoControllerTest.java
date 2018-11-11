package au.com.autogeneral.join.angapi.todo;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

import au.com.autogeneral.join.angapi.exception.NotFoundException;
import au.com.autogeneral.join.angapi.todo.service.TodoService;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItem;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemAddRequest;
import au.com.autogeneral.join.angapi.todo.transfer.TodoItemUpdateRequest;

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
    public void shouldThrow400ErrorWhenCreatingATodoItemIfTextIsLongerThan50Characters()
            throws Exception {

        String text = "buy groceries and do more things so that the text length is more than 50 characters";

        TodoItemAddRequest body = new TodoItemAddRequest(text);
        given(todoService.create(body))
                .willReturn(new TodoItem(BigDecimal.ONE, text, false, new Date().toString()));

        mockMvc.perform(post("/todo").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(body))).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name", is("ValidationError")))
                .andExpect(jsonPath("$.details[0].location", is("params")))
                .andExpect(jsonPath("$.details[0].param", is("text")))
                .andExpect(jsonPath("$.details[0].msg", is("Must be between 1 and 50 chars long")))
                .andExpect(jsonPath("$.details[0].value", is("")));
    }

    @Test
    public void shouldGetATodoItem() throws Exception {

        BigDecimal id = BigDecimal.ONE;
        String now = new Date().toString();
        String text = "Buy milk";

        given(todoService.get(id)).willReturn(new TodoItem(id, text, false, now));

        mockMvc.perform(get("/todo/" + id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.text", is(text)))
                .andExpect(jsonPath("$.isCompleted", is(false)))
                .andExpect(jsonPath("$.createdAt", is(now)));
    }

    @Test
    public void shouldThrow404ErrorWhenGettingATodoItemIfTheItemIsNotFound() throws Exception {

        BigDecimal id = BigDecimal.ONE;

        given(todoService.get(id)).willThrow(NotFoundException.class);

        mockMvc.perform(get("/todo/" + id)).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name", is("NotFoundError")))
                .andExpect(jsonPath("$.details[0].message", is("Item not found")));
    }

    @Test
    public void shouldUpdateATodoItem() throws Exception {

        BigDecimal id = BigDecimal.ONE;
        String text = "Buy milk";
        String now = new Date().toString();

        TodoItemUpdateRequest body = new TodoItemUpdateRequest(text, true);
        given(todoService.update(id, body)).willReturn(new TodoItem(id, text, true, now));

        mockMvc.perform(patch("/todo/" + id).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(body))).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.text", is(text)))
                .andExpect(jsonPath("$.isCompleted", is(true)))
                .andExpect(jsonPath("$.createdAt", is(now)));
    }

    @Test
    public void shouldThrow400ErrorWhenUpdatingATodoItemIfTextIsLongerThan50Characters()
            throws Exception {

        BigDecimal id = BigDecimal.ONE;

        TodoItemUpdateRequest body = new TodoItemUpdateRequest(
                "Buy milk but also do other things like increasing the text length to more than 50 characters",
                false);

        mockMvc.perform(patch("/todo/" + id).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(body))).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name", is("ValidationError")))
                .andExpect(jsonPath("$.details[0].location", is("params")))
                .andExpect(jsonPath("$.details[0].param", is("text")))
                .andExpect(jsonPath("$.details[0].msg", is("Must be between 1 and 50 chars long")))
                .andExpect(jsonPath("$.details[0].value", is("")));
    }

    @Test
    public void shouldThrow404ErrorWhenUpdatingATodoItemIfTheItemIsNotFound() throws Exception {

        BigDecimal id = BigDecimal.ONE;
        TodoItemUpdateRequest body = new TodoItemUpdateRequest("Buy milk", true);

        given(todoService.update(id, body)).willThrow(NotFoundException.class);

        mockMvc.perform(patch("/todo/" + id).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(body))).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name", is("NotFoundError")))
                .andExpect(jsonPath("$.details[0].message", is("Item not found")));
    }
}
