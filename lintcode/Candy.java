/*
 * There are N children standing in a line. Each 
 * child is assigned a rating value.

You are giving candies to these children subjected
to the following requirements:

Each child must have at least one candy.

Children with a higher rating get more candies 
than their neighbors.

What is the minimum candies you must give?

Example
Given ratings = [1, 2], return 3.

Given ratings = [1, 1, 1], return 3.

Given ratings = [1, 2, 2], return 4. ([1,2,1]).
 */
public class Candy {

    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < ratings.length; ++i) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int result = candy[candy.length - 1];
        for (int i = candy.length - 1; i >= 1; --i) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
            result += candy[i - 1];
        }
        return result;
    }

}
