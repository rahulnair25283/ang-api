package au.com.autogeneral.join.angapi.tasks.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExpressionValidatorTest {

    private ExpressionValidator expressionValidator = new ExpressionValidator();

    @Test
    public void shouldReturnTrueIfExpressionHasBalancedParenthesis() {
        assertThat(expressionValidator.hasBalancedParenthesis("{[({[]})]}"), is(true));
    }
    
    @Test
    public void shouldReturnFalseIfExpressionHasUnbalancedParenthesis() {
        assertThat(expressionValidator.hasBalancedParenthesis("{[({[]]}"), is(false));
    }

}
