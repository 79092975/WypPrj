package com.wypprj.service;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:36
 * @Description: 邮件处理接口
 * @Version: 1.0
 */
public interface MailService {
    void sendSimpleMail(String mailTo, String subject, String text);
}
