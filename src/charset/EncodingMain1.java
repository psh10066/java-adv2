package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A", US_ASCII); // 1byte
        encoding("A", ISO_8859_1); // 1byte
        encoding("A", EUC_KR); // 1byte
        encoding("A", UTF_8); // 1byte
        encoding("A", UTF_16BE); // 2byte

        System.out.println("== 한글 지원 ==");
        encoding("가", EUC_KR); // 2byte
        encoding("가", MS_949); // 2byte
        encoding("가", UTF_8); // 3byte
        encoding("가", UTF_16BE); // 2byte

        String str = "A";
        byte[] bytes = str.getBytes(); // defaultCharset
        System.out.println("bytes = " + Arrays.toString(bytes));
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
