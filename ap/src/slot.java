
public class slot {

    private int hid;
    private int nslot;
    private int dno;
    private int quan;
    private String sel;

    slot(int hid, int nslot, int dno, int quan, String sel){
        this.hid=hid;
        this.nslot=nslot;
        this.dno=dno;
        this.quan=quan;
        this.sel=sel;
        System.out.println("Slot added by Hospital "+hid+" for Day: "+dno+ ", Available Quantity: "+quan+" of Vaccine "+sel);
    }

    public String getSel() {
        return sel;
    }

    public void setQuan(int quan) {
        this.quan = quan-1;
    }

    public int getQuan() {
        return quan;
    }

    public int getDno() {
        return dno;
    }

    public int getHid() {
        return hid;
    }

    public int getNslot() {
        return nslot;
    }
}
