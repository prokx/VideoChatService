package com.hwan.firstweek.member.controller;

import com.hwan.firstweek.jwt.TokenInfo;
import com.hwan.firstweek.member.dto.MemberLoginRequestDto;
import com.hwan.firstweek.member.dto.MemberLoginResponseDto;
import com.hwan.firstweek.member.entity.Member;
import com.hwan.firstweek.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Api
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody @Validated MemberLoginRequestDto memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getMemberId();
        String password = memberLoginRequestDto.getPassword();
        TokenInfo tokenInfo = memberService.login(memberId, password);
        return tokenInfo;
    }


    @ApiOperation(value="멤버 찾기")
    @GetMapping("/{id}")
    public ResponseEntity<Member> findMember(@PathVariable(value="id") String id){
        Optional<Member> member = memberService.findMember(id);
        if(member.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(member.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(member.get());
        }
    }
    @ApiOperation(value="멤버 등록")
    @PostMapping("")
    public ResponseEntity<MemberLoginResponseDto> registMember(@RequestBody MemberLoginRequestDto memberLoginRequestDto){
        Member member = memberService.registMember(memberLoginRequestDto);
        if(member==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(MemberLoginResponseDto.builder().memberId(member.getMemberId()).build());
        }
    }





}