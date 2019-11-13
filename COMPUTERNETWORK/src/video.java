import java.sql.*;
import java.util.ArrayList;

public class video {
    String name;
    String videoLength;

    public video(String name, String videoLength) {
        this.name = name;
        this.videoLength = videoLength;
    }

    public static ArrayList<video> videos() throws ClassNotFoundException, SQLException {
        ArrayList<video> arr=new ArrayList<>();
        Connection conn=null;
        Statement stmt=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost/COMPUTER_NETWORK","root","dancebar123");
        String sql="Select * from video";
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            arr.add(new video(rs.getString("name"),rs.getString("size")));
        }
        return arr;
    }
}
