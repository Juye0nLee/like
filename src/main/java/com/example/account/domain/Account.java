package com.example.account.domain;

import com.example.account.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MEMBERS")
@Builder
public class Account extends BaseEntity {
    @Id
    @GeneratedValue

    @Column(name="ID")
    private Long id;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

}
