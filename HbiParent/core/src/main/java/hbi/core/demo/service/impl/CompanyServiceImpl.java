package hbi.core.demo.service.impl;

import hbi.core.demo.dto.Company;
import hbi.core.demo.service.ICompanyService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.system.service.impl.BaseServiceImpl;

@Service
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements ICompanyService {

}
