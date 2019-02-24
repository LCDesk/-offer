public class P46不用加减乘除做加法 {

    //异或是不考虑进位的相加
    //与运算是两个数相加的进位
    public static int Add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(Add(5, 3));
    }
}
