/**
 * - 추상화(Abstraction)
 *   작은 개념에서 그보다 더 큰 개념으로 대략적으로(정확한 구현없이)만드는 것
 *      > 수정에 대한 처리 최소화
 *
 *   보통 책에서 `특정한 개념에서 공통적인 부분만 추출해내서 추상적으로 만든 것`
 *   e.g. 사람 > 동물
 *
 * - 상속(Inheritance, `extends`) (vs 확장(Extension))
 *   일상 : 부모가 가진 것에서 자식에게 물려주는 것
 *   코딩 : 부모 클래스에서 자식 클래스로 필드 또는 메소드, 생성자, ...등을 물려주는 것
 *
 *   `
 *   class Parent {
 *       int sample = 20;
 *       ...
 *   }
 *   class Child extends Parent {
 *       // 여기에도 `int sample = 20;` 이 그대로 전수됨
 *       ...
 *   }
 *   `
 *
 *   문제1. 단일 상속만 가능
 *         여러 개를 상속받을 수 없기 때문에 기회는 단 한번...
 *         => 만약, 두 개 이상을 상속해야한다면, 전략 패턴(Strategy)으로 우회 사용
 *   문제2. 상속받는 클래스(부모)의 내부를 어느정도 이해해야 함
 *
 *   Tip. 다중 상속의 문제 (C++에서는 다중 상속 지원함)
 *        A클래스에 a 멤버변수가 있다고 가정했을 때,
 *        B클래스에서 a 멤버변수(동일이름)가 또 있다면?
 *        자식 클래스에서는 어느 것을 사용해야하는가? 라는 문제...
 *        명확하게 지칭해주면 되지 않나요?
 *        명시적으로 해주어야하는데, 누락시키는 경우로 인해 동작 이상 발생 가능
 *
 *   Tip. 생성자 호출 과정
 *        자식 > 부모 > 부모 > ... > 최상위 > 자식 > 자식 > ... > 자식
 *
 *        생성자도 함수! 그렇다면, super(...)라고 했던 부모 생성자의 호출이 기준이
 *        그 상속받은 멤버변수들의 초기화 여부가 결정됨
 *
 * - 메소드 오버라이드(Method Override)
 *   부모의 함수를 재정의하는 것
 *   메소드 : 생성자, 액세서, 기능 메소드, ...
 *   final : 더 이상 재정의 불가하다는 것을 의미
 *
 *   `
 *   class Parent {
 *       void method() {}
 *   }
 *   class Child extends Parent {
 *       @Override
 *       void method() {
 *           //여기에 코드를 작성하면, 실행 전 동작 코드
 *
 *           //super.method();
 *
 *           //여기에 코드를 작성하면, 실행된 후 동작 코드
 *
 *
 *
 *           // 오버라이드한 부모 메소드를 직접적으로 호출하여,
 *           // 메소드 숨김 현상(Method Hiding/Shadowing) 피할 수 있음
 *           // 의도적으로 숨기고 싶다면? 호출안하면 됨
 *           // 그런데, 일반적으로는 기존 기능에서 나의 기능을 추가하려고 하기 때문에
 *           // 호출해주는 것이 일반적임
 *           super.method();
 *       }
 *   }
 *   `
 *
 * - 추상 클래스(Abstract class, `abstract` + `extends`)
 *   상속의 기본 규칙을 모두 따름
 *   추상 클래스로 선언되면, 추상 메소드를 사용할 수 있게 됨
 *   생성자 함수를 갖지 않음 (왜? 생성자를 사용할 수 있게 되면,
 *                             몸체가 없는 추상 메소드 호출할 수 있게
 *                             된다는 논리와 같음 => 문제있음...)
 *
 *   추상 메소드는 몸체를 갖지않는 메소드 => 몸체없는 메소드
 *   몸체는 상속받는 측(자식)에서 메소드 오버라이드로 구현하게 됨
 *
 *   e.g. 동물은 뛸 수 있음 => 어떻게 뛰던간에 뛸 수 있음
 *        사람은 뛸 수 있음 => 어떻게 뛰는지 정확하게 코드적으로 작성됨
 *
 *   `
 *   abstract class Animal {
 *       // 어떻게 걷는지 몰라서 몸체를 갖지만, 구현을 안할 수도 있음
 *       // 또한, 구현을 강제하지 않음(몸체가 이미 구현되어있기 때문에)
 *       // 이렇게 사용하는 경우들 :
 *       //        꼭 구현하지 않더라도 관계없을 때 => 시점끼어들기(메소드 훅 Method Hook)
 *       //        기본 몸체를 가지게 할 때 => 기본적인 동작을 부여해놓고 싶을 때
 *       void work() { }
 *
 *       // 어떻게 뛰는지 몰라서 몸체가 전혀 없음
 *       // 몸체가 없기 때문에 상속받는 측(자식)에서 강제적으로 구현해야할 의무가 주어짐
 *       // 접근 제한자(public/protected/private) 사용 가능
 *       abstract void run();
 *   }
 *   class Person extends Animal {
 *       @Override
 *       //final void run() { ... } => 상속을 받더라도 더 이상 메소드 오버라이딩 불가
 *       void run() {
 *           // 추상 메소드 구현, super.run() 처럼 기존 메소드 사용 불가
 *           ...
 *       }
 *   }
 *   class KimJongHee extends Person {
 *       @Override
 *       void run() { super.run(); ... }
 *   }
 *   `
 *
 *   Tip. 메소드 오버라이드와 추상 메소드 조합
 *        추상 메소드는 강제적으로 구현을 요구할 떄 사용
 *        메소드 오버라이드는 몸체가 있기 때문에 옵션적으로 개입시킬 때 사용
 *        (프로그래밍 템플릿 패턴 참조)
 */
