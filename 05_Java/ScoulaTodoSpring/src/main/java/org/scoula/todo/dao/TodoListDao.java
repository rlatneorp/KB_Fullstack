package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListDao implements TodoDao {
    private static TodoListDao instance = new TodoListDao();

    public static TodoDao getInstance() {
        return instance;
    }
    private List<Todo> list;
    private TodoListDao() {
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++){ // 임시 테스트 데이터 구성
            Todo todo = Todo.builder()
                    .title("Todo " + i)
                    .description("Description " + i)
                    .done(false)
                    .build();
            list.add(todo);
        }
    }
    @Override
    public List<Todo> getList() {
        return list;
    }
    @Override
    public Todo getTodo
            (int id) {
        for(Todo todo : list){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }
    @Override
    public void add(Todo todo) {
        list.add(todo);
    }
    @Override
    public void update(Todo todo) {
        for(int i = 0; i< list.size();i++){
            if(todo.getId() == list.get(i).getId()){
                list.set(i, todo);
            }
        }
    }
    @Override
    public void delete(int id) {
        for(int i = 0; i < list.size(); i++){
            if(list.get( i).getId() == id){
                list.remove(i);
                return;
            }
        }
    }
}