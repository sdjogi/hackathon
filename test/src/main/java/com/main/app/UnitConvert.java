
package com.main.app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.UnitConverter;

/**
 * @author jogish
 */
@RestController
public class UnitConvert {

    @RequestMapping("/convertUnit/{fromUnit}/{toUnit}/{amount}")
    public String generate(@PathVariable
    String fromUnit, @PathVariable
    String toUnit, @PathVariable
    String amount) {
        UnitConverter from = new UnitConverter(fromUnit);
        return String.valueOf(from.toMeters(Double.parseDouble(amount)));

    }

    @RequestMapping("/showallunits")
    public String showAll() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("in = INCH ");
        buffer.append("ft = FEET ");
        buffer.append("mi = MILES ");
        buffer.append("mm = MILIMETER ");
        buffer.append("cm = CENTIMETER ");
        buffer.append("m = METER ");
        return buffer.toString();

    }
}
