package com.datcute.hello_spring_boot.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Builder
public class SampleDTO implements Serializable {
    private Integer id;
    private String name;
}
