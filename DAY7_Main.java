/**
 * - 함수(Functions)
 *   입력과 출력이 있고, 입력줬을 때, 동일한 값을 배출하는 코드 묶음
 *   여기서 말하는 동일한 값은 알고리즘을 거쳤을 때 예상치와 같이 동일한 결과
 *
 * - 수학에서의 함수
 *   y = f(x)
 *   입력 x를 줬을 때, 출력 y를 배출
 *
 * - 호출 기준 : 함수 호출 기본 형식
 *                  y    = f      (     x     )
 *   {데이터타입} {변수명} = {함수명}( {파라미터} );
 *     ==> 리턴 값이 있을 때 + 변수에 담고 싶을 때
 *         e.g. `boolean isStartsWith = baseStr.startsWith(starts);`
 *                         {함수명}( {파라미터} );
 *     ==> 리턴 값이 없을 때 + 단순 호출만 하고 싶을 때
 *         리턴 값이 있을 때 + 단순 호출만 하고 싶을 때
 *         e.g. `baseStr.startsWith(starts);`
 *
 * - 선언/정의 기준 : 함수 선언 기본 형식
 *
 *   `
 *   {리턴 타입}  {함수명} ( {파라미터} ) {
 *      // 코드 작성
 *
 *      // 써도되고 안 써도됨
 *      //
 *      // 리턴타입이 void가 아닐 때 작성해야 함
 *      // 리턴타입이 void 라면, 작성해도 되고 안해도 됨
 *      //
 *      // void 이고, 작성했을 때 : return;
 *      // void 이고, 작성안하고 싶을 때 : 안쓰면 됨
 *      [ return {변수명 또는 값}; ] <== 일반적으로는 변수명, 특정한 의미를 줄 때는 상수, 리터럴 주는 경우는 거의 없음
 *   }
 *   `
 *
 *   Tip. void vs null
 *        void는 공간은 있으나, 안이 비어있음을 의미(타입이 무엇인지 모르는 상태, 타입은 맞음)
 *        null은 값이 없음을 의미(아예 없는 상태, !값!으로써...즉, 타입이 아님!)
 *
 *        void는 이상없음 의미
 *
 *        main 함수 기준으로
 *        C언어에서는
 *        `int main(char* args) { return 0; // 이상없음 == 0, 이상있음? 숫자 }`
 *        Java언어에서는
 *        `public static void main(String[] args) {}`
 *
 * - ( {파라미터} )
 *   한 개 : `{데이터타입}  {파라미터명}`
 *   두 개 : `{데이터타입}  {파라미터명}, {데이터타입}  {파라미터명}`
 *   N 개 : `{데이터타입}  {파라미터명}, {데이터타입}  {파라미터명}, ...`
 *
 *   e.g. int 타입 입력 값 1개, String 타입 입력 값 1개를 파라미터로 전달받는다면,
 *   void fn( int integer, String str ) {}
 *
 * - 함수로 적을 수 있는 형태
 *   입력 값이 없고, 출력 값도 없는 형태
 *   void fn() { // fn은 함수명, 마음대로 작명(대신 숫자/언더라인 외 다른 특수문자 안됨)
 *      [ return; ]
 *   }
 *
 *   입력 값이 없고, 출력 값은 있는 형태
 *   {데이터타입} fn() { // fn은 함수명
 *      return {데이터타입의 값/상수/변수} ;
 *   }
 *
 *   입력 값이 있고, 출력 값은 없는 형태
 *   void fn( {파라미터} ) { // fn은 함수명
 *      [ return; ]
 *   }
 *
 *   입력 값이 있고, 출력 값이 있는 형태
 *   {데이터타입} fn( {파라미터} ) { // fn은 함수명
 *      return {데이터타입의 값/상수/변수} ;
 *   }
 *
 * - 리턴(Return)
 *   함수를 호출했을 때 일어나는 과정
 *
 *   1. (함수 호출( fn() )을 했을 때 리턴 값이 있든 없든 중요치 않음)
 *      함수 호출을 하게 되면, JVM은 그 함수가 선언된 부분을 찾아감
 *      이 때, JVM은 함수를 찾아가기 전에 명령행의 위치(프로그램 카운터)를 기억해둠
 *   2. 함수 내용을 실행
 *      도중에 다른 함수 호출을 만나면, 1번처럼 여기서 다시 프로그램 카운터 기억 후
 *      함수 내용을 실행
 *   3. return을 만나면,(없을 경우엔 코드블럭 끝을 확인)
 *      리턴 값과 리턴 타입과 비교 후 호출했던 지점으로 돌아감
 *      값을 가지고 갈 때, 값 복사를 해서 가져가고, 기존 값은 삭제
 *   4. 그 다음행 부터 실행
 *      마지막 빠져나가는 지점까지 반복
 *
 * - 재귀함수(Recursive Functions)
 *   함수가 자기자신을 재호출하는 것
 *
 *   e.g.
 *   // 재귀함수 스타일로 반복
 *   void fn() {
 *       int x = 10;
 *       fn();
 *   }
 *
 *   // 반복문 스타일로 반복
 *   int x = 10;
 *   while(...) {
 *   }
 *
 *   재귀함수 사용 시 주의사항(알고 있어야할 사항)
 *   함수 호출 시 무엇을 저장하는가? 프로그램 카운터, 함수 호출 전에 선언한 변수, ... 등
 *   방금 언급한 사항들이 모두 스택 Stack 영역에 저장됨
 *   이렇게 할 때, 함수를 많이 호출할 경우(극단적으로 10,000번) 메모리(스택영역)가
 *   가득 찰 수도 있음. 그래서 프로그램이 종료될 수도 있음(Stack overflow)
 *
 *   Overflow? 최고/최종 값을 벗어난 상태(양의 방향)
 *   Underflow? 최저 값을 벗어난 상태(음의 방향)
 *
 *   반복문 vs 재귀함수 (재귀함수는 호출 시작부터 반복문처럼 동작)
 *   재귀함수는 메모리 소비가 큼, 반복문보다 성능이 빠름
 *   반복문은 메모리 소비는 적음, 재귀함수보다 성능이 느림
 *   둘중의 선택 기준 : 횟수와 사용자의 메모리 용량
 *
 *   Tip. 재귀함수 작성해보기
 *        void fn() {
 *            // 중단점 : 종료지점
 *            if( ... ) { <== 어떤 조건에서 종료될 것 인가
 *                return; <== `return fn();` 여기부분에서는 다시 재귀 호출하지 않을 것!
 *            }
 *            return fn();
 *        }
 *
 *        e.g. 덧셈으로 한다면?
 *        int sum(int x) { <== x는 무엇인가? 특정한 수
 *            if(x == 1) {
 *                return x;
 *            }
 *            return x + sum(x-1);
 *            // 호출 시 생각 과정 : 5 + 4 + 3 + 2 + 1
 *            // 실행될 때 과정 : 1 + 2 + 3 + 4 + 5
 *            //
 *            // 5 + sum(5-1) : 5 + ( 4 + ( 3 + ( 2 + (2-1) ) ) )
 *            // 4 + sum(4-1) : 4 + ( 3 + ( 2 + (2-1) ) )
 *            // 3 + sum(3-1) : 3 + ( 2 + (2-1) )
 *            // 2 + sum(2-1) : 2 + (2-1)
 *            // 1            : 1
 *        }
 *
 * - 함수 오버로딩(Functions Overloading)
 *   같은 이름을 가진 함수를 여러 개 선언하는 것
 *
 *   함수가 어떻게 선언되고, 컴파일러가 함수를 어떻게 읽어가는가?
 *   함수 헤더/시그니처(Function Header/Signature)를 기준으로 읽음
 *
 *   int hello(String s, int a)
 *       => int (String s, int a)
 *       => int(String,int)
 *       => (Java 한정) (String,int)
 *   int hello(int a, String s)
 *       => int (int a, String s)
 *       => int(int,String) ---- int(String,int) == int(int,String) ? true : false
 *       => (Java 한정) (int,String) ---- (String,int) == (int,String) ? true : false
 *
 *   이름? 단순 식별용...그 이상 / 그 이하도 아님
 *   단, 자바 컴파일러는 반환형은 함수 시그니처에 포함하지 않음
 *   그래서, 함수의 시그니처 중 파라미터 부분이 달라야 함수 오버로딩을 할 수 있음
 *   (파라미터 이름은 대상이 아님, 기준은? !!파라미터의 타입!!
 *    이해가 안된다면? "컴파일러가 함수를 어떻게 읽어가는가?" 다시 읽어보기)
 *
 *       e.g. 응용
 *           초기화 식 같은 것을 구현해낼 수 있음
 *
 *           boolean palindrome(String palindrome) {
 *               return palindrome(palindrome, 0);
 *           }
 *           boolean palindrome(String palindrome, int i) {
 *               ...
 *               return front == back && palindrome(palindrome, i + 1);
 *           }
 *
 *           유사한 다른 형식의 함수를 추가할 수 있음
 *
 *           int addNumbers(int x, int y) {
 *               return x + y;
 *           }
 *           double addNumbers(double x, double y) {
 *               return x + y;
 *           }
 *
 *           클래스 생성자에서 사용 가능
 *
 *           MyClass() {// 기본 생성자 함수
 *               init();
 *           }
 *           MyClass(int i) {// 세컨더리 생성자 함수
 *               init(i);
 *           }
 *           void init(int i) {
 *               ...
 *               init();
 *           }
 *           void init() {
 *               ...
 *           }
 *
 * - 동적 갯수 파라미터(Number of dynamic parameter)
 *   함수의 파라미터를 우리가 직접 모두 정의하지 않고, 한 번에 여러 개 정의하는 것
 *   단, 동적 갯수 파라미터의 타입이 달라질 수 없음
 *
 *   `
 *   void function( {타입}... {동적 갯수 파라미터명} ) {
 *       // 동적 갯수 파라미터 == 배열    ==>   배열의 길이를 제한할 수는 없음
 *       // 타입이 중간에 달라지면, 다른 파라미터에 전달되어야 하는 것으로 간주함
 *       ...
 *   }
 *   `
 *
 *   e.g. 주어진 파라미터를 모두 더하는 함수
 *
 *       int sum(int... args) {
 *           int result = 0;
 *           for(int i = 0; i < args.length; i++) {
 *               result += args[i];
 *           }
 *           return result;
 *       }
 *
 *       // 호출 시
 *       sum(1, 2, 3, 4);
 *       sum(10, 11, 12);
 *       sum(1, 2);
 *
 *       // 들어오는 파라미터가 Object라면?
 *       void dynamicOfParameter(Object... args) {
 *           ...
 *       }
 *       // Object형 호출 시?
 *       dynamicOfParameter(1, "str", 1.0, true);
 *
 *   Tip. Object형
 *        모든 클래스의 최상위 클래스
 *        Java에서는 모든 것은 객체이기 때문에, 모두 다 여기에 해당됨(기본형 조차도...)
 *        Object == 모든 값을 할당 가능한 타입(== 타 언어 기준 Any, Object, ... 등)
 */
