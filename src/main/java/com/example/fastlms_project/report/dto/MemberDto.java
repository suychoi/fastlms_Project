package com.example.fastlms_project.report.dto;

import com.example.fastlms_project.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberDto {
    private String userEmail;
    private String userName;
    private String userPhone;

    public static MemberDto of(Member member) {
        
        return MemberDto.builder()
                .userEmail(member.getUserEmail())
                .userName(member.getUserName())
                .userPhone(member.getUserPhone())
                .build();
    }
}
