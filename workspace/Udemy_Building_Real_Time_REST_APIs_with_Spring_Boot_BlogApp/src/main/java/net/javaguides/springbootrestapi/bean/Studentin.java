package net.javaguides.springbootrestapi.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Studentin {


    private Long id;
    private String firstName;
    private String lastName;
    private Long birthDate;
    private String gender;
}