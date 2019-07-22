/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class PSTPROCESS {
    Connection conn=null;
    PreparedStatement pst = null;
    ResultSet rs=null;
   
    public int login(String Username,String Password){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="SELECT * FROM Users WHERE USERNAME=? and PASSWORD=?;";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Username);
            pst.setString(2,Password); 
            rs = pst.executeQuery();
            int current=rs.getInt("ID");
            if(rs.next()){
                 pst.close();
                 rs.close(); 
                 return current;
                 
                  
                  
            }
            else{
                 return 0;
            }
                
               
        }
        catch(Exception e){
             System.out.print(e);
          return 0;
        }
    }   
   public boolean CustomerDelete(String cell){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="DELETE FROM Customer Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(Exception e){
             System.out.print(e);
          return false;
        }
    } 

   public boolean CustomerUpdate(String cell,String Customer,String Address,String PhoneNumber,String Email){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="UPDATE Customer SET CUSTOMER_NAME=?,CUSTOMER_ADDRESS=?,PHONE_NUMBER=?,EMAIL=? Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Customer);
            pst.setString(2,Address);
            pst.setString(3,PhoneNumber);
            pst.setString(4,Email);
            pst.setString(5, cell);
           
            int rs = pst.executeUpdate();
           
       
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(Exception e){
             System.out.print(e);
          return false;
        }
    } 
    public boolean SignUp(String Username,String Password,String Address,String PhoneNumber,String Email,String FullName){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO USERS(USERNAME,PASSWORD,ADDRESS,PHONE_NUMBER,EMAIL,FULL_NAME)VALUES(?,?,?,?,?,?)";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Username);
            pst.setString(2,Password);
            pst.setString(3,Address);
            pst.setString(4,PhoneNumber);
            pst.setString(5,Email);
            pst.setString(6,FullName);
            int rs = pst.executeUpdate();
       
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(Exception e){
             System.out.print(e);
          return false;
        }
    }
    
    public boolean AddCustomer(String Customer,String Address,String PhoneNumber,String Email){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO Customer(CUSTOMER_NAME,CUSTOMER_ADDRESS,PHONE_NUMBER,EMAIL)VALUES(?,?,?,?);";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Customer);
            pst.setString(2,Address);
            pst.setString(3,PhoneNumber);
            pst.setString(4,Email);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }

     public boolean AddSupplier(String supplier,String Address,String PhoneNumber,String Email){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO Supplier(SUPPLIER_NAME,SUPPLIER_ADDRESS,SUPPLIER_PHONE,EMAIL)VALUES(?,?,?,?);";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, supplier);
            pst.setString(2,Address);
            pst.setString(3,PhoneNumber);
            pst.setString(4,Email);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
    public boolean SupplierDelete(String cell){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="DELETE FROM Supplier Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    } 
    public boolean SupplierUpdate(String cell,String Supplier,String Address,String PhoneNumber,String Email){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="UPDATE Supplier SET SUPPLIER_NAME=?,SUPPLIER_ADDRESS=?,SUPPLIER_PHONE=?,EMAIL=? Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Supplier);
            pst.setString(2,Address);
            pst.setString(3,PhoneNumber);
            pst.setString(4,Email);
            pst.setString(5, cell);
           
            int rs = pst.executeUpdate();
           
       
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    } 
  
    public boolean AddInvoice(String Date,String Customer_id,String ProductID,
            String ProductDescription,String Quantity,
            String Unitprice,String TotalPayment,
            String PayAmount,
            String DueAmount
    )
    
    {
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO Invoice(date,Customer_ID,ProductID,ProductDiscription,Quantity,UnitPrice,TotalAmount,PayAmount,DueAmount)VALUES(?,?,?,?,?,?,?,?,?);";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Date);
            pst.setString(2,Customer_id);
            pst.setString(3,ProductID);
            pst.setString(4,ProductDescription);
            pst.setString(5,Quantity);
            pst.setString(6,Unitprice);
            pst.setString(7,TotalPayment);
            pst.setString(8,PayAmount);
            pst.setString(9,DueAmount);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
      public boolean InvoiceDelete(String cell){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="DELETE FROM Customer Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(Exception e){
             System.out.print(e);
          return false;
        }
    } 
        public boolean InvoiceUpdate(String cell,String Date,String Customer_id,String ProductID,
            String ProductDescription,String Quantity,
            String Unitprice,String TotalPayment,
            String PayAmount,
            String DueAmount){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="UPDATE Invoice SET date=?,Customer_ID=?,ProductID=?,ProductDiscription=?,"
                + "Quantity=?,UnitPrice=?,TotalAmount=?,"
                + "PayAmount=?,DueAmount=? Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Date);
            pst.setString(2,Customer_id);
            pst.setString(3,ProductID);
            pst.setString(4,ProductDescription);
            pst.setString(5,Quantity);
            pst.setString(6,Unitprice);
            pst.setString(7,TotalPayment);
            pst.setString(8,PayAmount);
            pst.setString(9,DueAmount);
            pst.setString(10, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(Exception e){
             System.out.print(e);
          return false;
        }
    } 
public boolean AddProduct(String PRODUCT_NAME,
        String PRODUCT_DETAILS,String PRODUCT_BUY_PRICE,
        String PRODUCT_SELL_PRICE,String PRODUCT_SUPPLIER,
        String TOTAL_PRODUCT,String PRODUCT_BRAND){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO Products(PRODUCT_NAME,PRODUCT_DETAILS,PRODUCT_BUY_PRICE,PRODUCT_SELL_PRICE,PRODUCT_SUPPLIER,TOTAL_PRODUCT,PRODUCT_BRAND)VALUES(?,?,?,?,?,?,?);";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, PRODUCT_NAME);
            pst.setString(2,PRODUCT_DETAILS);
            pst.setString(3,PRODUCT_BUY_PRICE);
            pst.setString(4,PRODUCT_SELL_PRICE);
            pst.setString(5,PRODUCT_SUPPLIER);
            pst.setString(6,TOTAL_PRODUCT);
            pst.setString(7,PRODUCT_BRAND);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
public boolean ProductsDelete(String cell){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="DELETE FROM Products Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(Exception e){
             System.out.print(e);
          return false;
        }
    }
public boolean UpdateProduct(String Cell,String PRODUCT_NAME,
        String PRODUCT_DETAILS,String PRODUCT_BUY_PRICE,String PRODUCT_SELL_PRICE,
        String PRODUCT_SUPPLIER,String TOTAL_PRODUCT,String PRODUCT_BRAND){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="UPDATE Products SET PRODUCT_NAME=?,PRODUCT_DETAILS=?,PRODUCT_BUY_PRICE=?,PRODUCT_SELL_PRICE=?,"
                + "PRODUCT_SUPPLIER=?,TOTAL_PRODUCT=?,PRODUCT_BRAND=? where=?";
                
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, PRODUCT_NAME);
            pst.setString(2,PRODUCT_DETAILS);
            pst.setString(3,PRODUCT_BUY_PRICE);
            pst.setString(4,PRODUCT_SELL_PRICE);
            pst.setString(5,PRODUCT_SUPPLIER);
            pst.setString(6,TOTAL_PRODUCT);
            pst.setString(7,PRODUCT_BRAND);
            pst.setString(8,Cell);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
public boolean AddSales(String Date,String ProductID,String Quantity,String Price){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO Sales(date,ProductID,Quantity,Price)VALUES(?,?,?,?);";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Date);
            pst.setString(2,ProductID);
            pst.setString(3,Quantity);
            pst.setString(4,Price);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
    public boolean SalesDelete(String cell){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="DELETE FROM Sales Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
    public boolean UpdateSales(String Cell,String Date,String ProductID,String Quantity,String Price){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="UPDATE Sales SET date=?,ProductID=?,Quantity=?,Price=? where id=?;";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Date);
            pst.setString(2,ProductID);
            pst.setString(3,Quantity);
            pst.setString(4,Price);
            pst.setString(5,Cell);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
    public boolean AddBuys(String Date,String ProductID,String Quantity,String Price){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="INSERT INTO Buys(date,ProductID,Quantity,Price)VALUES(?,?,?,?);";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Date);
            pst.setString(2,ProductID);
            pst.setString(3,Quantity);
            pst.setString(4,Price);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
        public boolean BuysDelete(String cell){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="DELETE FROM Buys Where ID=?";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, cell);
            int rs = pst.executeUpdate();
           
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
           public boolean UpdateBuys(String Cell,String Date,String ProductID,String Quantity,String Price){
        conn=DataBaseHelperClass.ConnecrDB();
        String Sql="UPDATE Buys SET date=?,ProductID=?,Quantity=?,Price=? where id=?;";
        try{
            pst= conn.prepareStatement(Sql);
            pst.setString(1, Date);
            pst.setString(2,ProductID);
            pst.setString(3,Quantity);
            pst.setString(4,Price);
            pst.setString(5,Cell);
            int rs = pst.executeUpdate();
          
            if(rs!=0){
                 pst.close();
                 return true;
            }
            else{
                 return false;
            }
           
        }
        catch(SQLException e){
             System.out.print(e);
          return false;
        }
    }
}
