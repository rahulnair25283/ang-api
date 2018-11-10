package au.com.autogeneral.join.angapi.todo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo_item")
public class TodoItem implements Serializable {
    
    private static final long serialVersionUID = -5496048890364952870L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;
    
    @Column
    private String text;
    
    @Column
    private Boolean isCompleted = Boolean.FALSE;
    
    @Column
    private Date createdAt = new Date();
    
    public TodoItem(String text) {
        this.text = text;
    }
}
