package com.todo.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.list.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
