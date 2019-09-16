package com.ling.controller.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ling.controller.service.producer.TransactionProducer;
import com.ling.controller.vo.SellerVo;
import com.ling.enity.Seller;
import com.ling.service.FoodsService;
import com.ling.service.SellerService;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FoodsServiceRef {
    public static final String TX_PAY_TOPIC = "solr_tx_pay_topic";

    public static final String TX_PAY_TAGS = "pay";
    @Reference
    private FoodsService foodsService;

    @Autowired
    private TransactionProducer transactionProducer;

    public void devSolr(String id) {
        String keys = UUID.randomUUID().toString() + "$" + System.currentTimeMillis();
        //	消息发送并且 本地的事务执行
        Message message = new Message(TX_PAY_TOPIC, TX_PAY_TAGS, keys, "6666".getBytes());
        TransactionSendResult sendResult = transactionProducer.sendMessage(message, "多对对");
        if (sendResult.getSendStatus() == SendStatus.SEND_OK
                && sendResult.getLocalTransactionState() == LocalTransactionState.COMMIT_MESSAGE) {
            //	回调order通知支付成功消息
//			callbackService.sendOKMessage(orderId, userId);
            System.out.println("支付成功!");
        } else {
            System.out.println("支付失败!");
        }
    }
}
