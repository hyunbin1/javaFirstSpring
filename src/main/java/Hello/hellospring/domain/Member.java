package Hello.hellospring.domain;
import javax.persistence.*;

// 도메인: 비지니스 도메인 객체, 즉 회원, 주문, 쿠폰 등등. 이는 주로 데이터베이스에 저장하고 관리됨.
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 id 알아서 생성해준다.
    private Long id;

//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
