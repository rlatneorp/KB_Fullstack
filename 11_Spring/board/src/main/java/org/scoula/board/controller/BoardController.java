package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

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

    @GetMapping("/create")
    public void create() {
        log.info("create");
    }
    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("create: " + board);
//        service -> mapper.java -> mapper.xml
        service.create(board);
        return "redirect:/board/list";
    }

    @GetMapping({"/get","/update"}) // get과 update 경로를 둘 다 처리
    public void get(@RequestParam("no") Long no, Model model){ // @RequestParam:주소 뒤에 ? 를 붙여서 쿼리스트링으로 정보를 받아준다
        log.info("/get or update");
        // model 객체는 데이터를 뷰로 전달하기 위해 사용
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update: " + board);
        service.update(board);
//        수정한 후 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {
        log.info("delete... " + no);
        service.delete(no);
        return "redirect:/board/list";
    }

    @GetMapping("/download/{no}")
    @ResponseBody // view를 사용하지 않고, 직접 내보냄
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attach = service.getAttachment(no);
        File file = new File(attach.getPath());
        UploadFiles.download(response, file, attach.getFilename());
    }


}
