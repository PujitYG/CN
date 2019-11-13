import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet("/search")
public class search extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println("The parameter entered");
        ArrayList<video> arr = null;
        InputStream is = request.getInputStream();
        Scanner in = new Scanner(is);
        String str = "";
        while (in.hasNextLine()) {
            str = str + in.nextLine();
        }
        System.out.println("now comparing");
        try {
            if(str.length()>1) {
                arr = getList(str);
            }
        } catch (Exception e) {
        }
        String json = new Gson().toJson(arr);
        if (arr == null) {
            out.println(" ");
        } else {
            out.println(json);
        }
    }


    public ArrayList<video> getList(String str) throws SQLException, ClassNotFoundException {
            ArrayList<video> arr=video.videos();
            ArrayList<video> darr=new ArrayList<>();
            for(int i=0;i<arr.size();i++){
                System.out.println(arr.get(i).name);
                if(check(str.toLowerCase(),(arr.get(i).name).toLowerCase())){
                    darr.add(arr.get(i));
                }
            }
            return darr;
    }

    public static Boolean check(String str,String str2){
        char[]strOne=str.toCharArray();
        char[]strTwo=str2.toCharArray();
        boolean value=false;
        for(int i=0;i<=strTwo.length-(strOne.length);i++) {
            if (strTwo[i] == strOne[0]) {
                for (int k = 0; k < strOne.length; k++) {
                    if (strTwo[i + k] != strOne[k]) {
                        break;
                    }
                    if (k == strOne.length - 1) {
                        value = true;
                    }
                }
            }
        }
        return value;
    }
}
