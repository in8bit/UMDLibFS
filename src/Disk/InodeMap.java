package Disk;

import java.util.ArrayList;
import java.util.List;

public class InodeMap {
    private boolean[] inodeMap = new boolean[100];
    private char unusedInodeMap = 412;

    //constructor setting the inode map.
    public InodeMap(boolean[] inodeMap) {
        int index=0;
        for(boolean i : inodeMap){
            this.inodeMap[index] = i;
            index++;
        }
    }

    public List<Integer> get_IM_Free_Loc() {
        List<Integer> IM_Free_Loc_List = new ArrayList<Integer>();
        int index=0;
        for (boolean b: inodeMap) {
            if(b==false){
                IM_Free_Loc_List.add(index);
            }
            index++;
        }
        return IM_Free_Loc_List;
    }

    public void set_IM_Index_Bussy(int index) {
        inodeMap[index]=false;
    }

    public char getUnusedInodeMap() {
        return unusedInodeMap;
    }

    public void setUnusedInodeMap(char unusedInodeMap) {
        this.unusedInodeMap = unusedInodeMap;
    }

    //toString variation
    public String[] tostring() {
        int index=0;
        String[] inodeMAp = new String[100];
        for(boolean b: inodeMap){
            inodeMAp[index] = String.valueOf(b);
            index++;
        }
        return inodeMAp;
    }
}
