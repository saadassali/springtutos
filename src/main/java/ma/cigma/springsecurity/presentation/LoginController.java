package ma.cigma.springsecurity.presentation;

import java.lang.reflect.Method;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ma.cigma.springsecurity.aop.Author;
import ma.cigma.springsecurity.aop.Tracabilite;

@Controller
@Author(name = "ALAMI", date = "12-10-2020")
public class LoginController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	@Author(name = "FOULANE", date = "13-09-1999")
	@Tracabilite
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@Tracabilite
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userLogIn", auth.getName());
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@Tracabilite
	public ModelAndView methodForAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("adminMessage", "Content Available Only for Admins with ADMIN Role");
		modelAndView.setViewName("/admin/admin");
		return modelAndView;
	}

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public ModelAndView methodForClient() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("clientMessage", "Content Available Only for Clients with CLIENT Role");
		modelAndView.setViewName("client/client");
		return modelAndView;
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessdenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}
	
	@Author(name = "FOULANE", date = "13-09-1999")
	public ModelAndView login2(String m,Double a) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	public static void main(String[] args) {
//		Author auth = LoginController.class.getAnnotation(Author.class);
//		System.out.println(
//				"La classeLoginController a été développé par " + auth.name() + " à la date de :" + auth.date());
		
	try {
		Method m=LoginController.class.getMethod("login2",String.class,Double.class);
		Author a=m.getAnnotation(Author.class);
		System.out.println("la méthode "+ m.getName() + " a été développé par " + a.name());
		
		
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
		
		

	}

}