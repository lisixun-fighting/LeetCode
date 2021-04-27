package april;

public class Solution65 {
    public boolean isNumber(String s) {
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasCal = false;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'e':
                case 'E':
                    if(hasE) return false;
                    if(i == 0 || i == s.length()-1) return false;
                    if(i == 1 && s.charAt(0) == '+'|| s.charAt(0) == '-') return false;
                    hasE = true;
                    hasCal = false;
                    hasDot = true;
                    break;
                case '+':
                case '-':
                    if(hasCal) return false;
                    if(i == s.length()-1) return false;
                    hasCal = true;
                    break;
                case '.':
                    if(hasDot) return false;
                    hasDot = true;
                    hasCal = true;
                    break;
                default:
                    hasCal = true;
                    break;
            }
        }
        return true;
    }
}
