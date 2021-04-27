package april;

import java.util.*;

public class Solution5720 {
    public int makeStringSorted(String s) {
        int len = s.length();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < len; i++)
            list.add(s.charAt(i));
        int res = 0;
        while (true){
            int i = 0;
            for (int k = 1; k < len; k++) {
                if (list.get(k) < list.get(k-1))
                    i = k;
            }
            //System.out.println(Arrays.toString(sb));
            //System.out.print(i + ", ");
            if(i == 0) break;
            res++;
            int j = i;
            while (j < len && list.get(j) < list.get(i-1)) {
                j++;
            }
            j--;
            //System.out.println(j);
            char tmp = list.get(i-1);
            list.set(i-1, list.get(j));
            list.set(j, tmp);
            List<Character> l2 = list.subList(i, list.size());
            Collections.reverse(l2);
        }
        return res;
    }
}
