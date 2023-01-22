package net.javaguides.springbootrestapi.controller;


import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


//===============================================================================================================


    //< @GetMapping. '개별 학생 조회' >
    @GetMapping("/student")
    public Student getStudent(){
        //- 여기 '메소드 getStudent'의 '매개변수'에 'Student student'를 넣어주지 않았기 때문에,
        //아래에서 '새롭게 Student 객체를 생성'해줘야, 그 아래에서 'Student 객체'를 사용할 수 있다!
        //만약, 'public Student getStudent(Student student){..' 이렇게 했었다면,
        //아래에서 'Student student = new Student(...)' 이 과정이 필요 없이,
        //바로 '클래스변수 student'를 사용할 수 있게 된다!!
        //즉, '메소드 getgetStudent의 매개변수'에 'Student student가 들어오지 않았기에', '당연히 이 메소드 안에서 바로
        //Student 객체를 사용하는 것은 불가'하고, '메소드 중간에 Student student = new Student()' 처럼
        //'새롭게 최초로 Student 객체를 생성하여 사용'하든지, 아니면 여기 '리턴값처럼 새롭게 Student 객체를 생성'해서 사용해야 함!

        //- 여기 매개변수로 들어갈 수 있는 것은 '엔티티'이다!
        //- 또한 이 '메소드 getStudent'의 '리턴타입(자료형)이 Student 객체 타입'이기에,
        // '리턴값' 역시 'Student 객체'여야 한다!
        //- '엔티티 Student'의 '접근제어자는 public'이기에, '이 프로젝트의 언제 어디서나 다 공유사용
        //  가능하고, 따라서 여기 '클래스 StudentController의 메소드 getStudent'에서도
        //  자유롭게 '메소드의 리턴타입(자료형)으로 엔티티 Student'를 사용하는 것이 가능한 것이다!


        Student student = new Student(1L, "Ramesh", "Fadatare"); //'Student 객체'를 1개만 생성

        return student; //이 '메소드 getStudent의 리턴타입'이 'Student 객체'이기에, 당연히 여기서도 'Student 객체'를 리턴함.
                        //'이 메소드의 리턴타입이 Student 객체 타입인 것과 상관 없이', '이 메소드의 매개변수로
                        //Student student가 들어왔기 때문에', 이 메소드 안에서 '클래스변수 student'를 자유롭게
                        //사용하는 것이 가능하다!
                        //즉, ''public Student getStudent()'에서의 'Student''는
                        //'이 메소드의 리턴타입이 Student 객체라는 것을 강제할 뿐이지', 이 메소드 안에서
                        //'클래스변수 student'를 사용할 수 있다는 말이 절대 아니다!
                        //즉, '클래스변수 student'를 사용하려면, 반드시
                        //1.'이 메소드의 매개변수로 Student student'가 들어오든지,
                        //2.'이 메소드 안에서 새롭게 최초의 Student 객체를 생성(Student student = new Student())'하여
                        //   그 '클래스변수 student'를 사용하든지 해야 한다!
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

    //- REST API는 '클라이언트'와 '서버'간 소통을 'HTTP 통신'에 전적으로 의존하기 때문에,
    //  클라이언트가 보내는 데이터를 받으려면 이렇게 HTTP 통신을 활용하여 받아야 하는 것이다!

    //- '사용자'가 '주소창(or 포스트맨)'에 직접 'http://localhost:8080/student/36/yujong/cho' 이렇게 입력하면
    //  '서버'가 그 요청을 받아 이에 대한 응답 데이터를 전송해줌
    @GetMapping("/student/{yujongId}/{yujong-first-name}/{yujong-last-name}")
    //- '{yujong-first-name}': 'URL 변수'가 '두 단어 이상일 때', 이처럼 '하이픈(-)'으로 연결해서 표시한다!

    //'Student 객체'를 다루고 있기 때문에, 'public Student getStudent()' 이러는 것임!
    public Student getgetStudent(@PathVariable("yujongId") Long devId,
                                 @PathVariable("yujong-first-name") String devFirstName,
                                 @PathVariable("yujong-last-name") String devLastName){
        //< @PathVariable >
        //- 'yujongId', 'yujong-first-name', 'yujong-last-name':
        // '클라이언트가 URI 속에 넣어서 '3개의 {} 안에' 넣어 전달한 데이터 실제 값 그 자체인 'yujongId', 'yujong-first-name',
        //  'yujong-last-name' 그 자체를, '서버인 내가 임의로' '변수 devId', '변수 devFirstName', '변수 devLastName'을
        //  만들어서 그 데이터들을 받은 후(즉, 이 변수들은 그 데이터들을 받을 목적으로 내가 임의로 만든 변수임),
        //  그 '3개의 {} 안에 넣어 전달된 데이터 실제 값'을 위 '각각 3개의 변수 안에' 넣어서 그것을 이 아래 메소드에 넣은 후,
        //  사용하는 것이다.
        //  즉, '클라이언트로부터 넘어온 데이터 실제 값들'을 '내가 만든 임의의 변수들에 넣어 받은 후',
        //  'Student 객체의 추가 속성'으로 넣은 것이다!
        //  즉, 이 '클라이언트가 URI에 넣어서 전달하고자 하는 실제 값'을 컨트롤러가 '임의로 변수를 만들어서',
        //   그 데이터 실제 값을 받게 되는 것이다!
        //https://velog.io/@dmchoi224/Rest-API-RequestParam-%EA%B3%BC-PathVariable

        //- '@PathVariable("yujongId") Long studentId':
        //이렇게 작성하면, '클라이언트가 URI속에 넣어서 전달한 {} 속에 있는 데이터 실제 값인 yujongId'를
        // '컨트롤러'가 '변수 studentId'룰 만들어서, 그 '데이터 실제 값 yujongId'를 '내가 만든 변수 studentId에 담아서',
        //이이 메소드 안으로 대신 들어가서 사용하는 것이다!

        //- '@PathVariable("first-name") String firstName:
        //'클라이언트로부터 URI 통해 넘어온 first-name'이 이제 'firstName'을 그대로 '대체해서', 이 메소드 안으로 대신 들어간다!
        //즉, 'first-name' = 'firstName'이 되는 것이다!



        return new Student(devId, devFirstName, devLastName);
        //- 'firstName'과 'lastName'은 어쨌든 '변수'이기 때문에 이 'Student 객체' 안에 "firstName'과 "lastName"으로
        //  적는 것이 아니라, '변수 그대로' 'firstName'과 'lastName'으로 적는다!
        //- 'Student 객체'는 '클래스 Student'가 '외부 클래스'에서 사용할 수 있도록, 'public'으로 해뒀기 때문에
        //  여기서 사용 가능한 것이다!
        //- 이렇게 'return new Student(devId, devFirstName, devLastName)' 처럼 안 하고,
        //  Student student = new Student(devId, devFirstName, devLastName);
        //
        //     return student;
        //  로 해도 어차피 매한가지 같다! 당연함...

        //- '메소드 getgetStudent의 리턴타입(자료형)이 Student 객체 타입'이기에, 여기서 '리턴값도 당연히 Student 객체'여야 함
        //- 또한, '메소드 getgetStudent의 매개변수'에 'Student student가 들어오지 않았기에', '당연히 이 메소드 안에서 바로
        //  Student 객체를 사용하는 것은 불가'하고, '메소드 중간에 Student student = new Student()' 처럼
        //  '새롭게 최초로 Student 객체를 생성하여 사용'하든지, 아니면 여기 '리턴값처럼 새롭게 Student 객체를 생성'해서 사용해야 함!
        //  즉, '서버'가 '클라이언트'에게 'Student 객체를 리턴해줘야 하기 때문'에, 그렇기에 이 메소드의 리턴타입(자료형)을
        //  'Student'로 한 것이다!
    }


//===============================================================================================================


    //[ 22. 'Spring Boot REST API with Request Param - @RequestParam'강 ]
    //< '@RequestParam'. 매개변수 1개일 때 + 'GET 요청(동적 데이터 조회(검색 등) 등)'일 때 >
    //- e.g) 사용자가 '주소창(or 포스트맨)'에
    //      'http://localhost:8080/students/queryMessage?yujongId=243'을 입력했을 때,
    //      '서버'가 그 요청을 받아 다시 응답 데이터를 보내주기 위함과 같은 '쿼리 파라미터'를 handle 하기 위함
    //- '쿼리 파라미터': 여기서 '?id=1' 부분이 쿼리 파라미터임.
    //                 주로 '클라이언트의 동적 데이터 전송('검색 요청')'과 '조회 GET' 할 때 '쿼리 파라미터'를 사용한다.
    //
    @GetMapping("/students/queryMessage")


    //'주소창'에는 'http://localhost:8080/students/queryMessage?yujongId=243'을 입력해야 정상적으로 데이터 조회가 가능하다.
    //'주소창'에 절대 'http://localhost:8080/students/queryMessage'만 입력하는 것 아니다!
    public Student studentRequestVariable(@RequestParam("yujongId") Long myId) {


        return new Student(myId, 1234567L, "male");
        //- 'RequestParam으로 yujongId만 들어왔기 때문'에, 당연히 '생년월일'과 '성별'은 '하드코딩'으로 직접 타이핑해야 함
        //- '메소드 studentRequestVariable의 리턴타입(자료형)이 Student 객체 타입'이기에, 여기서 '리턴값도 당연히 Student 객체
        //  여야 함'. 또한, '메소드 studentRequestVariable의 매개변수'에 'Student student'가 들어오지 않았기에, '당연히
        //  이 메소드 안에서 바로 Student 객체를 사용하는 것이 불가'하고, '메소드 중간에 Student student = new Student()'처럼
        //  '새롭게 최초로 Student 객체를 생성하여 사용'하든지, 아니면 여기 '리턴값처럼 새롭게 Student 객체를 생성'해서 사용해야 함!
        //  즉, ''public Student getStudent()'에서의 'Student''는 '이 메소드의 리턴타입이 Student 객체라는 것을 강제할 뿐이지',
        //  이 메소드 안에서 '클래스변수 student'를 사용할 수 있다는 말이 절대 아니다!
        //  즉, '클래스변수 student'를 사용하려면, 반드시
        //  1.'이 메소드의 매개변수로 Student student'가 들어오든지,
        //  2.'이 메소드 안에서 새롭게 최초의 Student 객체를 생성(Student student = new Student())'하여
        //   그 '클래스변수 student'를 사용하든지 해야 한다!
        //  즉, '서버'가 '클라이언트'에게 'Student 객체를 리턴해줘야 하기 때문'에, 그렇기에 이 메소드의 리턴타입(자료형)을
        //  'Student'로 한 것이다!

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

    public Student studentRequestVariables(@RequestParam Long devdevId,
                                           @RequestParam Long devdevBirthDate,
                                           @RequestParam String devdevGender){
        //@RequestParam Long devdevId = @RequestParam("id") Long devdevId
        //@RequestParam Long devdevBirthDate = @RequestParam("birthDate") Long devdevBirthDate
        //@RequestParam Long devdevGender = @RequestParam("gender") Long devdevGender
        //즉, '@RequestParam()'의 '괄호 ()' 안에는, '클라이언트가 URI 속에 함께 넣어 보낸 데이터 실제 값(id, birthDate,
        //gender)'가 담겨져 있는 것이고,
        //'서버'에서는 그 '데이터 실제 값들'을, 각각 '서버 내가 임의로 만든 변수'인 '변수 devdevId', '변수 devdevBirthDate',
        //'변수 devdevGender'에 담은 후, 그것들을 이 메소드 안에 넣어 활용하는 것이다!


        return new Student(devdevId, devdevBirthDate, devdevGender);

    }


//===============================================================================================================


    //[ '23. Spring Boot POST REST API - @PostMapping and @RequestBody'강 ]
    //< '@PostMapping'과 '@RequestBody' >
    //cf) 'GET 요청(검색 등)'이 아니기 때문에, '@RequestParam'이 아니라, '@RequestBody'이다!
    //https://wildeveloperetrain.tistory.com/144
    //https://cheershennah.tistory.com/179
    //- '@RequestBody': '클라이언트가 전송해준 JSON형식 데이터의 HTTP 바디'를 '자바 객체'로 '변환시켜주는' 역할.
    //                  'HttpMessageConverter 타입의 메시지 변환기'를 통해 이렇게 작동하게 됨
    //                  즉, '서버'가 'HTTP 요청 바디'로부터 'JSON 형식의 데이터'를 '추출해내는 것'이다!
    //- '@ResponseBody': '서버가 응답해준 자바 객체'를 'JSON 형식 데이터의 HTTP 바디'로 '변환시켜주는' 역할.
    //- '@RequestBody'와 '@RequestParam'의 차이:
    //https://velog.io/@min-zi/Spring-RequestBody-vs-RequestParam-%EC%B0%A8%EC%9D%B4
    //https://parkadd.tistory.com/70

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED) //'포스트맨'에 '상태코드' 뜨게 하고 싶으면, 이 어노테이션 추가하라!
    public Student createStudent(@RequestBody Student student){ //'클라이언트'가 'JSON 형식으로 데이터 Student 객체'를
                                                                //'서버로 전달'하면서, 'Student 객체를 DB에 신규로 저장
                                                                //해줘!'라고 요청한 것이다!

//        아래는 그냥 없어도 됨.
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());

        return student; //'이 메소드의 리턴타입이 Student 객체 타입인 것과 상관 없이', '이 메소드의 매개변수로
                        //Student student가 들어왔기 때문에', 이 메소드 안에서 '클래스변수 student'를 자유롭게
                        //사용하는 것이 가능하다!
                        //즉, 'public Student createStudent()'의 'Student'는
                        //'이 메소드의 리턴타입이 Student 객체라는 것을 강제할 뿐이지', 이 메소드 안에서
                        //'클래스변수 student'를 사용할 수 있다는 말이 절대 아니다!
                        //즉, '클래스변수 student'를 사용하려면, 반드시
                        //1.'이 메소드의 매개변수로 Student student'가 들어오든지,
                        //2.'이 메소드 안에서 새롭게 최초의 Student 객체를 생성(Student student = new Student())'하여
                        //   그 '클래스변수 student'를 사용하든지 해야 한다!


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
    //- '사용자'가 '주소창(or 포스트맨)'에 직접 'http://localhost:8080/students/95/update' 이렇게 입력하면
    //  '서버'가 그 요청을 받아 이에 대한 응답 데이터를 전송해줌
    @PutMapping("/students/{mymyId}/update")
    public Student updateStudent(@RequestBody Student student,
                                 //- '@PutMapping'은 'update'이기 때문에, 따라서 어찌됐든
                                 //'클라이언트'가 '서버'로 '어떤 데이터를 전달해줘야 한다'!!
                                 //따라서, '@RequestBody'로 데이터를 전달해줘야 함!
                                 //- '클라이언트'가 '서버'로 'Student 객체를 전달해주긴 하는데',
                                 //- 나중에 '서버'가 '클라이언트'로 다시 되돌려주는 '응답 데이터'는
                                 //  오직 'return'에 담겨 있는 'Student 객체에 포함되어 있는 속성들'만 되돌려주는 것이다!
                                 //  (포스트맨으로 테스트하면서 확인해보기!)
                                 //- '클라이언트'가 '서버'로 'Student 객체를 전달'해준다는 것은,
                                 //  '사용자'가 '주소창(또는 포스트맨)'에 아래처럼 'Student 객체를 JSON 형식으로 작성'해서
                                 //  넘겨줄 수 있다는 것
                                 //    {
                                 //        "id": 22444170,
                                 //        "firstName": "yujong",
                                 //        "lastName": "cho",
                                 //        "birthDate": 001122,
                                 //        "gender": "male"
                                 //    }
                                 @PathVariable("mymyId") Long studentId)
                                 //- '주소창(or 포스트맨)'에 직접 'http://localhost:8080/students/95/update'라고
                                 //입력한다면, '서버'가 다시 보내주는 '응답 JSON 데이터'는
                                 //  {
                                 //     "id": 95,
                                 //     "firstName": null,
                                 //     "lastName": null,
                                 //     "birthDate": null,
                                 //     "gender": "male"
                                 //  }
                                 //- 여기서 'studentId'는 이 메소드 안에서 이를 활용해서 아래의 경우에는 응답 데이터에
                                 //  넣기 위해 임의로 변수를 작성해서 매개변수에 넣은 것이지,
                                 //  이 자체가 '주소창(or 포스트맨)'에 입력되어 있는 {mymyId}의 실제 값(여기서는 '95')에
                                 //  전혀 우선하는 것이 아니고, 사용자가 주소창에 입력하는 '95'에 전혀 영향을 끼칠 수 없다!
    {



//        return student;


//        만약,위에처럼 딱 'return student' 저렇게만 쓴다면, 'JSON 형식 응답 데이터'에 이 출력값을 보여줌.
//        즉, 아래처럼 'RequestBody'에
        //  '사용자'가 '주소창(또는 포스트맨)'에 'http://localhost:8080/students/95/update' 작성하고,
        //  포스트맨에서 '바디' 부분에 아래처럼 'Student 객체를 JSON 형식으로 작성'해서 '서버'에게 넘겨준다면,
        //    {
        //        "id": 22444170,
        //        "firstName": "yujong",
        //        "gender": "male"
        //    }

        //'서버'가 '사용자'에게 다시 응답해주는 'JSON 형식 응답 데이터'는 아래와 같게 됨.
//        {
//          "id": 22444170, //'주소창(또는 포스트맨)'에 입력된 '95'는 여기에 전혀 영향을 미칠 수 없다!
//          "firstName": "yujong",
//          "lastName": "null",
//          "birthDate": "null",
//          "gender": "male"
//        }





        return new Student(studentId, "male"); //'JSON 응답 데이터'로 '95', 'male'을 '클라이언트'에게 보내준다!
        //'사용자 생성자1'을 이용하여 객체 생성함.
        //'사용자'가 '주소창(또는 포스트맨)'에 'http://localhost:8080/students/95/update' 작성하고,
        //'포스트맨'에서 '바디' 부분에 아래처럼 RequestBody를 보내면,
//        {
//            "id": 22444170,
//            "firstName": "yujong",
//            "lastName": "cho",
//            "birthDate": 001122,
//            "gender": "male"
//        }

        //당연히, '서버'가 다시 보내주는 '응답 JSON 데이터'는, 오직 '현재 Student 객체의 속성인 'id'와 '성별 gender'만
        //보내줄 수 밖에 없는 것이다!
//         {
//           "id": 95, //'new Student(studentId, "male")' 에서 '현재 Student 객체의 속성 중 id 부분'은
//                     //URL로부터에 포함되어 전달받은 '실제 값 id'를 담은 '변수 studentId'를 '현재 Student 객체의 속성'에
//                     //넣었기 때문에,  당연히, '주소창(또는 포스트맨)'에 입력되어 있는 'id값'이 리턴되는 것일 뿐이다!
//           "firstName": null,
//           "lastName": null,
//           "birthDate": null,
//           "gender": "male"
//           }
    }


//===============================================================================================================


    //< @DeleteMapping >
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") Long studentId){
        //- '클라이언트'로부터 'id'값을 일단 어찌됐든 전달받았다면, '서버'는 그 '전달받은 id값'을 '변수 studentId'를 활용하여,
        //  '반.드.시 이 메소드 안에서 활용하여야', '포스트맨에서 통신오류가 발생하지 않는다'!!
        //  따라서, 여기서는 그냥 일단 그 간단한 활용 용도로 'System.out.println(studentId)'를 작성해서 사용해본 것임.
        //  이 '출력문 자체'는 어차피 'return 데이터'가 아니기 때문에, '서버'가 '클라이언트'에게 전달해주는 데이터가 아니다!
        //  즉, 만약, 애초에 '@PathVariable("id") Long studentId'와 같이 'id값'을 전달받지 않았다면,
        //  이 출력문 'System.out.println(studentId)'와 같은 것을 애초에 작성할 필요도 없고, 작성 안 해도 정상적으로 통신된다!

        System.out.println(studentId);

        return "Student deleted successfully!!"; //'서버'가 '클라이언트'에게 '응답 데이터로 String 타입을 리턴해주고자 하기
                                                 //때문'에, '이 메소드의 리턴타입(자료형)을 String 타입으로 한 것'임!
    }


