package chapter12.item87;

import java.io.Serializable;

// 아이템87 : 커스텀 직렬화 형태를 고려해보라

// 기본 직렬화 형태에 적합한 후보
public class Name implements Serializable {
    /**
     * 성. null이 아니어야 함
     * @serial
     */
    private final String lastName;

    /**
     * 이름. null이 아니어야 함
     * @serial
     */
    private final String firstName;

    /**
     * 중간이름. 중간이름이 없다면 null
     * @serial
     */
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}
