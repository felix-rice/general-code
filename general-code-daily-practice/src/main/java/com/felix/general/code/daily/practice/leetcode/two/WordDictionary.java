package com.felix.general.code.daily.practice.leetcode.two;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-10-05
 */
public class WordDictionary {
    static class Trie {
        private Trie[] children = new Trie[26];
        private boolean isEnd;

        public Trie() {

        }

        public void addWord(String word) {
            Trie pre = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (pre.children[idx] == null) {
                    Trie node = new Trie();
                    pre.children[idx] = node;
                }
                pre = pre.children[idx];
            }
            pre.isEnd = true;
        }

        public Trie[] getChildren() {
            return children;
        }

        public boolean getIsEnd() {
            return isEnd;
        }

    }
    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }


    public void addWord(String word) {
        root.addWord(word);
    }

    public boolean search(String word) {
        return searchSub(word, 0, root);
    }

    private boolean searchSub(String word, int start, Trie pre) {
        if (pre == null) return false;
        for (int i = start; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean ret = false;
                for (int j = 0; j < 26; j++) {
                    boolean cur = searchSub(word, i + 1, pre.getChildren()[j]);
                    if (cur) {
                        ret = true;
                        break;
                    }
                }
                return ret;

            } else {
                Trie node = pre.getChildren()[c - 'a'];
                if (node == null) return false;
                pre = node;
            }
        }
        if (word.charAt(word.length() - 1) == '.') {
            for (int i = 0; i < 26; i++) {
                if (pre.getChildren()[i] != null && pre.getChildren()[i].getIsEnd()) return true;
            }
            return false;
        }
        Trie end = pre.getChildren()[word.charAt(word.length() - 1) - 'a'];
        return end.getIsEnd();
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean ret1 = wordDictionary.search(".ad");
        boolean ret2 = wordDictionary.search("b..");
        System.out.println(ret1);
        System.out.println(ret2);
    }
}
