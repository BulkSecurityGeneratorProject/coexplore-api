package com.coexplore.api.service.mapper;

import com.coexplore.api.domain.*;
import com.coexplore.api.service.dto.WardDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Ward and its DTO WardDTO.
 */
@Mapper(componentModel = "spring", uses = {DistrictMapper.class})
public interface WardMapper extends EntityMapper<WardDTO, Ward> {

    @Mapping(source = "district.id", target = "districtId")
    WardDTO toDto(Ward ward);

    @Mapping(source = "districtId", target = "district")
    Ward toEntity(WardDTO wardDTO);

    default Ward fromId(Long id) {
        if (id == null) {
            return null;
        }
        Ward ward = new Ward();
        ward.setId(id);
        return ward;
    }
}
