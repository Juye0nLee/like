package com.example.account.util.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    //생성된 시간
    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createdAt;

    //마지막으로 수정된 시간
    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

}
