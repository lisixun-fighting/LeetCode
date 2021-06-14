package june;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PAT1007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PAT1007 pat = new PAT1007();
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int res = pat.handle(a);
            System.out.println(res);
        }
    }

    boolean[] avail;

    public int handle(int N) {
        avail = new boolean[N+1];
        Stack<Integer> primes = new Stack<>();
        int res = 0;
        for (int i = 2; i <= N; i++) {
            if (avail[i])
                continue;
            if (!primes.isEmpty() && i - primes.peek() == 2) {
                res++;
            }
            primes.push(i);
            for (int j = i; j <= N; j += i)
                avail[j] = true;
        }
        return res;
    }


}
