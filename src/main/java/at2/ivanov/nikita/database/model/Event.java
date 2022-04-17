package at2.ivanov.nikita.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Table(name="event")
@ToString(exclude = "todoList")
@EqualsAndHashCode(exclude = "todoList")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    @Size(max = 50)
    private String name;

    @Column(name = "description")
    @Size(max=200)
    @NotEmpty
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private EventType type;

    @Column(name = "done")
    private Boolean done = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    private TodoList todoList;
}
