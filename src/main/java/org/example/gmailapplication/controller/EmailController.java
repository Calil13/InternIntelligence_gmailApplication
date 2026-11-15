package org.example.gmailapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.gmailapplication.dto.EmailDraftRequest;
import org.example.gmailapplication.dto.EmailResponseDto;
import org.example.gmailapplication.dto.EmailSendRequest;
import org.example.gmailapplication.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailSendRequest request) {
        return emailService.sendEmail(request);
    }

    @PostMapping("/draft")
    public String saveDraft(@RequestBody EmailDraftRequest request) {
        return emailService.saveDraft(request);
    }

    @GetMapping("/message/{emailId}")
    public EmailResponseDto getEmailMessage(@PathVariable Long emailId) {
        return emailService.getEmailMessage(emailId);
    }
}
