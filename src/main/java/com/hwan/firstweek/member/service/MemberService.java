package com.hwan.firstweek.member.service;

import com.hwan.firstweek.jwt.JwtTokenProvider;
import com.hwan.firstweek.jwt.TokenInfo;
import com.hwan.firstweek.member.dto.MemberLoginRequestDto;
import com.hwan.firstweek.member.entity.Member;
import com.hwan.firstweek.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenInfo login(String memberId, String password) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }


    @Transactional
    public Member registMember(MemberLoginRequestDto memberLoginRequestDto){
         return memberRepository.save(Member.builder()
                .memberId(memberLoginRequestDto.getMemberId())
                .password(memberLoginRequestDto.getPassword())
                .build());
    }

    @Transactional(readOnly = true)
    public Optional<Member>  findMember(String id){
        return memberRepository.findByMemberId(id);

    }







}