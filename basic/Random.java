public class Random {

    // default given method
    public int rand7() {
        return 0;
    }

    //Use rand7() to generate rand10()

    public int rand10_0() {
        int[][] array = {
            {1, 2, 3, 4, 5, 6, 7},
            {8, 9, 10, 1, 2, 3, 4},
            {5, 6, 7, 8, 9, 10, 1},
            {2, 3, 4, 5, 6, 7, 8},
            {9, 10, 1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int result = 0;
        while (result == 0) {
            result = array[rand7() - 1][rand7() - 1];
        }
        return result;
    }

    public int rand10_1() {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        while (i > 5) {
            i = rand7();
        }
        while (j > 2) {
            j = rand7();
        }
        return i + 5 * (j - 1);
    }

    public int rand10_2() {
        int i = Integer.MAX_VALUE;
        while (i > 40) {
            i = 7 * (rand7() - 1) + rand7();
        }
        return i % 10 + 1;
    }

}

