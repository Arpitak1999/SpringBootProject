package com.webproject.webapplication.WebApplication.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private  static int todosCount=0;

    static {
        todos.add(new Todo(++todosCount, "Learn","DSA", LocalDate.now().plusYears(0),false));
        todos.add(new Todo(++todosCount, "Learn2","Java", LocalDate.now().plusYears(0),false));
        todos.add(new Todo(++todosCount, "Learn3","Springboot", LocalDate.now().plusYears(0),false));
        todos.add(new Todo(++todosCount, "Learn4","Linux", LocalDate.now().plusYears(0),false));

    }

    public static List<Todo> findByUsername(String username) {
//        Predicate<? super Todo> predicate = todo ->  todo.getUsername().equalsIgnoreCase(username);
//        return todos.stream().filter(predicate).toList();
        return todos;
    }
    public void addTodo(String username, String description, LocalDate date, boolean done) {
       Todo todo = new Todo(++todosCount,username,description,date,done);
       todos.add(todo);
    }
    public void deleteById(int id) {
    //Lambda expression todo ->  todo.getId() ==id;
        Predicate<? super Todo> predicate = todo ->  todo.getId() ==id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo ->  todo.getId() ==id;
         Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
