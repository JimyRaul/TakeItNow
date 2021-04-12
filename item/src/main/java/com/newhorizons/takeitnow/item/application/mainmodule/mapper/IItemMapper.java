package com.newhorizons.takeitnow.item.application.mainmodule.mapper;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;
import com.newhorizons.takeitnow.item.domain.entity.Item;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { IProductMapper.class})
public interface IItemMapper {
    @Mappings({
            @Mapping(source = "product", target = "product"),
            @Mapping(source = "quantity", target = "quantity")
    })
    ItemDto toItemDto(Item item);

    List<ItemDto> toItemsDto(List<Item> items);

    @InheritInverseConfiguration
    Item toItem(ItemDto itemDto);
}
