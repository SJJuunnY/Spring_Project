package exercise.etc;

public enum EnumDemoAfter {

    AMERICANO(0, "아메리카노"),
    LATTE(1, "라뗴"),
    STRAWBERRY_ADE(2, "딸기에이드"),
    EXPRESSO(3, "에스프레소");

    int menu = 1;
    private final String name;

    EnumDemoAfter(int num, String name) {
        this.name = name;
    }

    public void selectMenu(){
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "EnumDemoAfter{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                '}';
    }
}