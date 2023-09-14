/**
 * - 클래스(Class)
 *   객체를 분류하고, 그것을 코드화하여 타입으로 표현
 *
 *   일반적인 책에서는 "객체를 찍어내는 일종의 틀" 로 지칭
 *   => 여기서 모순점이 있음, 타입이 객체를 찍어내기 위한 틀정도의 수준인가?
 *      클래스라는 것은 반, 즉, 분류이자 가공된 자료인 정보. (Classify : 분류하다.)
 *
 *   Tip. 자료 vs 정보
 *        자료는 가공되지 않은 상태/값
 *        정보는 가공된 상태/값
 *
 * - 특정한 개념에 대한 분류의 과정
 *   객체는 단순히 사물이 아님 즉, 객체는 개념. (눈에 보이지 않는 것 또한 포함될 수 있음.)
 *   그래서, 객체를 분류할 때에는 [ 작은 범위 -> 큰 범위 ] 또는 [ 큰 범위 -> 작은 범위 ]로 분류.
 *   큰 범위로 갈수록 추상화되고, 작은 범위로 갈수록 구체화.
 *
 * - 객체 지향 프로그래밍
 *   클래스
 *      ㄴ 필드 : 개념의 상태정보 또는 속성 => 변수(값)
 *      ㄴ 메소드 : 개념의 행동 또는 기능 => 함수 (+@ 생성자, 액세서, ...)
 *   추상화
 *   다형성
 *   +@ 정보은닉
 *
 * - 클래스
 *   새로운 타입을 정의하는 것
 *
 *   클래스 정의(`class`)
 *
 *   `
 *   class [클래스명] {
 *       // 클래스 필드/메소드
 *       // 필드 (m으로 시작할 것)
 *       // 생성자
 *       // 퍼블릭 메소드
 *       // 프라이빗 메소드
 *       // 중첩/내부 클래스/인터페이스
 *   }
 *   `
 *
 *   객체 생성(`new`)
 *
 *   `
 *   [클래스명] [변수명] = new [클래스명]( [파라미터 값/변수] );
 *   `
 *
 *   멤버 접근 방법(`.`, Reference)
 *
 *   `
 *   [객체변수명] . [멤버 필드/메소드()] ;
 *   `
 *
 *   Tip. 멤버(Member)
 *        클래스에 선언되는 필드/메소드를 지칭
 *
 *        클래스 내 변수 : 필드/멤버변수/속성 가 1개 세트 용어
 *        클래스 내 함수 : 메소드/멤버함수/기능 가 1개 세트 용어
 *
 * - 필드(Field)
 *   객체에 선언된 변수 => 멤버 변수
 *   기본 + 커스텀(클래스) 데이터 타입을 기준으로 값을 저장
 *
 * - 메소드(Method)
 *   객체에 선언된 함수 => 멤버 함수
 *
 * - 생성자(Constructor)
 *   클래스를 객체로 만들어내는 함수
 *   즉, 함수 + 객체 생성 기능만 추가된 함수
 *
 *   이러한 특징에 따라, 생성자 함수 이름 == 그 클래스 이름
 *   `new` 와 함께 사용되어야 함
 *
 *   Tip. 클래스와 객체의 관계
 *        클래스  1 vs N  객체
 *
 * - this
 *   객체 자기자신을 가리키는 레퍼런스
 *
 * - static
 *   객체 생성없이 클래스 그 자체에서 사용 가능하도록 해줌
 *   생성자에서는 불가...
 *
 *   static 정의
 *
 *   `static [데이터타입] [변수명] = ~ ;`
 *   `static [리턴타입] [함수명]( [파라미터] ) { ... }`
 *
 *   static 호출
 *
 *   `[데이터타입] [변수명] = [클래스명].[변수명];`
 *   `[클래스명].[변수명] = ~ ;`
 *   `[클래스명].[함수명]( ~ );`
 *
 * - 멤버 분류
 *   인스턴스/동적(Instance, `new`) : 객체로 만들어진 후 호출 가능
 *      e.g. `(new MyClass()).instanceMethod();`
 *      ㄴ 필드 : 객체별로 변수를 가짐 => 같은 클래스지만, 객체마다 값이 다름
 *      ㄴ 메소드 : 차이없음
 *   클래스/정적(Class, `static`) : 클래스명을 통해서 언제든지 호출 가능
 *      e.g. `MyClass.staticMethod();`
 *      ㄴ 필드 : 클래스가 존재하는 메모리 영역에 있어서, 공유됨(엄밀히 말하면, 틀린 말. 그렇지만, 코드로 작성하다보면, 맞는말.)
 *      ㄴ 메소드 : 차이없음
 *
 *   Tip. Object vs Instance (+ vs Entity)
 *        Object는 모든 것을 의미하는 객체
 *        Instance는 컴퓨터 내 한정해서 의미하는 객체(메모리 상에 있을 때의 객체)
 *        Entity는 정보화된 객체
 *
 *        인스턴스화(Instantiation, Instantiate)는 클래스를 객체로 만들어내는 것
 *
 *        메모리 상에서
 *
 *        - 클래스 : 텍스트/코드 영역(Text/Code Area)
 *        - 인스턴스 : 힙 영역(Heap Area)
 *        - 지역변수(로컬변수) : 스택 영역(Stack Area)
 *        - 실행된 함수 : 스택 영역(Stack Area)
 *
 *        인데, 영역 별로
 *
 *        - 텍스트/코드 영역(Text/Code Area) : 프로그램이 끝날 때까지 존재
 *        - 힙 영역(Heap Area) : 사용자가 필요하면 만들어내고, 필요없을 때 삭제
 *                              (C언어에서 malloc, free 함수와 연관)
 *                              (C++언어에서 new 키워드, delete 키워드와 연관)
 *                              (Java언어에서 new 키워드, 변수를 null로 할당하는 것과 연관)
 *        - 스택 영역(Stack Area) : 임시적으로 존재
 *                                 (최대한 여기를 활용하는 것이 좋음,
 *                                  값이라고 말하는 상태 유지를 할 때 멤버 변수로 가져가는 것이 좋음)
 *
 *   Tip. 강한 참조와 약한 참조(Strong Reference vs Weakness Reference)
 *        참조(Reference)란? 직접적으로 값에 접근위한 메모리 주소
 *
 *        A객체와 B객체 중...
 *
 *        약한 참조 : A객체가 B객체를 멤버변수로 가지고 있고,
 *                   B객체는 A객체를 멤버변수로 가지고 있지 않는 상황
 *
 *                   `
 *                   class A {
 *                       B b = new B();
 *                   }
 *                   class B {
 *                   }
 *                   A a = new A();
 *                   // a 객체 다 사용 후 메모리 해제를 위해...
 *                   a = null;
 *                   `
 *
 *        강한 참조 : A객체가 B객체를 멤버변수로 가지고 있고,
 *                   B객체도 A객체를 멤버변수로 가지고 있는 상황
 *                   (WeakReference<T>, SoftReference<T> 클래스)
 *
 *                   `
 *                   class A {
 *                       B b = new B(this);
 *
 *                       void method() {
 *                           b.method(this);
 *                       }
 *
 *                       void dispose() {
 *                           b.dispose();
 *                           b = null;
 *                       }
 *                   }
 *                   class B {
 *                       A a;
 *                       B(A a) {
 *                           this.a = a;
 *                       }
 *
 *                       // 강한 참조 회피를 위한 방법1
 *                       void dispose() {
 *                           a = null;
 *                       }
 *
 *                       // 강한 참조 회피를 위한 방법2
 *                       void method(A a) {
 *                           a.~~();
 *                       }
 *                   }
 *                   A a = new A();
 *
 *                   //강한 참조 회피를 위해...
 *                   a.method();
 *
 *                   // 강한 참조 회피를 위해...
 *                   a.dispose();
 *
 *                   // a 객체 다 사용 후 메모리 해제를 위해...
 *                   a = null;
 *                   `
 *
 *        그래서, Java에서 절대 하지말아야할 것
 *
 *        - finalize 메소드 사용하지말 것 : GC때 호출이 될 수도 안될 수도 있는 메소드이므로
 *                                       메모리 누수로 이어질 수 있음
 *
 *          `
 *          @Override
 *          void finalize() {
 *              a = null;
 *          }
 *          `
 *
 *        - System.gc 메소드 직접 호출하지 말 것 : GC타임은 가비지 컬렉터가 직접 결정하는 것이기 때문에
 *                                              이 시기가 잘못되어서 성능이 저하될 수 있음
 *
 *          `
 *          System.gc();
 *          `
 *
 *        그렇다면, 가장 좋은 방법은 무엇인가요?
 *        Disposable 인터페이스를 사용하거나 (구현하는 패턴)
 *        `class B implements Disposable { ... }`
 *        WeakReference/SoftReference 클래스 사용 (스트레티지 패턴)
 *        `WeakReference<B> b = new WeakReference<B>()`
 *
 *   Tip. 가비지 컬렉터(Garbage Collector)
 *        ARC(Automatic Reference Counting) = Apple
 *         ㄴ 참조할 때마다 객체에 카운트를 업(멤버변수 B b = new B(); 하면, count += 1)
 *         ㄴ nil(유사. null) 처리할 때마다 카운트를 다운(멤버변수 B b = null; 하면, count -= 1)
 *         ㄴ 하지만, 이 경우에서도 강한 참조 시 문제가 될 수 있지만,
 *            특별한 알고리즘을 통해 해결했음.
 *        GC = Java/Dart, ...
 *         ㄴ Java, ... : Generational algorithm/세대 가비지 컬렉션
 *            ㄴ GC의 횟수 등을 기준으로 해서 시기를 결정
 *               금방 만들어진 시기 Young
 *               / 만들어지고 안정된 시기 Generic
 *               / 한참 전에 만들어진 시기 Old
 *            ㄴ null 처리 기준으로 삭제
 *         ㄴ Dart, ... : Cheney's algorithm/쓰레기 청소부 컬렉션(Scavenger)
 *            ㄴ 복사 출발점 > 복사 도착점 으로 나누고,
 *               출발점에서 도착점까지 참조하고 있지 않은 것은 출발점 메모리 영역에 버려두고 복사
 *               출발점 메모리 영역을 모두 삭제,
 *               다음 GC 때는 도착점이 출발점이되고, 출발점이 도착점이 되어서 반복
 *            ㄴ 복사(Copy)를 통해 삭제
 *            ㄴ null 처리 기준으로 삭제
 *
 *
 * - 접근제어자(Access Modifier)
 *   객체를 사용하는 쪽에서 멤버에 접근 가능 / 불가능을 결정
 *
 *   public : 모두 접근 가능 => 멤버 함수는 특별한 동작이기 때문에 대부분 이걸로 작성
 *   package-private : (키워드 없음/아무것도 작성 안할 시, 기본 값)같은 패키지라면 접근 가능
 *   protected : 상속 관계일 때 호출 가능 => 상속관계까지만 열어주고 싶을 때 이걸로 작성
 *   private : 객체 자기자신만 접근 가능 => 멤버 변수는 특별한 일이 없으면 이걸로 작성
 *                                       멤버 함수는 내부적으로 사용할 목적이라면 이걸로 작성
 *
 * - 액세서(Accessor)
 *   객체 지향에서 정보 은닉(Information Hiding)을 위해 멤버 변수는 대부분 private으로 작성
 *   다른 객체에서 접근할 때 이 메소드를 통하도록 해주는 역할
 *
 *   이름에
 *
 *   get 으로 시작하는 메소드 : Getter, 필드에서 값을 가져올 목적으로 사용됨
 *   set 으로 시작하는 메소드 : Setter, 필드에 값을 변경할 목적으로 사용됨
 *
 *   e.g.
 *   `
 *   class MyClass {
 *       // 객체 지향에서 정보은닉 위반
 *       //int prop = 10;
 *
 *       private int mProp = 10;
 *       int getProp() {
 *           int prop = this.mProp;
 *           // 값을 배출하기 전에 처리해야할 사항들(e.g. Log 기록, ... 등)
 *           return prop;
 *       }
 *       void setProp(int prop) {
 *           // 유효성 검사(Validation Checking) : 내가 원하는 값이 맞는지 체크
 *           // 유효성 - 디펜스 코드(Defence Code) : 값을 원하는 범위로 조정
 *           // Tip. 디펜스 코드? 여기 다음 줄부터 내가 작성한 코드가 잘 동작할 수 있도록 미리 선방어 조치하는 코드
 *           this.mProp = prop;
 *       }
 *
 *   }
 *
 *   MyClass myClass = new MyClass();
 *   // 객체 지향에서 정보은닉 위반
 *   // System.out.println(myClass.prop);
 *   // myClass.prop = 20;
 *   `
 *
 *   Tip. Setter 연속성 주기 - 빌더 패턴의 일부 차용
 *        Setter의 return 에 this를 주면, 연속적으로 호출 가능
 *
 *        `
 *        void setProp(int newValue) {
 *            mProp = newValue;
 *        }
 *        Sample setPropWithBuilderPattern(int newValue) {
 *            mProp = newValue;
 *            return this;
 *        }
 *
 *        Sample sample = new Sample();
 *        sample.setProp(1);
 *        sample.setProp(2);
 *        sample.setProp(3);
 *
 *        sample.setPropWithBuilderPattern(1)
 *              .setPropWithBuilderPattern(2)
 *              .setPropWithBuilderPattern(3);
 *        `
 *
 * - 패키지(Package)
 *   코드의 모음
 *   유사한 코드들(클래스, 유틸리티 함수, ...등)의 모음
 *
 *   툴에서 추가 : src 우클릭 > New > Package 클릭해서 패키지 추가
 *   직접 추가 : 폴더 생성(패키지 추가)
 *
 * - IDE별 파일 관리
 *   인텔리제이 = 단일프로젝트 + 멀티모듈
 *   이클립스 = 멀티프로젝트
 *
 *   모듈 vs 프로젝트
 *   프로젝트(큰개념) > 모듈 > 소스코드들
 *
 *   인텔리제이에서 작업하던 프로젝트를 이클립스로 불러오면 잘 안될 수 있음
 *   이클립스에서 작업하던 프로젝트를 인텔리제이에서 불러오면 잘 안될 수 있음
 *   멀티프로젝트 vs 멀티모듈
 *
 */
