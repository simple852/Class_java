class Hand {
    int finger = 5;

    // "생성자를 아무 것도 선언하지 않으면," 컴파일러가 자동으로 하나 추가해줌
    //   기본 생성자 : 파라미터가 아무것도 없고 객체만 생성해줌
}

class Arm {
    Hand hand = new Hand();
}

class Face {
    int hair = 1;
    int eye = 2;
    int nose = 1;
    int mouse = 1;
    int ear = 2;

    // 기본 생성자 직접 명시
    Face() {
    }

    // 생성자 오버로딩(Constructor Overloading)
    Face(int hair, int eye, int nose, int mouse, int ear) {
        // this. : 객체 자기자신을 가리키는 레퍼런스
        this.hair = hair;
        this.eye = eye;
        this.nose = nose;
        this.mouse = mouse;
        this.ear = ear;

        // 객체의 메소드 호출
        print();

        // 생성자 함수 : 객체를 생성 후, 생성자 함수 바디(코드블럭) 실행
    }

    void print() {
        System.out.println("머리 : "+hair);
        System.out.println("눈 : "+eye);
        System.out.println("코 : "+nose);
        System.out.println("입 : "+mouse);
        System.out.println("귀 : "+eye);
    }
}

class Person {
    Arm left = new Arm();
    Arm right = new Arm();

    int arm;
    int leg;
    int body;
    Face face = new Face();
}

public class DAY10_ClassSample {
    public static void main(String[] args) {
        Person kimjonghee = new Person();
        Person father = new Person();
        Person mother = new Person();
    }
}
