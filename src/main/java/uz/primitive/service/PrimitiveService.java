package uz.primitive.service;

import org.springframework.stereotype.Service;

@Service
public class PrimitiveService {

    public Double getSquareArea(Double width) {
        return width * width;
    }

    public Double getRectangleArea(Double width, Double height) {
        return width * height;
    }

    public Double getTriangleArea(String width, String height) {
        return 0.5 * Double.parseDouble(width) * Double.parseDouble(height);
    }

    public Double getCircleArea(String radius) {
        return Math.PI * Math.pow(Double.parseDouble(radius), 2);
    }

    public Double getSquarePerimeter(String width) {
        return 4 * Double.parseDouble(width);
    }

    public Double getRectanglePerimeter(Double width, Double height) {
        return 2 * (width + height);
    }

    public Double getTrianglePerimeter(Double aSide, Double bSide, Double cSide) {
        return aSide + bSide + cSide;
    }

    public  Double getCircleLength(Double diameter) {
        return Math.PI * diameter;
    }
}