import util.view.DrawUtil;
import util.view.*;

public class DAY10_Main {
    public static void main(String[] args) {
        DrawUtil.draw();
        DAY10_Main dfjlkdf = new DAY10_Main();

        // 클래스 1개 당 N개의 객체를 생성 가능
        MyClass myClass1 = new MyClass(new MyClass());
        MyClass myClass2 = new MyClass();
        MyClass myClass3 = new MyClass(myClass2);

        // 객체의 값 가져오기
        System.out.println(myClass1.boolProp);
        // 객체의 값 변경하기
        myClass1.strProp = "Hello, Java";

        // 세 객체는 서로 침범하지 않음
        System.out.println(myClass1.strProp);// Hello, Java
        System.out.println(myClass2.strProp);// str
        System.out.println(myClass3.strProp);// str

        myClass1.printIntProp();// 10, 10000
        myClass2.printIntProp();// 10000, 10000
        myClass3.printIntProp();// 10000, 10000
        System.out.println(MyClass.intProp);// 10000
    }
}

class DifferentClass {

}

class MyClass {
    static int intProp = 10;

    // 선언 + 초기화
    String strProp = "str";
    boolean boolProp = true;

    DifferentClass field = new DifferentClass();

    // 선언 + 초기화
    MyClass initialized = new MyClass(  new MyClass( )  );

    // 선언 후 늦은 초기화(Lazy Initialization)
    MyClass different;

    MyClass() {}

    MyClass(MyClass external) {
        different = external;
    }

    MyClass( boolean sdjfkljk, char adjflksd ) {
        boolProp = sdjfkljk;
    }

    void printIntProp() {
        System.out.println("변경 전 : " + intProp);
        // == MyClass.intProp
        // 그러나, 같은 클래스 내의 객체에서는 MyClass. 생략 가능
        intProp = 10000;
        System.out.println("변경 후 : " + intProp);
    }
}
