package mywork20140106;

import java.util.HashMap;
import java.util.Map;

public class CellMap {

    private Map<Integer, Map<Integer, Cell>> cellMap;

    public void setCellRowMap(Integer rowCount, Map<Integer, Cell> cellRowMap) {
        if (cellMap == null) {
            cellMap = new HashMap<Integer, Map<Integer,Cell>>();
        }

        cellMap.put(rowCount, cellRowMap);
    }

    public Map<Integer, Map<Integer, Cell>> getCellMap() {
        return cellMap;
    }


}
