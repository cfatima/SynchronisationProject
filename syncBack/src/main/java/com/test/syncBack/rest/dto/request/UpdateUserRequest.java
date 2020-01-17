package com.test.syncBack.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
    
}
