package com.example.httpinterfacedemo.beans;

import com.example.httpinterfacedemo.TodoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeTest {

    private final TodoService todoService;


    public void someTest() {
        todoService.getTodos().forEach((todo) -> {
            System.out.println(todo.getId() + " " + todo.getUserId() + " " + todo.getTitle() + " " + todo.getCompleted());
        });
    }
}
