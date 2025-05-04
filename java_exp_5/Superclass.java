package Experiment5;
class Superclass {
  //private int privateMember = 10;
}

class DerivedClass extends Superclass {
    void accessPrivateMember() {
        //System.out.println(privateMember);
    }
}

class Main1 {
    public static void main(String[] args) {
        DerivedClass obj = new DerivedClass();
        obj.accessPrivateMember();
    }
}