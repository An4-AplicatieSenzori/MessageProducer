package ro.sd.a2.sendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.DeviceDataDTO;
import ro.sd.a2.extractData.DeviceData;
import java.util.TimerTask;

@Service
public class SendingEnergyService //extends TimerTask
{
    private DeviceData deviceData = new DeviceData();

    //public SendingEnergyService(DeviceData deviceData)
    //{
    //    this.deviceData = deviceData;
    //}

    public SendingEnergyService()
    {
        //Nimic;
    }

    public DeviceDataDTO getData() throws Exception
    {
        //Test data:
        DeviceDataDTO deviceDataDTO = deviceData.getData();
        return deviceDataDTO;
    }

    //public void run()
    //{
    //    //Apelat de mai multe ori;
    //    getData();
    //}

//    public User getUserByDTO(UserDTO userDTO)
//    {
//        return userRepository.findByNameAndEmail(userDTO.getName(), userDTO.getEmail());
//    }
//
//    public List<User> getAllUsers()
//    {
//        return new ArrayList<>();
//    }
}











































