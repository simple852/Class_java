import java.util.ArrayList;
import java.util.List;

// 동물 : 새 정의하기
class Bird {
    // 새 라는 것은 어떤 속성/상태를 갖는가? => 무슨 값이 정의되어야 하는가?
    int head = 1;
    int body = 1;
    int wing = 2;
    int leg = 2;

    // 전략 패턴(Strategy Pattern)
    BirdState state = new BirdState();

    // 외부에서 상태 객체에 접근할 필요가 있을 때,
    public BirdState getState() {
        return state;
    }

    // 새 라는 것은 어떤 기능을 갖는가? => 무슨 함수가 정의되어야 하는가?
    void fly() {
        System.out.println("날개 " + wing + "개로 비행 중...");
    }
    void eat(int rice) {
        state.setHungry(state.getHungry() + rice);
        System.out.println("식사 중...");
    }

    void 지저귀기() {
        System.out.println("울어대는 중...");
    }
}

// 새의 상태만 따로 분리해서 관리한다면,
// 새 또한 이 상태값에 함부로 접근할 수 없음
class BirdState {
    private int hungry = 0; //100이면, 배 안 고픔

    int getHungry() {
        return this.hungry;
    }
    void setHungry(int hungry) {
        // hungry의 값은 0~100만 가능하다.
        // 그이상 또는 그이하 수준이 되면,
        // 개념 상 새는 사망 ===> 제한 값 필요

        // 멤버변수의 값 제한을 여기에다가 넣는 이유?
        // "eat에서 줄 수 있었던 것 아닌가요?"
        // eat는 기능에 대한 처리인데, hungry의 값까지 신경쓴다면,
        // 만약, 다른 메소드에서 이 제한을 무시할 수 있는 (실수에 의한) 형태로 개발이 된다면,
        // 규칙 위반, 그 메소드들 또한 이것에 대해 계속 신경써야 함
        // hungry 값을 변경하는 것을 setter에서 해준다면,
        // 세터 메소드만 호출하면, 위의 문제(규칙 위반, 신경써줘야할 것들)을 모두 해결 가능

        this.hungry = Math.max(Math.min(hungry, 100), 0);
    }
}

public class DAY10_ClassPractice {
    public static void main(String[] args) {
        // 새 100마리 만들기
        // 힌트1 : 반복하면 편하겠죠?
        // 힌트2 : 객체가 많다면 어디에 담는게 나을까요?

        // 배열 사용 or 리스트 사용
        Bird[] birdArr = new Bird[100];
        List<Bird> birdList = new ArrayList();
        for(int i = 0; i < 100; i++) {
            Bird bird = new Bird();

            // 생성된 새 객체를 배열에 할당
            birdArr[i] = bird;

            // 생성된 새 객체를 리스트에 할당
            // add(index, object) : 인덱스 위치에 객체를 추가 (insert)
            // add(object) : 리스트의 끝에 객체를 추가 (append)
            birdList.add(0, bird);
        }

        // 100마리 모두 비행시키기
        for(int i = 0; i < 100; i++) {
            // 배열에 직접 접근해서 비행시키기
            birdArr[i].fly();

            // 리스트는 get 함수로 찾아가기 위해 내부적으로 탐색을 하게 됨
            // 그래서, 일단 변수로 먼저 가져오는 것이 나음
            Bird bird = birdList.get(i);
            bird.fly();
        }

        // 100마리 모두 배 안 고프도록 만들기
        for(int i = 0; i < 100; i++) {
            Bird bird = birdList.get(i);
            // 우리가 원하지 않는 값은 어떻게 할 것인가?
            // 꼭 "식사한다" 라는 메소드를 사용해야하는가?
            bird.eat(1000);
        }
    }
}
