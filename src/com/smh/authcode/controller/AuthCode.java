package com.smh.authcode.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authCode")
public class AuthCode {

	@RequestMapping("/loginAuthCode.view")
	public void getLoginAuthCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		response.setHeader("Pragma", "No-chache");
		response.setHeader("Chache", "No-chache");
		response.setDateHeader("Expires", 0);
		int width = 80, height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		Font[] fonts = { new Font("宋体", Font.PLAIN, 18), new Font("黑体", Font.PLAIN, 18), new Font("幼西", Font.PLAIN, 18),
				new Font("楷体", Font.PLAIN, 18) };
		g.setFont(fonts[0]);
		Random random = new Random();
		String chs = "23456789abcdefghijkmnpqrstuvwxyz";
		String sr = "";
		for (int i = 0; i < 4; ++i) {
			int idx = random.nextInt(chs.length());
			String sre = chs.substring(idx, idx + 1);
			sr += sre;
			g.setFont(fonts[random.nextInt(fonts.length)]);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(sre, 15 * i + 6, 16);
		}
		request.getSession().setAttribute("rand", sr);
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
