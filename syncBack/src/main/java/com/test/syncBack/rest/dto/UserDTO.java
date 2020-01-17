package com.test.syncBack.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder()
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("email")
    private String email;
	

}
