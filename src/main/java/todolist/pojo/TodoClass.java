package todolist.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="todolist")
public class TodoClass {

    @Id
    private final ObjectId id;
    private final String todo;

    public TodoClass(ObjectId id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }
}
