package com.company.userms.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String firstname;
    private String lastname;

    private String pin;
}
