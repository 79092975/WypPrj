package com.wypprj.service.impl;

import com.wypprj.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:36
 * @Description: 邮件处理实现类
 * @Version: 1.0
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    //发送邮件发件箱
    private static final String MAIL_FROM = "79092975@qq.com";

    //创建线程池，异步发送邮件
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * 发送简单文本邮件
     * @param mailTo 收件人邮箱
     * @param subject 邮件主题
     * @param text 邮件内容
     */
    @Override
    public void sendSimpleMail(String mailTo, String subject, String text) {
        executorService.submit(() -> {  //提交线程任务
            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(MAIL_FROM);
                mailMessage.setTo(mailTo);

                mailMessage.setSubject(subject);
                mailMessage.setText(text);

                javaMailSender.send(mailMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
