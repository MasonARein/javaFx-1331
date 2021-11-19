public class TestMultipleClasses {
    private int outerInt = 99;
    InnerClass myclass = new InnerClass();

    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        System.out.println(anotherClass);
        System.out.println(anotherClass.x);
        System.out.println(anotherClass.y);
        //System.out.println(anotherClass.z);

        TestMultipleClasses testMultipleClasses = new TestMultipleClasses();
        InnerClass innerClass = testMultipleClasses.new InnerClass();
        System.out.println(innerClass);
        System.out.println(innerClass.a);
        System.out.println(innerClass.b);
        System.out.println(innerClass.c);
    }
    private class InnerClass {
        public int a = 0;
        protected int b = 3;
        private  int c = 4;
        public void someMethod() {
            System.out.println(outerInt);
        }
        @Override
        public String toString() {
            return "A = " + a + "; b = " + b + "; c = " + c
                    + "; outerInt = " + outerInt;
        }
    }
}

class AnotherClass {
    public int x = 2;
    protected int y = 5;
    private int z = 10;
    @Override
    public String toString() {
        return "x = " + x + "; y = " + y + "; z = " + z;
    }
}
