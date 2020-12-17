package day031.jdbc.stringbuffer_stringbuilder;

public class StringBufferTest {

    public static void main(String[] args) {
        System.out.println("--------->> String");
        String str = new String("Hello Java!!!");
        System.out.println("str = " + str);
        str = str + " 반갑습니다.";

        System.out.println(str.replace("a", "o"));
        System.out.println("str = " + str);

        System.out.println("--------->> String Buffer");
        StringBuffer sb = new StringBuffer("Hello Java!!!");
        System.out.println("sb.capacity() = " + sb.capacity());
        System.out.println("sb = " + sb);

        sb.append(" 반갑습니다.");
        System.out.println(sb);

        System.out.println("sb.capacity() = " + sb.capacity());

        System.out.println(">> delete(), insert() ---------");

        sb.delete(0, 6); // 0부터 6이전까지 삭제
        System.out.println("sb.delete(0, 6) 실행 결과 = " + sb);

        sb.insert(0, "Hello ");
        System.out.println("sb.insert(0,\"Hello \") 실행 결과 = " + sb);

        System.out.println("sb.length() = " + sb.length());
        System.out.println("sb.capacity() = " + sb.capacity());

        System.out.println("----------new StringBuffer(100) --------");
        StringBuffer sb2 = new StringBuffer(100);
        System.out.println("sb2.length() = " + sb2.length());
        System.out.println("sb2.capacity() = " + sb2.capacity());
        System.out.println();

        sb2.append("안녕하세요. 반갑습니다!!!");
        System.out.println("sb2.append(\"안녕하세요. 반갑습니다!!!\")");
        System.out.println("sb2.length() = " + sb2.length());
        System.out.println("sb2.capacity() = " + sb2.capacity());
        System.out.println();

        sb2.trimToSize();
        System.out.println("sb2.trimToSize()");
        System.out.println("sb2.length() = " + sb2.length());
        System.out.println("sb2.capacity() = " + sb2.capacity());
        System.out.println();

        sb2.append("자바 공부중").append("입니다.");
        System.out.println("sb2.append(\"자바 공부중\").append(\"입니다.\")");
        System.out.println("sb2.length() = " + sb2.length());
        System.out.println("sb2.capacity() = " + sb2.capacity());

        System.out.println("----------------------------");
        sb2.trimToSize();
        System.out.println("sb2.trimToSize()");
        System.out.println("sb2 = " + sb2);
        sb2.setLength(0);
        System.out.println("sb2.setLength(0)");
        System.out.println("sb2 = " + sb2);

    }
}
