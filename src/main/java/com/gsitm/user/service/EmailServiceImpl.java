/**
 * @programName : EmailServiceImpl.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 메일링 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.user.service;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.gsitm.common.dto.EmailDTO;



@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Resource(name="mailSender")
	JavaMailSenderImpl mailSender;	// 메일 발송 객체
	
	public void sendMail(EmailDTO dto) {
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			// 메일 수신자 추가
			msg.addRecipient(RecipientType.TO, 
					new InternetAddress(dto.getReceiveMail()));
			// 메일 발신자
			msg.addFrom(new InternetAddress[] {
					new InternetAddress(dto.getSenderMail(),
					dto.getSenderName())
			});
			// 메일 제목
			msg.setSubject(dto.getSubject(), "utf-8");
			// 메일 본문
			msg.setText(dto.getMessage(), "utf-8");
			// 이메일 전송
			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}