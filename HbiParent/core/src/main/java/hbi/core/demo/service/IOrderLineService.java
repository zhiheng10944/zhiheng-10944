package hbi.core.demo.service;

import hbi.core.demo.dto.OrderLine;


import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

 
public interface IOrderLineService extends IBaseService<OrderLine>, ProxySelf<IOrderLineService> {

	List<OrderLine> selectCondition(IRequest requestContext, OrderLine orderLine, int page, int pagesize);
	
	List<OrderLine> batchUpdate(IRequest requestContext, @StdWho List<OrderLine> lineList);
	
	List<OrderLine> selectLines(IRequest requestContext, OrderLine orderLine, int page, int pagesize);
	
}
