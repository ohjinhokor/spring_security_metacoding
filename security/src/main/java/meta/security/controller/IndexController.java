package meta.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("user")
	public String user() {
		return "user";
	}

	@GetMapping("admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("manager")
	public String manager() {
		return "manager";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("join")
	public String join() {
		return "join";
	}

	@GetMapping("joinProc")
	@ResponseBody
	public String joinProc() {
		return "join Success";
	}
}
