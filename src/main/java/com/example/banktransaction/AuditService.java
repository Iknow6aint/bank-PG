package com.example.banktransaction.service;

import com.example.banktransaction.entity.AuditLog;
import com.example.banktransaction.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditLogRepository auditLogRepository;

    public void saveAuditLog(AuditLog auditLog) {
        auditLogRepository.save(auditLog);
    }
}
