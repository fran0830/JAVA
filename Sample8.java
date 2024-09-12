
import java.util.Random;



public class Sample8{
    public static void main(String[] args) {
        /** 
        int math = 84;
        int science = 78;
        
        // 論理積。pythonで言うところの『and』
        if (math > 80 && science >80){
            System.out.println("ok");
        }

        // 論理和。pythonで言うところの『or』
        if (math >80 || science > 80){
            System.out.println("|| is ok");
        }

        //否定。 使い方的にはPythonと同じと思われる.
        if(math != 80){
            System.out.println("meow");
        }

        // こういった書き方も可能。
        System.out.println(!(math > 4));
        */
        pti1(args);
        System.out.println(pti2(3, 4));
        String x = pti3("s");
        System.out.println(x);
        pti4("a");
        //pti5("3");
        //pti6();
        pti7();
    }

    // クラスの戻り値は必ず明示的に定義しておく必要がある。
    static void pti1(String[] args){
        int score =76;

        String result = score > 70 ? "OK" : "NG";

        System.out.println(result);       
    }

    static int pti2(int x, int y ){
        return x + y;
    }

    static String pti3(String x){
        // printlnを使用する際に()をつけて先に計算を行事もできる。
        System.out.println("point" + (45*65*65));

        StringBuilder sb = new StringBuilder();
        sb.append("RB");
        sb.append(26);
        sb.append("DETT");
        x = sb.toString();
        // 蜩

        return x;
    }

    // 繰り返し処理
    static void pti4(String x){
        // 通常の場合は以下の使い方でok
        /*for (int i = 0 ; i < 10000; i++){
            System.out.println(i);
        }*/

        // 条件式を飛ばすことも可能
        int sum = 0;

        for (; sum < 10; sum++) {
            System.out.println(sum);
        }
        
        sum = 0;
        // forの条件式は飛ばしてもよいが、セミコロンを忘れてはいけないのら
        for (int i = 1; ; i--){
            sum += i;
            System.out.println(sum);
            if (sum < 5){
                break;
            }

        }
        System.out.println(sum);

        for (int i = 1; i < 3; i++){
            for (int j = 1; j < 3; j++){
              for (int k = 1; k < 3; k++){
                System.out.println("i = " + i + ", j = " + j + ", k = " + k);
              }
            }
        }
    }

    static void pti5(String x){
        //変数の初期化はWhileの外側で行う必要がある。
        int count = 0;
        while (true) { 
            
            // 繰り返しの中で実行される処理。
            try {
                Thread.sleep(1000);
                if (count > 1000){
                    System.out.println(count);
                    break;
    
                } else if(count % 5 == 0 ){
                    System.out.println(count);
                    count = count + 1;
                }else{
                    count = count + 1;
                }
    
                
            } catch (InterruptedException e) {
                System.err.println("割り込みが発生しました。: " + e);
            }

            

        }
    }

    static void pti6(){
        Random rand = new Random();
        long count = 0;
        int num;
        int target = 1;  // 1%を目指す


        // 最初の１回は必ずループして最後のwhile文にて最終評価が行われループの継続可否を決定する。
        /*
        do {
            System.out.println("num = " + num);
            num *= 2;
            if(Double.isInfinite(num)){
                System.err.println("計算結果が∞になってます。");
                break;
            }

        }while(true); 
        */
        
        while (true) {
            do {
                num = rand.nextInt(6) + 1;
                count++;
            } while (num != 6);

            double result = (1.0 / count) * 100;

            if (result <= target) {
                System.out.println("6を全く出さずにサイコロを振り続けた確率: " + result + "%");
                System.out.println("試行回数: " + count);
                break;
            } else {
                count = 0;
            }
        }
    }

    static void pti7(){
        Random rand = new Random();
        long totalTries = 0;  // 総試行回数
        int diceCount = 12;   // サイコロの数を21に修正
        long loopCount = 0;

        // シミュレーションを実行して、全てのサイコロが1になるまで続ける
        while (true) {
            boolean allOnes = true;  // すべてのサイコロが1になったかどうか
            totalTries++;  // 試行回数をカウント

            // 21個のサイコロを振る
            for (int i = 0; i < diceCount; i++) {
                int roll = rand.nextInt(6) + 1;  // 1から6のランダムな数
                if (roll != 1) {
                    allOnes = false;  // 一つでも1でなければフラグを下ろす
                }
            }

            // すべてのサイコロが1になったら終了
            if (allOnes) {
                System.out.println("すべてのサイコロが1になるまでの試行回数: " + totalTries);
                break;
            }

            loopCount++;

            // 進捗を1億回ごとに表示するように調整
            if (loopCount % 100_000_000 == 0) {
                System.out.println("現在のループ数: " + loopCount);
            }
        }

        // 結果の表示
        System.out.println("シミュレーションの結果、" + diceCount + "個のサイコロがすべて1になるまでにかかった試行回数: " + formatWithUnits(totalTries) + "回");
        System.out.println(diceCount+"個のサイコロをすべて１にする確率は"+((1.0 / totalTries) * 100 )+ "%");
    }

    // 数値を単位付きでフォーマットするメソッド
    private static String formatWithUnits(long value) {
        long oku = 100_000_000L; // 1億
        long cho = oku * 10_000L; // 1兆
        long kei = cho * 10_000L; // 1京
        long gai = kei * 10_000L; // 1垓

        if (value >= gai) {
            return String.format("%.2f垓", (double) value / gai);
        } else if (value >= kei) {
            return String.format("%.2f京", (double) value / kei);
        } else if (value >= cho) {
            return String.format("%.2f兆", (double) value / cho);
        } else if (value >= oku) {
            return String.format("%.2f億", (double) value / oku);
        } else {
            return String.valueOf(value);  // 単位なしでそのまま表示
        }
    }
}

