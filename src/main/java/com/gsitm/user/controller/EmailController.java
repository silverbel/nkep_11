/**
 * @programName : EmailController.java
 * @author      : ��醫낇쁽
 * @date        : 2018-06-11
 * @function    : 硫붿씪留� �꽌鍮꾩뒪
 *
 * [�씠由�]   [�닔�젙�씪]     [�궡�슜]
 * ----------------------------------------------------------
 * ��醫낇쁽	   2018-06-11	珥덉븞
 */ 
package com.gsitm.user.controller;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsitm.common.dto.BlackListLogDTO;
import com.gsitm.user.mail.MailHandler;
import com.gsitm.user.service.BlackListService;
import com.gsitm.user.service.MemberService;


@Controller
@RequestMapping("/email/*")
public class EmailController {
	@Inject
	private JavaMailSender mailSender;
	
	@Autowired
	private BlackListService bService;
	
	@Autowired
	private MemberService mService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@RequestMapping("write.do")
	public String write() {
		return "user/contact";	//email/write.jsp濡� �룷�썙�뵫
	}
	
	@RequestMapping("/send.do")
	public String report(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
		MailHandler sendMail = new MailHandler(mailSender);
		String senderName = request.getParameter("senderName");
		String receiveMail = request.getParameter("receiveMail");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		BlackListLogDTO bList = new BlackListLogDTO();
		bList.setBlkRes(message);
		bList.setEmpId(senderName);
		bList.setBlkSeq("BK"+receiveMail);
		bService.insertBlackList(bList);
		mService.updateBlackList(senderName);
		
//		logger.info("신고 : "+senderName+"    "+ receiveMail + "  "+ subject + "  "+ message);
//		sendMail.setSubject(subject);
//		sendMail.setText(new StringBuffer().append("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"<head>\r\n" + 
//				"  <title></title>\r\n" + 
//				"</head>\r\n" + 
//				"<body sytle=\"width: 100% !important; height: 100%; background: #f8f8f8;\">\r\n" + 
//				"<table class=\"body-wrap\" style=\"width: 100% !important; height: 100%; background: #f8f8f8;\">\r\n" + 
//				"    <tr>\r\n" + 
//				"        <td class=\"container\">\r\n" + 
//				"\r\n" + 
//				"            <!-- Message start -->\r\n" + 
//				"            <table style=\"width: 580px; height: 40px; margin: 0 auto;\">\r\n" + 
//				"                <tr>\r\n" + 
//				"                    <td align=\"center\" class=\"masthead\" style=\"padding: 80px 0; background: #FF5100; color: white; \">\r\n" + 
//				"\r\n" + 
//				"                        <h1 style=\"margin: 0 auto !important; max-width: 90%\"> 신고 </h1>\r\n" + 
//				"\r\n" + 
//				"\r\n" + 
//				"                    </td>\r\n" + 
//				"                </tr>\r\n" + 
//				"                <tr>\r\n" + 
//				"                    <td class=\"content\" style=\"background: white; padding: 30px 35px;\">\r\n" + 
//				"            <img style=\"max-width: 100%; margin: 0 auto; display: block;\" src=\"https://i.imgur.com/Q0zUYOW.png\"/> <br>\r\n" + 
//				"                        <h2>신고 사유</h2>\r\n" + 
//				"\r\n" + 
//				"                        <p>"+message +"<br>.</p>\r\n" + 
//				"\r\n" + 
//				"                        <table>\r\n" + 
//				"                            <tr>\r\n" + 
//				"                                <td align=\"center\">\r\n" + 
//				"                                    <p>\r\n" + 
//				"                                        <!--<a href=\"#\" class=\"button\">�듅�씤</a> <a href=\"#\" class=\"button\">확인</a>-->\r\n" + 
//				"                                    </p>\r\n" + 
//				"                                </td>\r\n" + 
//				"                            </tr>\r\n" + 
//				"                        </table>\r\n" + 
//				"\r\n" + 
//				"                        <p>, <a href=\"https://www.gsitm.com/\">GS ITM</a>.</p>\r\n" + 
//				"\r\n" + 
//				"                        <p><em>-"+senderName +"</em></p>\r\n" + 
//				"\r\n" + 
//				"                    </td>\r\n" + 
//				"                </tr>\r\n" + 
//				"            </table>\r\n" + 
//				"\r\n" + 
//				"        </td>\r\n" + 
//				"    </tr>\r\n" + 
//				"    <tr>\r\n" + 
//				"        <td class=\"container\">\r\n" + 
//				"\r\n" + 
//				"            <!-- Message start -->\r\n" + 
//				"            <table style=\"margin: 0 auto;\">\r\n" + 
//				"                <tr>\r\n" + 
//				"                    <td class=\"content footer\" align=\"center\" style=\"padding:30px 35px\">\r\n" + 
//				"                        <p style=\"margin-bottom: 0; color: #888; text-align: center; font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;Sent by <a href=\"#\" style=\"color: #888; text-decoration: none; font-weight: bold;\">GS ITM</a>, �꽌�슱�듅蹂꾩떆 醫낅줈援� 怨꾨룞 84</p>\r\n" + 
//				"                        <p style=\"margin-bottom: 0; color: #888; text-align: center; font-size: 14px;\"><a href=\"mailto:\" style=\"color: #888; text-decoration: none; font-weight: bold;\">&nbsp;&nbsp;&nbsp;&nbsp;gsitm@gsitm.com</a> | <a href=\"#\">Unsubscribe</a></p>\r\n" + 
//				"                    </td>\r\n" + 
//				"                </tr>\r\n" + 
//				"            </table>\r\n" + 
//				"\r\n" + 
//				"        </td>\r\n" + 
//				"    </tr>\r\n" + 
//				"</table>\r\n" + 
//				"</body>\r\n" + 
//				"</html>")
//				.toString());
//		sendMail.setFrom("abc@abc.com", senderName);
//		sendMail.setTo(receiveMail);
//		sendMail.send();
		return "user/contact";
	}
	
}
