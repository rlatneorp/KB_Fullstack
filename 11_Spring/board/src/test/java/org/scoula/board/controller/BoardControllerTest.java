package org.scoula.board.controller;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.service.BoardService;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration // MockMvc를 사용하기 위해 필요
@ContextConfiguration(classes ={RootConfig.class,ServletConfig.class}) // Spring 컨테이너 설정
@Log4j
public class BoardControllerTest {

    @Autowired
    BoardService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach // 각 테스트 메소드 실행 전에 호출
    public void setup() {
//        mockMvc 객체를 초기화
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void list() throws Exception {
        log.info(
//                borar/list을 처리하는 controller의 list() 메소드 호출
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // ResultActions 리턴
                        .andReturn() // MvcResult 리턴
                        .getModelAndView() // ModelAndView 리턴
                        .getModelMap() // Model 리턴
        );
    }
}