public class Random {
    public int rand7();

    //Use rand7() to generate rand10()
    public int rand10() {
        int vals[7][7] = {
            {1, 2, 3, 4, 5, 6, 7},
            {8, 9, 10, 1, 2, 3, 4},
            {5, 6, 7, 8, 9, 10, 1},
            {2, 3, 4, 5, 6, 7, 8},
            {9, 10, 1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
        };
        int result = 0;
        while(result = 0) {
            int i = rand7();
            int j = rand7();
            result = vals[i - 1][j - 1];
        }
        return result;
    }



    public int rand10() {
        int temp1, temp2;
        do {
            temp1 = rand7();
        } while(temp1 > 5);
        do {
            temp2 = rand7();
        } while(temp2 > 2);
        return temp1 + 5 * (temp2 - 1);
    }



    public int rand10() {
        int i;
        do {
            i = 7 * (rand7() - 1) + rand7();
        } while(i > 40);
        return i % 10 + 1;
    }
}
