package com.events.api.service;

import com.events.api.domain.events.Event;
import com.events.api.domain.events.EventRequestDTO;
import com.events.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(EventRequestDTO data) {
        String imgUrl = null;
        if(data.image()!=null){
            imgUrl = this.uploadImg(data.image());
        }
        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setRemote(data.remote());
        newEvent.setEventUrl(data.event_url());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImgUrl(imgUrl);


        eventRepository.save(newEvent);
        return newEvent;
    }

    private String uploadImg(MultipartFile multipartfile) {
        String fileName =  UUID.randomUUID() +"-"+ multipartfile.getOriginalFilename();
        try{
            File file  = this.convertMultipartToFile(multipartfile);
            return file.getAbsolutePath();
        }catch (Exception e){}
        return fileName;
    }

    private File convertMultipartToFile(MultipartFile multipartfile) throws IOException {

        File convFile = new File("images",Objects.requireNonNull(multipartfile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartfile.getBytes());
        fos.close();
        return convFile;
    }
}
