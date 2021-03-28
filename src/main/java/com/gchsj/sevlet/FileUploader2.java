package com.gchsj.sevlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@MultipartConfig(
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*50,
    maxRequestSize = 1024*1024*50*5
)
@WebServlet("/file2")
public class FileUploader2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if(title!=null) {
            System.out.println(title);
        }
        if (content!=null) {
            System.out.println(content);
        }


        String realPath = request.getServletContext().getRealPath("/upload");
        System.out.println(realPath);

        Collection<Part> parts = request.getParts();

        for (Part filePart : parts) {
            if (!filePart.getName().equals("file"))
                continue;

            String fileName = filePart.getSubmittedFileName();
            String filePath = realPath + File.separator + fileName;
            FileOutputStream  fileOutputStream = new FileOutputStream(filePath);
            InputStream inputStream = filePart.getInputStream();
            System.out.println(filePath);
            byte[] buf = new byte[1024];
            int size;
            while ((size=inputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, size);
            }
            fileOutputStream.close();
            inputStream.close();
        }


        RequestDispatcher fileDone = request.getRequestDispatcher("fileDone.jsp");
        fileDone.forward(request, response);
    }
}
