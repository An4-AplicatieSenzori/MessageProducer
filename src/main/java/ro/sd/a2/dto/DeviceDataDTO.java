package ro.sd.a2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*; //Pentru getter, setter, etc...;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDataDTO
{
    //Din .txt in UUID:
    private UUID deviceID;

    //Data actuala:
    private LocalDateTime currentTime;

    //Valorile din csv, un float:
    private float value;


    public DeviceDataDTO(@JsonProperty("deviceID") UUID deviceID,
                         @JsonProperty("currentTime") LocalDateTime currentTime,
                         @JsonProperty("value") float value)
    {
        this.deviceID = deviceID;
        this.currentTime = currentTime;
        this.value = value;
    }


    @Override
    public String toString() {
        return "DeviceDataDTO{" +
                " id = '" + deviceID + '\'' +
                ", currentTime = '" + currentTime + '\'' +
                ", value = '" + value + '\'' +
                '}';
    }
}























