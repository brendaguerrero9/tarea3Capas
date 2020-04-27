package com.uca.capas.nCapasTarea3.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/register")
	public String home() {
		return "app/register";
	}
	
	@RequestMapping("/validate")
	public ModelAndView validar(HttpServletRequest request) throws ParseException {
		String m1,m2,m3,m4,m5,m6,m7; //Mensajes de error
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String dateB = request.getParameter("dateB");
		String place = request.getParameter("placeB");
		String placeS = request.getParameter("school");
		String tel = request.getParameter("tel");
		String cel = request.getParameter("cel");		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = format.parse(dateB);
		Date date2 = format.parse("2003-01-01");
		
		if((name.length() >= 1 && name.length() <= 25) && (lastname.length() >= 1 && lastname.length() <= 25) && (date.before(date2) == false) && (place.length() >= 1 && place.length() <= 25) && (placeS.length() >= 1 && placeS.length() <= 100) && tel.length() == 8 && cel.length() == 8 ) 
		{
			mav.setViewName("app/good");
		}else {
			m1 = "La cantidad de caracteres no es correcta";	
			m2 = "La cantidad de caracteres no es correcta";
			m3 = "La cantidad de caracteres no es correcta";
			m4 = "La cantidad de caracteres no es correcta";
			m5 = "La cantidad de caracteres no es correcta";
			m6 = "La cantidad de caracteres no es correcta";
			m7 = "La cantidad de caracteres no es correcta";
			mav.addObject("m1", m1);
			mav.addObject("m2", m2);
			mav.addObject("m3", m3);
			mav.addObject("m4", m4);
			mav.addObject("m5", m5);
			mav.addObject("m6", m6);
			mav.addObject("m7", m7);
			mav.setViewName("app/error");			
		 }
		return mav;
	}
}
