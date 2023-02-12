package com.fiserv.departmentservice.service.impl;

import com.fiserv.departmentservice.dto.DepartmentDto;
import com.fiserv.departmentservice.entity.Department;
import com.fiserv.departmentservice.exception.ResourceNotFoundException;
import com.fiserv.departmentservice.mapper.IAutoDepartmentMapper;
import com.fiserv.departmentservice.repository.IDepartmentRepository;
import com.fiserv.departmentservice.service.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert DepartmentDto into Department JPA Entity
        Department department = IAutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        //convert Department JPA entity to DepartmentDto
        DepartmentDto savedDepartmentDto = IAutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(
                        () -> new ResourceNotFoundException
                                (String.format("Department not found for department code: %s", departmentCode)));

        return IAutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException
                                (String.format("Department not found for department id: %s", departmentId)));

        return IAutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return null;
    }
}
