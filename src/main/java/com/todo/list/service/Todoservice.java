package com.todo.list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.todo.list.entity.Todo;
import com.todo.list.repository.TodoRepository;

@Service
public class Todoservice {

	private TodoRepository repository;

	public Todoservice(TodoRepository repository) {
		this.repository = repository;
	}

	public List<Todo> create(Todo todo) {
		repository.save(todo);
		return list();
	}

	public List<Todo> list() {
		Sort sort = Sort.by("prioridade").and(Sort.by("nome"));

		return repository.findAll(sort);
	}

	public List<Todo> update(Todo todo) {
		repository.save(todo);
		return list();

	}

	public List<Todo> delete(Long id) {
		repository.deleteById(id);
		return list();
	}

}
