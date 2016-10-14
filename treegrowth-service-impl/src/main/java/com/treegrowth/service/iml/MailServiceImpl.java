package com.treegrowth.service.iml;

import com.treegrowth.model.entity.User;
import com.treegrowth.service.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;

@Service
public class MailServiceImpl implements MailService {

    @Autowired JavaMailSenderImpl javaMailSender;
    @Autowired Template template;

    @Override
    public void send(User user) {

        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom("Tree");
            messageHelper.setSubject("Tree_Growth");
            messageHelper.setText(textFromDateModel(user), true);
            messageHelper.setTo(user.getEmail());
        };
        javaMailSender.send(mimeMessagePreparator);
    }

    private String textFromDateModel(Object dataModel) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        template.process(dataModel, stringWriter);
        return stringWriter.toString();
    }
}
