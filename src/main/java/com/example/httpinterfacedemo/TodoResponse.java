package com.example.httpinterfacedemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponse {
    Long userId;
    Long id;
    String title;
    Boolean completed;
}
