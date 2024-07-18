package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;

public class TodoService {
    TodoDao dao = TodoListDao.getInstance();

    public void printTodoList() {
        for(Todo todo: dao.getList()) {
//            todo의 ID는 gid로 객체 생성시 1씩 더해서 삽입해줌
            String line = "%2d] %s".formatted(todo.getId(), todo.getTitle());
            System.out.println(line);
        }
        System.out.println();
    }

    public void detaillTodo() {
//        사용자에게 찾을 todo의 id 입력 받기
        int id = Input.getInt("Todo Id: ");
//        사용자에게 받은 id로 해당 todo 찾기
        Todo todo = dao.getTodo(id);
//        찾아온 todo의 상세정보 출력
        System.out.println("[Todo 상세보기]---------------------------------");
        System.out.println("ID : " + todo.getId());
        System.out.println("제목 : " + todo.getTitle());
        System.out.println("설명 : " + todo.getDescription());
        System.out.println("완료여부: " + todo.isDone());
        System.out.println("등록일 : " + todo.getRegDate());
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public void addTodo() {
        System.out.println("[새 Todo 추가]---------------------------------");
        String title = Input.getLine("제목: ");
        String description = Input.getLine("설명: ");
        System.out.println("----------------------------------------------");

        Todo todo = Todo.builder()
                .title(title)
                .description(description)
                .done(false)
                .build();
        dao.add(todo);

        System.out.println();
    }

    public void updateTodo() {
        int id = Input.getInt("수정할 Id: ");
        Todo todo = dao.getTodo(id);
        System.out.println("[Todo 수정하기]---------------------------------");
        System.out.println("ID : " + todo.getId());
        String title = Input.getLine("제목", todo.getTitle());
        String description = Input.getLine("설명", todo.getDescription());
        Boolean done = Input.confirm("완료여부", todo.isDone());
        System.out.println("----------------------------------------------");
        System.out.println();

        Todo updateTodo = (Todo)todo.clone();
        updateTodo.setTitle(title);
        updateTodo.setDescription(description);
        updateTodo.setDone(done);

        dao.update(updateTodo);
    }

    public void deleteTodo() {
//        사용자에게 삭제할 todo의 아이디 입력받기
        int id = Input.getInt("삭제할 Todo Id: ");
//        해당하는 id의 todo를 목록에서 삭제
        dao.delete(id);
        System.out.println();
    }
}