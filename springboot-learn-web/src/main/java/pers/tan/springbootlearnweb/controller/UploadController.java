package pers.tan.springbootlearnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class UploadController {

    @RequestMapping("uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model model) throws Exception {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();

            System.out.println(fileName);

            String destFileName = request.getServletContext().getRealPath("")+"uploaded"+ File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            model.addAttribute("fileName", fileName);
            return "showImg";
    }
}
