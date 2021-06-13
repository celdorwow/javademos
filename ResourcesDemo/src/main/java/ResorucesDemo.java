import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResorucesDemo {
    public static void main(String[] args) {
        BufferedReader rr = getReader("file.csv", ResorucesDemo.class);
        if (rr != null) {
            rr.lines()
                .map(e -> String.join(" ::: ", e.split(",")))
                .forEach(System.out::println);
        }
    }

    public static <T> BufferedReader getReader(String fileName, Class<T> type) {
        InputStream is = type.getResourceAsStream("file.csv");
        return is != null
            ? new BufferedReader(new InputStreamReader(is))
            : null;
    }
}
