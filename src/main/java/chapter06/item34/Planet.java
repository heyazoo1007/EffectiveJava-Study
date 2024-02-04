package chapter06.item34;

// 열거 타입 예시 - Planet
// 행성 정보(mass, radius) 를 저장해 놓고 편리하게 사용할 수 있다.
public enum Planet {
    EARTH(123, 456);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 1;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() { return mass; }
    public double radius() { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) { return mass * surfaceGravity; }
}
