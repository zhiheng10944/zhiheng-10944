package hbi.core.demo.service.impl;

import hbi.core.demo.dto.OrderLine;
import hbi.core.demo.mapper.OrderLineMapper;
import hbi.core.demo.service.IOrderLineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

@Service
@Transactional
public class OrderLineServiceImpl extends BaseServiceImpl<OrderLine> implements IOrderLineService {
	@Autowired
	private OrderLineMapper orderLineMapper; 
	@Override
	public List<OrderLine> selectCondition(IRequest requestContext, OrderLine orderLine, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return orderLineMapper.selectByCondition(orderLine);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderLine> batchUpdate(IRequest requestContext, List<OrderLine> lineList) {
        for (OrderLine orderLine : lineList) {
            if (orderLine.get__status() != null) {
                switch (orderLine.get__status()) {
                case DTOStatus.ADD:
                	orderLine.setLineId(orderLineMapper.countLine()+1);
                	orderLine.setLineNumber(orderLineMapper.countLine()+1);
                	orderLineMapper.insertLine(orderLine);
                    break;
                case DTOStatus.UPDATE:
                	orderLineMapper.updateLine(orderLine);
                    break;
                case DTOStatus.DELETE:
                    self().deleteByPrimaryKey(orderLine);
                    break;
                default:
                    break;
                }
            }
        }
        return lineList;
    }

	@Override
	public List<OrderLine> selectLines(IRequest requestContext, OrderLine orderLine, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return orderLineMapper.selectLine(orderLine);
	}

}
