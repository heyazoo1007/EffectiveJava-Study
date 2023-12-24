package Chapter02;

import java.io.*;

public class Item09 {

    public static final int BUFFER_SIZE = 10;

    // 1. try-finally 방식
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // 2. 자원이 둘 이상이면 try-finally가 복잡해짐
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // try-finally 를 사용하면 코드가 지저분해질 가능성이 있고, 첫 번째 예외를 파악하지 못할 수 있음
    // 반면에 try with resources 를 사용하면 코드가 짧고 간결해 읽기 수월하고, 문제 진단하기에 용이함

    // 해결 1. try with resources 를 활용해서 자원 회수
    static String firstLineOfFileWithTryWithResources(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // 해결 2. try with resources 를 활용해서 복수의 자원 회수
    static void copyWithTryResources(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    // 해결 3. try with resources 를 catch 문과 같이 사용
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal; //파일을 열거나 데이터를 읽지 못했을 때 예외를 던지는 대신 기본값을 반환
        }
    }
}
