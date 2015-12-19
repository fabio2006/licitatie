package ro.fabio.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ro.fabio.entity.Image;
import ro.fabio.service.ImageService;

@Controller
@RequestMapping(value = "/images")
public class UploadController implements HandlerExceptionResolver{
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "imageDisplay/{id}.html", method = RequestMethod.GET)
	
	  public void showImage(@PathVariable("id") Integer imageId,HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		System.out.println("test");
		Image image = imageService.findOne(imageId);
		
		  int len = image.getData().length;
		  byte [] rb = new byte[len];
		  rb = image.getData();
		  response.reset();
		  response.setContentType("image/jpg");
		  response.getOutputStream().write(rb,0,len);
		  response.getOutputStream().flush();  
		  
	    
//	    response.setContentLength(image.getData().length);
//	    System.out.println("image.getData().length: "+image.getData().length);
//	    response.setContentType("image/jpg");
//	    OutputStream o = response.getOutputStream();
//        o.write(image.getData());
//        o.flush(); 
//        o.close();
	    

//	    response.getOutputStream().close();
	}
	@RequestMapping(value = "imageDisplay/{id}-trumb.html", method = RequestMethod.GET)
	
	  public void showTrumbImage(@PathVariable("id") Integer imageId,HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		System.out.println("test trumb");
		Image image = imageService.findOne(imageId);
		BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getData()));
		 BufferedImage scaledImg = Scalr.resize(src, Mode.AUTOMATIC, 200, 135);
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 ImageIO.write( scaledImg, "jpg", baos );
		 baos.flush();
		 byte[] imageInByte = baos.toByteArray();
		 baos.close(); 
		 
		 int len = imageInByte.length;
		  byte [] rb = new byte[len];
		  rb = imageInByte;
		  response.reset();
		  response.setContentType("image/jpg");
		  response.getOutputStream().write(rb,0,len);
		  response.getOutputStream().flush();  
		  
	    
//	    response.setContentLength(image.getData().length);
//	    System.out.println("image.getData().length: "+image.getData().length);
//	    response.setContentType("image/jpg");
//	    OutputStream o = response.getOutputStream();
//      o.write(image.getData());
//      o.flush(); 
//      o.close();
	    

//	    response.getOutputStream().close();
	}

	@RequestMapping(value = "/savePhoto",method = RequestMethod.POST)
	public  String handleFormUpload( 
	    @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		System.out.println("inainte de try "+file.getName());
	if (!file.isEmpty()) {
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 BufferedImage scaledImg = Scalr.resize(src, Mode.AUTOMATIC, 1400, 935);
	 Image photoToSave = new Image();
	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 ImageIO.write( scaledImg, "jpg", baos );
	 baos.flush();
	 byte[] imageInByte = baos.toByteArray();
	 baos.close();
	 photoToSave.setName(file.getOriginalFilename());
	 photoToSave.setData(imageInByte);
	 imageService.save(photoToSave);

	}
	return "redirect:/index.html?success=true";
	}
	
	

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		return null;
	}

}
