public class PrimeCalculator {

    public void primesTo(int n) {
        if (n < 2) {
            throw new IllegalArgumentException(
                "Input must be a number greater than or equal to 2."
            );
        }

        ArrayQueue<Integer> numbers = new ArrayQueue<>();
        ArrayQueue<Integer> primes = new ArrayQueue<>();

        for (int i = 2; i <= n; i++) {
            numbers.enqueue(i);
        }

        while (!numbers.isEmpty()) {
            int p = numbers.dequeue();
            primes.enqueue(p);

            int size = numbers.size();
            for (int i = 0; i < size; i++) {
                int current = numbers.dequeue();
                if (current % p != 0) {
                    numbers.enqueue(current);
                }
            }
        }

        System.out.print("Printing primes up to " + n + ": ");

        int primeCount = primes.size();
        for (int i = 0; i < primeCount; i++) {
            int prime = primes.dequeue();
            System.out.print(prime);
            if (i < primeCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(".");
    }

    public static void main(String[] args) {
        PrimeCalculator pc = new PrimeCalculator();

        pc.primesTo(20);
        pc.primesTo(2);

        try {
            pc.primesTo(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}