package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//VO : Value Object (테이블의 한 행을 매핑)
public class UserVO {
    //    테이블 내에서 각각의 컬럼명과 동일하다
    private String id;
    private String password;
    private String name;
    private String role;
}