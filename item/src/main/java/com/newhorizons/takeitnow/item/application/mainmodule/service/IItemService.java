package com.newhorizons.takeitnow.item.application.mainmodule.service;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;
import com.newhorizons.takeitnow.item.domain.entity.Item;

import java.util.List;

public interface IItemService {
    List<ItemDto> getAll();
    ItemDto getItem(long productId, long quantity);
}
