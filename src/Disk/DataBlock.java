package Disk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBlock {
    private char[] data = new char[512];

    public DataBlock(char[] data) {
        int index = 0;
        for (char i : data) {
            this.data[index] = i;
            index++;
        }
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data, int start_Index) {
        int index = start_Index;
        for (char i : data) {
            this.data[index] = i;
            index++;
        }
    }
    public List<Integer> get_Free_Loc() {
        List<Integer> Free_Loc_List = new ArrayList<Integer>();
        int index=0;
        for (char c: data) {
            if(c==0){
                Free_Loc_List.add(index);
            }
            index++;
        }
        return Free_Loc_List;
    }

    public String[] tostring() {
        int index=0;
        String[] dataMAp = new String[512];
        for(char c: data){
            dataMAp[index] = String.valueOf(c);
            index++;
        }
        return dataMAp;
    }
}