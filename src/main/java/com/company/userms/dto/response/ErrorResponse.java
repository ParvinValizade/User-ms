package com.company.userms.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private Integer code;

    private String description;

}
