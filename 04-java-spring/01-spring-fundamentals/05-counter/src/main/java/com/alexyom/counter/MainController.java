package com.alexyom.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private int getSessionCount(HttpSession sesh) {
		Object seshCount = sesh.getAttribute("count");
		if (seshCount == null) {
			getSessionCount(sesh, 0);
			seshCount = sesh.getAttribute("count");
		}
		return (Integer)seshCount;
	}
	private void getSessionCount(HttpSession sesh, int val) {
		sesh.setAttribute("count", val);
	}
	@RequestMapping("/")
	public String Add(@PathVariable("times") String times, HttpSession s) {
		int t = 1;
		try {
			t = Integer.parseInt(times);
		}
		catch(NumberFormatException e) {
			System.out.println(String.format("Exception thrown %s", e.getMessage()));
			return "redirect:/";
		}
		int currentCount = getSessionCount(s);
		currentCount += t;
		getSessionCount(s, currentCount);
		return "index.jsp";
	}
	@RequestMapping("/reset")
	public String Reset(HttpSession s) {
		s.invalidate();
		return "redirect:/counter";
	}
	@RequestMapping("/counter")
	public String Counter(HttpSession s, Model model) {
		model.addAttribute("count", getSessionCount(s));
		return "count.jsp";
	}
}
