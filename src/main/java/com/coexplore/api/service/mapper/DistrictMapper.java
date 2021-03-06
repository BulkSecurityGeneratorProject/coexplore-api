package com.coexplore.api.service.mapper;

import com.coexplore.api.domain.*;
import com.coexplore.api.service.dto.DistrictDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity District and its DTO DistrictDTO.
 */
@Mapper(componentModel = "spring", uses = {ProvinceMapper.class})
public interface DistrictMapper extends EntityMapper<DistrictDTO, District> {

    @Mapping(source = "province.id", target = "provinceId")
    DistrictDTO toDto(District district);

    @Mapping(source = "provinceId", target = "province")
    District toEntity(DistrictDTO districtDTO);

    default District fromId(Long id) {
        if (id == null) {
            return null;
        }
        District district = new District();
        district.setId(id);
        return district;
    }
}
