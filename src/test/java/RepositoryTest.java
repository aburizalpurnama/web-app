//import com.rizalpurnama.todolist.entity.TodoList;
//import com.rizalpurnama.todolist.helper.DatabaseHelper;
//import com.rizalpurnama.todolist.repository.TodolistRepository;
//import com.rizalpurnama.todolist.repository.TodolistRepositoryImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Array;
//import java.util.Arrays;
//import java.util.List;
//
//public class RepositoryTest {
//
//    TodolistRepository todolistRepository;
//
//    @BeforeEach
//    void setUp() {
//        todolistRepository = new TodolistRepositoryImpl(DatabaseHelper.connect());
//    }
//
//    @Test
//    void testGetAll() {
//        List<TodoList> espectedList = Arrays.asList(
//                new TodoList(1, "Memancing"),
//                new TodoList(2, "Memandangmu")
//        );
//
//        Assertions.assertEquals(espectedList, todolistRepository.getAll());
//
//    }
//}
