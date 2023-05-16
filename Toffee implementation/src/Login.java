import java.io.*;

/**
 * login class to enable the user to log in the system to make the shopping
 * after a successful login, it stores the user in the datavase
 * and can check if the user registered before or not
 */
public class Login {
    private String Email,Password,Address,phone;
    public boolean log_in(String email, String password) {
        BufferedReader login_info= null;
        try {
            login_info = new BufferedReader(new FileReader("All Files/Login Info.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            boolean islogin=false;
            this.Email=login_info.readLine();
            this.Password=login_info.readLine();
            this.Address=login_info.readLine();
            this.phone=login_info.readLine();
            while(Email!=null){
                if(this.Email.equals(email) && this.Password.equals(password)){
                    islogin=true;
                    break;
                }
                this.Email=login_info.readLine();
                this.Password=login_info.readLine();
                this.Address=login_info.readLine();
                this.phone=login_info.readLine();
            }
            login_info.close();
            return islogin;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //to check if the email address exists or not, in other hand, if the user exists in database or not
    public boolean Emailexist(String email){
        BufferedReader login_info= null;
        try {
            login_info = new BufferedReader(new FileReader("All Files/Login Info.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            boolean islogin=false;
            this.Email=login_info.readLine();
            this.Password=login_info.readLine();
            this.Address=login_info.readLine();
            this.phone=login_info.readLine();
            while(Email!=null){
                if(this.Email.equals(email)){
                    islogin=true;
                    break;
                }
                this.Email=login_info.readLine();
                this.Password=login_info.readLine();
                this.Address=login_info.readLine();
                this.phone=login_info.readLine();
            }
            login_info.close();
            return islogin;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //to store the user by his email, password, address and phone
    public void Store_User(String email,String password,String Address,String phone){
        BufferedWriter user_store=null;
        try {
            user_store = new BufferedWriter(new FileWriter("All Files/Login Info.txt",true));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            user_store.write(email+"\n"+password+"\n"+Address+"\n"+phone+"\n");
            user_store.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}