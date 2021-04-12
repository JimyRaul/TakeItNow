package com.newhorizons.takeitnow.item.domain.repository;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;

import java.util.List;

public interface IItemRepository {
    List<ItemDto> getAll();
    ItemDto getItem(long productId, long quantity);
}
