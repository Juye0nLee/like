package com.example.account.accounts.service;

import com.example.account.accounts.dto.AccountCreateDto;
import com.example.account.accounts.repository.AccountRepository;
import com.example.account.domain.Account;
import com.example.account.util.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    //회원가입
    public ResponseEntity<CustomApiResponse<?>> signup(AccountCreateDto.Req req) {

        //
        Account account = req.toEntity();

        //저장
        Account savedAccount = accountRepository.save(account);

        //응답 구현
        AccountCreateDto.CreateAccount createAccountResponse = new AccountCreateDto.CreateAccount(savedAccount.getId(),savedAccount.getUpdatedAt());
        CustomApiResponse<AccountCreateDto.CreateAccount> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(),createAccountResponse,"회원가입 성공");
        return ResponseEntity.ok(res);
    }
}