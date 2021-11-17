package uz.primitive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.primitive.dto.*;
import uz.primitive.exception.NumberNegativeException;
import uz.primitive.service.PrimitiveService;

import java.util.Date;

@RestController
public class PrimitiveController {

    private final PrimitiveService primitiveService;

    @Autowired
    public PrimitiveController(PrimitiveService primitiveService) {
        this.primitiveService = primitiveService;
    }

    @GetMapping("/area/rectangle")
    public AreaResponseDTO getAreaRectangle(@RequestParam(name = "width", required = true) String  width,
                                            @RequestParam(name = "height", required = true) String heght) {
        String areaRectangle = primitiveService.getRectangleArea(width, heght);
        return new AreaResponseDTO(areaRectangle);
    }

    @GetMapping("/area/square")
    public AreaResponseDTO getAreaSquare(@RequestParam(name = "width", required = true) String width) {
        String areaSquare = primitiveService.getSquareArea(width);
        return new AreaResponseDTO(areaSquare);
    }

    @GetMapping("/area/triangle")
    public AreaResponseDTO getAreaTriangle(@RequestParam(name = "width", required = true) String width,
                                           @RequestParam(name = "height", required = true) String height) {
        return new AreaResponseDTO(primitiveService.getTriangleArea(width, height));
    }

    @GetMapping("/area/circle")
    public AreaResponseDTO getAreaCircle(@RequestParam(name = "radius", required = true) String radius) {
        return new AreaResponseDTO(primitiveService.getCircleArea(radius));
    }

    @GetMapping("/perimeter/square")
    public PerimeterResponseDTO getPerimeterSquare(@RequestParam(name = "width", required = true) String width) {
        return new PerimeterResponseDTO(primitiveService.getSquarePerimeter(width));
    }

    @GetMapping("/perimeter/rectangle")
    public PerimeterResponseDTO getPerimeterRectangle(@RequestParam(name = "width", required = true) String width,
                                                      @RequestParam(name = "height", required = true) String height) {
        return new PerimeterResponseDTO(primitiveService.getRectanglePerimeter(width, height));
    }

    @GetMapping("/perimeter/triangle")
    public PerimeterResponseDTO getPerimeterTriangle(@RequestParam(name = "aside", required = true) String aSide,
                                                     @RequestParam(name = "bside", required = true) String bSide,
                                                     @RequestParam(name = "cside", required = true) String cSide) {
        return new PerimeterResponseDTO(primitiveService.getTrianglePerimeter(aSide, bSide, cSide));
    }

    @GetMapping("/perimeter/circle")
    public PerimeterResponseDTO getCircleLength(@RequestParam(name = "diameter", required = true) String diameter) {
        return new PerimeterResponseDTO(primitiveService.getCircleLength(diameter));
    }

    @ExceptionHandler({ NumberNegativeException.class,
                        NumberFormatException.class,
                        NullPointerException.class })
    public ExceptionResponseDTO numberValidate(Exception e) {
        return new ExceptionResponseDTO("400",
                                        e.getClass().getSimpleName(),
                                        e.getMessage(),
                                        new Date().toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ExceptionResponseDTO missingParameter(Exception e) {
        return new ExceptionResponseDTO("400",
                                        e.getClass().getSimpleName(),
                                        e.getMessage(),
                                        new Date().toString());
    }

}