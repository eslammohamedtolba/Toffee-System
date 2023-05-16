import java.io.*;

/**
 * the class item that will deal with all items that will be showed
 * and can store new item in the database and show all items with common catalog
 * store for each item all its attributes from name and description and brand and ext.
 */
public class Item {
    private String name,description,brand,status,catalog;
    private int id,price,quantity,discount;

    public Item(){}
    public Item(String name,int id,int price,String catalog,String brand){
        this.name = name;
        this.id = id;
        this.price = price;
        this.catalog=catalog;
        this.brand=brand;
    }
    public Item(String name, String description,String catalog, String brand, String status, int id, int price, int quantity, int discount) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.status = status;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.catalog=catalog;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
    public String getCatalog() {
        return catalog;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //to store item in the databases
    public void StoreItem(){
        BufferedWriter Items_store=null;
        try {
            Items_store = new BufferedWriter(new FileWriter("All Files/Items.txt",true));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Items_store.write(name+"\n"+id+"\n"+price+"\n"+catalog+"\n"+brand+"\n"+quantity+"\n"+discount+"\n"+description+"\n"+status+"\n");
            Items_store.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //to view all stored items
    public static void ViewItemsbycatalog(String catalog_name){
        BufferedReader Store_Items= null;
        try {
            Store_Items = new BufferedReader(new FileReader("All Files/Items.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String Name=Store_Items.readLine()
                    ,Id=Store_Items.readLine()
                    ,Price=Store_Items.readLine()
                    ,Catalog=Store_Items.readLine()
                    ,Brand=Store_Items.readLine()
                    ,Quantity=Store_Items.readLine()
                    ,Discount=Store_Items.readLine()
                    ,Description=Store_Items.readLine()
                    ,Status=Store_Items.readLine();
            while(Name!=null){
                if(Catalog.equals(catalog_name)){
                    System.out.println(Name+" "+Id+" "+Price+" "+Catalog+" "+Brand+" "+Quantity+" "+Discount+" "+Description+" "+Status);
                }
                Name=Store_Items.readLine();
                Id=Store_Items.readLine();
                Price=Store_Items.readLine();
                Catalog=Store_Items.readLine();
                Brand=Store_Items.readLine();
                Quantity=Store_Items.readLine();
                Discount=Store_Items.readLine();
                Description=Store_Items.readLine();
                Status=Store_Items.readLine();
            }
            Store_Items.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //to get item by id
    public static Item getItem(int intid){
        Item it=new Item();String id=Integer.toString(intid);
        BufferedReader Store_Items= null;
        try {
            Store_Items = new BufferedReader(new FileReader("All Files/Items.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String Name=Store_Items.readLine()
                    ,Id=Store_Items.readLine()
                    ,Price=Store_Items.readLine()
                    ,Catalog=Store_Items.readLine()
                    ,Brand=Store_Items.readLine()
                    ,Quantity=Store_Items.readLine()
                    ,Discount=Store_Items.readLine()
                    ,Description=Store_Items.readLine()
                    ,Status=Store_Items.readLine();
            while(Name!=null){
                if(Id.equals(id)){
                    it=new Item(Name,Description,Catalog,Brand,Status,Integer.parseInt(Id),Integer.parseInt(Price),Integer.parseInt(Quantity),Integer.parseInt(Discount));
                }
                Name=Store_Items.readLine();
                Id=Store_Items.readLine();
                Price=Store_Items.readLine();
                Catalog=Store_Items.readLine();
                Brand=Store_Items.readLine();
                Quantity=Store_Items.readLine();
                Discount=Store_Items.readLine();
                Description=Store_Items.readLine();
                Status=Store_Items.readLine();
            }
            Store_Items.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return it;
    }
}
