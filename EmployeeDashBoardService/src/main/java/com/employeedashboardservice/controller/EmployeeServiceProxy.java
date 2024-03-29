package com.employeedashboardservice.controller;

import java.util.Collection;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeedashboardservice.domain.model.Employee;

@FeignClient(name = "EmployeeSearch", url = "http://localhost:8080/")
@RibbonClient(name = "EmployeeSearch")
public interface EmployeeServiceProxy {
    @RequestMapping("/employee/find/{id}")
    public Employee findById(@PathVariable(value = "id") Long id);
    @RequestMapping("/employee/findall")
    public Collection < Employee > findAll();
}
