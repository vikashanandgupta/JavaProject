
package db;

import java.sql.*;
import javax.swing.JOptionPane;



public class DBConnect {
    
    public static Connection c;
    public static Statement st;
    
     public static PreparedStatement checkedAdmin, checkedUser,updateComputerAsset,getAsset,updateChairAsset,
             updateTableAsset,updateWbAsset, updateProjectorAsset,updateFanAsset,addAssetLoc,changePassword,
             changeUserPassword,addRequest,getRequest,setUser,autoIdAssetLoc,setAcceptanace,assetLoc;
     
    
    static
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ams","ams");
            Statement st=c.createStatement();
            checkedAdmin=c.prepareStatement("select * from admin where aid=? and apw=?");
            checkedUser=c.prepareStatement("select * from user_info where userid=? and userpw=?");
            setUser=c.prepareStatement("insert into user_info values(?,?,?)");
            updateComputerAsset=c.prepareStatement("update total_asset set computer=? where ref_id=100");
            getAsset=c.prepareStatement("select * from total_asset where ref_id=?");
            updateChairAsset=c.prepareStatement("update total_asset set chair=? where ref_id=100");
            updateTableAsset=c.prepareStatement("update total_asset set tables=? where ref_id=100");
            updateWbAsset=c.prepareStatement("update total_asset set white_board=? where ref_id=100");
            updateProjectorAsset=c.prepareStatement("update total_asset set projector=? where ref_id=100");
            updateFanAsset=c.prepareStatement("update total_asset set fan=? where ref_id=100");
            
            changePassword=c.prepareStatement("update admin set apw=? where aid=? and apw=?");
            changeUserPassword=c.prepareStatement("update user_info set userpw=? where userid=? and userpw=?");
            addAssetLoc=c.prepareStatement("insert into asset_loc values(?,?,?,?)");
            assetLoc=c.prepareStatement("select * from asset_loc");
            
            autoIdAssetLoc=c.prepareStatement("insert into asset_loc(asset_name,block,room) values(?,?,?)");
            addRequest=c.prepareStatement("insert into request(asset_name,item_no,block,room_no,user_name,acceptance,user_id)"
                    + " values(?,?,?,?,?,?,?)");
            getRequest=c.prepareStatement("select * from request");
            
            setAcceptanace=c.prepareStatement("update request set acceptance=? where asset_id=?");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
