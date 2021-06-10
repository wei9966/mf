package mf_offer_system.springboot_02;

/**
 * Create By WeiBin on 2020/8/13 22:04
 */

public class TTTTT<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String args[]){
      TTTTT<String> ttttt=new TTTTT<String>();
        System.out.println(ttttt.getT());
    }
}
