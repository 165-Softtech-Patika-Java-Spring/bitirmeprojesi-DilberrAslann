package com.dilberaslan.graduationProject.graduationProject.prd.controller;

import com.dilberaslan.graduationProject.graduationProject.gen.dto.RestResponse;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDetailDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDto;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import com.dilberaslan.graduationProject.graduationProject.prd.service.PrdProductTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Dilber
 */
@RestController
@RequestMapping("/api/v1/productTypes")
@RequiredArgsConstructor
public class PrdProductTypeController {
    private final PrdProductTypeService prdProductTypeService;


    @Operation(tags = "Product Type Controller", summary = "Update Price with KDV")
    @PatchMapping("/kdv/{id}")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestParam BigDecimal kdv) {

        PrdProductTypeDto prdProductTypeDto = prdProductTypeService.updateKDV(id, kdv);

        return ResponseEntity.ok(RestResponse.of(prdProductTypeDto));
    }

    @Operation(tags = "Product Type Controller", summary = "All Product with Detail")
    @GetMapping("/details")
    public ResponseEntity findAllProductWithDetail() {

        List<PrdProductTypeDetailDto> allProductWithDetail = prdProductTypeService.findAllProductWithDetail();

        return ResponseEntity.ok(RestResponse.of(allProductWithDetail));
    }


}
