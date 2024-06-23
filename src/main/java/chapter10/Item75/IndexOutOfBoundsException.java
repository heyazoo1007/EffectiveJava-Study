package chapter10.Item75;


// 아이템75 : 예외의 상세 메시지에 실패 관련 정보를 담으라
public class IndexOutOfBoundsException extends RuntimeException {
    private int lowerBound;
    private int upperBound;
    private int index;

    /**
     * IndexOutOfBoundsException을 생성한다.
     *
     * @param lowerBound 인덱스의 최솟값
     * @param upperBound 인덱스의 최댓값 + 1
     * @param index 인덱스의 실제값
     */
    public IndexOutOfBoundsException(int lowerBound,
                                     int upperBound,
                                     int index
    ) {
        // 실패를 포착하는 상세 메시지를 생성한다.
        super(String.format(
                "최솟값 : %d, 최댓값 : %d, 인덱스 : %d",
                lowerBound, upperBound, index));

        // 프로그램에서 이용할 수 있도록 실패 정보를 저장해둔다.
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }
}
