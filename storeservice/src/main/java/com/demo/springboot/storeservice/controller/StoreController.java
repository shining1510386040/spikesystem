package com.demo.springboot.storeservice.controller;

import com.demo.springboot.storeservice.entity.TicketStore;
import com.demo.springboot.storeservice.service.StoreService;
import com.demo.springboot.storeservice.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 库存controller
 * @date 2021/4/20 18:44
 * @see
 */
@RestController
@RequestMapping("/store")
public class StoreController {


    @Autowired
    private StoreService storeService;


    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 保存库存
     * @date 2021/4/20 18:57
     */
    @PostMapping("/save")
    public ServiceResult saveStore(TicketStore store) {
        return storeService.saveStore(store);
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 扣减库存
     * @date 2021/4/21 15:54
     */
    @PostMapping("/decrease")
    public ServiceResult decreaseStore(TicketStore store, String productId, Integer num) {
        return storeService.decreaseStore(store, productId, num);
    }


    // todo ..

    @GetMapping("/echo")
    public String echo(HttpServletRequest request) {

        return "======>>>>此服务端口：9901";
    }


}
