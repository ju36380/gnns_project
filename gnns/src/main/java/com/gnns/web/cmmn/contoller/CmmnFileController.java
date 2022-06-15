package com.gnns.web.cmmn.contoller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gnns.web.cmmn.service.CmmnFIleService;
import com.gnns.web.common.model.FileModel;

@Controller
public class CmmnFileController {
	@Autowired
	private CmmnFIleService fileSevice;

	@GetMapping("/file/download")
	public ResponseEntity<Object> fileDownload(FileModel fileModel) throws IOException {
		String tbNm = null;
		if("pds".equals(fileModel.getFilePath())){
			tbNm = "WEB_BOARD_PDS";
		}else {
			tbNm = "WEB_".concat(fileModel.getFilePath().toUpperCase());
		}
		fileModel.setTbNm(tbNm);
		
		String orgFileNm = fileSevice.selectFileNm(fileModel);
		String fPath =null;
		if("pds".equals(fileModel.getFilePath())){
			fPath ="pds";
		}else {
			fPath = fileModel.getFilePath();
		}
		String path = "d:/99_data/" + fPath + "/" + orgFileNm;
		try {
			Path filePath = Paths.get(path);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath));

			File file = new File(path);

			HttpHeaders headers = new HttpHeaders();
			String fileName = URLEncoder.encode(file.getName(), "utf-8");
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());
			
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
	@ResponseBody
	@RequestMapping("/file/fileUpload")
	public Map<String, Object> fileUpload(final MultipartHttpServletRequest multiRequest, HttpServletResponse res, ModelMap model, FileModel fModel) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<FileModel> result  = new ArrayList<FileModel>();
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		String kind = multiRequest.getParameter("kind");
		if(!files.isEmpty()) {
			String storePathString = "D:/99_data/"+fModel.getFilePath();
			File saveFolder = new File(storePathString);
			if(!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdir();
			}
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			String filePath = "";
			
			
			FileModel fileModel = new FileModel();
			
			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();
				file = entry.getValue();
				String orginFileName = file.getOriginalFilename();
				int index = orginFileName.lastIndexOf(".");
				String fileExt = orginFileName.substring(index+1);
				
				String newName = orginFileName;
				long _size = file.getSize();
				String fileType = file.getContentType();
				
				filePath =  storePathString+"/"+newName;
				file.transferTo(new File(filePath));
				fileModel.setFileName(orginFileName);
				fileModel.setExt(fileExt);
				fileModel.setFileType(fileType);
				result.add(fileModel);
			}
		}
		
		resMap.put("fileList", result);
	    return resMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/file/fileDelete") // 2021-11-18 준혁 (추가)
	public Map<String, Object> fileDelete(final MultipartHttpServletRequest multiRequest, HttpServletResponse res, ModelMap model, FileModel fModel) throws Exception{
		
		String seq = multiRequest.getParameter("seq");
		String fileName = multiRequest.getParameter("fileName");
		String filePath = multiRequest.getParameter("filePath");
		String hide = multiRequest.getParameter("hide");
		
		String fileToPath = "D:/99_data/"+filePath+"/"+fileName;
		
		String tbNm = null;
		if("pds".equals(filePath)){
			tbNm = "WEB_BOARD_PDS";
		}else {
			tbNm = "WEB_".concat(filePath.toUpperCase());
		}
		fModel.setTbNm(tbNm);
		fModel.setFileSeq(seq);
		fModel.setHide(hide);
		
		File deleteFile = new File(fileToPath);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
			fileSevice.updateFile(fModel);
		}
		
		
		return null;
	}
}