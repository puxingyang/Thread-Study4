package lesson4;

//有一个共享变量，初始0，启动20个线程，每个线程循环10000，每次循环将共享变量++
public class SafeThread {

    private static int SUM;

    public static synchronized void increment(int n){
        SUM++;
    }

    public static void main(String[] args) {
        for(int i=0; i<20; i++){
            new Thread(()->{
                for(int j=0; j<10000; j++){
                    increment(j);
                }
            }).start();
        }
        //所有子线程执行完毕之后，打印SUM的值
        while(Thread.activeCount() > 1) {//idea使用debug运行，run运行的话，>2。
            Thread.yield();//当前线程由运行态转变为就绪态
        }
        System.out.println(SUM);
    }
}
