/**
 * - 클래스 vs 추상 클래스 vs 인터페이스
 *
 *   타입정의
 *   클래스 : 이미 구체화되어서, 구현체 그 자체임
 *   추상 클래스 : 추상 메소드를 가지기 때문에, 완전히 구현체 자체는 아님
 *   인터페이스 : 기능을 분류하는 정도에 그침
 *
 *   e.g. 클래스 : 김종희는 김종희다.
 *        추상 클래스 : 아직 사람이란 것 밖에는 모르겠지만, 사람으로 되려면, 이정도를 갖춰야한다!(상태적(값) 부분/)
 *        인터페이스 : 사람의 행동은 이런 것을 할 것이다!
 *
 *        abstract class Person { ... }
 *        class KimJongHee extends Person {}
 *
 * - 클래스(+ 상속, `class`+`extends`)
 *   필드 선언/초기화
 *   메소드 선언 - 액세서/일반적인 메소드
 *   생성자 함수 선언
 *   (+ 접근 제어자)
 *   메소드 오버라이드 가능 - 메소드를 사용 가능하기 때문...
 *   오버라이드 방지 가능 - `final`
 *
 * - 추상 클래스(+ 상속, `abstract class`+`extends`)
 *   필드 선언/초기화
 *   메소드 선언 - 액세서/일반적인 메소드
 *   ++ 추상 메소드 - 몸체없음
 *   생성자 함수 선언 - 생성을 위해 직접적인 호출 불가
 *                    (e.g. 이것 안됨! Abstract instance = new Abstract(...))
 *                    자식 클래스를 통해서 간접적인 호출 가능
 *                    (e.g. 이렇게는 가능! super(...))
 *   메소드 오버라이드 가능 - 메소드도, 추상 메소드도 사용 가능하기 때문...
 *   오버라이드 방지 가능 - `final`
 *
 * - 인터페이스(+ 구현, `interface`+`implements`)
 *   필드 사용 불가
 *   추상 메소드만 선언 가능
 *   생성자 함수 불가
 *   메소드 오버라이드 가능 - 추상 메소드가 사용 가능하기 때문...
 *   오버라이드 방지 불가 - 단, 상속을 해서 내려가다보면, 가능
 *                        => 자식클래스에서 최소 한번 구현 후에는(메소드가 몸체를 가지고난 후)
 *                           오버라이드 방지 가능
 *
 * - 상속/구현
 *   클래스 > 클래스 상속
 *   추상 클래스 > 클래스 상속
 *   인터페이스 > 클래스 구현
 *   인터페이스 > 추상 클래스 구현
 *   인터페이스 > 인터페이스 상속
 *
 * - 사용 시기가 언제인지 이해가 안갑니다.
 *   => 라이브러리를 만들어낸다.
 *   => 다중상속은 불가하다, 다중구현은 가능하다.
 *   => 왜 이 언어를 이렇게 만들었을까?
 *
 * - 타입 변환(Type casting)
 *   묵시적 타입 캐스팅(Implicit Type Casting)
 *      `([TYPE])` 이런 문법해서 타입을 강제적으로 변환하지 않고 변환 가능한 유형
 *   명시적 타입 캐스팅(Explicit Type Casting)
 *      `([TYPE])` 이런 문법해서 타입을 강제적으로 변환해야만 변환 가능한 유형
 *
 *   e.g. 사람 타입과 김종희 타입이 있다면,
 *        사람은 김종희다. => 틀린 것임 => 컴파일러도 틀렸다고 생각함 => 강제적 변환 필요
 *        `
 *        Person kim = new KimJongHee()
 *        KimJongHee kimJongHee = (KimJongHee)kim;
 *
 *        void method(Person person) { <- 김종희인지, 다른사람인지 알길이 없음
 *            // 타입 오류...이렇게 무작정 변환하면 안됨
 *            // person 안에는 Person을 만족하는 다른 객체가 있을 수 있음
 *            // 타입 검사 후 수행해야함
 *            KimJongHee kimJongHee = (KimJongHee)person;
 *            ...
 *        }
 *        `
 *
 *        김종희는 사람이다.
 *        `
 *        KimJongHee kimJongHee = new KimJongHee();
 *        Person person = kimJongHee;
 *
 *        method((KimJongHee)person);// 사람은 김종희다. 이것을 만족시키기위해 강제적 형변환
 *        method(kimJongHee);
 *
 *        void method(KimJongHee kimJongHee) {
 *            // 이 메소드는 재사용성이나 범용성 측면에서 많이 떨어짐
 *        }
 *        `
 *
 * - 무명 클래스(생성할 때 직접적으로 구현하는 방법, `new`)
 *   `new` 키워드는 원래 클래스/배열에서만 사용 가능
 *
 *   1회성으로 클래스를 만들어서 객체를 만들고 난 후 사용하는 방법
 */
