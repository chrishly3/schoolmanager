package com.schoolmanager.controller;

import com.github.pagehelper.PageInfo;
import com.schoolmanager.entity.QueryOrder;
import com.schoolmanager.entity.SchoolRepair;
import com.schoolmanager.entity.SchoolUserinfo;
import com.schoolmanager.service.SchoolOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.HttpCode.R;

import java.util.List;

@RequestMapping("/order")
@RestController
@CrossOrigin
public class SchoolOrderController {

    @Autowired
    private SchoolOrderService orderService;
    private final Logger logger = LoggerFactory.getLogger(SchoolUserInfoController.class);

    /**
     * 根据id查询维修单
     * @param id
     * @return
     */
    @GetMapping("getOrder/{id}")
    public R getOrder(@PathVariable String id) {
        SchoolRepair order = orderService.getOrderById(id);
        return R.ok().data("order",order);
    }
    /**
     * 编辑维修单
     * @param id
     * @param schoolRepair
     * @return
     */
    @PostMapping("updateOrder/{id}")
    public R editOrder(@PathVariable String id,@RequestBody SchoolRepair schoolRepair){

        int row=orderService.editOrder(schoolRepair);
        if(row==1){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 删除报修单
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
        Integer delete= orderService.removeById(id);
        System.out.println(delete);
        if(delete.equals(1)){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 带条件分页查询
     * @param queryOrder
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("moreCondtionPageList/{page}/{pageSize}")
    public  R showOrders(@PathVariable Integer page, @PathVariable Integer pageSize,
                        @RequestBody(required = false) QueryOrder queryOrder){
        PageInfo<SchoolRepair> pageList = orderService.showOrders(page, pageSize);
        String repairUserName = queryOrder.getRepairUserName();
        System.out.println(repairUserName);
        String repairType = queryOrder.getRepairType();
        if(repairUserName != null || repairType != null) {
            pageList = orderService.selectOrderLike("%"+repairUserName+"%",page, pageSize,"%"+repairType+"%");
        }
        System.out.println(pageList);
        return R.ok().data("items",pageList);
    }

    /**
     * 查询所有报修单（测试）
     * @return
     */
    @GetMapping("/list")
    public R getAllOrderList() {
        //调用service的方法
        List<SchoolRepair> list = orderService.listOrder();
        return R.ok().data("items",list);
    }

    /**
     * 添加维修单的方法
     * @param schoolRepair
     * @return 是否添加成功
     */
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public R addSchoolRepair(@RequestBody SchoolRepair schoolRepair) {
        System.err.println(schoolRepair.getRepairUserName());
        System.err.println(schoolRepair.getRepairType());
        logger.info("SchoolUserInfoController-addSchoolRepair-schoolRepair",schoolRepair.getRepairUserName());
        int save = orderService.saveOrder(schoolRepair);
        if(save==1) {
            return R.ok();
        } else {
            return R.error();
        }
    }


}
