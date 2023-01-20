package net.javaguides.springbootrestapi.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Student {

    private int id;
    private String firstName;
    private String lastName;



}
