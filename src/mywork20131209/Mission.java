package mywork20131209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 入力
 *
 * N
 * a0 b0
 * a1 b1
 * :
 * :
 * aN−1 bN−1
 *
 * N    購入する商品の品数 (1 <= N <= 10)
 * ai   商品の個数 (1≦ai≦10)
 * bi   商品の消費税抜きの単価 (1≦bi≦1,000)
 *
 * 入力は N+1 行ある。
 * 1 行目には、購入する商品の品数を表す整数 N(1≦N≦10) が与えられる
 * 2 行目から N 行の i+2 行目にはある商品の購入したい個数を表す整数 ai(1≦ai≦10) と
 * その単価を表す整数 bi(1≦bi≦1,000) が空白区切りで与えられる。
 *
 *
 * 出力
 * 高橋君のおつかいに必要な金額を消費税5%で標準出力に 1 行で出力せよ。
 * なお、最後には改行を出力せよ。
 *
 * 消費税は 1 円未満は切り捨てます。
 *
 * @author emperorpenguinA
 *
 */
public class Mission {

    public static void main(String[] args) {

        try {

            System.out.println("入力");
            //入力を受け取る
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //入力Nを受け取る
            String line = br.readLine();
            int itemKind = 0;
            if (validate(line, 1, 10)) {
                itemKind = Integer.parseInt(line);
            } else {
                return;
            }

            //入力をN行分受け取る
            List<ItemSet> itemList = new ArrayList<ItemSet>();
            for (int i = 1; i <= itemKind; i++) {
                String item = br.readLine();
                String[] itemArray = item.split(" ");
                if (itemArray.length == 2) {
                    if (validate(itemArray[0], 1, 10) && validate(itemArray[1], 1, 1000)) {
                        ItemSet itemSet = new ItemSet(Integer.parseInt(itemArray[0]), Integer.parseInt(itemArray[1]));
                        itemList.add(itemSet);
                    } else {
                        return;
                    }
                } else {
                    System.out.println("不正な入力です。");
                    return;
                }
            }

            br.close();

            //計算する
            int result = caliculate(itemList);
            //出力する
            System.out.println("出力");
            System.out.println(result);
            System.out.println();

        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    /**
     * 引数の商品情報を下に、合計金額を計算して返す。
     *
     * @param itemList
     * @return
     */
    private static int caliculate(List<ItemSet> itemList) {
        //合計を計算する
        double sum = 0;
        for (ItemSet itemSet : itemList) {
            sum += itemSet.getNumber() * itemSet.getPrice();
        }

        //消費税追加して小数点以下切り捨て
        int result = (int) Math.floor(sum * 1.05);
        return result;
    }

    /**
     * 入力値が範囲内の整数であることを確認する
     *
     * @param targetStr
     * @param startRange
     * @param endRange
     * @return
     */
    private static boolean validate(String targetStr, int startRange, int endRange) {

        try {
            int number = Integer.parseInt(targetStr);

            if (number >= startRange && number <= endRange) {
                return true;
            } else {
                System.out.println("範囲外の値です。");
                return false;
            }

        } catch (NumberFormatException e) {
            System.out.println("整数で入力して下さい。");
            return false;
        }
    }
}
