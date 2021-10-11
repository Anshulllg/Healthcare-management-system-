
public class hospital{
    private String name;
    private int pin;
    private int id;

    hospital(String a, int d, int dd){
        this.name=a;
        this.pin=d;
        this.id=dd;
        System.out.println("Hospital Name: "+name+", Pincode: "+pin+ " Unique ID: "+dd);
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public int getPin() {
        return pin;
    }
}
