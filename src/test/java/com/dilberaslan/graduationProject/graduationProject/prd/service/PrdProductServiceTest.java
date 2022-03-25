package com.dilberaslan.graduationProject.graduationProject.prd.service;

import com.dilberaslan.graduationProject.graduationProject.prd.converter.PrdProductMapper;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProduct;
import com.dilberaslan.graduationProject.graduationProject.prd.service.entityService.PrdProductEntityService;
import com.dilberaslan.graduationProject.graduationProject.prd.service.entityService.PrdProductTypeEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dilbe
 */
@ExtendWith(MockitoExtension.class)
class PrdProductServiceTest {

    @InjectMocks
    private PrdProductService prdProductService;

    @Mock
    private PrdProductEntityService prdProductEntityService;
    @Mock
    private PrdProductTypeEntityService prdProductTypeEntityService;
    @Mock
    private PrdProductMapper prdProductMapper;

    @Test
    void save() {
    }

    @Test
    void calculatePricesWithUpdatedProductType() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void shouldFindAll() {
        PrdProduct prdProduct = mock(PrdProduct.class);
        List<PrdProduct> prdProductList = new ArrayList<>();
        prdProductList.add(prdProduct);


//        PrdProductDto prdProductDto = mock(PrdProductDto.class);
//        List<PrdProductDto>  prdProductDtoList = new ArrayList<>();
//        prdProductDtoList.add(prdProductDto);

        PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);

        when(prdProductEntityService.findAll()).thenReturn(prdProductList);
//        when(PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList)).thenReturn(prdProductDtoList);


        List<PrdProductDto> result = prdProductService.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void shouldFindAllProductListIsEmpty() {
        List<PrdProduct> prdProductList = new ArrayList<>();
        PrdProductDto prdProductDto = mock(PrdProductDto.class);
        when(prdProductDto.getPriceWithKdv()).thenReturn(null);

        when(prdProductEntityService.findAll()).thenReturn(prdProductList);
        // when(PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList)).thenReturn(prdProductDtoList);


        List<PrdProductDto> result = prdProductService.findAll();

        assertEquals(0, result.size());
    }

    @Test
    void shouldFindAllProductListIsNull() {

//        when(prdProductEntityService.findAll()).thenReturn(null);
//        when(prdProductMapper.INSTANCE.convertToPrdProductDtoList(null)).thenCallRealMethod();
//
//        assertThrows(NullPointerException.class, () -> prdProductService.findAll());
    }

    @Test
    void updatePrice() {
    }

    @Test
    void findAllByPriceWithKdvBetween() {
    }

    @Test
    void findAllByProductType() {
    }
}