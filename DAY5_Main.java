import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * - 흐름 제어
 *   조건문 : 조건식에 따라 참이라면 실행하는 구문 유형
 *   반복문 : 조건식에 따라 참일 때까지 "반복" 실행하는 구문 유형
 *
 * - 반복문
 *   while : (횟수 무관, 특정한 상황) 조건식이 참일 때까지 반복
 *   do-while : (횟수 무관, 특정한 상황) "무조건 1회 실행 후" 조건식이 참일 때까지 반복
 *   for : (횟수 유관, 순번 있음) 특정한 횟수/갯수까지 반복
 *   + foreach : (갯수 유관, 순번 없음) 특정한 갯수까지 반복
 *
 * - 반복 흐름 제어
 *   break : 반복 중지
 *   continue : 조건 확인으로 즉각 이동(for문일 경우 증감식 후 조건 확인으로 이동)
 *
 *   Note. 반복에 대한 다음 루틴 필터링
 *   반복문 { if + break } : 특정한 조건일 때 반복 중지 유형
 *   반복문 { if + continue } : 특정한 조건일 때 조건 확인으로 즉각 이동 유형
 *
 * - 반복문에서 주의사항
 *   아래처럼 무한루프식은 작성하지 않는다. ==> 중단점이 없어지거나 누락될 수 있음
 *
 *   while(true) {
 *       if( ... ) {
 *           break;
 *       }
 *   }
 *
 *   반복문의 용도를 지킨다. ==> 가독성 문제 있을 수 있음
 *   for(; {조건식} ;) {
 *       ...
 *       i++
 *   }
 *
 * - while
 *
 *   `
 *   while ( {조건식} ) {
 *       /// 반복할 코드 ///
 *   }
 *   `
 *
 * - do-while
 *
 *   `
 *   do {
 *      /// 반복할 코드 ///
 *   } while( {조건식} );
 *   `
 *
 * - for
 *   {선언/초기화} : 꼭 하지 않아도 되며, 여기서 선언된 변수는 코드 블럭 바깥 쪽에 영향 없음
 *                                     (호출 불가)
 *   {횟수조건식} : 조건식(e.g. i < data.length, i < 100 or i >= 0 )
 *   {증감식} : 산술식(e.g. i++ or i--, i += 3 or i -= 3)
 *
 *   `
 *   for ( {선언/초기화} ; {횟수조건식} ; {증감식} ) {
 *       /// 반복할 코드 ///
 *   }
 *   `
 *
 *   Tip. 선언/초기화 부분에 대한 고찰
 *
 *      int i = 0;
 *      for( i = 0; ... ) {}
 *      // 뒷 쪽에서 i가 카운팅이 되어서 몇 번 반복했는지 알 수 있음
 *
 *      // 두 개도 가능
 *      for( int k = 0, j = 0 ; ... ){}
 *      // 이건 안 됨 => 다중 선언 + 초기화를 수행하던가 or 초기화만 수행하던가 둘 중 가능
 *      //for( int k = 0, j = 0, i = 0 ; ... ){}
 *
 * - foreach
 *   iterator 를 갖고 있어야 함
 *   final {값 자료형} {상수명} : 배열/컬렉션의 값 (final 은 상수화시키기 위해 필요할 뿐...)
 *   다른 언어에서는 콜론(`:`) > in 으로 작성
 *
 *   `
 *   for( final {값 자료형} {상수명} : {배열/컬렉션} ) {
 *       /// 반복할 코드 ///
 *   }
 *   `
 *
 * - 변수명 주의사항 ( 전역 변수와 지역 변수 )
 *   전역 변수(전역 공간) : 현재 코드블럭의 바깥쪽에 있는 변수
 *   지역 변수(지역 공간) : 현재 코드블럭의 안쪽에 있는 변수
 *
 *   `
 *   String s;// 코드블럭 기준으로 이 변수는 전역화됨
 *   {
 *       String s; //불가, 바깥 쪽에 s가 이미 선언되어있음
 *       int x; // 문제 없음
 *   }
 *   // 안쪽의 x는 여기에서 사용 불가 => x는 위의 코드블럭 안에 지역화됨
 *   `
 */

