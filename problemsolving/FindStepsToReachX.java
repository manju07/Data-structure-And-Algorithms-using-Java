package problemsolving;

/**
 * Need to find the number of steps to reach X, they have given you 2 methods. one will increment current value by 1 
 * and another double the current value. Intial value will be 0. 
 * @author Manjunath Asundi
 */
public class FindStepsToReachX {
    
    private static int findStepsToReachX(int x) {
        if(x == 0) return 0;
        if(x%2 == 0) 
           return 1 + findStepsToReachX(x/2);
        return 1 + findStepsToReachX(x-1);
    }

    public static void main(String[] args) {
        int x = 100;
        System.out.println("Number of Steps to reach " + x +" is " + findStepsToReachX(29));
    }
}