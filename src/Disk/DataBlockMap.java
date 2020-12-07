package Disk;

import java.util.ArrayList;
import java.util.List;

public class DataBlockMap {
    private boolean[] dataMap = new boolean[500];// why not 512 all? ask prof.
    private char unusedDataMap = 12;

    public DataBlockMap(boolean[] dataMap) {
        int index=0;
        for(boolean i : dataMap){
            this.dataMap[index] = i;
            index++;
        }
    }

    public List<Integer> get_DBM_Free_Loc() {
        List<Integer> DBM_Free_Loc_List = new ArrayList<Integer>();
        int index=0;
        for (boolean b: dataMap) {
            if(b==false){
                DBM_Free_Loc_List.add(index);
            }
            index++;
        }
        return DBM_Free_Loc_List;
    }

    public void set_DBM_Loc_Bussy(int index) {
        dataMap[index]=false;
    }

    public boolean[] getDataMap() {
        return dataMap;
    }

    public char getUnusedDataMap() {
        return unusedDataMap;
    }

    public void setUnusedDataMap(char unusedDataMap) {
        this.unusedDataMap = unusedDataMap;
    }
}
