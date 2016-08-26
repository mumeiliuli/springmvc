package test.spring.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import test.spring.model.Person;

@Controller
@RequestMapping("/Hello")
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello(){
		ModelAndView model=new ModelAndView();
		model.addObject("message", "你好啊");
		model.setViewName("hello");
		return model;
	}
	
	@RequestMapping(value="/GetPerson",method=RequestMethod.GET)
	@ResponseBody
	public void GetPerson(String name,@RequestHeader(value="User-Agent", defaultValue="") String userAgent, PrintWriter pw){
		pw.write(userAgent);
//		Person p=new Person();
//		p.setName(name);
//		p.setAge(18);
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//			String pstr= mapper.writeValueAsString(p);
//			pw.write(pstr);
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	@RequestMapping(value="/GetPersonInfo",method=RequestMethod.POST)
	@ResponseBody
	public void GetPersonInfo(Person p,PrintWriter pw){
		p.setAge(p.getAge()+20);
		ObjectMapper mapper=new ObjectMapper();
        try {
			String pstr= mapper.writeValueAsString(p);
			pw.write(pstr);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value="/SubmitPersonInfo",method=RequestMethod.POST)
	public String SubmitPersonInfo(Person p,PrintWriter pw){
		pw.write(p.getName()+"----"+p.getAge());
		return "redirect:hello";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception {
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("filename");
		String fileName = file.getOriginalFilename();
		//E:/study/jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMvc/upload
		String path = req.getSession().getServletContext().getRealPath("upload");
		File f=new File(path);
		if(!f.exists()&&!f.isDirectory()){
			f.mkdir();
		}
		FileOutputStream fos = new FileOutputStream(path+ "/"+fileName); 
		fos.write(file.getBytes()); 
		fos.flush(); 
		fos.close(); 
		return "redirect:hello";
	}
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest req) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "pic.jpg");
        String path = req.getSession().getServletContext().getRealPath("upload");
		File f=new File(path+"/pic1.jpg");
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),headers, HttpStatus.CREATED);
    }

}
