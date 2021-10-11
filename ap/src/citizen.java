public class citizen {
    private String cname;
    private int cage;
    private String unid;
    private String vtaken;
    private int dued;
    private int dtaken=0;


    public citizen(String cname,int age,String unid){
        this.cname=cname;
        this.cage=age;
        this.unid=unid;
        System.out.println("Citizen Name: "+cname+", Age: "+cage+", Unique ID : "+unid);
        if(cage<18) {
            System.out.println("Only above 18 are allowed");
        }
    }

    public int getCage() {
        return cage;
    }

    public String getCname() {
        return cname;
    }
    public String getUnid(){
        return unid;
    }

    public void setVtaken(String v){
        this.vtaken= v;
    }

    public String getVtaken() {
        return vtaken;
    }

    public void setDtaken() {
        this.dtaken++;
    }

    public void setDued(int dued) {
        this.dued = dued;
    }

    public int getDued() {
        return dued;
    }

    public void status(int tdose){
        if(this.dtaken==tdose){
            System.out.println("FUllY VACCINATED");
            System.out.println("Vaccine Given: "+this.vtaken);
            System.out.println("No of Doses given: "+this.dtaken);
        }
        else if(this.dtaken>0){
            System.out.println("PARTIALLY VACCINATED");
            System.out.println("Vaccine Given: "+this.vtaken);
            System.out.println("No of Doses given: "+this.dtaken);
            System.out.println("Next Dose due Date: "+this.dued);
        }
        else {
            System.out.println("Citizen REGISTERED");
        }
    }
}
