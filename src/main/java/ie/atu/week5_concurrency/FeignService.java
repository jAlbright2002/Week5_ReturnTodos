package ie.atu.week5_concurrency;

import org.apache.commons.io.input.TaggedInputStream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeignService {

    private final TodoClient todoClient;

    public FeignService(TodoClient todoClient) {
        this.todoClient = todoClient;
    }



    public TodoResponse fetchData() {
        ArrayList<TodoResponse> todos = todoClient.fetchData();
        System.out.println(todos);
        TodoResponse todoResponse = new TodoResponse();
        for (TodoResponse todo : todos) {
            if (todo.getId() == 196) {
                System.out.println("Found matching id in " + todo.toString());
                todoResponse = todo;
                break;
            }
        }

        return todoResponse;
    }

}
