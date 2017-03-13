/**
 * Created by ASUS on 13/03/2017.
 */
public class GradeCalculator {
    public char calculate(double... scores){
        // A implement code to find summation of all scores to sum
        double sum = 0;
        for (int i = 0 ; i < scores.length ; i++) {
            sum = sum + scores[i];
        }
        // B implement code to return right output from sum
        if(sum <= 100 && sum >= 0){
            if (sum > 95) return 'A';
            if (sum > 80) return 'B';
            if (sum > 60) return 'C';
            return 'F';
        }else if(sum < 0) return 'U';
        return 'x';

    }
}
