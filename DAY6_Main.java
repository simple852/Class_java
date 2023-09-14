/**
 * - 진수에 대한 이해
 *   10진수 > 2진수 변환 방법 : 10진수 > 16진수 > 2진수
 *   2진수 > 10진수 역변환 방법 : 2진수 > 16진수 > 10진수
 *   컴퓨터 모두 다 2진수이지만, 축약 및 연산에 대해 빨리 이해하기 위해서는 16진수를 알아야 함
 *   컴퓨터는 왜 2진수이냐? 디지털(Digital)
 *      |----|      ==> peek : 1
 *   ___|    |___   ==>        0
 *
 *   2진수   8진수  10진수  16진수
 *   0000       0      0       0
 *   0001       1      1       1
 *   0010       2      2       2
 *   0011       3      3       3
 *   0100       4      4       4
 *   0101       5      5       5
 *   0110       6      6       6
 *   0111       7      7       7
 *   1000      10      8       8
 *   1001      11      9       9
 *   1010      12     10       A
 *   1011      13     11       B
 *   1100      14     12       C
 *   1101      15     13       D
 *   1110      16     14       E
 *   1111      17     15       F
 *
 *  1 0000      18     16      10
 *
 * - 비트 연산
 *   컴퓨터의 모든 숫자는 비트로 이루어져있으며, 이 비트를 연산하는 연산자
 *   어떻게 연산하는가?
 *
 *   참 : 0 외 모든 숫자
 *   거짓 : 0
 *
 *   연산 기준 표
 *   A 연산 B = C
 *   0 연산 0 = ?
 *   0 연산 1 = ?
 *   1 연산 0 = ?
 *   1 연산 1 = ?
 *
 * - 비트연산 AND : A & B
 *   A도 참 => 1, B도 참 => 1
 *   특정 비트가 1인지 확인할 때 사용(CHECK 연산)
 *   특정 비트를 0으로 만들 때 사용(UNSET 연산)
 *
 *   0 0 = 0
 *   0 1 = 0
 *   1 0 = 0
 *   1 1 = 1
 *
 *   e.g. 5 & 3 = ?
 *
 *   5 = 0000 0101
 *   3 = 0000 0011
 *   & -----------
 *   1 = 0000 0001
 *
 * - 비트연산 OR : A | B
 *   A나 B 중에 참 => 1
 *   특정 비트를 1로 만들기 위해 사용(SET 연산)
 *
 *   0 0 = 0
 *   0 1 = 1
 *   1 0 = 1
 *   1 1 = 1
 *
 *   e.g. 5 & 3 = ?
 *
 *   5 = 0000 0101
 *   3 = 0000 0011
 *   & -----------
 *   7 = 0000 0111
 *
 * - 비트연산 XOR : A ^ B
 *   A, B의 비트 중 비교되는 비트가 서로 달라야 참 => 1
 *   특정 비트가 1인지 확인할 때 사용(CHECK 연산)
 *   특정 비트를 0으로 만들 때 사용(UNSET 연산)
 *
 *   0 0 = 0
 *   0 1 = 1
 *   1 0 = 1
 *   1 1 = 0
 *
 *   5 = 0000 0101
 *   3 = 0000 0011
 *   & -----------
 *   6 = 0000 0110
 *
 * - 비트연산 NOT : ~A
 *   A의 보수( 2의 보수와 1의 보수 ) - 뺄셈에서 사용
 *
 * - 비트연산 LEFT-SHIFT : A << B
 *   A의 비트들을 모두 B만큼 좌측 이동
 *
 *     5 = 0000 0101
 *     << ---------- 3
 *  0x28 = 0010 1000
 *
 *   일반적인 코딩(애플리케이션 수준) : 특정한 비트(1)을 이동시켜서 상수화(옵션용)
 *   final static int OPTION_0 = 1 << 0;
 *   final static int OPTION_1 = 1 << 1;
 *   final static int OPTION_2 = 1 << 2;
 *
 * - 비트연산 RIGHT-SHIFT : A >> B
 *   A의 비트들을 모두 B만큼 우측 이동
 *
 *   ? = 0010 1000
 *   >> ---------- 2
 *   A = 0000 1010
 *
 * - 비트연산UNSIGNED RIGHT-SHIFT : A >>> B
 *   A의 비트들을 모두 B만큼 우측 이동(단, 회전됨)
 *
 */
public class DAY6_Main {
    final static int OPTION_0 = 1 << 0;
    final static int OPTION_1 = 1 << 1;
    final static int OPTION_2 = 1 << 2;

    public static void main(String[] args) {
        int option001Setting = OPTION_0;
        int option010Setting = OPTION_1;
        int option100Setting = OPTION_2;
        int option101Setting = OPTION_0 | OPTION_2;
        int option110Setting = OPTION_1 | OPTION_2;
        int option111Setting = OPTION_0 | OPTION_1 | OPTION_2;

        // { Byte/Short/Integer/Long }
        // .toBinaryString() : 특정 수에서 2진수 문자열로 변환
        // .toOctalString() : 특정 수에서 8진수 문자열로 변환
        // .toHexString() : 특정 수에서 16진수 문자열로 변환
        System.out.println(Integer.toBinaryString(option001Setting));
        System.out.println(Integer.toBinaryString(option010Setting));
        System.out.println(Integer.toBinaryString(option100Setting));
        System.out.println(Integer.toBinaryString(option101Setting));
        System.out.println(Integer.toBinaryString(option110Setting));
        System.out.println(Integer.toBinaryString(option111Setting));

        // 옵션같은 것들은 자연수로 구분해도 될텐데, 왜 굳이 비트연산을 하는가?
        // 비트가 가장 단위에서 2종류를 의미하기 좋고, 동시에 여러가지를 한번에 표현하기 좋음
        //
        // BASE 0101    0111
        // OPT1 0010    0010
        // R    0000    0010
        // 결과 값이 010 이라면, 활성화 되어있음
        // 결과 값이 000 이라면, 비활성화 되어있음
        if( (option101Setting & OPTION_1) == OPTION_1 ) {
            // 작동시키는 코드
        }

        // 0111
        // 마스크(Mask) : 특정한 수에 원하는 비트만 가져오기(비트 범위 제한시키기)
        int optionMask = OPTION_0 | OPTION_1 | OPTION_2;

        // BASE 1101
        // MASK 0111
        // R    0101
        int maskingNumber = 0b1101 & optionMask;
    }
}
