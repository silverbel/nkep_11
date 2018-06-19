package com.gsitm.user.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.gsitm.user.service.EmailService;


@Controller
public class EmailResvController {

	@Resource(name = "emailService")
	private EmailService emailService;

	private static final Logger logger = LoggerFactory.getLogger(EmailResvController.class);
	private static RestTemplate restTemplate = new RestTemplate();

	@Autowired(required=false)
	private JavaMailSender mailSender;

	@RequestMapping(value = "/sendReport.do")
	public String mailAboutResult(HttpServletRequest request) {

		String senderName = "eun";
		String senderMail = "senderMail";
		String subject = "report";
		String message = "This is report.";
/*		String setfrom = "蹂대궡�뒗 �궗�엺";
//		String tomail = request.getParameter("tomail"); // 諛쏅뒗 �궗�엺 �씠硫붿씪
		String title="�젣紐�";
		String tomail = " 諛쏅뒗 �궗�엺 �씠硫붿씪"; // 諛쏅뒗 �궗�엺 �씠硫붿씪
		String address = request.getParameter("address");
		String numberOfPerson= request.getParameter("numberOfPerson");
		String building= request.getParameter("building");
		String time= request.getParameter("time");
		String timeSelect= request.getParameter("timeSelect");
		String roomType= request.getParameter("roomType");
		String beam= request.getParameter("beam");
		String beamSelect= request.getParameter("beamSelect");
		String date= request.getParameter("date");
		String notebook= request.getParameter("notebook");
		String notebookSelect= request.getParameter("notebookSelect");
		

		System.out.println("content : "+title+address+numberOfPerson+building+time+timeSelect+roomType+beam+beamSelect+date+notebook+notebookSelect);

		Enumeration<?> params=request.getParameterNames();
		Map<String,String> paramMap=new HashMap<String, String>();
		String content="";
		
		while(params.hasMoreElements()) {
			String name=params.nextElement().toString();
			String value=request.getParameter(name);
			
			paramMap.put(name, value);
			
			content+=name+" : "+value+"<br/>";
			
			
		}*/
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"  <title></title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<table class=\"body-wrap\" style=\"width: 100% !important; height: 100%; background: #f8f8f8;\">\r\n" + 
				"    <tr>\r\n" + 
				"        <td class=\"container\">\r\n" + 
				"            <!-- Message start -->\r\n" + 
				"            <table style=\"width: 580px; height: 40px; margin: 0 auto;\">\r\n" + 
				"                <tr>\r\n" + 
				"                    <td align=\"center\" class=\"masthead\" style=\"padding: 80px 0; background: #3DB7CC; color: white; \">\r\n" + 
				"                        <h1 style=\"margin: 0 auto !important; max-width: 90%\"> 신고가 접수 되었습니다. </h1>\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"                <tr>\r\n" + 
				"                    <td class=\"content\" style=\"background: white; padding: 30px 35px;\">\r\n" + 
				"            <img style=\"max-width: 100%; margin: 0 auto; display: block;\" src=\"https://i.imgur.com/Q0zUYOW.png\"/> <br>\r\n" + 
				"                        <h2>11조 분들께,</h2>\r\n" + 
				"                        <p>11조팀, 인원수 3명이 삼환빌딩 1번 회의실 예약 반려되었습니다. 반려사유는 아래와 같습니다. 수신인분들이 예약하신 해당일에 공사가 진행으로 인하여 반려되었습니다. <br>감사합니다.</p>\r\n" + 
				"                        <table>\r\n" + 
				"                            <tr>\r\n" + 
				"                                <td align=\"center\">\r\n" + 
				"                                    <p>\r\n" + 
				"                                        <!--<a href=\"#\" class=\"button\">승인</a> <a href=\"#\" class=\"button\">반려</a>-->\r\n" + 
				"                                    </p>\r\n" + 
				"                                </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                        </table>\r\n" + 
				"                        <p>문의사항이 문의는, <a href=\"https://www.gsitm.com/\">GS ITM</a>에 방문해 주십시오.</p>\r\n" + 
				"                        <p><em>– GS ITM 시스템 관리자</em></p>\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"            </table>\r\n" + 
				"        </td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"        <td class=\"container\">\r\n" + 
				"            <!-- Message start -->\r\n" + 
				"            <table style=\"margin: 0 auto;\">\r\n" + 
				"                <tr>\r\n" + 
				"                    <td class=\"content footer\" align=\"center\">\r\n" + 
				"                        <p>Sent by <a href=\"#\">GS ITM</a>, 서울특별시 종로구 계동 84</p>\r\n" + 
				"                        <p><a href=\"mailto:\">gsitm@gsitm.com</a> | <a href=\"#\">Unsubscribe</a></p>\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"            </table>\r\n" + 
				"        </td>\r\n" + 
				"    </tr>\r\n" + 
				"</table>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"");



		
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");

			/*messageHelper.setFrom(setfrom); // 蹂대궡�뒗�궗�엺 �깮�왂�븯嫄곕굹 �븯硫� �젙�긽�옉�룞�쓣 �븞�븿
			messageHelper.setTo(tomail); // 諛쏅뒗�궗�엺 �씠硫붿씪
			messageHelper.setSubject(title);*/
			messageHelper.setText(sb.toString(),true); // 硫붿씪 �궡�슜

			mailSender.send(msg);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:/email/write.do";
	}
	
/*	@RequestMapping(value = "/mailRequest.do", method = RequestMethod.GET)
	public String moviemain(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
			Model model,  MovieVO movieVO) throws Exception {

		movieVO.setStartDate(request.getParameter("startDate"));
		movieVO.setEndDate(request.getParameter("endDate"));

		model.addAttribute("mailVO", mailVO);

		return "/mail/mail";
	}*/
}
