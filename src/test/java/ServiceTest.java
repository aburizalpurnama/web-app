import com.rizalpurnama.todolist.entity.TodoList;
import com.rizalpurnama.todolist.repository.TodolistRepository;
import com.rizalpurnama.todolist.repository.TodolistRepositoryImpl;
import com.rizalpurnama.todolist.service.TodolistServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ServiceTest {
    @Test
    void testShowTodoList() {
        TodolistRepository repository = Mockito.mock(TodolistRepositoryImpl.class);
        Mockito.when(repository.getAll()).thenReturn(Arrays.asList(
                new TodoList(1, "Mancing"),
                new TodoList(2, "Minum")
        ));

        TodolistServiceImpl todolistService = new TodolistServiceImpl(repository);

        todolistService.showTodoList();

        Mockito.verify(repository, Mockito.times(1)).getAll();

    }
}
