package bytecode;

public class ByteCodeMain {

    private static  int[] ints = {1,3,5};
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        int a = 10;
        int b = 5;
        arithmetic.add(a,b);
        arithmetic.sub(a,b);

        for (int i:ints) {
            if (i!=3){
                a = arithmetic.mul(a,i);
                b = arithmetic.div(b,i);
            }
        }
    }
}
