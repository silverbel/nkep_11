package com.gsitm.user.mail;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class SimpleRegistrationNotifier {

   @Autowired
   private VelocityEngine ve;
   
   @Autowired
   private JavaMailSender autoMailSender;
   
   public void sendMail(String email, int mgrNo, String empNm, String partyNm, String resDateToString, String startDateToString, String endDateToString) {
      try {
            MimeMessage message = autoMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            
            messageHelper.setSubject("회의실 승인 관련 안내입니다.");   //제목
            messageHelper.setFrom("stackover92@gmail.com","회의실관리자");   //보내는사람
            messageHelper.setTo(email);   //받는사람
            System.out.println("여기까지도 됨 심플레지스텀 ㅣㅏ험ㄷ기ㅏㅓㄹㄷㅁㄱㄹ");
            Map model = new HashMap<String, String>();
            model.put("mgrNo", mgrNo);
            model.put("mreDate", empNm);
            model.put("partyNm", partyNm);
            model.put("resDateToString", resDateToString);
            model.put("startDateToString", startDateToString);
            model.put("endDateToString", endDateToString);
            System.out.println("model: " + model);
            String text = VelocityEngineUtils.mergeTemplateIntoString(
                  ve, "com/gsitm/user/mail/mailForm_default.vm", "UTF-8", model);
            System.out.println("메일갔을껄..");
            messageHelper.setText(text, true);   
            autoMailSender.send(message);
            
         } catch (Exception ex) {
            ex.printStackTrace();
         }
   }
}