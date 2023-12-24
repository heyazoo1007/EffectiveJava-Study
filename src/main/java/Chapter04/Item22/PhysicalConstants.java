package Chapter04.Item22;

// 아이템22 : 인터페이스는 타입을 정의하는 용도로만 사용하라
// PhysicalConstants 인터페이스는 static final 상수로만 구현된 인터페이스
// 이러한 인터페이스는 구현하지 말아야 한다 -> 이것보다 Enum 이나 유틸리티 클래스를 이용하자
public interface PhysicalConstants {

        // 아보가드로 수 (1/몰)
        static final double AVOGADROS_NUMBER = 6.022_140_857e23;

        // 볼츠만 상수 (J/K)
        static final double BOLTZMANN_CONSTANT = 1.380_64852e23;

        // 전자 질량 (kg)
        static final double ELECTRON_MASS = 9.109_383_56e-31;
}
