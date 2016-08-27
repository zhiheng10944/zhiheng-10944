package hbi.core.demo.service;

import hbi.core.demo.dto.InventoryItem;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

 
public interface IInventoryItemService extends IBaseService<InventoryItem>, ProxySelf<IInventoryItemService> {


}
