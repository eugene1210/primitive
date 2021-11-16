package uz.primitive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.primitive.controller.dto.*;
import uz.primitive.service.PrimitiveService;

@RestController
public class PrimitiveController {

    private final PrimitiveService primitiveService;

    @Autowired
    public PrimitiveController(PrimitiveService primitiveService) {
        this.primitiveService = primitiveService;
    }

    @GetMapping("/area/rectangle")
    public AreaResponseDTO getAreaRectangle(@RequestBody RectangleRequestDTO rectangleRequestDTO) {
        Double areaRectangle = primitiveService.getRectangleArea(rectangleRequestDTO.getWidth(),
                                                                 rectangleRequestDTO.getHeight());
        return new AreaResponseDTO(areaRectangle);
    }

    @GetMapping("/area/square")
    public AreaResponseDTO getAreaSquare(@RequestBody SquareRequestDTO squareRequestDTO) {
        Double areaSquare = primitiveService.getSquareArea(squareRequestDTO.getWidth());
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
    public PerimeterResponseDTO getPerimeterRectangle(@RequestBody RectangleRequestDTO rectangleRequestDTO) {
        return new PerimeterResponseDTO(primitiveService.getRectanglePerimeter(rectangleRequestDTO.getWidth(),
                                                                               rectangleRequestDTO.getHeight()));
    }

    @GetMapping("/perimeter/triangle")
    public PerimeterResponseDTO getPerimeterTriangle(@RequestBody TriangleRequestDTO triangleRequestDTO) {
        return new PerimeterResponseDTO(primitiveService.getTrianglePerimeter(triangleRequestDTO.getASide(),
                                                                              triangleRequestDTO.getBSide(),
                                                                              triangleRequestDTO.getCSide()));
    }

    @GetMapping("/perimeter/circle")
    public PerimeterResponseDTO getCircleLength(@RequestBody CircleRequestDTO circleRequestDTO) {
        return new PerimeterResponseDTO(primitiveService.getCircleLength(circleRequestDTO.getDiameter()));
    }
}