//===============================================================================================================


    //[ '26. Using Spring ResponseEntity to Manipulate the HTTP Response - ResponseEntity'강 ]
    //< ResponseEntity. @GetMapping. '개별 학생 조회' >
    @GetMapping("/ResponseEntityStudent")
    public ResponseEntity<Student> getResponseEntityStudent(Student student){

        student.setFirstName("yujong"); //이 메소드 안에서 '새롭게 최초로 생성한 현재 Student 객체의 속성'으로
                                        //'이름 yujong', '성별 male'을 추가해줬다!
        student.setGender("male");

        //return ResponseEntity.ok(student) //이것과 아래는 '완전히 동일'하다!
        return new ResponseEntity<>(student, HttpStatus.OK);
        //- '새로운 ResponseEntity 객체를 생성해줘야', '리턴값 return'에 그 '새로운 ResponseEntity 객체'를 넣어서
        //  사용해주는 것이 가능한 것이다!
        //- '바디', '헤더', '상태코드'
        //- 이 메소드의 매개변수로 'Student 객체'를 던져줬기 때문에 당연히, '리턴값 return'에서 '그 클래스변수 student'를
        //  '바디' 부분에 사용하는 것이 가능하다!
        //- '사용자'가 '주소창(또는 포스트맨)'에 'http://localhost:8080/ResponseEntityStudent'를 작성하면,
        //'서버'가 '사용자'에게 다시 응답해주는 'JSON 형식 응답 데이터'는 아래와 같게 됨.
//        {
//          "id": null,
//          "firstName": "yujong",
//          "lastName": null,
//          "birthDate": null,
//          "gender": "male"
//        }
//      그리고, 'Headers'에 상태코드가 이전의 '201 Created'가 아닌 '200 OK'로 '클라이언트에게' 응답해서 전달해준다!

    }



//===============================================================================================================




//===============================================================================================================


}
