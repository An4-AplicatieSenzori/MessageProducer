package ro.sd.a2.extractData;

import ro.sd.a2.dto.DeviceDataDTO;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class DeviceData
{
    public int contorGlobal;
    public UUID deviceID;
    public float value;



    //DeviceID.txt
    //ContorCSV.txt
    //Sensor.csv
    public DeviceData() //(int contorGlobal)
    {
        //this.contorGlobal = contorGlobal;
    }

    //Throw if wrong;
    public DeviceDataDTO getData() throws Exception
    {
        //Test data:
        //"43e38ccb-68c3-43ec-8f5f-7425183d1fb3"
        //UUID deviceID = UUID.randomUUID();
        //DeviceDataDTO deviceDataDTO = new DeviceDataDTO(deviceID,
        //        LocalDateTime.now(), 23.2f);
        //Creare obiect:
        DeviceDataDTO deviceDataDTO = new DeviceDataDTO();



        //1) Citirea ID-ului:
        File deviceIdFile = new File("./DeviceID.txt");
        Scanner txtDevice = new Scanner(deviceIdFile);
        while (txtDevice.hasNextLine()) {
            String deviceStringID = txtDevice.nextLine();
            //System.out.println(deviceStringID);
            System.out.println("Gasit device id!");
            deviceID = UUID.fromString(deviceStringID);
        }
        txtDevice.close();




        //2) Citirea contorului curent:
        File contorGlobalFile = new File("./ContorCSV.txt");
        Scanner txtContor = new Scanner(contorGlobalFile);
        while (txtContor.hasNextLine()) {
            String contorGlobalString = txtContor.nextLine();
            //System.out.println(contorGlobalString);
            System.out.println("Gasit contor!");
            contorGlobal = Integer.valueOf(contorGlobalString);
        }
        txtContor.close();





        //Citirea din CSV:
        //3) Citirea valorii:
        //Scanner csv = new Scanner(new File("C:\\Users\\Tudor\\OneDrive\\Desktop\\FolderFisiereSemestrul7"
        //        + "\\FisiereSD\\Saptamana3\\DS2022_30641_Orsan_Tudor_1_MessageProducer\\Sensor.csv"));
        //Scanner csv = new Scanner(new File("./Sensor.csv"));
        //Scanner csv = new Scanner(new File("./SensorOriginal.xlsx"));
        Scanner csv = new Scanner(new File("./SensorOriginal.csv"));
        //, este delimitator in csv:
        csv.useDelimiter(",");
        //Afisarea tuturor datelor, luarea datei bune:
        int contorLocal = 0;
        String[] valoriColoana;
        while (csv.hasNext())
        {
            //System.out.print("New data: " + csv.next());
            //value = Float.valueOf(csv.next());

            //Accesez coloana: toate valorile salvate de la 0 pana unde sunt:
            valoriColoana = csv.next().split("\n");

            //Accesez direct data folosind contorul global:
            System.out.println("Gasit value dorita!");
            value = Float.valueOf(valoriColoana[contorGlobal - 1]);

//            while(contorLocal < contorGlobal)
//            {
//                //System.out.println(valoriColoana[3]);
//                value = Float.valueOf(valoriColoana[contorLocal]);
//                contorLocal++;
//            }
        }
        //Testare ce este csv next:
        //System.out.println("Test: " + csv.next()); //Acest next este intreaga coloana;
        csv.close();



        //Actualizare contor global, il adun cu 1:
        //Scanner writeContor = new Scanner(new File("./ContorCSV.txt"));
        //Append false, deci nu scrie la final de fisier;
        FileWriter writeContor = new FileWriter("./ContorCSV.txt", false);
        //Transform din int in string automat;
        //contorGlobal = contorGlobal + 1;
        //writeContor.write(contorGlobal);
        writeContor.write(Integer.toString(contorGlobal + 1));
        System.out.println("Contor nou: " + contorGlobal + " !");
        writeContor.close();



        //Punerea obiectului:
        deviceDataDTO.setDeviceID(deviceID);
        deviceDataDTO.setValue(value);
        deviceDataDTO.setCurrentTime(LocalDateTime.now());

        return deviceDataDTO;
    }

    //User findByNameAndEmail(String name, String email);
    //User findByEmailAndPassword(String email,String password);
}















































