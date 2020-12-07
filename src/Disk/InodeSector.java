package Disk;

import java.util.Arrays;

public class InodeSector {
    private Inode[] inodes = new Inode[10];
    private char unusedInodeSector = 32;

    public InodeSector(Inode[] inode) {
        int index=0;
        for (Inode i: inode) {
            this.inodes[index]=i;
            index++;
        }
    }

    public Inode getInode(int index) {
        return inodes[index];
    }
    //to set single inode in the array of inodes
    public void set_Inode_In_Inode_Sector(Inode inode, int index) {
        inodes[index]= inode;
    }

    //to set the entire sector with inode array
    public void reset_Inode_Sector(Inode[] inode){
        int index=0;
        for (Inode i: inode) {
            this.inodes[index]=i;
            index++;
        }
    }
    public String[] tostring(){
        String[] inodesString = new String[10];
        int index=0;
        for (Inode i: inodes){
            for (String s: i.tostring()) {
                inodesString[index] = s;
            }
        }
        return inodesString;

    }


    public char getUnusedInodeSector() {
        return unusedInodeSector;
    }

    public void setUnusedInodeSector(char unusedInodeSector) {
        this.unusedInodeSector = unusedInodeSector;
    }

    public Inode[] get_Inode_Array( ) {
       return this.inodes;
    }
}
