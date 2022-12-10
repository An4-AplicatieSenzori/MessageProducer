package ro.sd.a2.config;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.DeviceDataDTO;

import java.util.TimerTask;


//RabbitMQ foloseste SPRING cred;
@Service
public class RabbitSender //extends TimerTask
{
    @Autowired
    private AmqpTemplate rabbitTemplate;
    private static final Logger logRabbit = LoggerFactory.getLogger(RabbitSender.class);

    @Value("queue.e")
    private String queueE;

    @Value("queue.r")
    private String queueR;


    //Functia de send:
    //In loc de send, run:
    public void send(DeviceDataDTO payloadDeviceData) //throws JsonProcessingException
    {
        rabbitTemplate.convertAndSend(queueE, queueR, payloadDeviceData);
        logRabbit.info("The device data " + payloadDeviceData + " was sent.");
    }

    //public void run()
    //{
    //    send();
    //}
}









