package ro.sd.a2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.sd.a2.dto.DeviceDataDTO;
import ro.sd.a2.mainSendUnit.MessageProducer;
import ro.sd.a2.sendService.SendingEnergyService;
//Configuratie RMQ poate are nevoie de SPRING;

@SpringBootApplication
public class Assignment2SdApplication
{
    public static void main(String[] args)
    {
        //Test constructor;
        //DeviceDataDTO deviceDataDTO = new DeviceDataDTO();
        //SendingEnergyService sendingEnergyService = new SendingEnergyService(deviceDataDTO);
        //MessageProducer messageProducer = new MessageProducer(sendingEnergyService);

        SpringApplication.run(Assignment2SdApplication.class, args);

        //Test pentru apel:
        //messageProducer.sendMessage();

        System.out.println("\nFinalul programului!");
    }
}



































