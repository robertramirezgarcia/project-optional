package com.optional.projectoptional.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ResourceNotFoundException extends Exception{

    private String message;

}
