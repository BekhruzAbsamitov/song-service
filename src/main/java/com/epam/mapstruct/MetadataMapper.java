package com.epam.mapstruct;

import com.epam.dto.MetadataDto;
import com.epam.entity.Metadata;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MetadataMapper {

    MetadataMapper INSTANCE = Mappers.getMapper(MetadataMapper.class);

    Metadata toMetadata(MetadataDto metadataDto);

    MetadataDto toMetadataDto(Metadata metadata);

}
