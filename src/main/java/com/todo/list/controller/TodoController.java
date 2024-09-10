package com.todo.list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.list.entity.Todo;
import com.todo.list.service.Todoservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private Todoservice todoservice;

	@PostMapping
	ResponseEntity<List<Todo>> created(@Valid @RequestBody Todo todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(todoservice.create(todo));
	}

	@GetMapping
	List<Todo> list() {
		return todoservice.list();
	}

	@PutMapping("{id}")
	List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
		return todoservice.update(id, todo);
	}

	@DeleteMapping("{id}")
	List<Todo> delete(@PathVariable Long id) {
		return todoservice.delete(id);
	}
}
