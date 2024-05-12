package com.example.account.accounts.controller;


import com.example.account.accounts.dto.AccountCreateDto;
import com.example.account.accounts.dto.AccountEnterDto;
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
    @PostMapping("/sign-up")
   public  ResponseEntity<CustomApiResponse<?>> signup(@Valid @RequestBody AccountCreateDto.Req req){
        ResponseEntity<CustomApiResponse<?>> result = accountService.signup(req);
        return result;
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<CustomApiResponse<?>> login(@RequestBody AccountEnterDto req){
        //AccountEnterDto res = new AccountEnterDto();
        ResponseEntity<CustomApiResponse<?>> result = accountService.login(req);
        return result;
    }
}
