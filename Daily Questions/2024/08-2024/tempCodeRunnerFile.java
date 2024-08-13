tic long floorSqrt(long n) {
        long i = 0, j = n, ans = 0;;
        while (i<j) {
            if((i * i) <= n) {
                ans = i;
                i++;
            }
            else 
                j--;
        }

        return ans;