package com.example.api.mapper;

import com.example.core.kafka.dto.KafkaShelterDTO;
import com.example.api.model.ShelterModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KafkaShelterDTOMapper {
    KafkaShelterDTOMapper INSTANCE = Mappers.getMapper(KafkaShelterDTOMapper.class);

    KafkaShelterDTO toKafkaShelterDTO(ShelterModel shelterModel);
}
