package hbi.core.demo.service.impl;

import hbi.core.demo.dto.OrderHeader;
import hbi.core.demo.service.IOrderHeaderService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.system.service.impl.BaseServiceImpl;

@Service
@Transactional
public class OrderHeaderServiceImpl extends BaseServiceImpl<OrderHeader> implements IOrderHeaderService {

}
