package Disk;

import java.util.List;

public class DiskStructure {
    private SuperBlock superblock= new SuperBlock(0, true);
    private InodeMap inodeMap;
    private DataBlockMap[] dataBlockMaps = new DataBlockMap[2];
    private InodeSector[] inodeSectors = new InodeSector[10];
    private DataBlock[] dataBlocks = new DataBlock[986];

    public DiskStructure() {

        //creating BOOLEAN array and then creating inodeMap
        boolean iMapArr[] = new boolean[100];
        for(int i=0; i<100; i++){
            iMapArr[i]=false;
        }
        this.inodeMap = new InodeMap(iMapArr);

        //creating BOOLEAN array and then creating datablockMap array
        boolean dMapArr[] = new boolean[500];
        for(int i=0; i<500; i++){
            dMapArr[i]=false;
        }
        for(int i=0; i<2; i++){
            DataBlockMap dataBlockMap = new DataBlockMap(dMapArr);
            this.dataBlockMaps[i] = dataBlockMap;
        }

        //creating datablock and then Inodes to create inode sectors--- all the inodes are initialised to 0
        int[] dblock = new int[10];
        for(int i =0; i<10; i++){
            dblock[i]=0;
        }
        Inode inodeArr[] = new Inode[10];
        for(int i= 0; i<10; i++){
            Inode inode = new Inode(0,-1,dblock);
            inodeArr[i] =inode;
        }
        for(int i=0; i<10; i++){
            this.inodeSectors[i]= new InodeSector(inodeArr);
        }

        //creating dataBlock array for creating one sector and then creating array of the sectors to create dataBlock
        char[] data = new char[512];
        for (int i=0; i<512; i++){
            data[i] =0;
        }
        for(int i=0; i<986; i++){
            DataBlock dataBlock = new DataBlock(data);
            this.dataBlocks[i] = dataBlock;
        }

        }//end constructor
    //***********************Super Block FUNCTIONS****************************************************
    public SuperBlock get_Superblock() {
        return superblock;
    }

    public void set_Superblock(SuperBlock superblock) {
        this.superblock.setUMDlibFSAvailable(superblock.isUMDlibFSAvailable());
        this.superblock.setMagicNumber(superblock.getMagicNumber());
        this.superblock.setUnusedSuperBlock(superblock.getUnusedSuperBlock());
    }
    //***********************INODE MAP FUNCTIONS****************************************************
    public InodeMap get_Inode_Map() {
        return inodeMap;
    }
    public List<Integer> get_IM_Free_Loc() {
       return inodeMap.get_IM_Free_Loc();
    }
    public void reset_InodeMap(boolean[] iMapArr) {
        this.inodeMap = new InodeMap(iMapArr);
    }
    public void set_IM_Index_Bussy(int index){
        this.inodeMap.set_IM_Index_Bussy(index);
    }

    //***********************DATA BLOCK MAP FUNCTIONS**************************************************
    public DataBlockMap[] get_Data_Block_Maps() {
        return dataBlockMaps;
    }
    public List<Integer> get_DataBlockMap_Free_Loc(int mapIndex){
        return dataBlockMaps[mapIndex].get_DBM_Free_Loc();
    }
    public void reset_Both_DataBlockMaps(boolean[] dMapArr) {
        for(int i=0; i<2; i++){
            DataBlockMap dataBlockMap = new DataBlockMap(dMapArr);
            this.dataBlockMaps[i] = dataBlockMap;
        }
    }
    public void set_DataBlockMap_Index_Bussy(int mapIndex, int dataIndex) {
        this.dataBlockMaps[mapIndex].set_DBM_Loc_Bussy(dataIndex);
    }

    //***********************INODE SECTOR FUNCTIONS****************************************************
    public InodeSector[] get_InodeSectors() {
        return inodeSectors;
    }
    public Inode[] get_InodeArray_Of_InodeSector(int inodeSectorIndex){
        return this.inodeSectors[inodeSectorIndex].get_Inode_Array();
    }
    public Inode get_Inode_From_InodeArray_Of_InodeSector(int inodeSectorIndex, int inodeIndex){
        return this.inodeSectors[inodeSectorIndex].getInode(inodeIndex);
    }

    public void set_InodeSectors(InodeSector[] inodeSectors) {
        this.inodeSectors = inodeSectors;
    }
    public void set_Inode_Of_InodeSector(int inodeSectorIndex, int inodeIndex, Inode inode){
        this.inodeSectors[inodeSectorIndex].set_Inode_In_Inode_Sector(inode, inodeIndex);
    }
    public void set_InodeArray_In_InodeSector(int inodeSectorIndex, Inode[] inodes){
        this.inodeSectors[inodeSectorIndex].reset_Inode_Sector(inodes);
    }

    //***********************Data Block FUNCTIONS****************************************************
    public DataBlock[] get_All_DataBlocks() {
        return dataBlocks;
    }
    public char[] get_dataBlock(int dataBlocksindex){
        return this.dataBlocks[dataBlocksindex].getData();
    }
    public void set_DataBlock(char[] data, int dataBlockIndex, int free_loc_index) {
        List<Integer> free_Loc_List= dataBlocks[dataBlockIndex].get_Free_Loc();
        if (free_Loc_List.size()!=data.length){
            System.out.println("cannot allocate in the given datablock, try again");
        }
        this.dataBlocks[dataBlockIndex].setData(data,free_loc_index);
    }
    //************************** function to visualise the disk structure****************************
    public void diskStructure_visualisation(){
        System.out.println("**********************************************Super Block**********************************************");
        System.out.println(this.superblock.getMagicNumber());
        System.out.println(this.superblock.isUMDlibFSAvailable());
        System.out.println(this.superblock.getUnusedSuperBlock());
        System.out.println("**********************************************Inode Map**********************************************");
        String[] imap = this.inodeMap.tostring();
        int imapIndex=0;
        for(String s: imap){
            System.out.println("index: "+imapIndex+" " +" value: "+ s);
            imapIndex++;
        }
        System.out.println("**********************************************Data Block Map**********************************************");
        int datamapindex =0;
        for(DataBlockMap dbm: dataBlockMaps ){
           boolean[] datamap = dbm.getDataMap();
            for (boolean dm: datamap) {
                System.out.println("index: "+ datamapindex+" "+" value: "+dm);
                datamapindex++;
            }
        }
        System.out.println("**********************************************Inode Sectors**********************************************");
       int inodeSectoreIndex=0;
       for(InodeSector is: inodeSectors){
           for(String s:is.tostring()){
               System.out.println(inodeSectoreIndex+" "+s);
           }
           inodeSectoreIndex++;
       }
        System.out.println("***Data***");
       int datablocksindex=0;
        for (DataBlock d: dataBlocks){
            System.out.println("index : "+ datablocksindex +" "+"value: "+d.tostring());
            datablocksindex++;

        }
    }
}

