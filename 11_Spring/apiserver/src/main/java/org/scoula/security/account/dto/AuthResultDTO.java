package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResultDTO {
    String token;
    UserInfoDTO user;
}
