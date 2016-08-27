package hbi.core.demo.service;

import hbi.core.demo.dto.OrderHeader;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

 
public interface IOrderHeaderService extends IBaseService<OrderHeader>, ProxySelf<IOrderHeaderService> {


}
