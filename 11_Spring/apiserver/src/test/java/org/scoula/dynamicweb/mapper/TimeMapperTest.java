package org.scoula.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class}) //테스트에서 사용할 설정 클래스
@Log4j
public class TimeMapperTest {
    @Autowired
    private TimeMapper timeMapper;

    @Test
    @DisplayName("TimeMapper의 getTime()")
    public void getTime() {
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

    @Test
    @DisplayName("TimeMapper의 getTime2()")
    public void getTime2() {
        log.info("getTime");
        log.info(timeMapper.getTime2());
    }

}