public class Joseph {

    public int getResult(int n, int m) {
        int s = 0;
        for (int i = 2; i <= n; ++i) {
            s = (s + m) % i;
        }
        return s + 1;
    }

}
