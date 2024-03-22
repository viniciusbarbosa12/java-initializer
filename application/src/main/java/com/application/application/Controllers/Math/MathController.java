package com.application.application.Controllers.Math;

import com.application.application.Execptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{valueOne}/{valueTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "valueOne") String valueOne,
                      @PathVariable(value = "valueTwo") String valueTwo) throws UnsuportedMathOperationException {
        if (!IsNumeric(valueOne) || !IsNumeric(valueTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return ConvertToDouble(valueOne) + ConvertToDouble(valueTwo);
    }


    @RequestMapping(value = "/divide/{valueOne}/{valueTwo}", method = RequestMethod.GET)
    public Double divide(@PathVariable(value = "valueOne") String valueOne,
                      @PathVariable(value = "valueTwo") String valueTwo) throws UnsuportedMathOperationException {
        if (!IsNumeric(valueOne) || !IsNumeric(valueTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return ConvertToDouble(valueOne) / ConvertToDouble(valueTwo);
    }

    @RequestMapping(value = "/multiply/{valueOne}/{valueTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(value = "valueOne") String valueOne,
                         @PathVariable(value = "valueTwo") String valueTwo) throws UnsuportedMathOperationException {
        if (!IsNumeric(valueOne) || !IsNumeric(valueTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return ConvertToDouble(valueOne) * ConvertToDouble(valueTwo);
    }

    @RequestMapping(value = "/subtract/{valueOne}/{valueTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "valueOne") String valueOne,
                           @PathVariable(value = "valueTwo") String valueTwo) throws UnsuportedMathOperationException {
        if (!IsNumeric(valueOne) || !IsNumeric(valueTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return ConvertToDouble(valueOne) * ConvertToDouble(valueTwo);
    }

    private Double ConvertToDouble(String strValue) {
        return Double.parseDouble(strValue.replaceAll(",", "."));
    }

    public static boolean IsNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
