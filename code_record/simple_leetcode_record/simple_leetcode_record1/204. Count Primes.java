/*Created by ${USER} on ${DATE}.
 *题意：计算不超过n的质数的个数
 *注意：素数筛选法
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}

//第二次
public class Solution {
    public int countPrimes(int n) {
        boolean []isPrime = new boolean[n];
        int count = 0 ;
        for(int i = 2; i < n; i++){
            if(!isPrime[i])
                count++;
            for(int j = 2; i*j < n; j++){
                isPrime[i*j] = true;
            }
        }
        return count;
    }
}


//错误
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            count++;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        return count;
    }
}
