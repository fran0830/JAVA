/**
 * JSample6_1
 * 
 * 2024.08.30
 */

public class Sample6 {
    public static void main(String[] args) {
        int sum = 0;
        boolean kas = true;
        //10回繰り返す
        for (int i = 1; i <= 10; i++){
            sum = sum + i;      // 数値を順に加算する
        }

        //if文テスト javascriptやphpの使用に近い
        if (kas == true){
            System.out.println("test");
        } else if(sum > 15){
            System.err.println("cat");
        } else{
            System.err.println("エラーが発生しました。");
        }

        /*
         * 集計した結果を画面に表示する。
         */
        System.out.println(sum);
    }    
}
