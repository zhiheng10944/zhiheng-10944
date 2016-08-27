package hbi.core.demo.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.demo.dto.Customer;
import hbi.core.demo.service.ICustomerService;


@Controller
public class CustomerController  extends BaseController{

    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping("/customer/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, Customer customer,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<Customer> datas = iCustomerService.select(iRequest, customer, page, pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/customer/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submit(HttpServletRequest request, @RequestBody List<Customer> customer) {
        IRequest iRequest = createRequestContext(request);
        List<Customer> datas = iCustomerService.batchUpdate(iRequest, customer);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Customer> Customer) {
        IRequest iRequest = createRequestContext(request);
        iCustomerService.batchDelete(Customer);
        return new ResponseData();
    }
}
