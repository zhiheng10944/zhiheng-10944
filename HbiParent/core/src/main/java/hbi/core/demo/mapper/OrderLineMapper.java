package hbi.core.demo.mapper;

import hbi.core.demo.dto.OrderLine;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

 

public interface OrderLineMapper extends Mapper<OrderLine> {
	List<OrderLine> selectByCondition(OrderLine orderLine);
	
	List<OrderLine> selectLine(OrderLine orderLine);
	
	int insertLine(OrderLine orderLine);

    void updateLine(OrderLine orderLine);
    
    Long countLine();

}
