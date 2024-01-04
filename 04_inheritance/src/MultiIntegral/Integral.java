package Integral;

class Integral1 {
    private String result;

    public String getResult() {
        return this.result;
    }

    public Integral1(String s) {
        this.result = s;
        this.calIntegral();
    }

    public void calIntegral() {
        this.result = "%" + this.result;
    }
}

class Integral2 extends Integral1 {
    public Integral2(String s) {
        super(s);
        this.calIntegral();
    }
}

class Integral3 extends Integral2 {
    public Integral3(String s) {
        super(s);
        this.calIntegral();
    }
}
