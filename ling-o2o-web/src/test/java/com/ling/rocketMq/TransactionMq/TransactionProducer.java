package com.ling.rocketMq.TransactionMq;

import com.ling.rocketMq.constants.Const;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.*;


public class TransactionProducer {
    private static final String PRODUCER_GROUP_NAME = "test_transaction_producer_name";
    public static final String TX_PAY_TOPIC = "tx_pay_topic";

    public static final String TX_PAY_TAGS = "pay";

    public static void main(String[] args) throws MQClientException {

        TransactionMQProducer producer = new TransactionMQProducer(PRODUCER_GROUP_NAME);

        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(PRODUCER_GROUP_NAME + "-check-thread");
                return thread;
            }
        });
        producer.setExecutorService(executorService);
        producer.setNamesrvAddr(Const.NAMESRV_ADDR_MASTER_SLAVE);
        producer.setSendMsgTimeout(10000);

        TransactionListenerImpl transactionListenerImpl = new TransactionListenerImpl();
        producer.setTransactionListener(transactionListenerImpl);
        producer.start();

        String keys = UUID.randomUUID().toString() + "$" + System.currentTimeMillis();
        Message message = new Message(TX_PAY_TOPIC, TX_PAY_TAGS, keys, "消息多]对对".getBytes());
        TransactionSendResult sendResult = producer.sendMessageInTransaction(message, "dd");
        if (sendResult.getSendStatus() == SendStatus.SEND_OK
                && sendResult.getLocalTransactionState() == LocalTransactionState.COMMIT_MESSAGE) {
            //	回调order通知支付成功消息
//			callbackService.sendOKMessage(orderId, userId);
            System.out.println("支付成功!");
        } else {
            System.out.println("支付失败!");
        }
//        producer.shutdown();
    }


}




