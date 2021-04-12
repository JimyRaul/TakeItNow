package com.newhorizons.takeitnow.item.domain.service;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;
import com.newhorizons.takeitnow.item.application.mainmodule.service.IItemService;
import com.newhorizons.takeitnow.item.domain.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    @Qualifier("repositoryFeign")
    private IItemRepository itemRepository;

    public List<ItemDto> getAll() {
        return itemRepository.getAll();
    }

    public ItemDto getItem(long productId, long quantity) {
        return itemRepository.getItem(productId, quantity);
    }
}
