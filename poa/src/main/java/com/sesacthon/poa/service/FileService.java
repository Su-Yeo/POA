package com.sesacthon.poa.service;

import com.sesacthon.poa.common.S3Uploader;
import com.sesacthon.poa.domain.FileEntity;
import com.sesacthon.poa.dto.FileDto;
import com.sesacthon.poa.dto.mapper.FileMapper;
import com.sesacthon.poa.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {
    private final FileRepository fileRepository; // JPA
    private final FileMapper fileMapper; // DTO로 변환
    private final S3Uploader s3Uploader;

    /**
     * file_id로 파일 조회
     * @param file_id
     * @return FileDto
     */
    public FileDto findFile(Integer file_id){
        return fileMapper.toDto(fileRepository.findById(file_id).orElse(null));
    }

    /**
     * 파일 여러개 저장
     * @param imgFiles
     * @return FileDto
     */
    public FileDto saveFiles(List<MultipartFile> imgFiles) {
        FileDto fileDto = new FileDto();
        JSONObject jsonName = new JSONObject();
        JSONObject jsonUrl = new JSONObject();
        JSONObject jsonPath = new JSONObject();
        JSONArray name = new JSONArray();
        JSONArray url = new JSONArray();
        JSONArray path = new JSONArray();

        for (MultipartFile imgFile : imgFiles) {
            if(fileUpload(imgFile)){
                name.add(imgFile.getOriginalFilename());
                url.add("api/img/"+imgFile.getOriginalFilename());
                path.add("C:\\img/"+imgFile.getOriginalFilename());
            }
        }

        jsonName.put("name", name);
        jsonUrl.put("url", url);
        jsonPath.put("path", path);
        fileDto.setFile_name(jsonName.toJSONString());
        fileDto.setFile_url(jsonUrl.toJSONString());
        fileDto.setFile_path(jsonPath.toJSONString());
        FileEntity fileEntity = fileMapper.toEntity(fileDto);
        return fileMapper.toDto(fileRepository.save(fileEntity));
    }

    /**
     * 파일 1개 저장
     * @param imgFile
     * @return
     */
    public FileDto saveFile(MultipartFile imgFile) {
//        if(!fileUpload(imgFile)) return null;
//        FileDto fileDto = new FileDto();
//        fileDto.setFile_name(imgFile.getOriginalFilename());
//        fileDto.setFile_url("api/img/"+imgFile.getOriginalFilename());
//        fileDto.setFile_path("C:\\img/"+imgFile.getOriginalFilename());
//        FileEntity fileEntity = fileMapper.toEntity(fileDto);
//        return fileMapper.toDto(fileRepository.save(fileEntity));
        return s3Upload(imgFile);
    }

    /**
     * 실제 파일 저장
     * @param imgFile
     * @return boolean
     */
    public boolean fileUpload(MultipartFile imgFile) {
        try {
            imgFile.transferTo(new File(imgFile.getOriginalFilename()));
        } catch (IOException e) {
            log.error("파일 업로드 오류 : {}", e.getMessage());
            return false;
        }
        return true;
    }

    public FileDto s3Upload(MultipartFile imgFile) {
        String storedFileName = null;
        if(!imgFile.isEmpty()) {
            try {
                storedFileName = s3Uploader.upload(imgFile,"images");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileDto fileDto = new FileDto();
        fileDto.setFile_name(imgFile.getOriginalFilename());
        fileDto.setFile_url(storedFileName);
        fileDto.setFile_path("images/"+imgFile.getOriginalFilename());
        FileEntity fileEntity = fileMapper.toEntity(fileDto);
        return fileMapper.toDto(fileRepository.save(fileEntity));
    }
}
