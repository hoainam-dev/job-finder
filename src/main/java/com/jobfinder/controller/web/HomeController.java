package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.repository.UserRepository;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IUserService;
import com.jobfinder.service.impl.UserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private IJobService jobService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<JobDTO> jobs = jobService.findAll();
		List<CategoryDTO> categories = categoryService.findAll();
		List<UserDTO> users = userService.findAll();

		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("jobs", jobs);
		mav.addObject("categories", categories);
		mav.addObject("users", users);

		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("keyword") String keyword, Model model) {
		List<JobDTO> jobs = jobService.findByTitle(keyword);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/home";
	}

	@RequestMapping(value = "/trang-chu/thong-tin-ca-nhan", method = RequestMethod.GET)
	public String showEditForm(@RequestParam(value = "id") Long id, Model model) {
		UserDTO user = userService.findById(id);
		model.addAttribute("user", user);
		return "web/user-profile";
	}

	@RequestMapping(value = "/trang-chu/thong-tin-ca-nhan", method = RequestMethod.POST)
	public String updateUser(@RequestParam(value = "id") Long userId, UserDTO userDTO
			, RedirectAttributes redirectAttributes) {
		userService.save(userDTO);
		redirectAttributes.addFlashAttribute("message", "Đổi thông tin thành công");//truyen message thanh cong toi trang dang nhap
		redirectAttributes.addFlashAttribute("alert", "success");//truyen type message toi trang dang nhap
		return "redirect:/trang-chu/thong-tin-ca-nhan?id=" + userId;
	}
}
