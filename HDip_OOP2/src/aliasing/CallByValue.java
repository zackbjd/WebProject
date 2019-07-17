package aliasing;

public class CallByValue {
    public static void f(CallByValue xyz){
        System.out.println("xyz in f() is "+xyz);
    }
    
    public static void main(String[] args) {
        CallByValue cbv = new CallByValue();
        System.out.println("cbv in main() is "+cbv);
        f(cbv);
    }
}
/*
cbv in main() is aliasing.CallByValue@15db9742
xyz in f() is aliasing.CallByValue@15db9742

*/