public class DAY7_Main {

    public static void main(String[] args) {
        // 클래스(static) 함수 호출할 때
        DAY7_Main.classFunction();

        // !!이렇게 작성하시는 것 권장!!
        // 객체 함수 호출할 때
        //
        // 잘 모르겠으니, 일단 이대로 작성
        // public class DAY8_Main 이라면,
        // DAY8_Main 변수 = new DAY8_Main();
        DAY7_Main main = new DAY7_Main();
        main.instanceFunction();
        main.instanceFunction2();

        // 덧셈 함수 결과 확인
        int addResult = main.add(10, 20);
        System.out.println("add : " + addResult);
        // 뺄셈 함수 결과 확인
        int x = 12839;
        int substractResult = main.substract(x, 6372);
        System.out.println("substract : " + substractResult);
        // 곱셈 함수 결과 확인
        System.out.println("multiply : " + main.multiply(x, 6372));
        // 나눗셈 함수 결과 확인
        System.out.println(
            "divide : " +
                main.divide(
                    main.add(10, 20),
                    main.multiply(10, 20)
                )
        );

        main.lengthSum(
            2,
            "hello", "world", "Java", "Number of dynamic parameter"
        );

        // 배열 vs 동적 갯수 파라미터
        String[] a = { "String", "String2" };
        callWithArray(a, 0);
        callWithDynamicNumberOfParameter("String", "String2");
    }

