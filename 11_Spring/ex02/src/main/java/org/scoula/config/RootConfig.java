package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration // 설정
@ComponentScan(basePackages = {"org.scoula"}) // 해당 패키지에서 @Component를 찾아서 등록
public class RootConfig {
}
