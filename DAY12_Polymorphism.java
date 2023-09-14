import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 방 정보
// 상태 ? 창문 갯수, 천장 갯수, 바닥 갯수
// 기능 ? 창문 열기/닫기
class Room {
    private int window;
    private int ceiling = 1;
    private int floor = 1;

    public Room(int window) {
        this.window = window;
    }
    public Room(int window, int ceiling, int floor) {
        this.window = window;
        this.ceiling = ceiling;
        this.floor = floor;
    }

    public int getWindow() { return window; }
    public void setWindow(int window) { this.window = window; }
    public int getCeiling() { return ceiling; }
    public void setCeiling(int ceiling) { this.ceiling = ceiling; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    public void openWindow() { System.out.println("창문 열기"); }
    public void closeWindow() { System.out.println("창문 닫기"); }
}

// 건물 클래스
// 상태 ? 엘리베이터 갯수, 계단 갯수, 층 수
// 기능 ? 숙박(취침), 불켜기/끄기, 엘리베이터 승차/하차, 계단 오르기/내리기
abstract class Building {
    private List<Room> rooms = new ArrayList<>();
    private int elevator;
    private int stairs;
    private int floor;

    public Building(List<Room> rooms, int elevator, int stairs, int floor) {
        this.rooms = rooms;
        this.elevator = elevator;
        this.stairs = stairs;
        this.floor = floor;
    }

    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }
    public int getElevator() { return elevator; }
    public void setElevator(int elevator) { this.elevator = elevator; }
    public int getStairs() { return stairs; }
    public void setStairs(int stairs) { this.stairs = stairs; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    // 기능
    // 건물마다 호수별로 할지, 집 전체가 자야할지는 그 건물이 하도록...
    public abstract void sleep();

    // 건물마다, 호수별/방별로/집전체로 할지 결정
    interface Light {
        void lightOn();
        void lightOff();
    }
    // 건물마다, 엘리베이터가 있을 수도? 없을 수도? 있다면, 이것을 구현
    interface Elevator {
        void rideElevator();// { System.out.println("엘리베이터 승차 : 불가"); }
        void quitElevator();// { System.out.println("엘리베이터 하차 : 불가"); }
    }
    // 건물마다, 계단이 있을 수도? 없을 수도? 있다면, 이것을 구현
    interface Stairs {
        void climbStairs();// { System.out.println("계단 오르기 : 불가"); }
        void goDownStairs();// { System.out.println("계단 내리기 : 불가"); }
    }
}
// 건물 ? 아파트, 고층빌딩, 주택
class Skyscrapers extends Building implements Building.Light, Building.Elevator, Building.Stairs {
    public Skyscrapers(int rooms, int elevator, int stairs, int floor){
        super(
            Arrays.stream(new Room[rooms]).toList(),
            elevator,
            stairs,
            floor
        );
    }

    @Override
    public void sleep() {
        System.out.println("호수별로 잠듬");
    }

    @Override
    public void lightOn() {
        System.out.println("호수별로 켜기");
    }

    @Override
    public void lightOff() {
        System.out.println("호수별로 끄기");
    }

    @Override
    public void rideElevator() {
        System.out.println("엘리베이터 승차");
    }

    @Override
    public void quitElevator() {
        System.out.println("엘리베이터 하차");
    }

    @Override
    public void climbStairs() {
        System.out.println("계단 오르기");
    }

    @Override
    public void goDownStairs() {
        System.out.println("계단 내리기");
    }
}
class Apart extends Building implements Building.Light, Building.Elevator, Building.Stairs {
    public Apart(int rooms, int elevator, int stairs, int floor){
        super(
            Arrays.stream(new Room[rooms]).toList(),
            elevator,
            stairs,
            floor
        );
    }

    @Override
    public void sleep() {
        System.out.println("호수별로 잠듬");
    }

    @Override
    public void lightOn() {
        System.out.println("호수별로 켜기");
    }

    @Override
    public void lightOff() {
        System.out.println("호수별로 끄기");
    }

    @Override
    public void rideElevator() {
        System.out.println("엘리베이터 승차");
    }

    @Override
    public void quitElevator() {
        System.out.println("엘리베이터 하차");
    }

    @Override
    public void climbStairs() {
        System.out.println("계단 오르기");
    }

    @Override
    public void goDownStairs() {
        System.out.println("계단 내리기");
    }
}

class House extends Building implements Building.Light {
    public House(int rooms){
        super(
            Arrays.stream(new Room[rooms]).toList(),
            0,
            0,
            1
        );
    }

    @Override
    public void sleep() {
        System.out.println("방마다 잠듬");
    }

    @Override
    public void lightOn() {
        System.out.println("방마다 켜기");
    }

    @Override
    public void lightOff() {
        System.out.println("방마다 끄기");
    }
}



public class DAY12_Polymorphism {
    public static void main(String[] args) {
        // 고층빌딩 2개
        Building skyscrapers1 = new Skyscrapers(
            100,
            8,
            1000,
            10
        );
        Building skyscrapers2 = new Skyscrapers(
            200,
            8,
            500,
            5
        );

        // 타입 캐스팅으로 타입 단언(Type Assertion)
        // 타입 단언 : 강제적 타입 캐스팅을 통해 컴파일러에게 타입이 올바르다는 것을 알려줌
        // 묵시적 타입 변환(캐스팅) : 문법적으로 당연한 것들인 경우 가능
        // 명시적 타입 변환(캐스팅) : 문법적으로는 부자연스럽지만, 프로그래머가 알고 있는 사항을
        //                         컴파일러에게 알려줘서 강제적으로 가능하게 함
        Building.Light lightOnOff = (Building.Light)skyscrapers1;
        Skyscrapers tmp = (Skyscrapers)skyscrapers1;
        lightOnOff = tmp;
    }
}
