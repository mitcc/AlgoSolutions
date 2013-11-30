public class Chapter7 {

    // 7.2
    public double antsCollision(int n) {
        return 1 - 1.0 / (1 << n - 1);
    }

    // 7.3
    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        return Math.abs(s1 - s2) > 0 || Math.abs(y1 - y2) < 0.000001;
    }

    // 7.4
    public int calc(int a, int b, int type) {
        if (type == 1) {
            return multiple(a, b);
        } else if (type == 0) {
            return divide(a, b);
        } else if (type == -1) {
            return minus(a, b);
        }
        return Integer.MAX_VALUE;
    }

    public int negative(int x) {
        int base = x > 0 ? -1 : 1;
        int result = 0;
        for (; x != 0; x += base, result += base);
        return result;
    }

    public int multiple(int a, int b) {
        boolean flag = a >= 0 && b >= 0 || a < 0 && b < 0;
        if (a < 0) {
            a = negative(a);
        }
        if (b < 0) {
            b = negative(b);
        }
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int result = 0;
        for (int i = 0; i < b; ++i) {
            result += a;
        }
        return flag ? result : negative(result);
    }

    public int minus(int a, int b) {
        return a + negative(b);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        boolean flag = a >= 0 && b > 0 || a < 0 && b < 0;
        if (a < 0) {
            a = negative(a);
        }
        if (b < 0) {
            b = negative(b);
        }
        int result = 0;
        for (int sum = b; sum <= a; sum += b, ++result);
        return flag ? result : negative(result);
    }

    // 7.5
    public double[] getBipartition(Point[] A, Point[] B) {
        double xc = (A[0].x + A[1].x + A[2].x + A[3].x) / 4.0;
        double yc = (A[0].y + A[1].y + A[2].y + A[3].y) / 4.0;
        double xd = (B[0].x + B[1].x + B[2].x + B[3].x) / 4.0;
        double yd = (B[0].y + B[1].y + B[2].y + B[3].y) / 4.0;
        double k = (yd - yc) / (xd - xc);
        double y0 = yd - xd * (yd - yc) / (xd - xc);
        return new double[] {k, y0};
    }

    // 7.7
    public int findKth(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[k + 1];
        int i3 = 0;
        int i5 = 0;
        int i7 = 0;
        result[0] = 1;
        for (int i = 1; i <= k; ++i) {
            result[i] = Math.min(result[i3] * 3, 
                    Math.min(result[i5] * 5, result[i7] * 7));
            if (result[i] == result[i3] * 3) {
                i3++;
            }
            if (result[i] == result[i5] * 5) {
                i5++;
            }
            if (result[i] == result[i7] * 7) {
                i7++;
            }
        }
        return result[k];
    }

    public int findKth(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        int result = 3;
        for (; k > 0; ++result) {
            int tmp = result;
            while (tmp % 3 == 0 || tmp % 5 == 0 || tmp % 7 == 0) {
                if (tmp % 3 == 0) {
                    tmp /= 3;
                }
                if (tmp % 5 == 0) {
                    tmp /= 5;
                }
                if (tmp % 7 == 0) {
                    tmp /= 7;
                }
                if (tmp == 1) {
                    k--;
                }
            }
        }
        return result - 1;
    }

}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
}
