package mywork20140106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Queen {

    private CellMap cellmap = new CellMap();

    /**
     * 入力
     * 入力は以下の形式で与えられる。
     * c11 c12 … c18
     * c21 c22 … c28
     * :
     * :
     * c81 c82 … c88
     * 1 行目から 8 行目の各行は 8 文字の文字列が与えられる。
     * i 行目の先頭から j 番目の文字である cij は、i 行目 j 列目にクイーンが置かれているかどうかを表す。
     * cij は、'.' もしくは 'Q' で与えられ、'.' であればクイーンが置かれていないことを、'Q' であればクイーンが置かれていることを表す。
     * 出力
     * 8 つのクイーンを置き終わった後の状態のうちの 1 つを、入力と同様のフォーマットで出力せよ。
     * 答えが存在しない場合は、"No Answer" と 1 行で出力せよ。
     */
    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.execute();
    }

    private void execute() {

        try {
            // 入力値を読み込む
            System.out.println("入力");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            int rowCount = 1;
            while((line = br.readLine()) != null){
                Map<Integer, Cell> cellRowMap = new HashMap<Integer, Cell>();
                for (int i=1; i<=8; i++) {
                    cellRowMap.put(i, new Cell(line.substring(i - 1, i)));
                }
                cellmap.setCellRowMap(rowCount, cellRowMap);
                rowCount++;
                if (rowCount >= 8) {
                    System.out.println();
                    break;
                }
            }
            br.close();

            // TODO 判定する処理が未実装


            //出力する
            System.out.println();
            System.out.println("出力");
            for (int i=1; i<=8; i++) {
                String output = "";
                for (int j=1; j<=8; j++) {
                    output += cellmap.getCellMap().get(i).get(j).getValue();
                }
                System.out.println(output);
            }


        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
