package meta.security.controller;

import lombok.RequiredArgsConstructor;
import meta.security.entity.Role;
import meta.security.entity.User;
import meta.security.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class IndexController {

	private final BCryptPasswordEncoder passwordEncoder;

	private final UserRepository userRepository;

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
		System.out.println("login");
		return "loginForm";
	}

	@PostMapping("join")
	//Entity를 그대로 받는 것은 좋지 않지만 예제이므로 그냥 진행
	public String join(User user) {
		user.setRole(Role.ROLE_USER);
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return "redirect:/login";
	}

	@GetMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
}