public class DAY11_Main {

    static class Parent {
        int sample;

        // 생성자에 들어오는 파라미터가 다 다를 때
        Parent() {
            // 1차 가공

            // 생성의 초기화를 공통화하는 방법2
            this(3387490);
        }
        Parent(int sample) {
            // 1차 가공

            // 생성의 초기화를 공통화하는 방법1
            init(sample);
        }

        // 초기화를 한 곳에서 몰아올 수 있음
        // private 으로 자식 클래스에서도 함부로 초기화할 수 없게 함
        private void init(int sample) {
            this.sample = sample;
        }

        void parentMethod() {}
    }
    static class Child extends Parent {
        Child() {
            // 상속된 멤버변수가 아직 초기화 되지 않은 상태의 위치

            // 부모 생성자 호출 => Parent() {} 호출함
            // 부모 생성자의 시그니처는 선택적으로 호출하면 됨
            super(456465);

            // 상속된 멤버변수가 초기화되고 난 상태의 위치
        }
        void childMethod() {
            System.out.println(sample);
            parentMethod();
        }

        @Override
        void parentMethod() {
            super.parentMethod();
        }
    }
    static class DifChild extends Parent { }

    // 다중 상속 허용 안됨
    // static class DifParent { }
    // static class MultiExtends extends Parent, DifParent { }

    // 문제 : 사람은 동물이 될 수 있고, 사람은 강사이다. 동시에 표현 불가


    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        // 타입 캐스팅대한 테스팅
//        // 동물은 동물입니다.
//        Animal animal = new Animal();// 추상 클래스이기 때문에 생성자 없음!
//        // 사람은 사람입니다.
//        Person person = new Person();
//        // 사람은 동물입니다.
//        Animal personWithAnimal = new Person();
//        // 동물은 사람입니다.
//        //Person animalWithPerson = new Animal();
//
//        // 사람은 동물입니다.
//        animal = person;
//        // 동물은 사람입니다. (틀림)
//        //person = animal;
    }

    //동물 비유
    static abstract class Animal {
        // 상속에서만 호출 가능, 직접적으로 외부에서 생성하기위해 사용하는 것은 불가
        // 상속을 받아서 구현할 때는 이미 run 메소드는 몸체를 가질 것이기 때문에 가능
        Animal() { }

        // 구현을 해도 되고, 안해도 되는 패턴의 경우 이 방법을 사용함
        // 실제 코드에서는, 안드로이드 라이프사이클 같은 것이 이렇게 구현되어 있음
        void work() {}

        abstract void run();
    }
    static class Person extends Animal {
        Person(){
            super();
        }

        @Override
        void run() { }
    }
}

abstract class ApplicationLifecycle {
    void onCreate(){}
    void onStart(){}
    void onResume(){}

    // 템플릿 패턴 : 구조 패턴
    final void run() {
        // 생성 전 해야할 것들
        onCreate();
        // 생성 후 해야할 것들

        // 시작 전 해야할 것들
        onStart();
        // 시작 후 해야할 것들

        // 반복 재생 전 해야할 것들
        onResume();
        // 반복 재생 후 해야할 것들
    }
}

class MyApplication extends ApplicationLifecycle {
    //onCreate 단계에 개입하고 싶을 때, 구현하면 됨
    @Override
    void onCreate() {

    }

}
