package com.bruno.Servizi.Logging.services;

import com.bruno.Servizi.Logging.controllers.BasicController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);
    public double calculatePower(int num1, int num2) {
        logger.debug("Calculating power of {} and {}", num1, num2); //che figata se metto {} mi passa il valore dentro
        double result = Math.pow(num1, num2);
        logger.debug("Power calculated: {}", result);
        return result;
    }

}
