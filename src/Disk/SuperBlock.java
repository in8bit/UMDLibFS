package Disk;

public class SuperBlock {
   private int magicNumber;
   private boolean UMDlibFSAvailable;
   private char unusedSuperBlock = 507;

    public SuperBlock(int magicNumber, boolean UMDlibFSAvailable) {
        this.magicNumber = magicNumber;
        this.UMDlibFSAvailable = UMDlibFSAvailable;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public boolean isUMDlibFSAvailable() {
        return UMDlibFSAvailable;
    }

    public void setUMDlibFSAvailable(boolean UMDlibFSAvailable) {
        this.UMDlibFSAvailable = UMDlibFSAvailable;
    }

    public char getUnusedSuperBlock() {
        return unusedSuperBlock;
    }

    public void setUnusedSuperBlock(char unusedSuperBlock) {
        this.unusedSuperBlock = unusedSuperBlock;
    }
}
