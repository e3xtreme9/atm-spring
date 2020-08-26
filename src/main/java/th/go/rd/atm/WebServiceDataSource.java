package th.go.rd.atm;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class WebServiceDataSource implements DataSource{

    public ArrayList<Customer> getCustomerData(){
        //จำลองการต่อ Web Service API ดึงข้อมูลลูกค้า
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(300 , "แอนดี้" , "4567"));
        customers.add(new Customer(400 , "ลูซี่" , "5678"));
        return customers;
    }
}
