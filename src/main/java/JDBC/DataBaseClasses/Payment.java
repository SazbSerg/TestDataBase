package JDBC.DataBaseClasses;

public class Payment {
    private String methodType;

    public Payment() {
    }

    public Payment(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public String
    toString() {
        return "Payment{" +
               "methodType='" + methodType + '\'' +
               '}';
    }
}
