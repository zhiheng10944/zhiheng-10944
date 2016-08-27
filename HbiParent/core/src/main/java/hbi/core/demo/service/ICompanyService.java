package hbi.core.demo.service;

import hbi.core.demo.dto.Company;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

 
public interface ICompanyService extends IBaseService<Company>, ProxySelf<ICompanyService> {


}
