package net.javaguides.springbootrestapi.controller;


import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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


    //< '@PathVariable()' >
    @GetMapping("/student/{id}/{first-name}/{last-name}") //- 'URI 템플릿 variable'
                                                             //- '{first-name}': 'URL 변수'가 '두 단어 이상일 때',
                                                             //                  이처럼 '하이픈(-)'으로 연결해서 표시한다!
    public Student getgetStudent(@PathVariable("id") Long studentId,
                                 @PathVariable("first-name") String firstName,
                                 @PathVariable("last-name") String lastName){
        //- '@PathVariable("id") Long studentId':
        //이렇게 작성하면, '클라이언트로부터 URI 통해 넘어온 id'가 'studentId'를 그대로 '대체해서', 이 메소드 안으로 대신 들어간다.
        //즉, 'id' = 'studentId'가 되는 것이다!
        //- '@PathVariable("first-name") String firstName:
        //'클라이언트로부터 URI 통해 넘어온 first-name'이 이제 'firstName'을 그대로 '대체해서', 이 메소드 안으로 대신 들어간다!
        //즉, 'first-name' = 'firstName'이 되는 것이다!



        return new Student(studentId, firstName, lastName);
        //- 'firstName'과 'lastName'은 어쨌든 '변수'이기 때문에 이 'Student 객체' 안에 "firstName'과 "lastName"으로
        //  적는 것이 아니라, '변수 그대로' 'firstName'과 'lastName'으로 적는다!
        //- 'Student 객체'는 '클래스 Student'가 '외부 클래스'에서 사용할 수 있도록, 'public'으로 해뒀기 때문에
        //  여기서 사용 가능한 것이다!
        //- 이렇게 'return new Student(studentId, firstName, lastName)' 처럼 안 하고,
        //  Student student = new Student(studentId, firstName, lastName);
        //
        //     return student;
        //  로 해도 어차피 매한가지 같다! 당연함...

    }


//===============================================================================================================


    //[ 'Spring Boot REST API with Request Param - @RequestParam'강 ]
    //< '@RequestParam' >
    //- 'http://localhost:8080/students?id=1' 과 같은 '쿼리 파라미터'를 handle 하기 위함

    public Student studentRequestVariable(@RequestParam Long id){



        return null;
    }





//===============================================================================================================



}
