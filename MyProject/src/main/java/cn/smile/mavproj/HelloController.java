package cn.smile.mavproj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class HelloController {
	
	@RequestMapping("/helloSmile")
	public String index() {
		return "Hello Smileeeee";
	}
}
