import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static int id=100000;
    static public ArrayList<vaccine> vdata = new ArrayList<vaccine>();
    static public ArrayList<citizen> cdata = new ArrayList<citizen>();
    static public ArrayList<hospital> hdata = new ArrayList<hospital>();
    static public ArrayList<slot> sdata = new ArrayList<slot>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        int check = 1;
        do {
            System.out.println("CoWin Portal initialized....");
            System.out.println("----------------------");
            System.out.println("Choose the task");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("----------------------");

            int n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    int gap=0;
                    System.out.println("Menu Options");
                    System.out.println("----------------------");
                    System.out.println("Vaccine Name: ");
                    String Vname =sc.nextLine();
                    System.out.println("Number of Doses: ");
                    int doses =sc.nextInt();
                    if(doses>1){
                        System.out.println("Gap Between Doses: ");
                        gap = sc.nextInt();
                    }

                    vaccine x = new vaccine(Vname, doses, gap);
                    vdata.add(x);

                    break;
                case 2:
                    System.out.println("Menu Options");
                    System.out.println("----------------------");
                    System.out.println("Hospital Name: ");
                    String Hname = sc.nextLine();
                    System.out.println("Pincode: ");
                    int pincode = sc.nextInt();
                    id++;
                    hospital y= new hospital(Hname,pincode, id);
                    hdata.add(y);
                    break;
                case 3:
                    System.out.println("Citizen Name: ");
                    String cname = sc.nextLine();
                    System.out.println("Age: ");
                    int cage= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Unique ID: ");
                    String unid= sc.nextLine();
                    citizen c= new citizen(cname,cage,unid);
                    cdata.add(c);

                    break;
                case 4:
                    System.out.println("Enter Hospital ID: ");
                    int hid= sc.nextInt();
                    System.out.println("Enter number of Slots to be added: ");
                    int nslot= sc.nextInt();
                    for (int i=0; i<nslot;i++){
                        System.out.println("Enter Day Number: ");
                        int dno= sc.nextInt();
                        System.out.println("Enter Quantity: ");
                        int quan= sc.nextInt();
                        System.out.println("Select Vaccine");
                        for(int j=0;j<vdata.size();j++){
                            System.out.println(j+". "+vdata.get(j).getName());
                        }
                        int sel=sc.nextInt();
                        slot sl=new slot(hid,nslot,dno,quan,vdata.get(sel).getName());
                        sdata.add(sl);
                    }

                    break;
                case 5:
                    int pid=0;
                    int vid=0;
                    int p_in=0;
                    int ch=0;
                    System.out.println("Enter patient Unique ID: ");
                    String hospid= sc.nextLine();
                    for( int j=0; j<cdata.size();j++) {
                        if (hospid.equals(cdata.get(j).getUnid())) {
                            pid = j;
                        }
                    }
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.println("Enter option: ");
                    int way = sc.nextInt();
                    sc.nextLine();
                    if (way == 1) {
                        System.out.println("Enter PinCode: ");
                        int pin = sc.nextInt();
                        for(int i=0; i<hdata.size();i++){
                            if (pin==hdata.get(i).getPin()){
                                System.out.println(hdata.get(i).getId()+" "+hdata.get(i).getName());
                            }
                        }
                        System.out.println("Enter hospital ID: ");
                        int hoid = sc.nextInt();
                        for (int i = 0; i < sdata.size(); i++) {
                            if (hoid == (sdata.get(i).getHid()) && cdata.get(pid).getDued()<=sdata.get(i).getDno() ) {
                                System.out.println(i + "-> Day: " + (i + 1) +" Available Qty: " + sdata.get(i).getQuan()+" Vaccine: " + sdata.get(i).getSel());
                                ch=1;
                            }
                        }
                        if (ch==1){
                            System.out.println("Choose slot: ");
                            int slott = sc.nextInt();

                            System.out.println(cdata.get(pid).getCname() + " vaccinated with " + sdata.get(slott).getSel());
                            for( int j=0; j<vdata.size();j++) {
                                if (sdata.get(slott).getSel().equals(vdata.get(j).getName())){
                                    vid=j;
                                }
                            }
                            cdata.get(pid).setDtaken();
                            cdata.get(pid).setVtaken(sdata.get(slott).getSel());
                            cdata.get(pid).setDued(sdata.get(slott).getDno()+vdata.get(vid).getGap());
                            sdata.get(slott).setQuan(sdata.get(slott).getQuan());
                        }
                        else{
                            System.out.println("No Slots Available");
                        }


                    } else if (way == 2) {
                        System.out.println("Enter Vaccine name: ");
                        String vvname = sc.nextLine();
                        for (int i = 0; i < hdata.size(); i++) {
                            for (int j = 0; j < sdata.size(); j++) {
                                if (vvname.equals(sdata.get(j).getSel()) && sdata.get(j).getHid()==hdata.get(i).getId()) {
                                    System.out.println(hdata.get(i).getId() + " " + hdata.get(i).getName());
                                }
                            }
                        }

                        System.out.println("Enter hospital ID: ");
                        int hoid = sc.nextInt();

                        for (int i = 0; i < sdata.size(); i++) {
                            if (hoid == (sdata.get(i).getHid()) && sdata.get(i).getSel().equals(vvname) && cdata.get(pid).getDued()<=sdata.get(i).getDno()) {
                                System.out.println(i + "-> Day: " + (i + 1) +" Available Qty: " + sdata.get(i).getQuan()+" Vaccine: " + sdata.get(i).getSel() );
                                ch=1;
                            }
                        }
                        if (ch==1){
                            System.out.println("Choose slot: ");
                            int slott = sc.nextInt();

                            System.out.println(cdata.get(pid).getCname() + " vaccinated with " + sdata.get(slott).getSel());
                            for( int j=0; j<vdata.size();j++) {
                                if (sdata.get(slott).getSel().equals(vdata.get(j).getName())){
                                    vid=j;
                                }
                            }
                            cdata.get(pid).setDtaken();
                            cdata.get(pid).setVtaken(sdata.get(slott).getSel());
                            cdata.get(pid).setDued(sdata.get(slott).getDno()+vdata.get(vid).getGap());
                        }
                        else{
                            System.out.println("No Slots Available");
                        }



                    } else if (way == 3) {
                        break;
                    }

                    break;

                case 6:
                    System.out.println("Enter Hospital Id: ");
                    int hosid=sc.nextInt();
                    for (int i=0; i<sdata.size();i++){
                        if (hosid==(sdata.get(i).getHid())){
                            System.out.println("Day: "+i+" Vaccine: "+sdata.get(i).getSel()+" Available Qty: "+sdata.get(i).getQuan());
                        }

                    }
                    break;
                case 7:
                    int p_id=0;
                    int vi_d=0;
                    System.out.println("Enter Patient ID: ");
                    String piid=sc.nextLine();

                    for(int i=0;i<cdata.size();i++){
                        if (piid.equals(cdata.get(i).getUnid())){
                            p_id=i;
                        }
                    }
                    for(int i=0;i<vdata.size();i++){
                        if (cdata.get(p_id).getVtaken().equals(vdata.get(i).getName())){
                            vi_d=i;
                        }
                    }
                    cdata.get(p_id).status(vdata.get(vi_d).getDose());

                    break;
                case 8:
                    System.out.println("{End of Test Case}");
                    check = 0;
                    break;
            }

        } while (check == 1);

    }


}
