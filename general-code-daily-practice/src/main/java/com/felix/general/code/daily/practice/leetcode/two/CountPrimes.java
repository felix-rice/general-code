package com.felix.general.code.daily.practice.leetcode.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-10-04
 */
public class CountPrimes {
    public int countPrimes(int n) {
        return eratosthenes(n);
    }

    /**
     * 埃氏筛法，核心观点：合数必定是素数的倍数。
     * 1. 从2开始，将每一个素数的倍数标记为合数
     * 2. 当前数未被标记，则说明该数是素数
     */
    public int eratosthenes(int n) {
        boolean[] primes = new boolean[n];
        // 1. 假设所有的数都是素数
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            // 2. 当前数字是素数
            if (primes[i]) {
                // 3. 将素数的倍数标记为合数
                // 此处从i * i开始的原因是什么？
                // a. 素数 = 2时, 2i, 4i...
                // b. 素数 = 3时, 3i, 6i...
                // c. 素数 = 5时, 5i, 10i...
                // d. i < i时，（2i, 3i, ..., (i - 1)i）已经被标记过了
                // 从i * i开始
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int cnt = 0;
        // 4. 统计所有的素数个数
        for (int i = 2; i < n; i++) {
            if (primes[i]) cnt++;
        }
        return cnt;
    }

    public int euler(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        List<Integer> primes = new ArrayList<>();
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                primes.add(i);
                cnt++;
            }
            for (int j = 0; j < cnt && primes.get(j) * i < n; j++) {
                isPrimes[primes.get(j) * i] = false;
                if (i % primes.get(j) == 0) break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int counted = countPrimes.euler(10);
        System.out.println(counted);
    }
}
