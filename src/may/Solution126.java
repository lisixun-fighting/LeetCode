package may;

import org.junit.Test;

import java.util.*;


/**
 * brand first search
 */
public class Solution126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> myWordList = new HashSet<>(wordList);
        Set<List<String>> bfs = new HashSet<>();
        bfs.add(List.of(beginWord));
        myWordList.remove(beginWord);
        boolean flag = true;
        while (flag && bfs.size() > 0) {
            Set<List<String>> tmp = new HashSet<>();
            for (List<String> l : bfs) {
                findNext(l, myWordList, tmp);
            }
            bfs = tmp;
            for (List<String> l : bfs) {
                if(l.get(l.size()-1).equals(endWord)) {
                    res.add(l);
                    flag = false;
                }
                myWordList.remove(l.get(l.size()-1));
            }
        }
        return res;
    }

    private void findNext(List<String> l, Set<String> wordList, Set<List<String>> res) {
        for (String word : wordList) {
            if(matches(word, l.get(l.size()-1))) {
                ArrayList<String> tmp = new ArrayList<>(l);
                tmp.add(word);
                res.add(tmp);
            }
        }
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
        List<List<String>> res = findLadders(begin, end, wordList);
        System.out.println(res);
    }

}
