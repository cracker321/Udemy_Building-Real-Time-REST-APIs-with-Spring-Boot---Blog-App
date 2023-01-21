package net.javaguides.springbootrestapi.controller;


import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){

        Student student = new Student(1L, "Ramesh", "Fadatare"); //'Student 객체'를 1개만 생성

        return student;

    }


//===============================================================================================================


    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>(); //'Student 객체'를 '여러 개' 생성하여 List에 담음



        //- 아래에서 'List'에 들어갈 수 있는 것은 오직 '객체' 뿐이기 때문에, 'new Student(...)' 형식의 'Student 객체'를
        //넣어주는 것이다!!!
        //- 그리고, '생성자의 인자값' 통해서 '각 Student 객체'들의 '개별 속성'을 '정해주는 것'이다!
        students.add(new Student(1L, "yujong", "cho"));
        students.add(new Student(2L, "ahra", "cho" ));
        students.add(new Student(3L, "seokjin", "lee"));
        students.add(new Student(4L, "minji", "kim"));

        return students;
    }


//===============================================================================================================


    @GetMapping("/student/{id}") //'URI 템플릿 variable'
    public Student getgetStudent(@PathVariable("id") Long studentId){ //이렇게 작성하면, 프론트로부터 넘어온 'id'가
                                                                      //'studentId'를 그대로 '대체해서', 이 안으로
                                                                      //대신 들어간다. 즉, 'id' = 'studentId'가
                                                                      //되는 것이다!



        return new Student(studentId, "seonghyun", "kim");

    }


}
