package hbi.core.demo.service.impl;

import hbi.core.demo.dto.Customer;
import hbi.core.demo.service.ICustomerService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.system.service.impl.BaseServiceImpl;

@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService {

}
