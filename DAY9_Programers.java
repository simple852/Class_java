public class DAY9_Programers {
    public static void main(String[] args) {
        DAY9_Programers programers = new DAY9_Programers();
        programers.multiply(23,23);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120804
    // answer = multiply(num1, num2);
    int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120803
    // answer = subtract(num1, num2);
    int subtract(int num1, int num2) {
        num1 = num1 >= -50000? num1 : -50000;
        num1 = num1 <= 50000? num1 : 50000;
        num2 = num2 >= -50000? num2 : -50000;
        num2 = num2 <= 50000? num2 : 50000;

        return num1 - num2;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120807
    // answer = compareNumbers(num1, num2);
    int compareNumbers(int num1, int num2) {
        // 방법1 : 음수 값을 사용할 수 있기 때문에 이렇게 작성해도 됨
        // if( /*0~10000 사이인지 조건*/ ) {
        //     return -1;
        // }

        // 방법2 : 값의 범위를 조정해주는 스타일로 작성
        num1 = num1 >= 0? (num1 <= 10000 ? num1 : 10000) : 0;
        num2 = num2 >= 0? (num2 <= 10000 ? num2 : 10000) : 0;

        return num1 == num2 ? 1 : -1;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120805
    // answer = divide(num1, num2);
    int divide(int num1, int num2) {
        if(num1 < 0) {
            num1 = 0;
        }
        if(num1 > 100) {
            num1 = 100;
        }

        if(num2 < 0) {
            num2 = 0;
        }
        if(num2 > 100) {
            num2 = 100;
        }

        return num1 / num2;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12081
    // answer = modular(num1, num2);
    int modular(int num1, int num2) {
        num1 = Math.max(num1, 0); // 최대값 : 둘 중 더 큰 것
        num1 = Math.min(num1, 100); // 최소값 : 둘 중 더 작은 것
        num2 = Math.max(num2, 0);
        num2 = Math.min(num2, 100);

        return num1 % num2;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120820
    // answer = calculateBirth(age);
    int calculateBirth(int age) {
        age = Math.min(Math.max(age, 0), 120);
        int baseYear = 2022;

        // r = x + y
        // 2022 = 40 + y
        // 2022 - 40 = y
        int resultYear = baseYear - age;// 만 나이
        return resultYear + 1;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120817
    // 수학에서 "평균"이란 자료 전체의 합을 자료의 개수로 나눈 값
    // 소수점 6자리까지 사용하겠다 : float
    float average(int[] numbers) {
        // 배열의 갯수가 0개라면, 평균 값은 당연히 0임
        if(numbers.length <= 0) {
            return 0.0f;
        }

        // 100개보다 클 경우 처리 방법1 : 100개로 만듦
        if(numbers.length > 100) {
            int[] newNumbers = new int[100];
            for(int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }

        int sum = 0;
        // foreach 문 사용했을 때...
        // for(final int number : numbers) {
        //     sum += number;
        // }

        // for 문 사용했을 때...
        // 100개보다 클 경우 처리 방법2 : 100번 미만까지 for문 동작으로 제한
        int length = Math.min(numbers.length, 100);
        for(int i = 0; i < length; i++) {
            sum += Math.min(Math.max(numbers[i], 0), 1000);
        }

        // sum == int
        // numbers.length == int
        // sum / numbers.length == int 이므로,
        // 둘중 하나만 float이 된다면, 결과 값은 float으로 변환됨
        return (float)sum / numbers.length;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/120822
    // answer = reverse(my_string);
    String reverse(String my_string) {
        String result = "";
        int length = my_string.length();
        for(int i = 0; i < my_string.length(); i++) {
            result += my_string.charAt((length - 1) - i);
        }
        return result;
    }

    // 프로그래머스 문제 아님.
    // 문자 배열 뒤집기
    // String to char array : char[] chars = String.toCharArray()
    // Char array to String : String str = new String(chars);
    // char[] answer = reverse( "Hello, World" .toCharArray() );
    char[] reverse(char[] str) {
        // 단, 배열 하나 더 생성하지 않고, 배열을 뒤집는다.
        // 회문 : "refer", "reer"
        char tmp;
        int length = str.length / 2; // 5 / 2 == 2, 4 / 2 == 2
        for(int i = 0; i < length; i++) {
            int backwardIndex = (str.length - 1) - i;

            // char forward = str[i];
            // char backward = str[backwardIndex];

            // 스왑(Swap) : 배열 등에서 요소의 자리 바꾸기
            tmp = str[i];
            str[i] = str[backwardIndex];
            str[backwardIndex] = tmp;
        }

        // Tip. 배열의 파라미터로 받고, 그 배열의 요소를 조작한 후 void 로 반환하는 경우
        //      배열의 요소는 이미 배열에서 조작되었기 때문에 반환할 필요가 없다는 것을 의미
        //
        // C언어 : 파라미터로 전달되는 배열은, 그 배열의 첫 번째 요소의 위치 주소
        // Java언어 : 파라미터로 전달되는 배열은, 그 배열의 레퍼런스 주소
        //
        // 레퍼런스 vs 포인터 : 객체쯤 가서 다시 배울 예정
        
        // 이렇게 했다는 것은, 함수 실행 후 결과 배열을 변수에 담을 수 있도록 하는 기능도 제공하겠다는 것
        return str;
    }
}
