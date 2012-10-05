package com.rollingstone.orderprocessing.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.rollingstone.orderprocessing.exceptions.CustomerException;
import com.rollingstone.orderprocessing.model.Address;
import com.rollingstone.orderprocessing.model.Country;
import com.rollingstone.orderprocessing.model.CreditCard;
import com.rollingstone.orderprocessing.model.Customer;
import com.rollingstone.orderprocessing.model.State;
import com.rollingstone.orderprocessing.service.ICountryService;
import com.rollingstone.orderprocessing.service.ICustomerService;
import com.rollingstone.orderprocessing.service.IStateService;
import com.rollingstone.orderprocessing.web.validators.CustomerValidator;

/* Other examples
 * 
 * @Controller
 @RequestMapping("/member/*")
 public class MemberController {
 private MemberService memberService;
 @Autowired
 public MemberController(MemberService memberService) {
 this.memberService = memberService;
 }
 @RequestMapping("add")
 public String addMember(Model model) {
 model.addAttribute("member", new Member());
 model.addAttribute("guests", memberService.list());
 return "memberList";
 }

 */
@Controller
public class CustomerController {

	private ICustomerService customerService;
	private IStateService stateService;
	private ICountryService countryService;

	private CustomerValidator customerValidator;

	public CustomerValidator getCustomerValidator() {
		return customerValidator;
	}

	@Autowired
	@Required
	public void setCustomerValidator(CustomerValidator customerValidator) {
		this.customerValidator = customerValidator;
	}

	public ICountryService getCountryService() {
		return countryService;
	}

	@Autowired
	@Required
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}

	public IStateService getStateService() {
		return stateService;
	}

	@Autowired
	@Required
	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	@Required
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@ModelAttribute("states")
	public List<State> populateUSStates() {
		return stateService.getAllStates();
	}

	@ModelAttribute("phonetypes")
	public List<String> populatePhoneTypes() {
		List<String> phoneTypes = new ArrayList<String>();

		phoneTypes.add("Mobile");
		phoneTypes.add("Home");

		return phoneTypes;
	}

	@ModelAttribute("creditcardtype")
	public List<String> populateCardType() {
		List<String> cardTypes = new ArrayList<String>();

		cardTypes.add("VISA");
		cardTypes.add("Mastercard");
		cardTypes.add("AMEX");
		cardTypes.add("Discover");

		return cardTypes;

	}

	@ModelAttribute("countries")
	public List<Country> populateCountries() {
		return countryService.getAllCountries();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(
			@RequestParam(required = false, value = "username") String username,
			ModelMap model) {
		Customer customer = new Customer();
		customer.setCustomerAddress(new Address());
		customer.setDefaultCard(new CreditCard());
		model.addAttribute("customer", customer);
		return "customerForm";
	}

	@RequestMapping("/customer/add.htm")
	public String addCustomer(Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:list.htm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("reservation") Customer customer,
			BindingResult result, SessionStatus status) {
		customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			return "customerForm";
		} else {
			customerService.addCustomer(customer);
			status.setComplete();
			return "redirect:list.htm";
		}
	}

	/*
	 * @RequestMapping(value= "processUser" method = RequestMethod.POST) public
	 * String submitForm(@ModelAttribute("member") Member member, BindingResult
	 * result, Model model) { ..... }
	 */
	@RequestMapping(value = { "/customer/remove", "/customer/delete" }, method = RequestMethod.GET)
	public String removeCustomer(@RequestParam("customerId") long customerId) {
		customerService.removeCsutomer(customerId);
		return "redirect:list.htm";
	}

	@RequestMapping(value="/customer/list", method = RequestMethod.GET)
	public @ResponseBody List<Customer> listCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		//return new ModelAndView("memberList", "members", customers);
		
		return customers;
	}

	/*@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeInXML(@PathVariable String name) {
 
		Coffee coffee = new Coffee(name, 100);
 
		return coffee;
 
	}*/
 
	@RequestMapping(value = { "/customer/membersince" }, method = RequestMethod.GET)
	public String generateMembersince(
			@RequestParam(required = true, value = "date") String selectedDate,
			Model model) throws CustomerException {
		List<Customer> customers = java.util.Collections.emptyList();
		try {
			Date memberSince = new SimpleDateFormat("yyyy-MM-dd")
					.parse(selectedDate);
			customers = customerService.findByMemberSince(memberSince);
		} catch (java.text.ParseException ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			throw new CustomerException(
					"Invalid date format for reservation summary");
		}
		model.addAttribute("customers", customers);
		return "membersince";
	}

	@RequestMapping(value = { "/customer/zipcode" }, method = RequestMethod.GET)
	public String generateByZipCode(
			@RequestParam(required = true, value = "date") String zipCode,
			Model model) throws CustomerException, java.text.ParseException {
		List<Customer> customers = java.util.Collections.emptyList();
		customers = customerService.findByZipCode(Long.parseLong(zipCode));
		model.addAttribute("customers", customers);
		return "customerbyzipcode";
	}
}
