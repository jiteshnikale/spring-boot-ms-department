package com.fiserv.departmentservice.service;

import com.fiserv.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface IDepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();
}
