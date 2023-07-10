public class StringVerify {

    public static void main(String[] args) {

        String x = new String("def");
        String y = x.intern();

        System.out.println(x==y);

    }
}
