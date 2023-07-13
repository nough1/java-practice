public class StringVerify {

    public static void main(String[] args) {

        String x = new String("def");
        String y = x.intern();

        System.out.println(x==y);


        String a = new String(new char[]{'a','b','c'});
        String b = a;

        String d = "abc";

        String c = a.intern();

        System.out.println(a==b);

        System.out.println(a==c);

        System.out.println(a==d);

    }
}
