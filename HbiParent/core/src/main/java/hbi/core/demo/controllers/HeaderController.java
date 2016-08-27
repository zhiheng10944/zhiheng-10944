package hbi.core.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.demo.dto.OrderHeader;
import hbi.core.demo.service.IOrderHeaderService;


@Controller
public class HeaderController  extends BaseController{

    @Autowired
    private IOrderHeaderService iOrderHeaderService;

    @RequestMapping("/header.do")
    @ResponseBody
    public void insterHeader(HttpServletRequest request, OrderHeader orderHeader) {
        IRequest iRequest = createRequestContext(request);
        iOrderHeaderService.insert(iRequest, orderHeader);
    }
    
    @RequestMapping("/header/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, OrderHeader orderHeader,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<OrderHeader> datas = iOrderHeaderService.select(iRequest, orderHeader, page, pagesize);
        return new ResponseData(datas);
    }
    
}
