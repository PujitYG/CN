import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/fetchVideo")
public class fetchVideo extends HttpServlet {
    public void service(HttpServletRequest request,HttpServletResponse response)
            throws IOException
    {
        response.setContentType("video/mp4");
        String file=request.getParameter("video");
        ServletOutputStream out = response.getOutputStream();
        File fin2=new File("C:\\Users\\PUJIT\\Desktop\\COMPUTERNETWORK\\src\\"+file+".mp4");
        System.out.println(fin2.length());
        FileInputStream fin = new FileInputStream(fin2);

        byte [] buf = new byte[70096];
        int read;
        while((read = fin.read(buf)) != -1)
        {
            out.write(buf, 0, read);
        }

        fin.close();
        out.flush();
        out.close();
    }
}
