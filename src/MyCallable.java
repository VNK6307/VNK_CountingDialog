import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private final String title;
    private static int counter = 0;
    int threadSleep = 300;
    int cycle = 3;

    public static int getCounter() {
        return counter;
    }

    public MyCallable(String title) {
        this.title = title;
    }

    @Override
    public Integer call() throws Exception {
        int taskCounter = 0;
        for (int i = 1; i <= cycle; i++) {
            Thread.sleep(threadSleep);
            System.out.println("Я " + Thread.currentThread().getName() + ", выполнил " + title + " " + i + " раз.");
            taskCounter++;
            counter++;
        }
        return taskCounter;
    }
}
