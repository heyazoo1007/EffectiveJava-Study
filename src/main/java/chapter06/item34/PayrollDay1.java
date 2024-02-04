package chapter06.item34;

// enum 상수들끼리 코드 공유가 어려운 경우
// 문제점 : 새로운 열거 타입 추가시 switch 에 별도 로직을 추가해야함
// 혹시라도 로직 추가를 누락하면 문제 발생 가능성 존재
enum PayrollDay1 {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay;
        switch (this) {
            case SATURDAY: case SUNDAY:
                overtimePay = basePay / 2;
                break;
            default :
                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }

        return basePay + overtimePay;
    }
}
