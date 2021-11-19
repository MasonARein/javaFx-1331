public class A {
    private int val;
    private class B {
        private int total;
        void method2(){
            //you can do this but why?
            A myA = new A();
            // you can access private data & methods
            // from the outer class
            System.out.println(myA.val);
            myA.method1();
        }
    }
    private void method1() {
        A a = new A();
        B b = a.new B();
        System.out.println(b.total);
        b.method2();
    }
}