package hbi.core.demo.service.impl;

import hbi.core.demo.dto.InventoryItem;
import hbi.core.demo.service.IInventoryItemService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.system.service.impl.BaseServiceImpl;

@Service
@Transactional
public class InventoryServiceImpl extends BaseServiceImpl<InventoryItem> implements IInventoryItemService {

}
