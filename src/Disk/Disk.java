package Disk;

public class Disk {
    private DiskStructure structure;

    public Disk(){
      int rc= Disk_Init();
        if(rc ==-1){
            System.out.println("Disk Initialisation problem.");
        }else System.out.println("disk created");
    }//end constructor

    private int Disk_Init(){
        try{
            structure = new DiskStructure();
            //*************create a root directory***********
            return 0;
        }catch(Exception e){
            System.out.println("not able to create the data structure.");
            return -1;
        }
    }

    public int Disk_Load(Disk disk){
        /*
        must be called once from the FS_sync
         */
        this.structure.set_Superblock(disk.structure.get_Superblock());
        return 0;}

    public int disk_save(){
        return 0;}

    public int disk_write(int sector, String buffer){
        return 0;}

    public int disk_read(int sector, String buffer){
        return 0;}

    public void printDiskContents(){
        structure.diskStructure_visualisation();
    }

    public DiskStructure getStructure() {
        return structure;
    }

    public void setStructure(DiskStructure structure) {
        this.structure = structure;
    }
}