abstract class MyAbstract {
    // 추상메소드
    abstract void abstractMethod();
    // 몸체를 갖는 메소드(이미 구현되어있는 메소드)
    void method() {}
}
interface MyInterface {
    void method1();
    void method2();
}
public class DAY13_Main {
    public static void main(String[] args) {
        MyAbstract myAbstractInstance = new MyAbstract() {
            private int field;
            // 무명 클래스 초기화를 위한 임시적 메소드
            MyAbstract init(int p) {
                field = p;
                return this;
            }

            @Override
            void abstractMethod() {
                method();
            }
        }.init(456);

        MyInterface instance = new MyInterface() {
            private int field;

            // 무명 클래스 초기화를 위한 임시적 메소드
            MyInterface init(int p) {
                field = p;
                return this;
            }

            @Override
            public void method1() { }
            @Override
            public void method2() { }
        }.init(12783);

        callWithMyAbstract(myAbstractInstance);

        callWithMyAbstract(new MyAbstract() {
            private int field;
            // 무명 클래스 초기화를 위한 임시적 메소드
            MyAbstract init(int p) {
                field = p;
                return this;
            }

            @Override
            void abstractMethod() {
                method();
            }
        }.init(456));
    }
    static void callWithMyAbstract(MyAbstract myAbstract) {
        myAbstract.abstractMethod();
    }
}

interface Day13A1 {
    void f1();
}
interface Day13A2 {
    void f2();
}
interface Day13A extends Day13A1, Day13A2 {
    void f3();
}

class Day13B {
    private Day13A day13A;
    public Day13B(Day13A day13A) {
        this.day13A = day13A;
    }
    void template() {
        // 뭔갈 할것
        day13A.f1();//Delegated
        // 뭔갈 할것
        day13A.f2();
        // 뭔갈 할것
        day13A.f3();
        // 뭔갈 할것
    }

    static void entryPoint() {
        Day13B day13B = new Day13B(
            // 외부에서 기능 구현을 받아서 실행함
            new Day13A() {
                @Override
                public void f3() { }
                @Override
                public void f1() { }
                @Override
                public void f2() { }
            }
        );
    }
}


















interface 기능모음1 {
    void 기능1_1();
    void 기능1_2();
}
interface 기능모음2 {
    void 기능2_1();
    void 기능2_2();
}

class 기능유형1 implements 기능모음1 {
    @Override
    public void 기능1_1(){}
    @Override
    public void 기능1_2(){}
}
class 기능유형2 implements 기능모음2 {
    @Override
    public void 기능2_1(){}
    @Override
    public void 기능2_2(){}
}
class 모든기능유형 implements 기능모음1, 기능모음2 {
    @Override
    public void 기능1_1(){}
    @Override
    public void 기능1_2(){}
    @Override
    public void 기능2_1(){}
    @Override
    public void 기능2_2(){}
}
class 모든기능유형상속 extends 모든기능유형 {

}

class 사용클래스 {
    void 기능모음1사용( 기능모음1 기능 ) {
        기능.기능1_1();
        기능.기능1_2();
    }
    void 기능모음2사용( 기능모음2 기능 ) {
        기능.기능2_1();
        기능.기능2_2();
    }
    void 기능모음1사용( 모든기능유형 기능 ) {
        기능.기능1_1();
        기능.기능1_2();
    }

    static void use() {
        사용클래스 사용인스턴스 = new 사용클래스();

        기능유형1 유형1인스턴스 = new 기능유형1();
        기능유형2 유형2인스턴스 = new 기능유형2();
        모든기능유형 모든유형인스턴스 = new 모든기능유형();

        사용인스턴스.기능모음1사용(유형1인스턴스);
        사용인스턴스.기능모음1사용(유형2인스턴스);//불가
        사용인스턴스.기능모음1사용(모든유형인스턴스);
        사용인스턴스.기능모음2사용(유형1인스턴스);//불가
        사용인스턴스.기능모음2사용(유형2인스턴스);
        사용인스턴스.기능모음2사용(모든유형인스턴스);


        모든기능유형상속 모든유형상속인스턴스 = new 모든기능유형상속();
        사용인스턴스.기능모음1사용(모든유형상속인스턴스);
    }
}
