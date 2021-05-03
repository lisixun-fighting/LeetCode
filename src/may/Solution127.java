package may;

import org.junit.Test;

import java.util.*;

/**
 * brand first search
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> myWordList = new HashSet<>(wordList);
        int res = 1;
        Set<String> dfs = new HashSet<>();
        dfs.add(beginWord);
        myWordList.remove(beginWord);
        while (dfs.size() > 0 && !dfs.contains(endWord)) {
            Set<String> tmp = new HashSet<>();
            for (String word : dfs)
                tmp.addAll(findNext(word, myWordList));
            dfs = tmp;
            res++;
        }
        return dfs.contains(endWord) ? res : 0;
    }

    private Set<String> findNext(String word, Set<String> wordList) {
        Set<String> res = new HashSet<>();
        Iterator<String> it = wordList.iterator();
        while (it.hasNext()) {
            String w = it.next();
            if(matches(w, word)) {
                res.add(w);
                it.remove();
            }
        }
        return res;
    }

    private boolean matches(String w1, String w2) {
        if(w1.length() != w2.length())
            return false;
        int flag = 0;
        for (int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i))
                flag++;
        }
        return flag == 1;
    }

    @Test
    public void test() {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        String begin = "hit";
        String end = "cog";
        ladderLength(begin, end, wordList);
    }
}