public class DAY5_Main {
    public static void main(String[] args) {
        // 전역 공간
        int jj = 0;
        {
            // 지역 공간
            System.out.println(jj);
            int x = 0;

            // 전역 공간
            {// 여기 기준으로
                // 지역 공간

                // 지역 내 지역 공간
            }
        }
        //사용 불가
        //System.out.println(x);

        List<String> data = new ArrayList<>();
        data.add("b"); // 0
        data.add("d"); // 1
        data.add("a"); // 2
        data.add("c"); // 3

        // a 문자 찾기
        int k = 0;
        String str = null;
        while( str == null ) {
            // i 가 데이터의 길이를 넘어서면, 반복 중지
            // Tip. 이런 유형의 코드는 while문의 조건식에 들어갈 수 있는 대상
            //      아래 코드는 연습용
            if(k >= data.size()) {
                // 테스트해보려면, 이부분 삭제
                // data.add("a"); // 2
                System.out.println("break");
                break;
            }

            // 임시변수에 담음
            String tmp = data.get(k++);
            if(tmp.contentEquals("a")) {
                str = tmp;
            }
        }
        System.out.println("a 찾기 : "+str);

        // while 문을 for문 처럼 작성하기
        k = 0;
        while(k < data.size()) {
            if(k == 0) {// 0번째만 필터링
                k++;
                System.out.println("continue");
                continue;
            }

            /// i == 0 일 때를 제외한 나머지 반복할 코드

            k++;
        }

        // (오름차순식)앞으로 세어서 100번 반복 ( 0~99 )
        for (int j = 0; j < 100; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        // (내림차순식)뒤으로 세어서 100번 반복 ( 99~0 )
        for (int j = 100 - 1; j >= 0; j--) {
            System.out.print(j + " ");
        }
        System.out.println();

        // data 리스트에서 값을 하나씩 가져와서 반복하는 방법
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);
            /// 반복할 코드 ///
        }

        for(final String s : data) {
            /// final String s == 위의 String s = data.get(i);

            /// 반복할 코드 ///
        }

        // 내부적으로 바로위의 foreach 문을 실행
        // 함수형 프로그래밍
        data.forEach((s) -> {
            /// 반복할 코드 ///
        });

        Random random = new Random();

        // (숫자) 배열에서 가장 큰 수 찾기
        // +몇 번째 위치?
        int[] intArr = {
            random.nextInt(100),
            random.nextInt(100),
            random.nextInt(100),
            random.nextInt(100),
            random.nextInt(100),
        }; // 리터럴 배열, 안에 초기화 값으로 넣은 갯수만큼인 길이의 배열이 생성
        int max = 0;
        int maxIndex = -1;
        for(int i = 0; i < intArr.length; i++) {
            // 더 큰지 확인
            if(max < intArr[i]) {
                max = intArr[i];
                maxIndex = i;
            }

            final boolean isBigger = max < intArr[i];
            max = isBigger ? intArr[i] : max;
            maxIndex = isBigger ? i : maxIndex;
        }

        System.out.println(maxIndex + "번째 : " + max);

        // 구구단 출력하기
        // 2x1   3x1   4x1   ...  |------- 컬럼(열)+1
        // 2x2   3x2   4x2   ...  |
        // 2x3   3x3   4x3   ...  |
        // ...   ...   ...   9x9  로우(행)+1
        //
        // System.out.print() => 출력 후 줄 안 바꿈
        // System.out.println() => 출력 후 줄 바꿈
        for(int i = 0; i < 9; i++) {
            // i가 1번씩 수행될 때마다 j는 N번만큼 반복
            for(int j = 0; j < 9; j++) {
                if(j == 0) {
                    continue;
                }
                System.out.print((j+1)+"x"+(i+1)+"   ");
            }
            System.out.println();
        }

