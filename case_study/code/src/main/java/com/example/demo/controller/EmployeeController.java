package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.*;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IDivisionService;
import com.example.demo.service.IEducationDegreeService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IPositionService;
import com.example.demo.ulti.EncrypPasswordUtils;
import com.example.demo.ulti.validator.EmployeeValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private EmployeeValidate employeeValidate;

    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.findAll();
    }
    @ModelAttribute("divisions")
    public List<Division> divisions() {
        return divisionService.findAll();
    }
    @ModelAttribute("educationDegrees")
    public List<EducationDegree> educationDegrees() {
        return educationDegreeService.findAll();
    }

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 3) @SortDefault(sort = "salary", direction = Sort.Direction.DESC)Pageable pageable){
        return new ModelAndView("/employee/list","employees",employeeService.findAll(pageable));

    }
    @GetMapping("/create-employee")
    public ModelAndView create() {
        return new ModelAndView("employee/create", "employee", new Employee());
    }

    @PostMapping("/create-employee")
    public ModelAndView createPost(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult
            , @PageableDefault(value = 3) Pageable pageable) {
        employeeValidate.validate(employee, bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/employee/create","employee",employee);
        }

        User user = new User();
        user.setEmail(employee.getEmail());
        user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userRepository.save(user);
        User user1=userRepository.findByEmail(employee.getEmail());
        employee.setUser(user1);
        employeeService.save(employee);
        return new ModelAndView("/employee/list","employees", employeeService.findAll(pageable) );

    }
    @GetMapping("/edit-employee/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ModelAndView("customer/404");
        }
        return new ModelAndView("employee/edit", "employee", employee);
    }

    @PostMapping("/edit-employee")
    public ModelAndView editPost(@ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                           @PageableDefault(value = 3) Pageable pageable) {
        employeeValidate.validate(employee, bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/employee/edit","employee",employee);
        }
        employeeService.save(employee);
        return new ModelAndView("/employee/list","employees", employeeService.findAll(pageable) );
    }
    @GetMapping("/delete-employee/{id}")
    public String delete(@PathVariable Integer id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("/detail-employee/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ModelAndView("customer/404");
        }
        return new ModelAndView("employee/detail", "employee", employee);
    }
}
