import java.util.Random;
import java.util.Scanner;

public class CaseEx {


   void casetest()
    {
        Scanner sc = new Scanner(System.in);
        int  input= sc.nextInt();
        int  n= sc.nextInt();
        int  m= sc.nextInt();
        switch (input){
            case   0 :  System.out.println("0입니다");
                break;
            case   1 :  System.out.println("0입니다");
                break;
            case   2 :  System.out.println("0입니다");
                break;
            case   3 :  System.out.println("0입니다");
                break;
            case   4 :  System.out.println("0입니다");
                break;
            case   5 :  System.out.println("0입니다");
                break;
            case   6 :  System.out.println("0입니다");
                break;



            default:System.out.println("예외발생");
        }


    }




    void weather()
    {
        String result;
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();


        if(month  >=12 && month <= 2)
        {
            System.out.println("겨울입니다");
        }
        else if(month  >=3 && month <= 5)
        {
            System.out.println("봄입니다");
        }
        else if(month  >=6 && month <= 8)
        {
            System.out.println("여름입니다");
        }
        else if(month  >=9 && month <= 11)
        {
            System.out.println("가을입니다");
        }





    }




    void weather_case()
    {
        String result;
        Scanner sc = new Scanner(System.in);
//        int month = sc.nextInt();
        Random random = new Random();
        int month = random.nextInt(12) +1;
        System.out.println(month);


switch (month){
    case 12: case 1:case 2:
        System.out.println("겨울입니다");
    break;

    case 3:case 4:case 5:
        System.out.println("봄입니다");
        break;

    case 6:case 7:case 8:
        System.out.println("여름입니다");
        break;
    case 9:case 10:case 11:
        System.out.println("가을입니다");
        break;
    default:
        System.out.println("예외발생");
}
       




    }
}
