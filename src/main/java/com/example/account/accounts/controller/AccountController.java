package com.example.account.accounts.controller;


import com.example.account.accounts.dto.AccountCreateDto;
import com.example.account.accounts.service.AccountService;
import com.example.account.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class AccountController {
    private final AccountService accountService;
    //회원가입
    @PostMapping
   public  ResponseEntity<CustomApiResponse<?>> signup(@Valid @RequestBody AccountCreateDto.Req req){
        ResponseEntity<CustomApiResponse<?>> result = accountService.signup(req);
        return result;
    }
}
