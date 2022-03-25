package com.dilberaslan.graduationProject.graduationProject.prd.controller;

import com.dilberaslan.graduationProject.graduationProject.gen.dto.RestResponse;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import com.dilberaslan.graduationProject.graduationProject.prd.service.PrdProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Dilber
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class PrdProductController {
    private final PrdProductService prdProductService;

    @Operation(
            tags = "Product Controller",
            description = "Creates new product",
            summary = "creates new product",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Products",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = PrdProductSaveRequestDto.class
                                    ),
                                    examples = {
                                            @ExampleObject(
                                                    name = "new type of food product",
                                                    summary = "New Food Type Product Example",
                                                    value = "{\n" +
                                                            "  \"prdProductTypeName\": \"FOOD\",\n" +
                                                            "  \"name\": \"chicken\",\n" +
                                                            "  \"price\": \"100\"\n" +
                                                            "}"
                                            ),
                                            @ExampleObject(
                                                    name = "new type of clothes product",
                                                    summary = "New Clothes Type Product Example",
                                                    value = "{\n" +
                                                            "  \"prdProductTypeName\": \"CLOTHES\",\n" +
                                                            "  \"name\": \"jean\",\n" +
                                                            "  \"price\": \"300\"\n" +
                                                            "}"
                                            ),
                                            @ExampleObject(
                                                    name = "new type of stationary product",
                                                    summary = "New Stationary Type Product Example",
                                                    value = "{\n" +
                                                            "  \"prdProductTypeName\": \"STATIONARY\",\n" +
                                                            "  \"name\": \"pencil\",\n" +
                                                            "  \"price\": \"50\"\n" +
                                                            "}"
                                            )
                                    }
                            ),
                    }
            )
    )
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody PrdProductSaveRequestDto prdProductSaveRequestDto) {

        PrdProductDto prdProductDto = prdProductService.save(prdProductSaveRequestDto);

        WebMvcLinkBuilder linkDelete = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(
                        this.getClass()).delete(prdProductDto.getId()));

        EntityModel entityModel = EntityModel.of(prdProductDto);

        entityModel.add(linkDelete.withRel("delete"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(entityModel);

        return ResponseEntity.ok(RestResponse.of(mappingJacksonValue));

    }

    @Operation(tags = "Product Controller", summary = "Delete Product")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        prdProductService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @Operation(tags = "Product Controller", summary = "Update Product")
    @PutMapping
    public ResponseEntity update(@RequestBody PrdProductUpdateRequestDto prdProductUpdateRequestDto) {

        PrdProductDto prdProductDto = prdProductService.update(prdProductUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }

    @Operation(tags = "Product Controller", summary = "All Product")
    @GetMapping
    public ResponseEntity findAll() {


        List<PrdProductDto> prdProductDtoList = prdProductService.findAll();

        return ResponseEntity.ok(RestResponse.of(prdProductDtoList));
    }


    @Operation(tags = "Product Controller", summary = "Update Product Price")
    @PatchMapping("/price/{id}")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestParam BigDecimal price) {

        PrdProductDto prdProductDto = prdProductService.updatePrice(id, price);

        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }

    @Operation(tags = "Product Controller", summary = "Between Price All")
    @GetMapping("/betweenPrice")
    public ResponseEntity findAllByBetweenPrice(@RequestParam("min") BigDecimal firstPrice, @RequestParam("max") BigDecimal finalPrice) {

        List<PrdProductDto> prdProductDtoList = prdProductService.findAllByPriceWithKdvBetween(firstPrice, finalPrice);

        return ResponseEntity.ok(RestResponse.of(prdProductDtoList));
    }

    @Operation(tags = "Product Controller", summary = "All Product Type")
    @GetMapping("/productType")
    public ResponseEntity findAllByProductType(@RequestParam PrdProductTypeName prdProductTypeName) {

        List<PrdProductDto> prdProductDtoList = prdProductService.findAllByProductType(prdProductTypeName);

        return ResponseEntity.ok(RestResponse.of(prdProductDtoList));

    }


}
