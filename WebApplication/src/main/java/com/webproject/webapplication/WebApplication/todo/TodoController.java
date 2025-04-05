package com.webproject.webapplication.WebApplication.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {


    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }
    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        //String username = getLoggedInUsername(model);
        String username = (String)model.get("name");
        List<Todo> todos =todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewTodo(ModelMap model){
        //String username = getLoggedInUsername(model);
        String username = (String)model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(0),false);
        model.put("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if (result.hasErrors()){
            return "addTodo";
        }
        String username = (String)model.get("name");
       // String username = getLoggedInUsername(model);
        todoService.addTodo(username, todo.getDescription(),todo.getDate(),false);
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todos")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping("update-todos")
    public String showUpdateTodo(@RequestParam int id,ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "update-todos", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if (result.hasErrors()){
            return "addTodo";
        }
        String username = (String)model.get("name");
 //       String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

//    private String getLoggedInUsername(ModelMap model) {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
}
