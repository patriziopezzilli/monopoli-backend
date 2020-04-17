package com.bee.content.backend.service;

import javax.mail.internet.AddressException;
import java.util.List;

public interface MailService {

    void sendMail(List<String> recipients, String subject, String content, String merchant) throws AddressException, Exception;

    void sendMailWithAttachment(List<String> recipients, String subject, String content, String contentAttachment, String merchant) throws AddressException, Exception;
}
