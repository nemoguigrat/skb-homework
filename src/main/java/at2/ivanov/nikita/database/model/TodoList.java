package at2.ivanov.nikita.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "todo_list")
@NoArgsConstructor
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    @Size(max = 50)
    private String name;

    @OneToMany(mappedBy = "todoList", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Event> events = new HashSet<>();
}
