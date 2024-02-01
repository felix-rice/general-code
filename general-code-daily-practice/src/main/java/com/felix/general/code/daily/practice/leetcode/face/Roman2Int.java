package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class Roman2Int {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int num = 0;
        int i = 0;
        while (i < ch.length) {
            switch (ch[i]) {
                case 'I' -> {
                    if (i + 1 < ch.length) {
                        if (ch[i + 1] == 'V') {
                            num += 4;
                            i++;
                        } else if (ch[i + 1] == 'X') {
                            num += 9;
                            i++;
                        } else {
                            num++;
                        }
                    } else {
                        num++;
                    }
                }
                case 'V' -> num += 5;
                case 'X' -> {
                    if (i + 1 < ch.length) {
                        if (ch[i + 1] == 'L') {
                            num += 40;
                            i++;
                        } else if (ch[i + 1] == 'C') {
                            num += 90;
                            i++;
                        } else {
                            num += 10;
                        }
                    } else {
                        num += 10;
                    }
                }
                case 'L' -> num += 50;
                case 'C' -> {
                    if (i + 1 < ch.length) {
                        if (ch[i + 1] == 'D') {
                            num += 400;
                            i++;
                        } else if (ch[i + 1] == 'M') {
                            num += 900;
                            i++;
                        } else {
                            num += 100;
                        }
                    } else {
                        num += 100;
                    }
                }
                case 'D' -> num += 500;
                case 'M' -> num += 1000;
            }
            i++;
        }
        return num;
    }
}
