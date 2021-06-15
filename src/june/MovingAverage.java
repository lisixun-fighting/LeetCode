package june;

public class MovingAverage {

    int[] window;
    int index;
    double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        index = 0;
    }

    public double next(int val) {
        sum -= window[index % window.length];
        window[index % window.length] = val;
        sum += window[index % window.length];
        index++;
        return sum / (index >= window.length ? window.length : (index + 1));
    }
}
