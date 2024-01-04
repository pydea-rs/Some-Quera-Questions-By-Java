package FibboThread;

public class FibboThread extends Thread {
    private int n;
    private long f_n = -1;
    public FibboThread(int n) {
        this.n = n;
    }

    public void run() {
        //System.out.println("Thread running for n = " + this.n);
        if(this.n == 0 || this.n == 1)
            this.f_n = 1;
        else {
            FibboThread threadF_n_1 = new FibboThread(this.n - 1), threadF_n_2 = new FibboThread(this.n - 2);
            threadF_n_1.run();
            threadF_n_2.run();
            this.f_n = threadF_n_1.f_n + threadF_n_2.f_n;
        }
    }
    public long F_n() {
        return this.f_n;
    }
}
