public class MultiThreadingTest1 {

    public static void main(String[] args){
        for(int i =0; i < 5; i++) {
            Thread thread1 = new Thread(() -> new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread no : ");
                }
            });
            thread1.start();
        }
    }
}
