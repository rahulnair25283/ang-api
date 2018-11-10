package au.com.autogeneral.join.angapi.todo.service;

import au.com.autogeneral.join.angapi.todo.transfer.TodoItem;

/**
 * Maps between domain and transfer objects.
 * 
 * @author rahulnair
 *
 */
public class TodoItemMapper {

    /**
     * Maps from the {@link au.com.autogeneral.join.angapi.todo.domain.TodoItem} domain object to
     * the {@link TodoItem} transfer object
     * 
     * @param domainObject
     *            the object to be mapped from
     * @return {@link TodoItem} to object to be mapped to
     */
    public static TodoItem fromDomain(
            au.com.autogeneral.join.angapi.todo.domain.TodoItem domainObject) {
        return new TodoItem(domainObject.getId(), domainObject.getText(),
                domainObject.getIsCompleted(), domainObject.getCreatedAt().toString());
    }

}
