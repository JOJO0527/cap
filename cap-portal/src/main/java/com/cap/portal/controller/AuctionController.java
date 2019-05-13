package com.cap.portal.controller;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.RecordException;
import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapUser;
import com.cap.portal.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *  竞标Controller
 */
@Controller
@RequestMapping("/auction/{itemId}")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;
    @RequestMapping("/saveAuctionRecord")
    public TaotaoResult saveAuctionRecord(CapAuctionRecord auctionrecord, HttpServletRequest request) throws RecordException {
            //从request中获取user的id
            CapUser user = (CapUser) request.getAttribute("user");
            //设置好商品竞拍记录的user id
            auctionrecord.setUserId(user.getId());
            //设置商品竞拍记录当前时间
            auctionrecord.setAuctiontime(new Date());

            TaotaoResult result = auctionService.addAuctionrecord(auctionrecord);

        return result;
    }


}
