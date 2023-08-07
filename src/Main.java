import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * - 프로그램의 특징
 *   프로그램은 한 줄씩 차례대로 실행되며, 생략될 수 없다.
 *   생략이 되었다? == 프로그램이 종료되었음
 *
 *   ==> 내가 실행하고자하는 부분 부분 별로 실행할 수 없다.
 *
 * - 흐름 제어
 *   조건문 : 조건식에 따라 참이라면 실행하는 구문 유형
 *   반복문 : 조건식에 따라 참일 때까지 "반복" 실행하는 구문 유형
 *
 * - 조건문
 *   if-else 구문 : 조건식(결과가 boolean을 배출하는 식)에 따라 "참"이라면 실행
 *   switch-case-default 구문 : case에 작성된 상수가 일치 여부에 따라 실행
 *
 * - if-else 구문
 *
 *   `if ( [조건식] ) { /// 작동시킬 코드 /// }`
 *   [조건식] 이 참이라면, { /// 작동시킬 코드 /// } 를 실행한다.
 *
 *   `else if ( [조건식] ) { /// 작동시킬 코드 /// }`
 *   앞의 if 구문이 거짓이라면, 그리고, [조건식] 이 참이라면, { /// 작동시킬 코드 /// } 를 실행한다.
 *
 *   `else { /// 작동시킬 코드 /// }`
 *   앞의 if문과 else if문들이 모두 거짓이라면, { /// 작동시킬 코드 /// } 를 실행한다.
 *
 *   if문 안에 또 다른 if문이 작성될 수 있다.
 *   단, 바깥 쪽 if문과 안쪽의 if문은 흐름상 결합되지 않는다.
 *
 *   // 블럭이 실행되면, 새로운 루틴(명행의 모음 단위)이 시작되는 것과 같다.
 *   if ( [조건식] ) {
 *
 *       // 여기의 if문이 거짓이라면, else if 문으로 가지 않는다.
 *       if ( [조건식] ) {
 *          ...
 *       }
 *
 *   } else if ( [조건식] ) {
 *      /// 작동시킬 코드 ///
 *   }
 *
 *   삼항연산자 vs if문의 차이
 *   삼항연산자는 "연산자" 이므로 결과물을 배출한다.
 *   if문은 결과물을 배출하지 않는다.
 *
 *   // 이건 가능
 *   int z = x > y ? x : y;
 *
 *   // Java에서는 이건 안됨 ==> Swift, Kotlin 같은 언어들은 가능
 *   // 제임스 고슬링 규칙 : 헷갈리는건 다 허용하지 않겠다.
 *   int z = if(x > y) { x; } else { y; }
 */

public class Main {
    public static void main(String[] args) {

        Random  random = new Random();

arastones ars= new arastones();
//ars.act();
//ars.bool();
//int[] arr = ars.max();
//for(int i=0; i < arr.length; i++)
//        {
//            System.out.println(arr[i]);
//
//        }





        CaseEx weather = new CaseEx();
        weather.weather_case();
    }
}
class arastones
{
  void act()
  {
      int i= 120;
      for(int x=0; x<i; x++)
      {
          if(x==2 || x==3||x==5||x==7){
              System.out.println("소수");
          }
          else if (x%2 ==0||x%3 ==0||x%5 ==0||x%7 ==0)
          {
              System.out.println("소수아님");
          }
          else
          {
              System.out.println("소수");

          }
      }

  }

  void bool()
  {
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();
      if(i%2 == 0)
      {
        System.out.print("짝수입니다");

      } else if (i%2 == 1) {
          System.out.print("홀수입니다");
      }


  }



  int[] max()
  {
      int max;
      int min;

      Scanner sc = new Scanner(System.in);
      System.out.print("x값을 입력해주세요");
      int x = sc.nextInt();
      System.out.print("z값을 입력해주세요");
      int z = sc.nextInt();
      System.out.print("값을 입력해주세요");
      int y = sc.nextInt();
     if(x>y && x>z ){
         System.out.print("x가 가장큽니다");
        max = x;
        if(y>z)
        {
            System.out.print("z가 가장잡습니다");
            min = z;
        }
        else
        {
            System.out.print("y가 가장잡습니다");
            min = y;
        }
     }
     else if (y>x && y>z) {
         System.out.print("y가 가장큽니다");
         max = y;
         if(x>z)
         {
             System.out.print("z가 가장잡습니다");
             min = z;
         }
         else
         {
             System.out.print("x가 가장잡습니다");
             min = x;
         }
     }
     else if (z>x && z > y) {
         System.out.print("z가 가장큽니다");
         max = z;
         if(y>x)
         {
             System.out.print("x가 가장잡습니다");
             min = x;
         }
         else
         {
             System.out.print("y가 가장잡습니다");
             min = y;
         }
     }
     else{
         System.out.print("모든수가 같습니다");
         max = 0;
         min = 0;

     }
     int[] arr = {max,min};
      return arr;
  }


  }


