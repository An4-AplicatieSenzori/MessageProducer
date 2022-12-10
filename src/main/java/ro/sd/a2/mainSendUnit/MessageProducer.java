package ro.sd.a2.mainSendUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
//import org.apache.logging.log4j.core.config.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sd.a2.config.RabbitSender;
import ro.sd.a2.dto.DeviceDataDTO;
import ro.sd.a2.sendService.SendingEnergyService;

import java.util.Timer;
import java.util.TimerTask;


@Controller
@EnableScheduling
public class MessageProducer
{
    private static final Logger messageProducerLog = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private RabbitSender rabbitSender;

    @Autowired
    private SendingEnergyService sendingEnergyService;

    //Constructor:
    //public MessageProducer(SendingEnergyService sendingEnergyService)
    //{
    //    this.sendingEnergyService = sendingEnergyService;
    //}

    public MessageProducer()
    {
        //Nimic
    }


    //Se face direct apelul la timpul stabilit:
    //In loc sa se apeleze din GUI la GET / POST, se apeleaza la un timp anume;
    //Trebuie sa te duci la alta pagina;
    //@Scheduled(fixedRate = 60000)
    //Se face de la pornirea aplicatiei;
    //@GetMapping("/TestRMQ")
    @Scheduled(fixedRate = 10000) //Every 10 seconds; (miliseconds)
    //@Scheduled(fixedRate = 600000) //Every 10 minutes;
    public ResponseEntity<DeviceDataDTO> sendMessage() throws Exception //throws JsonProcessingException
    //public void sendMessage()
    {
        DeviceDataDTO deviceDataDTO = sendingEnergyService.getData();
        //System.out.println("Obiectul test: " + deviceDataDTO);
        System.out.println("Obiectul gasit: " + deviceDataDTO);

        //Trimis rabbitSender.send(deviceDataDTO); la un interval:
        //1)
        //Functia send se va apela la fiecare 10 minute (dand un schedule):
        //Timer timer = new Timer();
        //TimerTask task = rabbitSender.send(deviceDataDTO);
        //timer.schedule(task, 2000, 5000);

        //2)
        //Timer timer = new Timer();
        //TimerTask task = sendingEnergyService;
        //timer.schedule(task, 200, 1000);

        //3)
        //Comentare daca nu vreau sa trimit:
        //rabbitSender.send(deviceDataDTO);

        messageProducerLog.info("Device Data was sent!");

        return new ResponseEntity<>(deviceDataDTO, HttpStatus.OK);
    }
}








