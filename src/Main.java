import java.util.Random;

/**
 * - 변수/상수 : 메모리에 우리가 원하는 공간을 만드는 행위
 *
 * - 연산자(Operator)
 *   변수/상수 등으로 어떤 연산을 수행하는 것
 *
 * - 연산자 종류/우선순위(2항 연산자)
 *   산술연산(고) > 관계연산 > 논리연산 > 할당연산(저)
 *
 *   산술연산 : 숫자 계산
 *   관계연산 : 두 수의 관계 / 결과
 *   논리연산 : 이런 관계연산이 여러 개 있을 때 묶어주는 역할
 *   할당연산 : 완료된 연산 결과 값을 특정 변수에 저장
 *
 *   3항연산자 : 연산식 ? 값1 : 값2;
 *
 * - 산술연산(Arithmetic) : 언어마다 여기서 추가됨
 *   C == 숫자
 *   덧셈 : C = A + B
 *   뺄셈 : C = A - B
 *   곱셈 : C = A * B
 *   나눗셈 : C = A / B
 *   나머지셈 : C = A % B
 *             A % B = 0 ~ B-1
 *       쉬프팅 A % B + X or A % B - X = (0 +- X) ~ (B - 1 +- X)
 *
 * - 관계연산(Relation) : A는 기준 숫자, B는 비교되는 숫자
 *   C == boolean
 *   크다 : C = A > B
 *   작다 : C = A < B
 *   크거나 같다 : C = A >= B
 *   작거나 같다 : C = A <= B
 *   같다 : C = A == B
 *   다르다 : C = A != B
 *
 * - 논리연산(Logical) : A, B는 관계연산
 *   C == boolean
 *   그리고/And, A도 참, B도 참 : C = A && B
 *   또는/Or, A나 B중에 참 : C = A || B
 *   반전/Not, 결과물을 반대로 만듦 : C = !A
 *        (참 -> 거짓, 거짓 -> 참)
 *
 * - 할당연산(Assignment) : 우측 B는 값이거나 산술/관계/논리 등 연산
 *   우측에서 좌측으로 값을 저장
 *   값 저장 : A = B
 *   (옵션) 산술 + 할당 : A += B, A -= B, A *= B, A /= B, ...
 *      e.g. A = A + B >> A += B
 *   (자주 사용하는 옵션) +1, -1만 수행하는 연산
 *         A++ : +1, 다음 행부터 +1로 되어있음
 *         ++A : +1, 현재 행부터 +1로 되고, 같은 행에서 연산
 *         A-- : -1, 다음 행부터 -1로 되어있음
 *         --A : -1, 현재 행부터 -1로 되고, 같은 행에서 연산
 */
public class Main {
    public static void main(String[] args) {
        // 의사 난수로 임의의 숫자를 만들어냄
        // Tip. 의사 난수 ? 규칙이 있는 알고리즘으로 만들어진 랜덤한 숫자
        Random random = new Random();
        // 0 ~ 100까지만 출력하도록
        int x = random.nextInt( 100 );
        // -~~ ~ +~~ 사이의 숫자를 출력 후 나머지셈으로 제한
        // 음수도 포함되기 때문에 절대값을 취함
        int y = Math.abs(random.nextInt() % 100);
        int z = Math.abs(random.nextInt() % 100);

        // 결과물을 변수에 담음
        int additionC = x + y;
        int substractionC = x - y;
        int multiplyC = x * y;
        int divideC = x / y;
        int modularC = x % y;

        boolean isGreaterThan = x > y;
        boolean isLessThan = x < y;
        boolean isGreaterThanOrEqual = x >= y;
        boolean isLessThanOrEqual = x <= y;
        boolean isEqual = x == y;
        boolean isNotEqual = x != y;

        // 관계식을 직접 사용하거나
        // boolean 에 담아서 사용할 수도 있다.
        boolean AND_style1 = x > y && x == y;
        boolean AND_style2 = isGreaterThan && isEqual;
        boolean OR = isGreaterThan || isEqual;
        boolean NOT = !isGreaterThan;
        boolean NOT_style2 = !( x > y && x == y );

        // 복합식 : 산술 > 관계 > 논리 > 할당 순으로 동작
        boolean result = x+y == x*y && x-1 > 0;
        // 숫자 세개 비교 : 이렇게 하면 안됨!
        // boolean result2 = x > y > z;

        // 출력
        System . out . println(x + " " + y);

        // 두 숫자 중 더 큰 수 찾기
        // ( 같은지, 어느 쪽이 더 큰지 출력 )
        // x 가 크다면 true, y 가 크다면 false
        boolean isXBiggerThanY = x > y;
        System.out.println( isXBiggerThanY );
        System.out.println( x > y );

        int k = x > y ? x : (x > y ? x : y);

        // 삼항 연산자 - 조건처럼 사용 가능
        // 조건식 ? 참일 때 값 : 거짓일 때 값
        // 조건식 == true/false로 결과 값을 배출하는 식
        int max = x > y ? x : y; // x가 y보다 크다면 ? x : y
        System.out.println( "Max value : " + max );

        // 세 개 값 중 더 큰 값을 출력
        int maxFrom3 = x > y ? x : y;// x와 y중 더 큰 값을 찾음
        //maxFrom3에는 이미 x와 y 사이에서는 비교가 끝났고,
        // 둘 중 더 큰 값이 있음
        maxFrom3 = maxFrom3 > z ? maxFrom3 : z;// 더 큰 수 중 z와 비교

        // 숫자 x가 소수인지 아닌지 판별하기
        // 에라스토테네스 체
        // 자기 자신을 제외한 X의 배수를 모두 지운다.
        // 2의 배수를 모두 지운다. => X / 2 == 1 => X % 2 == 0
        // 3의 배수를 모두 지운다. => X / 3 == 1 => X % 3 == 0
        // 5의 배수를 모두 지운다. => X / 5 == 1 => X % 5 == 0
        // 7의 배수를 모두 지운다. => X / 7 == 1 => X % 7 == 0
        // 위의 과정을 반복하면 구하는 구간의 모든 소수가 남는다.
        boolean isPrime =
                x % 2 != 0
                        && x % 3 != 0
                        && x % 5 != 0
                        && x % 7 != 0;
        System.out.println( "X는 소수인가? " + ( isPrime ? "맞음" : "아님" ) );
    }
}
