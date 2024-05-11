package com.example.account.accounts.service;

import com.example.account.accounts.dto.AccountCreateDto;
import com.example.account.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    //회원가입
    ResponseEntity<CustomApiResponse<?>> signup(AccountCreateDto.Req req);
}
