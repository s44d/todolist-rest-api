package todolist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todolist.db.MongoDao;
import todolist.pojo.TodoClass;

import java.util.List;

@RestController
public class TodoController {

    @RequestMapping("/todo/getall")
    public List<TodoClass> getAllTodo(){
        List<TodoClass> todoList = MongoDao.getAll();
        return todoList;
    }

    @RequestMapping(value = "/todo/add/{todo}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@PathVariable String todo){
        MongoDao.add(todo);
    }

}
