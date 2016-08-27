package hbi.core.demo.controllers;
import hbi.core.demo.dto.Company;
import hbi.core.demo.service.ICompanyService;

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


@Controller
public class CompanyController  extends BaseController{

    @Autowired
    private ICompanyService companyService;

    @RequestMapping("/company/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, Company condition,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<Company> datas = companyService.select(iRequest, condition, page, pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/company/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submit(HttpServletRequest request, @RequestBody List<Company> companys) {
        IRequest iRequest = createRequestContext(request);
        List<Company> datas = companyService.batchUpdate(iRequest, companys);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/company/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Company> companys) {
        IRequest iRequest = createRequestContext(request);
        companyService.batchDelete(companys);
        return new ResponseData();
    }
}
