package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-11
 */
public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        // 1. 不断累加字符串和1个空格
        // 2. 长度小于maxWidth，继续
        // 3. 长度等于maxWidth
        // 3.1 word还有剩余，则将多余1个空格，放在该行首位
        // 3.2 word无剩余，则最后一个字符后不跟字符
        // 2. 当长度大于maxWidth时，有两种情况
        // 2.1 减去多余一个空格，刚好填满，此时选择最后一个字符串
        // 2.2 减去多余空格后，还是大于maxWidth，此时回滚（1 + word.length + 1)，对选取字符串-1作除法，将多余空格填充
        int i = 0, n = words.length, chooseWordCount = 0, chooseWordLen = 0;
        int chooseBegin = 0;
        List<String> ans = new ArrayList<>();
        while (i < n) {
            chooseWordCount++;
            chooseWordLen += words[i].length();
            chooseWordLen++;
            // 刚好填满 或者 减去多余一个空格，刚好填满，此时选择最后一个字符串
            if (chooseWordLen == maxWidth || chooseWordLen - 1 == maxWidth) {
                chooseWordLen--;
                chooseBegin = buildLine(ans, words, chooseBegin, chooseWordLen, chooseWordCount, maxWidth, i == n - 1);
                chooseWordLen = 0;
                chooseWordCount = 0;
            } else if (chooseWordLen > maxWidth + 1) {
                // 减去多余空格后，还是大于maxWidth，此时回滚（1 + word.length + 1)，对选取字符串-1作除法，将多余空格填充
                chooseWordLen = chooseWordLen - words[i].length() - 2;
                chooseWordCount--;
                i--;
                chooseBegin = buildLine(ans, words, chooseBegin, chooseWordLen, chooseWordCount, maxWidth, i == n - 1);
                chooseWordLen = 0;
                chooseWordCount = 0;
            }
            i++;
        }
        while(chooseBegin < n) {
            chooseBegin = buildLine(ans, words, chooseBegin, chooseWordLen, chooseWordCount, maxWidth, true);
        }
        return ans;
    }

    private static int buildLine(List<String> ans, String[] words, int chooseBegin, int chooseWordLen,
                      int chooseWordCount, int maxWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        if (isLastLine || chooseWordCount == 1) {
            for (int i = 0; i < chooseWordCount; i++) {
                sb.append(words[chooseBegin++]);
                sb.append(' ');
            }
            // 最后一行无需补充空字符串，删除
            if (sb.length() > maxWidth) sb.deleteCharAt(sb.length() - 1);
            // 最后一行需要填充字符串
            if (sb.length() < maxWidth) {
                sb.append(" ".repeat(Math.max(0, maxWidth - sb.length())));
            }
            ans.add(sb.toString());
            return chooseBegin;
        }
        int spaceCount = maxWidth - chooseWordLen;
        // 平均每个字符串之间填充的空字符个数
        int spaceEach = spaceCount / (chooseWordCount - 1) + 1;
        // 不够平均的时候，从前到后添加
        int moreSpace = spaceCount % (chooseWordCount - 1);
        for (int i = 0; i < chooseWordCount - 1; i++) {
            sb.append(words[chooseBegin++]);
            sb.append(" ".repeat(Math.max(0, spaceEach)));
            if (moreSpace > 0) {
                sb.append(' ');
                moreSpace--;
            }
        }
        sb.append(words[chooseBegin++]);
        ans.add(sb.toString());
        return chooseBegin;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        int widthLen = 16;
        List<String> ans = fullJustify(words, widthLen);
        System.out.println(ans);
    }

}
