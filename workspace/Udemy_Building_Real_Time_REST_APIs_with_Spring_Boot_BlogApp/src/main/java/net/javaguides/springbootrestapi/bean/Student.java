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


    private Long id;
    private String firstName;
    private String lastName;
    private Long birthDate;
    private String gender;



    public Student(Long id, String firstName, String lastName){ //생성자 오버로딩

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    public Student(Long id, Long birthDate, String gender){

        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
    }




}
