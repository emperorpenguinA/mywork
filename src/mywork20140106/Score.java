package mywork20140106;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * (入力)
 * 入力は以下の形式で与えられる。
 * N
 * c1c2c3…cN
 * 1 行目は、センター試験の問題の数を表す整数 N (1≦N≦100) が与えられる。
 * 2 行目は、センター試験の解答を表す N 文字の文字列が与えられる。
 * この文字列の i 文字目 (1≦i≦N) の文字 ci (ci は 1、2、3、4 のいずれかである) は、
 * i 番目の問題の正解が ci であったことを表す。
 *
 * (出力)
 * 高橋君が正解する問題の数として考えられる最大と最小の数を空白区切りで 1 行に出力せよ。
 *
 */
public class Score {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Score score = new Score();
        score.execute();
    }

    private void execute() {
        try {
            System.out.println("入力");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //問題数を読み込む
            String line = br.readLine();
            int qNum = 0;
            if (validateQNum(line)) {
                qNum = Integer.parseInt(line);
            } else {
                br.close();
                return;
            }

            //問題の回答を読み込む
            line = br.readLine();
            if (line.length() == qNum) {
                for (int i = 0; i < qNum; i++) {
                    if (validateANum(line.substring(i, i + 1))) {
                        Answer.countUp(line.substring(i, i + 1));
                    } else {
                        br.close();
                        return;
                    }
                }
            } else {
                br.close();
                System.out.println("問題数と回答数があっていません。");
                return;
            }

            //正解数の最大と最小を出力する
            System.out.println("出力");
            int[] output = Answer.getMaxMinCount();
            System.out.println(output[0] + " " + output[1]);

            br.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    /**
     * qNumStr が
     * 　整数で
     * 　1<=qNumStr<=100
     * を満たすならtrueを返す
     *
     * @param qNum
     * @return
     */
    private boolean validateQNum(String qNumStr) {
        try {
            int qNum = Integer.parseInt(qNumStr);
            if (qNum >= 1 && qNum <= 100) {
                return true;
            } else {
                System.out.println("問題数が範囲外です。");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("数値を入力してください。");
            return false;
        }
    }

    /**
     * aNumStr が
     * 　1, 2, 3, 4のいずれかである
     * を満たすならtrueを返す
     *
     * @param aNumStr
     * @return
     */
    private boolean validateANum(String aNumStr) {
        if ("1".equals(aNumStr) || "2".equals(aNumStr) || "3".equals(aNumStr) || "4".equals(aNumStr)) {

            return true;
        } else {
            System.out.println("解答が範囲外です。");
            return false;
        }
    }

    private enum Answer {
        ONE("1", 0),
        TWO("2", 0),
        THREE("3", 0),
        FOUR("4", 0);

        private String answerNumStr;
        private int count;

        Answer(String answerNumStr, int count) {
            this.answerNumStr = answerNumStr;
            this.count = count;
        }

        /**
         * 対象の解答のcountを1増やす
         * @param input
         */
        public static void countUp(String input) {
            for (Answer answer : Answer.values()) {
                if (answer.answerNumStr.equals(input)) {
                    answer.count++;
                }
            }
        }

        /**
         * countの最大値と最小値を配列で返す
         *
         * @return
         */
        public static int[] getMaxMinCount() {
            int[] answerCountArray = new int[4];
            for (Answer answer : Answer.values()) {
                answerCountArray[answer.ordinal()] = answer.count;
            }
            int max = answerCountArray[0];
            int min = answerCountArray[0];

            for (int count : answerCountArray) {
                max = Math.max(max, count);
                min = Math.min(min, count);
            }

            return new int[] { max, min };
        }
    }
}
