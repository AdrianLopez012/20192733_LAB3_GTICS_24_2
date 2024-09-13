package com.example.lab3_20192733.controller;

import com.example.lab3_20192733.entitiy.Employee;
import com.example.lab3_20192733.entitiy.Job;
import com.example.lab3_20192733.entitiy.JobHistory;
import com.example.lab3_20192733.repository.EmployeeRepository;
import com.example.lab3_20192733.repository.JobHistoryRepository;
import com.example.lab3_20192733.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final JobHistoryRepository jobHistoryRepository;
    public EmployeeController(EmployeeRepository employeeRepository, JobRepository jobRepository, JobHistoryRepository jobHistoryRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.jobHistoryRepository = jobHistoryRepository;
    }

    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("employeeList", lista);
        return "empleados";
    }

    @GetMapping({"jobHistoryList/list", "jobHistory"})
    public String listarHistorialTrabajo(Model model) {
        List<JobHistory> lista = jobHistoryRepository.findAll();
        model.addAttribute("jobhistorylist", lista);
        return "historial";
    }
    @GetMapping("employee/info/{id}")
    public String informEmpleado(@PathVariable("id") Integer employeeId, Model model) {
        Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
        if(optEmployee.isPresent()){
            Employee employee = optEmployee.get();
            model.addAttribute("employee",employee);
            model.addAttribute("selectedJobId", employee.getJob().getJob_id());

        }
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs",jobs);
        return "edit_employee";
    }
    @GetMapping("/delete")
    public String borrarEmpleado(Model model, @RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            if (employee.getEnabled() != 0) {
                try {
                    employee.setEnabled(0);
                    employeeRepository.save(employee);
                    redirectAttributes.addFlashAttribute("exito", "El empleado ha sido deshabilitado correctamente.");
                } catch (Exception e) {
                    redirectAttributes.addFlashAttribute("error", "No se pudo deshabilitar el empleado.");
                }
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Empleado no encontrado.");
        }
        return "redirect:/employee/list";
    }


}