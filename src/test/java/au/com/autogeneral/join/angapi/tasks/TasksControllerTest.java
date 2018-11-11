package au.com.autogeneral.join.angapi.tasks;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import au.com.autogeneral.join.angapi.tasks.model.BalanceTestResult;
import au.com.autogeneral.join.angapi.tasks.service.TasksService;

@RunWith(SpringRunner.class)
@WebMvcTest(TasksController.class)
public class TasksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TasksService tasksService;

    @Test
    public void shouldValidateBrackets() throws Exception {

        String expression = "([()])";

        BalanceTestResult result = new BalanceTestResult(expression, true);
        given(tasksService.validateBrackets(expression)).willReturn(result);

        mockMvc.perform(get("/tasks/validateBrackets?input=" + expression))
                .andExpect(status().isOk()).andExpect(jsonPath("$.input", is(expression)))
                .andExpect(jsonPath("$.isBalanced", is(true)));
    }

    @Test
    public void shouldThrow400ErrorIfExpressionisGreaterThan100Characters() throws Exception {

        String expression = "(())()(()()() [[][[)]][[[][][]()[[[[[[[[]][[[[[]][[[[()()()()()()()()()()[[[]]][[[[]]]]]]]]][[[[[[[[[[][][][][]";

        mockMvc.perform(get("/tasks/validateBrackets?input=" + expression))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name", is("ValidationError")))
                .andExpect(jsonPath("$.details[0].location", is("params")))
                .andExpect(jsonPath("$.details[0].param", is("text")))
                .andExpect(jsonPath("$.details[0].msg", is("Must be between 1 and 100 chars long")))
                .andExpect(jsonPath("$.details[0].value", is("")));
    }

}
