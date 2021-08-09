package com.den.javacourse.userInformation;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private int id;
    private String name;
}
