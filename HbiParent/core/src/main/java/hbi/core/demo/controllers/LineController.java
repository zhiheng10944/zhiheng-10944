package hbi.core.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.demo.dto.OrderLine;
import hbi.core.demo.service.IOrderLineService;


@Controller
public class LineController  extends BaseController{

    @Autowired
    private IOrderLineService iOrderLineService;
    
    @RequestMapping("/line2/query")
    @ResponseBody
    public ResponseData selectList2(HttpServletRequest request, OrderLine orderLine,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<OrderLine> datas2 = iOrderLineService.selectLines(iRequest, orderLine, page, pagesize);
        return new ResponseData(datas2);
    }
    
    @RequestMapping("/line/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, OrderLine orderLine,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<OrderLine> datas = iOrderLineService.selectCondition(iRequest, orderLine, page, pagesize);
        return new ResponseData(datas);
    }
    
    @RequestMapping(value = "/line/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submitLine(@RequestBody List<OrderLine> lineList, BindingResult result, HttpServletRequest request)
            throws BaseException {
        getValidator().validate(lineList, result);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(iOrderLineService.batchUpdate(requestContext, lineList));
    }
}
