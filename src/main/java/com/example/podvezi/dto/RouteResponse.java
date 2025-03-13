package com.example.podvezi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class RouteResponse {
    private String systemName;
    private String labelName;
}
