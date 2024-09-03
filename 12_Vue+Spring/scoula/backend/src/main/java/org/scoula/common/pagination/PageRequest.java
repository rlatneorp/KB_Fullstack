package org.scoula.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequest {
    private int page; // 요청 페이지
    private int amount; //한 페이지당 데이터 건수

    public PageRequest() {
        page = 1;
        amount = 10;
    }

//    팩토리 메소드를 사용해서 PageRequest 생성자 사용
    public static PageRequest of(int page, int amount) {
        return new PageRequest(page, amount);
    }

    public int getOffset() { // offset값 계산
        return (page - 1) * amount;
    }
}