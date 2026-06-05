package com.BJJMarket.backend.modules.auth.dto.response;

import java.util.UUID;

import com.BJJMarket.backend.modules.auth.util.vews.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    @JsonView(View.Detail.class)
    private UUID userId;
    @JsonView(View.Summary.class)
    private String username;
    @JsonView(View.Summary.class)
    private String email;
    @JsonView(View.Detail.class)
    private String status;
}
