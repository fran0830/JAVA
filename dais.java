import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class dais {
    public static void main(String[] args) {
        // 並列処理用のスレッドプールを作成
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 並列シミュレーションを実行
        long totalTries = forkJoinPool.invoke(new DiceTask(21, 0));

        // 結果の表示
        System.out.println("シミュレーションの結果、すべてのサイコロが1になるまでにかかった試行回数: " + formatWithUnits(totalTries) + "回");
    }

    // サイコロのシミュレーションを行うタスク
    static class DiceTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 100_000; // タスクのしきい値
        private int diceCount;
        private long loopCount; // ループ数のカウンタ

        public DiceTask(int diceCount, long loopCount) {
            this.diceCount = diceCount;
            this.loopCount = loopCount;
        }

        @Override
        protected Long compute() {
            Random rand = new Random();
            long totalTries = 0;

            // タスクを細分化するか、単一スレッドで処理するかを決定
            if (diceCount > THRESHOLD) {
                // 大きなタスクを2つに分割して並列処理
                int half = diceCount / 2;
                DiceTask task1 = new DiceTask(half, loopCount);
                DiceTask task2 = new DiceTask(diceCount - half, loopCount);

                // 並列実行
                task1.fork();
                long result2 = task2.compute();
                long result1 = task1.join();

                // 結果を合算
                return result1 + result2;
            } else {
                // しきい値以下なら通常の処理を実行
                while (true) {
                    totalTries++;
                    loopCount++;
                    boolean allOnes = true;
                    for (int i = 0; i < diceCount; i++) {
                        int roll = rand.nextInt(6) + 1;
                        if (roll != 1) {
                            allOnes = false;
                            break;
                        }
                    }

                    // すべてのサイコロが1なら終了
                    if (allOnes) {
                        break;
                    }

                    // 進捗を1億回ごとに表示
                    if (loopCount % 100_000_000 == 0) {
                        System.out.println("現在のループ数: " + loopCount);
                    }
                }
                return totalTries;
            }
        }
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
