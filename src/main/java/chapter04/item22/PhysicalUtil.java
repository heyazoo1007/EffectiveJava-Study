package chapter04.item22;

// 공개적인 상수가 필요한 경우에 유틸리티 클래스를 사용하는 것도 방법이다
// 여기에 private 생성자로 인스턴스화를 방지해야 한다
public class PhysicalUtil {
    private PhysicalUtil() {} // 인스턴스화 방지

    // 아보가드로 수 (1/몰)
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // 볼츠만 상수 (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_64852e-23;

    // 전자 질량 (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}
