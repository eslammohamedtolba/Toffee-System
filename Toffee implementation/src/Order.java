import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * When the customer is ready to check out, the items in their cart are used to create an order.
 * The order typically includes information such as the customer's name and contact information,
 * the items they have purchased, and the total cost of the purchase.
 * The order is then stored in a database or other storage system.
 */
public class Order
{
    private int id,address,earnedPoints;
    private double totalCost;
    private String date,phoneNumber,email;
    private Vector<Item>items=new Vector<Item>();
    private static int CounterId=1;
    private boolean isShipped;

    public Order(){
        id=CounterId;
        CounterId++;
    }
    public Order(String email,int address, int earnedPoints, String date, String phoneNumber) {
        this.email=email;
        this.address = address;
        this.earnedPoints = earnedPoints;
        this.date = date;
        this.phoneNumber = phoneNumber;
        id=CounterId;
        CounterId++;
    }
    public void CreateOrder(Cart c){
        this.email=c.email;
        this.items=c.getItems();
        this.totalCost=c.getTotalcost();
    }
    public static void GetOrdersforEmail(String email){
        BufferedReader Store_Orders= null;
        try {
            Store_Orders = new BufferedReader(new FileReader("All Files/Orders.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Item it=new Item();int intid=0,j=1;boolean rightemail;
            String Email=Store_Orders.readLine(),
            Id=Store_Orders.readLine();
            while(Email!=null){
                rightemail=false;
                if(Email.equals(email)){
                    rightemail=true;
                    System.out.println("the ("+j+") "+"items order are");
                    j++;
                }
                intid=Integer.parseInt(Id);
                for(int i=0;i<intid;i++){
                    Id=Store_Orders.readLine();
                    it=Item.getItem(Integer.parseInt(Id));
                    if(rightemail){
                        System.out.println("\t name "+it.getName()+" id "+it.getId()+" price "+it.getPrice()+" catalog "+it.getCatalog());
                    }
                }
                Email=Store_Orders.readLine();
                Id=Store_Orders.readLine();
            }
            Store_Orders.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public int getAddress() {
        return address;
    }
    public void setAddress(int address) {
        this.address = address;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }
    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public boolean isShipped() {
        return isShipped;
    }
    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }
}
