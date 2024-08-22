package com.example.jpa.memo.repository;

import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    // 이 예제에서는 하드코딩된 패스워드를 사용합니다. 실제 구현에서는 DB에서 조회할 수 있습니다.
    private static final String VALID_PASSWORD = "1234";

    @Override
    public boolean verifyPassword(String code) {
        return VALID_PASSWORD.equals(code);
    }
}
