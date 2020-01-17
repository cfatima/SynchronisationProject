package com.test.syncBack.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.syncBack.rest.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
@ToString
public class UpdateUserResponse extends ApiResponseDTO{
	

	
	

}
