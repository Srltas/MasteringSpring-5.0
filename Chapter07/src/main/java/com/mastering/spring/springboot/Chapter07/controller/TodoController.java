package com.mastering.spring.springboot.Chapter07.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mastering.spring.springboot.Chapter07.bean.Todo;
import com.mastering.spring.springboot.Chapter07.bean.TodoNotFoundException;
import com.mastering.spring.springboot.Chapter07.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/users/{name}/todos")
	public List<Todo> retrieveTodos(@PathVariable String name) {
		return todoService.retrieveTodos(name);
	}
	
	@GetMapping("/users/{name}/todos/{id}")
	public EntityModel<Todo> retrieveTodo(@PathVariable String name, @PathVariable int id) {
		
		Todo todo = todoService.retrieveTodo(id);
		
		if (todo == null) {
			throw new TodoNotFoundException("Todo Not Found");
		}
		
		EntityModel<Todo> resource = EntityModel.of(todo);
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveTodos(name));
		resource.add(linkTo.withRel("parent"));
		
		return resource;
	}
	
	@PostMapping("/users/{name}/todos")
	ResponseEntity<?> add(@PathVariable String name, @Valid @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), todo.isDone());
		
		if (createdTodo == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/users/{name}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String name, @PathVariable int id, @RequestBody Todo todo) {
		todoService.update(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{name}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String name, @PathVariable int id) {
		Todo todo = todoService.deleteById(id);
		
		if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/users/dummy-service")
	public Todo errorService() {
		throw new RuntimeException("Some Exception Occured");
	}
}
