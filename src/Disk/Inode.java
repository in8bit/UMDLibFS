package Disk;

import java.util.Arrays;

public class Inode {
    private int fileSize;
    private int fileType;
    private int[] dataBlocks = new int[10];

    public Inode(int fileSize, int fileType, int[] dataBlocks) {
        this.fileSize = fileSize;
        this.fileType = fileType;//0=dir &1=file & -1 = empty

        int index=0;
        for(int i : dataBlocks){
            this.dataBlocks[index] =i;
            index++;
        }

    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public int[] getDataBlocks() {
        return dataBlocks;
    }

    public void setDataBlocks(int[] dataBlocks) { //ask the datablock array to always be sent in size 10. send 0 for empty blocks.
        int index=0;
        for(int i : dataBlocks){
            this.dataBlocks[index] =i;
            index++;
        }
    }

    public String[] tostring() {
        String inode[] = new String[12];
        inode[0] = String.valueOf(getFileSize());
        inode[1] = String.valueOf(getFileType());
        int index =0;
          for(int i=2; i<12; i++){
           inode[i]= String.valueOf(this.dataBlocks[index]);
           index++;
          }
        return inode;
    }
}
