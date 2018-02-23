package com.lemon.phoenix.util;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.lemon.phoenix.mail.Auth;
import com.sun.mail.smtp.*;
public class EmailUtil {
	private static Logger log = Logger.getLogger(EmailUtil.class);
	public static void main(String[] args) {
		File logFile = new File("E://javacode//phoenix_weblog//web.log.2018-01-16");
		File testCase = new File("src/test/resources/register.xlsx");
		List<File> files = new ArrayList<File>();
		files.add(logFile);
		files.add(testCase);
		EmailUtil.sendmessage("13517315120@163.com", "nick1234", "smtp.163.com", "25", "m13517315120@163.com","1044612871@qq.com", "测试报告", "http://localhost/html/index.html",files);

	}
	/**
	 *
	 * @param userName  发送邮箱账号  xxx@xxx.com形式
	 * @param passWord  发送邮件密码
	 * @param smtpHost  stmp服务器地址
	 * @param smtpPort  smtp服务器端口
	 * @param from      发件人地址
	 * @param tos       收件人地址
	 * @param title     标题
	 * @param content   内容
	 */
	public static void sendmessage(String userName,String passWord,String smtpHost,String smtpPort,String from,String tos ,String title,String content,List<File> fileList)
	{
		Properties smtpProper=setSmtp(smtpHost, smtpPort, userName, passWord);
		Auth authenticator=new Auth(userName, passWord);
		try {

			//创建session实例
			Session session=Session.getInstance(smtpProper, authenticator);
			MimeMessage message=new MimeMessage(session);
			session.setDebug(true);

			//设置from发件人邮箱地址
			message.setFrom(new InternetAddress(from));
			//收件人to LIST
			ArrayList<Address> toList=new ArrayList<Address>();
			//收件人字符串通过,号分隔收件人
			String[] toArray=tos.split(",");
			for (int i = 0; i < toArray.length; i++)
			{
				String str = toArray[i];
				toList.add(new InternetAddress(str));
			}
			//将收件人列表转换为收件人数组
			Address[] addresses=new Address[toList.size()];
			addresses=toList.toArray(addresses);
			//设置to收件人地址
			message.setRecipients(MimeMessage.RecipientType.TO,addresses);
			//设置邮件标题
			message.setSubject(title);
			Multipart multipart = new MimeMultipart();
			//添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(content,"text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);
			//添加附件
			if(fileList!=null&&fileList.size()>0){
				for (File file : fileList) {
					BodyPart attachmentPart = new MimeBodyPart();
					DataSource ds = new FileDataSource(file);
					attachmentPart.setDataHandler(new DataHandler(ds));
					attachmentPart.setFileName(file.getName());
					multipart.addBodyPart(attachmentPart);
				}
			}
			//设置邮件内容
			message.setContent(multipart);
			//Transport.send(message);
			Transport transport=session.getTransport();
			transport.connect(smtpHost,userName, passWord);
			//发送邮件
			transport.sendMessage(message,addresses);
			log.info("发送邮件成功！");

		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送邮件失败！");
			e.printStackTrace();
		}


	}

	private static Properties setSmtp(String smtpHost,String smtpPort,String userName,String passWord)
	{
		//创建邮件配置文件
		Properties maiProperties=new Properties();
		//配置smtp发件服务器
		maiProperties.put("mail.transport.protocol", "smtp");
		//配置smtp服务器
		maiProperties.put("mail.smtp.host", smtpHost);
		//配置smtp服务器端口
		maiProperties.put("mail.smtp.port", smtpPort);
		//配置smtp用户名
		maiProperties.put("mail.user", userName);
		//配置smtp身份验证
		maiProperties.put("mail.smtp.auth", "true");
		return maiProperties;


	}
	

}


