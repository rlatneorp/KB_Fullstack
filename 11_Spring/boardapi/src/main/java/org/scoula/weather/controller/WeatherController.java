package org.scoula.weather.controller;

import lombok.extern.slf4j.Slf4j;
import org.scoula.weather.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller // 메서드의 반환값을 뷰로 받는다
@Slf4j
@RequestMapping("/weather")
@PropertySource("classpath:/application.properties") // 어디서 resource를 가져올지
public class WeatherController {
    @Value("${weather.url}") // application.properties 에서 키값으로 설정을 가져옴
    private String URL; 

    @Value("${weather.icon_url}")
    private String ICON_URL;

    @Value("${weather.api_key}")
    private String API_KEY;

    @GetMapping({"", "/{city}"}) // 주소 형식이 /weather, /weather/{city}로 올 경우 둘 다 처리
    public String weather(Model model, @PathVariable(value="city", required = false) String city) {
        city = city == null ? "seoul" : city;
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString(); // 기본 url에 쿼리스트링을 연결해서 새로운 주소 생성
        // 생성된 url를 통해서 WeatherDTO 결과값 반환받아옴
        WeatherDTO weather = restTemplate.getForObject(url, WeatherDTO.class);
//        WearthrDTO의 weather -> WeatherItem의 리스트 중 첫번째 아이템의 아이콘으로 ICON_URL 포맷
        String iconUrl = ICON_URL.formatted(weather.getWeather().get(0).getIcon());
        log.info("오늘의 날씨: " + weather);
//        뷰쪽에서 사용하기 위해 모델에 데이터 저장
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        model.addAttribute("iconUrl", iconUrl);

//        @Controller에서는 리턴값이 곧 뷰 이름
        return "weather/today";
    }
}

