package com.hwan.firstweek.member.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class MemberLoginResponseDto {

    private String memberId;
    private String password;
}