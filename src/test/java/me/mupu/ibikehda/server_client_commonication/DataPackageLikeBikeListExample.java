package me.mupu.ibikehda.server_client_commonication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.mupu.ibikehda.persistence.dao.Bike;
import me.mupu.ibikehda.persistence.dao.Station;
import me.mupu.ibikehda.persistence.dao.enums.PaymentMethod;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class DataPackageLikeBikeListExample implements Serializable {

    ArrayList<String> stations = new ArrayList<>();

    Bike bike;

}
