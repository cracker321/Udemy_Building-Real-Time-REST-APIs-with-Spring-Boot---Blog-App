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

        this.lastName = "kim"; //'외부 클래스'에서 '이 사용자 생성자'를 이용하여 'Student 객체'를 생성하려 한다면,
                               //그 때 비록 그 객체에서 '초기화되어 사용되는 속성'은 'id, birthDate, gender'이지만,
                               //일단, '그 Student 객체'가 나중에 언제 어디서 '필드 lastName'을 사용할 수 있다고 보고,
                               //그럴 경우에 대비하여, '그 Student 객체'가 사용하는 '이 사용자 생성자'를 통해
                               //'성 lastName'을 'kim'으로 일단 초기화해둠.
                               //따라서, 나중에 '그 Student 객체'가 '성 lastName 속성을 추가'할 때,
                               //'성 lastName 속성을 따로 변경해서 사용하지 않는다면', 그 때 사용되는 '성 lastName 속성의
                               //기본값'은 'kim'이 된다!
                               //(이클립스 'Constructor4'에 자세한 설명!)
    }



    public Student(String firstName, Long birthDate){


    }

}
