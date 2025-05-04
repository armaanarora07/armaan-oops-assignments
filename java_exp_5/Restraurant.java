package Experiment5;
class Chef {
    public void makeSpecialDish() {
        System.out.println("Making a special dish.");
    }
}

class ItalianChef extends Chef {
    @Override
    public void makeSpecialDish() {
        System.out.println("Making pasta.");
    }
}

class ChineseChef extends Chef {
    @Override
    public void makeSpecialDish() {
        System.out.println("Making dumplings.");
    }
}

class MexicanChef extends Chef {
    @Override
    public void makeSpecialDish() {
        System.out.println("Making tacos.");
    }
}

class Main1 {
    public static void main(String[] args) {
        Chef[] chefs = new Chef[3];
        chefs[0] = new ItalianChef();
        chefs[1] = new ChineseChef();
        chefs[2] = new MexicanChef();

        for (Chef chef : chefs) {
            chef.makeSpecialDish();
        }
    }
}