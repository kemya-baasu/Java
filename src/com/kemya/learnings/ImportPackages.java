package com.kemya.learnings;

public class ImportPackages {
     int x = 0;
    void method() {
         int x = 2;
        System.out.println(x);
    }
    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ImportPackages.this.x);
        }
    }

    public static void main(String... args) {
        ImportPackages st = new ImportPackages();
        ImportPackages.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
        st.method();
    }
//    public static void main(String[] args) {
//        Hostel hostelObj=new Hostel();
//        hostelObj.display();
////        public static DocumentBuilderFactory newInstance();
//    }

}
