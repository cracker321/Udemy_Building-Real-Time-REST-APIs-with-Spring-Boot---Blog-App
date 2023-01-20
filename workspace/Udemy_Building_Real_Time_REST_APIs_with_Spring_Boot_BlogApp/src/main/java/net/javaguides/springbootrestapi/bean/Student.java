package net.javaguides.springbootrestapi.bean;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {


    private int id;
    private String firstName;
    private String lastName;



}
