package todolist.db;

import org.bson.types.ObjectId;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import todolist.pojo.TodoClass;

import java.util.ArrayList;
import java.util.List;


public class MongoDao {

    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static MongoOperations mongoOps = (MongoOperations) context.getBean("mongoTemplate");

    public static final String TODOLIST_COLLECTION = "todolist";

    public static List<TodoClass> getAll(){
        List<TodoClass> list = new ArrayList<TodoClass>();
        list = mongoOps.findAll(TodoClass.class,TODOLIST_COLLECTION);
        return list ;
    }

    public static void add(String todo){
        TodoClass todoClass = new TodoClass(new ObjectId(),todo);
        mongoOps.insert(todoClass);
    }
}
