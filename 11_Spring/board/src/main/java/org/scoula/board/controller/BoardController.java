package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@RequestMapping("/board") // url 공통주소 할당
@RequiredArgsConstructor // 생성자 주입
public class BoardController {

    final private BoardService service;

    // return 값이 void기 때문에 뷰도 경로가 동일(board/list)
    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
//        Model의 속성에 데이터를 담을 경우 뷰로 전달 가능
        model.addAttribute("list", service.getList());
    }



}
