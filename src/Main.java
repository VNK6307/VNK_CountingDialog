import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Создаю потоки...");

        int threads = Runtime.getRuntime().availableProcessors();
        System.out.println("Число возможных потоков - " + threads);

        threads = 4;
        System.out.println("Для выполнения задачи будем использовать " + threads + " потоков.");

        int amountOfTasks = 7;

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= amountOfTasks; i++) {
            tasks.add(new MyCallable("Задача " + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        int totalMessages = 0;
        for (Future<Integer> future : futures) {
            totalMessages += future.get();
        }
        System.out.println("Всего выведено " + totalMessages + " сообщений.");
        System.out.println();

        int result = executorService.invokeAny(tasks);
        System.out.println("Самым быстрым потоком выведено " + result + " сообщений.");
        System.out.println();

        result = MyCallable.getCounter();
        System.out.println("За время работы программы выведено " + result + " сообщений.");

        executorService.shutdown();

    }// main
}// class