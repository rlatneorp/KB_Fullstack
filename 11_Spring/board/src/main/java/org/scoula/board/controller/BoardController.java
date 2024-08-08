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
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }



}
