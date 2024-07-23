package com.events.api.domain.events;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record EventRequestDTO(String title, String description, Long date, String city, String uf, Boolean remote, String event_url, MultipartFile image) {
}
