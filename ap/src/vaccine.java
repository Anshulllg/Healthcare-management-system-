public class vaccine {
    private String name;
    private int dose;
    private int gap;
    vaccine(String a, int d, int g){
        this.name=a;
        this.dose=d;
        this.gap=g;
        System.out.println(" Vaccine Name: "+this.name+", Number of Doses:"+this.dose+", Gap Between Dose: "+this.gap);
    }

    public int getDose() {
        return dose;
    }

    public String getName() {
        return name;
    }

    public int getGap() {
        return gap;
    }
}
