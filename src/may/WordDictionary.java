package may;

import org.junit.Test;

import java.util.*;

public class WordDictionary {

    Set<WordDictionary> list;
    char val;
    boolean isEnd;

    public WordDictionary() {
        list = new HashSet<>();
    }

    public boolean search(String word) {
        return search(word, 0);
    }

    public boolean search(String word, int index) {
        if (index == word.length())
            return isEnd;
        for (WordDictionary w : list)
            if(w.val == word.charAt(index) || word.charAt(index) == '.')
                if (w.search(word, index+1))
                    return true;
        return false;
    }

    public void addWord(String word) {
        addWord(word, 0);
    }

    public void addWord(String word, int index) {
        if (index == word.length()) {
            isEnd = true;
            return;
        }
        for (WordDictionary w : list) {
            if(w.val == word.charAt(index)) {
                w.addWord(word, index+1);
                return;
            }
        }
        WordDictionary next = new WordDictionary();
        list.add(next);
        next.val = word.charAt(index);
        next.addWord(word, index+1);
    }

    @Test
    public void test() {
        WordDictionary dic = new WordDictionary();
        dic.addWord("add");
        System.out.println(dic.search("add"));
    }
}
