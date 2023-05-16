import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * class Cart enables the user to save its chosen items or remove it
 * and its importance When a customer adds items to their cart,
 * the items are associated with that cart, which may be stored in a database or memory.
 * The customer can continue to add or remove items from their cart until they are ready to check out.
 */
public class Cart  {
    private Vector<Item>items=new Vector<Item>();
    private long totalcost;
    String email;

    public Cart(String email){
        totalcost=0;
        this.email=email;
    }
    public void AddtoCart(Item t1 ){
        items.add(t1);
        totalcost+=t1.getPrice();
    }
    public void displayCart(){
        System.out.println("the items of your cart with total cost is "+totalcost+" and the items are");
        for(int i=0;i<items.size();i++){
            System.out.println("("+(i+1)+") name "+items.elementAt(i).getName()+" id "+items.elementAt(i).getId()+" price "+items.elementAt(i).getPrice());
        }
    }
    public void removeItem(int id){
        for(Item item : items){
            if(item.getId() == id){
                items.remove(item);
                totalcost-=item.getPrice();
                break;
            }
        }
    }
    public long getTotalcost(){
        return totalcost;
    }
    public void checkout(){
        BufferedWriter Orders_store=null;
        try {
            Orders_store = new BufferedWriter(new FileWriter("All Files/Orders.txt",true));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        try {
            Orders_store.write(email+"\n"+items.size()+"\n");
            for(int i=0;i<items.size();i++){
                Orders_store.write(items.get(i).getId()+"\n");
            }
            Orders_store.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Vector<Item> getItems() {
        return items;
    }
    public String getEmail() {
        return email;
    }
}
