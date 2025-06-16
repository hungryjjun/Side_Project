package kr.or.ddit.file.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.dao.FileMapper;
import kr.or.ddit.file.vo.FileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FileserviceImpl implements FileService {

	@Autowired
	private FileMapper mapper;
	private final Path uploadDir = Paths.get("/upload/notice");//절대경로
	
	@Override
	public List<FileVO> getFiles(Long noticeId) {
		return mapper.selectByAllId(noticeId);
	}
	
	@Override
	public FileVO selectedFile(Long fileId) {
		return mapper.selectById(fileId);
	}
	
	@Override
	public List<FileVO> saveFiles(Long noticeId, List<MultipartFile> files) throws IOException {
		List<FileVO>list = new ArrayList<>();
		
		Files.createDirectories(uploadDir); //최초1회
		log.info("files받는값++++:file서비스임플{}",files);
		
		for(MultipartFile mf : files) {
			if(mf.isEmpty())continue;
			
			String origin = mf.getOriginalFilename();
			String save = UUID.randomUUID() + "_" + origin;
			Path target = uploadDir.resolve(save);
			mf.transferTo(target);//실제 저장
			
			FileVO fileVo = new FileVO();
			fileVo.setNoticeId(noticeId);
			fileVo.setOriginName(origin);
			fileVo.setSaveName(save);
			fileVo.setPath(target.toString());
			fileVo.setFileSize(mf.getSize());
			fileVo.setMimeType(mf.getContentType());
			
			mapper.insert(fileVo);
			list.add(fileVo);
			
		}
		
		return list;
	}

	@Override
	public void deleteFiles(List<Long> fileIds) {
		if(fileIds ==null) return;
		fileIds.forEach(mapper::markDelete);//논리삭제
	}


	@Override
	public Resource getResource(FileVO meta) throws IOException {
		Path path = Paths.get(meta.getPath());
		if(!Files.exists(path))throw new FileNotFoundException("파일없음");
		return new UrlResource(path.toUri());
	}




}
