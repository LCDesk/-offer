public class P29整数中1出现的次数 {

    /**
     * 规律：当前为<1,仅由高位决定
     * 当前位>1:仅由高位决定
     * 当前位=1:由高位和低位决定
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int times = 0, current, addOne = 0, powerOfTen = 0, n2 = n;
        while (n > 0) {
            current = n % 10;
            n /= 10;

            if (current > 1) {
                addOne = 1;
            } else if (current == 1) {
                times += (n2 % Math.pow(10, powerOfTen)) + 1;
            }
            times += (n + addOne) * Math.pow(10, powerOfTen);
            powerOfTen++;
            addOne = 0;
        }
        return times;
    }
}
