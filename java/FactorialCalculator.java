import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialCalculator {
    public static void main(String[] args) throws Exception {
        if(args.length ==0){
            System.out.print("Numerical args missing! Provide arguments e.g. 1 2 3");
            System.exit(-1);
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Numbers for which factorial needs to be calculated
        List<Integer> numbers = new ArrayList<>();

        for (String s : args) {
            numbers.add(Integer.parseInt(s));
        }
        // Array to store Future objects representing the results of factorial calculations
        Future<Long>[] futures = new Future[numbers.size()];

        // Submit factorial calculation tasks for each number
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            futures[i] = executor.submit(new FactorialTask(number));
        }

        // Wait for all tasks to complete and print the results
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            long factorial = futures[i].get();
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        // Shutdown the executor
        executor.shutdown();
    }

    // Callable task to calculate factorial of a number
    static class FactorialTask implements Callable<Long> {
        private final int number;

        FactorialTask(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
