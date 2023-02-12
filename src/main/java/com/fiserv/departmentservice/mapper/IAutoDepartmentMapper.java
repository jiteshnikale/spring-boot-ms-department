package com.fiserv.departmentservice.mapper;

import com.fiserv.departmentservice.dto.DepartmentDto;
import com.fiserv.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAutoDepartmentMapper {

    IAutoDepartmentMapper MAPPER = Mappers.getMapper(IAutoDepartmentMapper.class);
    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
