
import java.util.Random;

class Dentaku {
    public static void main(String[] args) {
        Dentaku dentaku = new Dentaku();
        dentaku.plus(10,5);
        dentaku.minus(9,2);
    }    

    void plus(int val1, int val2){
        System.out.println(val1 + val2);
    }

    void minus(int val1, int val2){
        System.out.println(val1 + val2);
    }
}

// 挨拶を行うための簡単なコードだす。
// クラスのサンプル
class Robot{
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.hello();
        robot.bye();        //

    }

    void hello(){
        System.out.println("Hello");
    }

    void bye(){
        System.out.println("Bye");
    }
}

/* メソッドのサンプル */
class Robot2{
    public static void main(String[] args) {
        Robot2 robot2 = new Robot2();
        robot2.greeting("Hello");
        robot2.greeting("Bye");
    }

    void greeting(String msg){
        /* Greetingメソッドを使用して任意の文字列を表示するような感じだと思う。
         * Pythonで言うところの変数に値を代入して関数に値を渡してprint(msg)を行っている感じ
         * さらに言えば、JAVAは関数やクラスを常に使うようなイメージ。
         */
        System.out.println(msg);
    }
}

/* フィールドのサンプル */
class Dest{
    Random rnd = new Random();
    double currentPosition = rnd.nextInt(101) + 1;
    public static void main(String[] args) {
        Dest dest = new Dest();
        dest.report();
        dest.moveForward();
        dest.report();
        dest.moveForward2();
        dest.report();
    }

    void report(){
        System.out.println("Current Position = " + currentPosition);
    }

    void moveForward(){
        currentPosition = currentPosition * 126 ;
    }

    void moveForward2(){
        double res = Math.pow(654, 35);
        currentPosition = currentPosition + res;
    }
}
/**
 * for (int i = 1; i <= 10; i++){

    }
 */
