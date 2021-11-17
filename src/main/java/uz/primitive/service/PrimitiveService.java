package uz.primitive.service;

import org.springframework.stereotype.Service;
import uz.primitive.utils.Utils;
import java.util.logging.Logger;

@Service
public class PrimitiveService {

    private Logger logger = Logger.getLogger(PrimitiveService.class.getName());

    public String getSquareArea(String width) {
        Double _width = Utils.getDoubleValue(width, logger);
        Double result = _width * _width;
        return result.toString();
    }

    public String getRectangleArea(String width, String height) {
        Double _width = Utils.getDoubleValue(width, logger);
        Double _height = Utils.getDoubleValue(height, logger);
        Double result = _width * _height;
        return result.toString();
    }

    public String getTriangleArea(String width, String height) {
        Double _width = Utils.getDoubleValue(width, logger);
        Double _height = Utils.getDoubleValue(height, logger);
        Double result = 0.5 * _width * _height;
        return result.toString();
    }

    public String getCircleArea(String radius) {
        Double _radius = Utils.getDoubleValue(radius, logger);
        Double result = Math.PI * Math.pow(_radius, 2);
        return result.toString();
    }

    public String getSquarePerimeter(String width) {
        Double _width = Utils.getDoubleValue(width, logger);
        Double result = 4 * _width;
        return result.toString();
    }

    public String getRectanglePerimeter(String width, String height) {
        Double _width = Utils.getDoubleValue(width, logger);
        Double _height = Utils.getDoubleValue(height, logger);
        Double result = 2 * (_width + _height);
        return result.toString();
    }

    public String getTrianglePerimeter(String aSide, String bSide, String cSide) {
        Double _aSide = Utils.getDoubleValue(aSide, logger);
        Double _bSide = Utils.getDoubleValue(bSide, logger);
        Double _cSide = Utils.getDoubleValue(cSide, logger);
        Double result = _aSide + _bSide + _cSide;
        return result.toString();
    }

    public String getCircleLength(String diameter) {
        Double _diameter = Utils.getDoubleValue(diameter, logger);
        Double result = Math.PI * _diameter;
        return result.toString();
    }
}