    // 객체 함수
    void instanceFunction() {}
    void instanceFunction2() {
    }

    // 클래스(static) 함수
    static void classFunction() {}


    // RESULT_1, RESULT_2 라는 이름을 갖는 상수에 의미를 가져갈 수 있도록 만들어줌
    final static int RESULT_1 = 10;
    final static int RESULT_2 = 20;
    int some() {
        return RESULT_2;
    }

    /*
     * Tip. 함수 작성
     *      1. 다음과 같이 작성 : `void function() {}`
     *      2. 입력 값이 있는가? 있다면, 괄호(`()`) 안쪽 내용 채우기
     *      3. 출력 값이 있는가? 있다면, 알맞은 타입을 void 자리에 작성
     *      4. 출력 값이 있었다면, [ return {값/상수/변수} ]문 작성
     *      5. 함수의 동작 코드를 채우기
     */

    // 리턴이 int 타입이고, 주어진 A와 B를 더해서 배출하는 함수
    int add(int a, int b) {
        // 변수 리턴 방식
        int result = a + b;
        return result;

        // 값 리턴 방식
        // return a + b;
    }

    // 두 숫자를 입력받고, 뺄셈
    int substract(int x, int y) {
        // 변수를 리턴하는 방식
        int result = x - y;
        return result;
    }

