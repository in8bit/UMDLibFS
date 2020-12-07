import Disk.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        Disk ram = new Disk();
        Disk HDD = new Disk();

        DiskStructure ramStruct = ram.getStructure();
        SuperBlock sb=ramStruct.get_Superblock();
        System.out.println(sb.getMagicNumber());
        InodeSector[] ramis= ramStruct.get_InodeSectors();
        for (InodeSector is: ramis) {
           String[] s= is.tostring();
           for (String a: s){
               System.out.println(a);
           }
        }

    }
}
