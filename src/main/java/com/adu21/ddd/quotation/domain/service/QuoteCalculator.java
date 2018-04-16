package com.adu21.ddd.quotation.domain.service;

import com.adu21.ddd.exception.InvalidQuotationException;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableMap.of;

@Service
public class QuoteCalculator {

    private static final String NUMBER_PATTERN = "#.00";
    private static final double BASE_PREMIUM = 100.0;
    private static final Map<String, Double> HOME_POLICY_BUILDING_MATERIAL_RATE_MAP = of("铝材", 1.1, "钢材", 1.2, "砖", 1.3);
    private static final Map<String, Double> HOME_POLICY_BUILDING_TYPE_RATE_MAP = of("公寓", 1.1, "别墅", 1.2, "Soho", 1.3);
    private static final Map<String, Double> HOME_POLICY_NUMBER_OF_ROOMS_RATE_MAP = of("一室", 1.1, "二室", 1.2, "三室及以上", 1.3);

    private static final Map<String, Double> CAR_POLICY_PRODUCTIVE_YEAR_RATE = of(">=2015", 1.0, "2010-2014", 1.2, "<=2009", 1.4);
    private static final Map<String, Double> CAR_POLICY_BMW_MODEL_RATE = of("C600", 1.4, "C650", 1.6);
    private static final Map<String, Double> CAR_POLICY_DUCATI_MODEL_RATE = of("1199", 1.4, "1299", 1.6, "848", 1.6);
    private static final Map<String, Double> CAR_POLICY_HONDA_MODEL_RATE = of("AG-XR", 1.2, "CB1100", 1.2, "CB125E", 1.4);
    private static final Map<String, Double> CAR_POLICY_PARK_PLACE_RATE = of("carport", 1.1, "Drive way", 1.2, "Street", 1.6);
    private static final Map<String, Double> CAR_POLICY_DISTANCE_PRE_YEAR_RATE = of(">=1500km", 1.4, "750-1499km", 1.2, "<570km", 1.0);

    public Double calculate(HomePolicyQuotation homePolicyQuotation) {
        Double buildingMaterialRate = HOME_POLICY_BUILDING_MATERIAL_RATE_MAP.get(homePolicyQuotation.getBuildingMaterial());
        Double buildingTypeRate = HOME_POLICY_BUILDING_TYPE_RATE_MAP.get(homePolicyQuotation.getBuildingType());
        Double numberOfRoomsRate = HOME_POLICY_NUMBER_OF_ROOMS_RATE_MAP.get(homePolicyQuotation.getNumberOfRooms());

        checkRateValidState(buildingMaterialRate, buildingTypeRate, numberOfRoomsRate);

        return formatPremium(BASE_PREMIUM * buildingMaterialRate * buildingTypeRate * numberOfRoomsRate);
    }

    public Double calculate(CarPolicyQuotation carPolicyQuotation) {
        Double productiveYearRate = CAR_POLICY_PRODUCTIVE_YEAR_RATE.get(carPolicyQuotation.getProductiveYear());
        Double parkPlaceRate = CAR_POLICY_PARK_PLACE_RATE.get(carPolicyQuotation.getParkPlace());
        Double distancePreYearRate = CAR_POLICY_DISTANCE_PRE_YEAR_RATE.get(carPolicyQuotation.getDistancePreYear());
        Double carBrandModelRate = null;
        switch (carPolicyQuotation.getCarBrand()) {
            case "BMW":
                carBrandModelRate = CAR_POLICY_BMW_MODEL_RATE.get(carPolicyQuotation.getCarModel());
                break;
            case "HONDA":
                carBrandModelRate = CAR_POLICY_HONDA_MODEL_RATE.get(carPolicyQuotation.getCarModel());
                break;
            case "DUCATI":
                carBrandModelRate = CAR_POLICY_DUCATI_MODEL_RATE.get(carPolicyQuotation.getCarModel());
                break;
        }

        checkRateValidState(productiveYearRate, parkPlaceRate, distancePreYearRate, carBrandModelRate);

        return formatPremium(BASE_PREMIUM * productiveYearRate * parkPlaceRate * distancePreYearRate * carBrandModelRate);
    }

    private void checkRateValidState(Double... args) {
        if (Stream.of(args).anyMatch(ObjectUtils::isEmpty)) throw new InvalidQuotationException();
    }

    private Double formatPremium(Double premium) {
        DecimalFormat decimalFormat = new DecimalFormat(NUMBER_PATTERN);
        return new Double(decimalFormat.format(premium));
    }
}
