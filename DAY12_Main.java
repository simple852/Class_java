/**
 * - 인터페이스(Interface, `interface` + `implements`)
 *   필드를 갖지않는 추상 클래스(연관 단어 : 구현)
 *   필드, 생성자 갖지 않음 => 상태 정보와 관계없이 동작(함수)만 요구한대로 맞춰지면 됨
 *   필드를 갖는다 => 상태(값) 정보를 가짐
 *
 *   메소드에 대해 프로토콜을 맞추는 용도 (e.g. 콘센트와 케이블 연상)
 *   다중 구현 가능
 *
 *   `
 *   interface [인터페이명] {
 *       // 필드가 없음... => 액세서로 강제함
 *       int getProp();
 *       void setProp(int newValue);
 *
 *       // 추상 메소드만 선언 가능(`abstract` 키워드는 없어도 됨)
 *       // 무조건 public, 접근제한자 변경 불가
 *       void method();
 *   }
 *   class MyClass implements [인터페이스명] {
 *       int prop;
 *       @Override
 *       int getProp() { return prop; }
 *       @Override
 *       void setProp(int newValue) { prop = newValue; }
 *
 *       @Override
 *       void method() {
 *           // 추상 메소드 구현, super.method() 처럼 기존 메소드 사용 불가
 *       }
 *   }
 *   `
 *
 *   Tip. 다형성(Polymorphism)
 *        객체의 모양이 다양해질 수 있음
 *        프로그래밍에서 객체의 모양이 다양해지는 방법
 *        - 상속 : B가 A를 상속받았다면, `B는 A다.` B가 A도 될 수 있고, B도 될 수 있음.
 *        - 구현 : B가 C를 구현했다면, `B는 C다.` B가 C도 될 수 있고, B도 될 수 있음.
 *
 *        interface InterfaceA {}
 *        interface InterfaceB {}
 *        class ClassA {}
 *
 * - 무명 클래스(생성할 때 직접적으로 구현하는 방법, `new`)
 *
 *
 */
interface Interface1 {
    abstract void methodWithAbstractKeyword();
    void method();
}
interface Interface2 {
    abstract void methodWithAbstractKeyword();
    void method();
}
class Impl implements Interface1, Interface2 {
    @Override
    public void method() {
        System.out.println("method!");
    }

    @Override
    public void methodWithAbstractKeyword() {

    }

    static void entryPoint() {
        Impl impl = new Impl();
        Interface1 interface1 = new Impl();
        Interface2 interface2 = new Impl();
        impl.method();
        interface1.method();
        interface2.method();
    }
}

//abstract class AbstractClass1 {
//    int prop = 10;
//}
//abstract class Abstractclass2 {
//    int prop = 20;
//}
//class AbstractImpl extends  AbstractClass1, Abstractclass2 {
//
//}

abstract class Parent {
    void method() {}
    // 몸체를 어떻게 구현해야할지 모르기때문에 구현을 나중으로 미룸
    abstract void abstractMethod();
}

interface Interface {
    void method();
}

class Child extends Parent implements Interface {
    @Override
    public void method() {
        super.method();
    }

    // 명확해졌을 때 구현함
    @Override
    void abstractMethod() { }

    void methodOfChild() {}
}

public class DAY12_Main {
    public static void main(String[] args) {
        // Child -> Parent가 되려면, 무엇을 버려야하는가?
        // Child가 가진 필드나 메소드만 버리면, Parent가 될 수 있음

        // Parent -> Child가 되려면, 무엇을 더 얻어야하는가?
        // Parent를 상속받는 Child는 Child 클래스만 가능한가? => 상속은 상속받지 못하도록 하지는 못함
        // Parent의 자식 클래스가 무엇이 될지 알 수 없기 때문에 불가

        Child child = new Child();
        child.method();
        child.methodOfChild();

        Parent parent = new Child();
        parent.method();
        // 이것 불가 : parent는 parent 모양만 알고 있음
        // child.methodOfChild();

        // 이건 가능... : child는 이미 parent의 부분을 모두 갖고 있음...
        parent = child;

        // 이건 불가능... : child에 더 필요한 부분이 뭔지 모름...
        //child = parent;

        // child는 Interface 인터페이스에서 요구하는 메소드 구현 요건을 모두 만족했으므로 가능
        Interface asInterface = child;

        // 불가 : 인터페이스에서 구현을 요구하는 메소드가 아니기 때문에 불가능
        //asInterface.method();

        // parent는 Parent 클래스 형태의 객체이므로, 인터페이스를 변환할 수 없음
        //parent = asInterface;

        // Parent 클래스는 Interface 인터페이스를 구현한 적이 없기 때문에 불가
        //asInterface = parent;

    }
}
