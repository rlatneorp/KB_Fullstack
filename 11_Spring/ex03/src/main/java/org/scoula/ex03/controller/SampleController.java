package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.SampleDTOList;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;


@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

    @RequestMapping("")
    public void basic(){
        log.info("basic.............");
    }

    // get과 post 두개를 다 처리할 수 있는 메소드
    // localhost:8080/sample/basic
    @RequestMapping(value="/basic", method={RequestMethod.GET, RequestMethod.POST})
    public void basicGet(){
        log.info("basicGet.............");
    }

//    @RequestMapping과  + Get 요청을 합친 어노테이션, Get요청만 처리가능
    @GetMapping("/basicOnlyGet")
    public void basicGet2(){
        log.info("basic get only get..........");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        log.info("" + dto);
        return "ex01"; // view 이름
    }

//    @RequestParam은 DTO객체를 안 쓰고 각자 파라미터를 받아줄때 사용
//    필드 다 제대로 안 넣어주면 예외 발생, 개별 파라미터는 뷰로 전달 불가능
    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name, @RequestParam("age") int age){
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    // 같은 이름으로 여러번 전달하는 경우 List나 배열로 받아올 수 있다
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids){
        log.info("ids: " + ids);

        return "ex02List";
    }

//    @GetMapping("/ex02List")
//    public String ex02List(@RequestParam("ids") String[] ids) {
//        log.info("array ids: " + Arrays.toString(ids));
//
//        return "ex02List";
//    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list){
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo){
        log.info("todo : " + todo);
        return "ex03";
    }

    // page를 기본 자료형으로 넘기면 log에는 찍히지만 뷰로 전달되지 앟는다
    // 따라서 @ModelAttribute로 전달해야 한다(request scope 저장)
//    @GetMapping("/ex04")
//    public String ex04(SampleDTO dto, int page){
//        log.info("dto: " + dto);
//        log.info("page: " + page);
//
//        return "ex04";
//    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
        log.info("dto: " + dto);
        log.info("page: " + page);

        return "sample/ex04";
    }

//    return 값이 void일 경우 요청 url을 기준으로 jsp 파일을 찾는다
    @GetMapping("/ex05")
    public void ex05(){
        log.info("/ex05..........");
    }

//    리다이렉트 시 요청 파라미터로 name과 age를 추가해준다
//    해당경로 접근시 http://localhost:8080/sample/ex06-2?name=AAA&age=18 로 리다이렉트됨
    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra){
        log.info("/ex06.........");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 18);
//        리다이렉트 시 "redirect:" 접두사를 사용한다
        return "redirect:/sample/ex06-2";
    }

//    @ResponseBody 어노테이션은 변환된 객체가 json형식으로 변환되어 보여지도록 한다
    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07(){
        log.info("/ex07.......");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }

//    ResponseEntity = json 형태의 body + 응답 헤더까지 추가
    @GetMapping("/ex08")
    public ResponseEntity<String> ex08(){
        log.info("/ex08.........");
        String msg = "{\"name\": \"홍길동\"}";

        HttpHeaders header = new HttpHeaders();
//      HttpHeaders 객체 생성 후 Content-Type 헤더 설정
        header.add("Content-Type", "application/json; charset=UTF-8");
//      ResponseEntity객체 내에 바디, 헤더, 상태코드 OK는 200 반환
        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload(){
        log.info("exUpload..........");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files){
        for(MultipartFile file : files){
            log.info("---------------------");
            log.info("name : " + file.getOriginalFilename()); // 파일의 원래 이름 출력
            log.info("size : " + file.getSize());
        }
    }
}
