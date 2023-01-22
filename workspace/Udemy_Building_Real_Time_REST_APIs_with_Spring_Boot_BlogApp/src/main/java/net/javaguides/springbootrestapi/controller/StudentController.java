package net.javaguides.springbootrestapi.controller;


import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    //- '사용자'가 '주소창'에 직접 'http://localhost:8080/student/36/yujong/cho' 이렇게 입력하면
    //  '서버'가 그 요청을 받아 이에 대한 응답 데이터를 전송해줌
    @GetMapping("/student/{id}/{first-name}/{last-name}") //- 'URI 템플릿 variable'
                                                             //- '{first-name}': 'URL 변수'가 '두 단어 이상일 때',
                                                             //                  이처럼 '하이픈(-)'으로 연결해서 표시한다!

    //'Student 객체'를 다루고 있기 때문에, 'public Student getStudent()' 이러는 것임!
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


    //[ 22. 'Spring Boot REST API with Request Param - @RequestParam'강 ]
    //< '@RequestParam'. 매개변수 1개일 때 + 'GET 요청(동적 데이터 조회(검색 등) 등)'일 때 >
    //- e.g) 사용자가 '주소창'에
    //      'http://localhost:8080/students/queryMessage?id=243'을 입력했을 때,
    //      '서버'가 그 요청을 받아 다시 응답 데이터를 보내주기 위함과 같은 '쿼리 파라미터'를 handle 하기 위함
    //- '쿼리 파라미터': 여기서 '?id=1' 부분이 쿼리 파라미터임.
    //                 주로 '클라이언트의 동적 데이터 전송('검색 요청')'과 '조회 GET' 할 때 '쿼리 파라미터'를 사용한다.
    //
    @GetMapping("/students/queryMessage") //'주소창'에는 'http://localhost:8080/students/queryMessage?id=243'을
                                             //입력해야 정상적으로 데이터 조회가 가능하다.
                                             //'주소창'에 절대 'http://localhost:8080/students/queryMessage'만
                                             // 입력하는 것 아니다!
    public Student studentRequestVariable(@RequestParam Long id){


        return new Student(id, 1234567L, "male"); //'RequestParam으로 id만 들어왔기 때문'에, 당연히
                                                                 //'생년월일'과 '성별'은 '하드코딩'으로 직접 타이핑해야 함
    }


    


    //< '@RequestParam'. 매개변수 2개 이상일 때 + 'GET 요청(동적 데이터 조회(검색 등))'일 때 >
    //- e.g) '사용자'가 '주소창'에
    //      'http://localhost:8080/students/queryMessage?id=243&birthDate=1234567&gender=male'을 입력했을 때
    //      (cf: - 1234567L이 아니라, 1234567만 입력해주는 것
    //           - "male"이 아니라, male 로 입력해준다. )
    //      '서버'가 그 요청을 받아 다시 응답 데이터를 보내주기 위함
    @GetMapping("/students/queryMessages") //'주소창'에는 'http://localhost:8080/students/queryMessage?id=243..'을
                                             //입력해야 정상적으로 데이터 조회가 가능하다.
                                             //'주소창'에 절대로 'http://localhost:8080/students/queryMessage'만
                                             //입력하는 것 아니다!!
    public Student studentRequestVariables(@RequestParam Long id,
                                           @RequestParam Long birthDate,
                                           @RequestParam String gender){


        return new Student(id, birthDate, gender);

    }


//===============================================================================================================


    //[ '23. Spring Boot POST REST API - @PostMapping and @RequestBody'강 ]
    //< '@PostMapping'과 '@RequestBody' >
    //cf) 'GET 요청(검색 등)'이 아니기 때문에, '@RequestParam'이 아니라, '@RequestBody'이다!
    //https://wildeveloperetrain.tistory.com/144
    //https://cheershennah.tistory.com/179
    //- '@RequestBody': '클라이언트가 전송해준 JSON형식 데이터의 HTTP 바디'를 '자바 객체'로 '변환시켜주는' 역할.
    //                  'HttpMessageConverter 타입의 메시지 변환기'를 통해 이렇게 작동하게 됨
    //- '@ResponseBody': '서버가 응답해준 자바 객체'를 'JSON 형식 데이터의 HTTP 바디'로 '변환시켜주는' 역할.
    //- '@RequestBody'와 '@RequestParam'의 차이:
    //https://velog.io/@min-zi/Spring-RequestBody-vs-RequestParam-%EC%B0%A8%EC%9D%B4
    //https://parkadd.tistory.com/70

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED) //'포스트맨'에 '상태코드' 뜨게 하고 싶으면, 이 어노테이션 추가하라!
    public Student createStudent(@RequestBody Student student){

//        아래는 그냥 없어도 됨.
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());

        return student;


        //'클라이언트'의 데이터 전송: '포스트맨'에 아래처럼 '사용자'가 '서버'에 'JSON 형식'으로 데이터를 보내면,
//        {
//            "id": 53,
//            "lastName": "cho",
//            "gender": "male"
//        }


        //'서버'의 데이터 응답:
//        {
//            "id": 53,
//            "firstName": "null",
//            "lastName": "cho",
//            "birthDate": null,
//            "gender": "male"
//        }

        //cf) 원래라면, '사용자'가 'Student 객체의 필드(속성)들'인 'id', 'firstName', 'lastName', 'birthDate', 'gender'를
        //    '다 포함시켜서' '서버에게' 데이터를 전송해주는 것이 맞는 것임! 이건 그냥 단지 실험사항임!


    }


//===============================================================================================================


    //[ '24. Spring Boot PUT REST API - @PutMapping and @RequestBody'강 ]
    //< @PutMapping >

    public Student updateStudent(@RequestBody String firsttName,
                                 @RequestBody Long birthDate){

       Student student= new Student("yujong", 921028L);




        return null;
    }



}