    // 두 숫자를 입력받고, 곱셈
    int multiply(int x, int y) {
        // (식을 리턴하는 것이 아니라,)
        // 값을 리턴하는 방식
        return x * y;
    }

    // 두 숫자를 입력받고, 나눗셈
    int divide(int x, int y) {
        return x / y;
    }

    // 재귀함수 : 팩토리얼(https://ko.wikipedia.org/wiki/%EA%B3%84%EC%8A%B9)
    //           https://www.acmicpc.net/problem/27433
    //       -1  -1  -1  -1
    // 5! = 5 x 4 x 3 x 2 x 1
    int factorial(int n) {
        if(n == 1) {// 마지막 값 찾기
            return 1;// 그리고, 그 마지막 값 반환
        }
        // 곱셈 규칙 적용
        return n * factorial(
            //수의 규칙 적용(수열)
            n - 1
        );
    }

    // 재귀함수 : 피보나치의 수(https://ko.wikipedia.org/wiki/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98_%EC%88%98)
    //           https://www.acmicpc.net/problem/10870
    // f(5) = f(n-1) + f(n-2)
    // f(0) = 0
    // f(1) = 1 ==> if(n <= 1) { return n; }
    int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // 재귀함수 : 회문(https://namu.wiki/w/%ED%9A%8C%EB%AC%B8)
    //           https://www.acmicpc.net/problem/25501
    // 반틈 읽었을 때(앞과 뒷쪽으로 읽어야함) : str.length / 2
    // 양끝의 글자들이 차례로 안쪽으로 오면서 읽고, 비교
    boolean palindrome(String palindrome, int i) {
        int length = palindrome.length();
        char front = palindrome.charAt(i);
        char back = palindrome.charAt((length - 1) - i );//총 길이 - 1 = 마지막 인덱스, -i

        if(i >= length / 2) { // for문 기준의 반대 조건을 적용하면 됨
            // i == 2
            // ABABA : i < (5 / 2 => 2.5)
            // ABABA :
            // 01234
            // == return front == back;
            return true;
        }
        return front == back && palindrome(palindrome, i + 1);
    }

    // 동적 갯수 파라미터 예시
    int lengthSum(int start, String... args) {
        int result = 0;
        int i = 0;
        for(final String s : args) {
            if(i < start) { // 동적 갯수 파라미터에서 시작 위치
                i++;
                continue;
            }
            result += s.length();
            i++;
        }
        return result;
    }


    public static void callWithArray(String[] args, int a) {}
    public static void callWithDynamicNumberOfParameter(String... args /*, int a 불가*/) {}
}










