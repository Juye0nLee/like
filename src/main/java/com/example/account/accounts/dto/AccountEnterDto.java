package com.example.account.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEnterDto {
        @NotBlank(message = "아이디를 입력해주세요")
        private String userId;

        @NotBlank(message = "비밀번호를 입력해주세요")
        private String password;

        //불필요한듯
/*        @Getter
        @NoArgsConstructor
        public static class AccountEnter {
            private Long id;
            private LocalDateTime createAt;
            public AccountEnter(Long id,LocalDateTime createAt) {
                this.createAt = createAt;
                this.id = id;
            }
        }*/
}