        // 아래처럼 출력하기
        // *****
        // ****
        // ***
        // *
        //
        // *****  5x5
        // ****-
        // ***--
        // __---  ==> if + continue;
        // *----
        for(int i = 0; i < 5; i++) {
            if(i == 3) {
                continue;
            }
            for(int j = 0; j < 5-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------------------");

        // 아래처럼 출력하기 ( 2^n <= 2의 N제곱 )
        // 0 => 1 *
        // 1 => 3 ***
        // 2 => 2 **
        // 3 => 3 ***
        // 4 => 4 ****
        // 5 => 3 ***
        // 6 => 8 ********
        //
        // a의 b제곱 : Math.pow(a, b); (단, ==> a = base, b = exponent)
        //
        // 1 << 0 : 1  // 0000 0001
        // 1 << 1 : 2  // 0000 0010
        // 1 << 2 : 4  // 0000 0100
        // 1 << 3 : 8  // 0000 1000
        //
//        System.out.println();
//        System.out.println((int)Math.pow(2, 1));
//        System.out.println(1 << 0);
//        System.out.println(1 << 1);

        final int lines = 7;
        for(int i = 0, l = 0; i < lines; i++) {
            if(i % 2 == 1) {
                System.out.println("***");
                continue;
            }
            for(int j = 0; j < (int)Math.pow(2, l); j++) {
                System.out.print("*");
            }
            System.out.println();
            l++;// 짝수일 때만 +1씩 증가
        }

        // 문자열에서 회문(앞으로 읽어도, 뒤로 읽어도 같은 문자)인지 확인하기
        // "문자열".charAt(0) : 문자열에서 0번째의 문자를 가져옴
        String palindrome = "refer";
        boolean isPalindrome = true;
//        boolean isPalindrome = palindrome.length() % 2 == 0 || (palindrome.length() - 1) % 2 == 0;
//        if(isPalindrome) {
            int endIndex = palindrome.length() - 1;
            // 반틈만큼만 확인
            int count = palindrome.length() / 2;
            for(int i = 0; i < count; i++) {
                // 앞에서부터 문자
                char forward = palindrome.charAt(i); // 0 1 2 3 ...
                // 뒤에서부터 문자
                char backward = palindrome.charAt(endIndex - i); // 7 6 5 4 ...
                if(forward != backward) {
                    isPalindrome = false;
                    break;
                }
            }
//        }
        System.out.println(isPalindrome? "회문" : "회문아님");


        // 특정한 문자열로 시작하는지 + 끝나는지 확인하기
        // 앞쪽, 뒷쪽 확인할 문자열 변수 두 개
        // 시작문자열이 다르든, 종료문자열이 다르든 둘 다 확인해야 함
        // 230502_file.ppt
        // for문 두 개
        // for문 1개
        final String baseStr = "230502_file.ppt"; // 파일 이름 목록 가져오기 통해서 수집 가능
        final String starts = "230502"; // 사용자가 입력해줄 사항
        final String ends = ".ppt"; // 사용자가 입력해줄 사항

        final int baseStrLength = baseStr.length();
        final int startsLength = starts.length();
        final int endsLength = starts.length();

        // baseStr 길이가 더 길면, 일단, 갖고 있다고 가정(예측)
        boolean isContainedStarts = baseStrLength > startsLength? true : false;
        if(isContainedStarts) {
            // 만약, baseStr이 더 긴지 체크했다면, 이 구문은 필요없을 수 있음
            // final int length =
            //       baseStrLength < startsLength? baseStrLength : startsLength;
            for(int i = 0; i < startsLength; i++) {
                final char b = baseStr.charAt(i);
                final char s = starts.charAt(i);
                if(b != s) {
                    isContainedStarts = false;
                    break;
                }
            }
        }

        // 앞쪽 문자열의 길이를 구함
        int frontLength = baseStrLength - endsLength;
        boolean isContainedEnds = frontLength >= 0;
        if(isContainedEnds) {
            // 위와 동일
            for(int i = 0; i < endsLength; i++) {
                //길이를 넘어설 수도 있음 => frontLength+i
                final char b = baseStr.charAt(frontLength+i);
                final char s = ends.charAt(i);
                if(b != s) {
                    isContainedStarts = false;
                    break;
                }
            }
        }

        // 앞쪽에 주어진 문자열이 포함되어있는지 확인해주는 함수
        boolean isStartsWith = baseStr.startsWith(starts);
        // 뒷쪽에 주어진 문자열이 포함되어있는지 확인해주는 함수
        boolean isEndsWith = baseStr.endsWith(ends);


    }
}
