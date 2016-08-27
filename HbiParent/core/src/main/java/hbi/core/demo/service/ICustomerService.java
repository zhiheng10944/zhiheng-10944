package hbi.core.demo.service;

import hbi.core.demo.dto.Customer;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

 
public interface ICustomerService extends IBaseService<Customer>, ProxySelf<ICustomerService> {


}
