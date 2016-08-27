package hbi.core.demo.controllers;
import hbi.core.demo.dto.InventoryItem;
import hbi.core.demo.service.IInventoryItemService;

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
public class InventoryItemController  extends BaseController{

    @Autowired
    private IInventoryItemService inventoryItemService;

    @RequestMapping("/inventoryItem/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, InventoryItem condition,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<InventoryItem> datas = inventoryItemService.select(iRequest, condition, page, pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/inventoryItem/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submit(HttpServletRequest request, @RequestBody List<InventoryItem> inventoryItems) {
        IRequest iRequest = createRequestContext(request);
        List<InventoryItem> datas = inventoryItemService.batchUpdate(iRequest, inventoryItems);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/inventoryItem/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<InventoryItem> inventoryItems) {
        IRequest iRequest = createRequestContext(request);
        inventoryItemService.batchDelete(inventoryItems);
        return new ResponseData();
    }
}
