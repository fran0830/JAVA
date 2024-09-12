
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sample7 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));        //現在のファイルのエンコーディングを出力する
        /*main2(args);
        main3(args);
        clac(args);
        st(args);
        clu(args);
        data(args);
        final_test(args);*/
        ar(args);
        for_test(args);
    }

    public static void main2(String[] args) {
       System.out.println("こんにちわ");
       
    }
    
    static void main3(String[] args){
        String c1 = "aaa";
        char c2 = 'a';
        char c3 = 97;
        System.err.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    static void clac(String[] args){
        int num1 = 36;
        int num2 = 64;
        System.out.println(num1 + num2);
        
    }
    
    static void st(String[] args){
        float num;
        System.out.println(9223372036854775807L);
        num = 7.8F;
        num = num * 3F;                //float型は数値の後ろにFを付けることによってfloat型になる。
        System.out.print(num +"\n");   //数値型と改行
        System.out.println(10>7);   //bool値
        System.out.println(5==4);   //bool値
    }

    static void clu(String[] args){
        int sum;
        String mai = null;
        InputStreamReader text = new InputStreamReader(System.in);      //キーボードからの入力を行うための処理
        BufferedReader br = new BufferedReader(text);
        

        sum = 56 + 63 + 36;
        System.out.print("合計:" + sum + "\n");
        System.out.println("入力待機中...");    
        try{
            mai = br.readLine();    //入力処理
            br.close();             //入力処理をクローズする
        }catch(IOException e){
            System.err.println(e);
        }
        
        //str型とint型は流石に計算を行うことはできない。
        System.out.println(mai);        
    }

    static void data(String[] args){
        int num;    //int型。計算速度も高速らしい。
        long あｓ;  // long型。intよりも大きいサイズの数値を入力するためのデータ型
        num = 96;
        あｓ = 52; 
        System.out.println(num);
        System.out.println(あｓ);

        int width, height, depth;
        width = height = depth = 0;
        System.out.println(width + height + depth +"\n");
        var teni = 12234234;        //varは無闇に使用する変数ではない。

    }

    static void final_test(String[] args){
        final double TAX = 0.1;     //finalは1度のみ代入可能な変数を作成する
        double price = 458 * (1 + TAX);
        System.out.print(price);

    }

    // ラッパークラス
    public static void ar(String[] args){
        Integer i = Integer.valueOf(16);    // ラッパークラスを召喚する儀式。
        int val = i.intValue();             // オブジェクト化するとnullを使用することができる様になる。

        Integer q = 25;                     // 上記の手順を踏まなくても自動的にラッパークラスを召喚することもできる。

        System.out.println(val + q);        // オブジェクト化することによって頻繁に計算する必要が発生した際はメモリにキャッシュされるので効率よく開発可能になる。

        int x = 10;
        int y = 23;
        System.out.println("10 * 23 = " + (x *y));

        /*
         * JAVAはどちらか片方にでもより大きな数値を格納できるように宣言された変数が存在した場合
         * 大きな値を引くことができる方へ自動的に変換される。
        */

        double zero = 0;
        System.out.println(10 / zero);      //double型は0で割ったり0で割ったあまりを取得してもerrorにはならない。
    }

    public static void for_test(String[] args) {
        int num = 5;
        double x = 2;
        num++;
        System.out.println(num);
        /* 
        for (double i = 1; i <= 10; i++){      //このコードの場合は問題が発生する。
            System.out.println(x *= x);  //iが10よりも大きい数になった場合に停止するのに減算している。=>無限ループ
        }
        */

        int q;
        q = 85 & 15;    // ビット演算
        // ビット演算は低レベルなハードウェアの計算などに有効。普段は使用しない。マイコン系は必須?
    
        System.out.println(q);
    }

}
