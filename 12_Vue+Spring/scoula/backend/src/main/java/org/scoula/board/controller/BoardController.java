package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController // 모든 메소드에 @ResponseBody 추가해줌 -> 응답을 json으로 받아온다
@RequestMapping("/api/board") // 메소드들의 공통 url
@RequiredArgsConstructor // final이 붙은 필드로 생성자 만들어줌
@Slf4j // 로깅을 위한 어노테이션
public class BoardController {
    private final BoardService service;

    @GetMapping("")
//    전체 게시글 조회
    public ResponseEntity<List<BoardDTO>> getList() {
//        상태 코드가 200이고 body 타입이 List<BoardDTO>인 응답 객체를 리턴
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> getById(@PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

//    Multipart 인코딩이므로 @RequestBody 붙이지 않음
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }

//    기존 게시글 삭제
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }

//    해당하는 경로로 파일을 다운로드
    @GetMapping("/download/{no}")
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attachment = service.getAttachment(no);
        File file = new File(attachment.getPath());
        UploadFiles.download(response, file, attachment.getFilename());
    }

    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no) throws Exception {
        return ResponseEntity.ok(service.deleteAttachment(no));
    }
}

