package com.example.shoppingmall.product.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {

//    @Autowired // DI
    ProductService productService;
//    Logger logger = LoggerFactory.getLogger(ProductController.class);

    // 상품 개별 등록
    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {
        // * 유효성 검사 : name(영어), price(숫자)
        // 1) 조건문
        if(Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice()) ) {
            Product savedProduct = productService.registerProduct(product);
            log.info(product.getName());
            // TODO NPE 처리(try-catch)
            try{
                System.out.println(savedProduct.getName());
            }catch (NullPointerException e){
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(HttpStatus.CREATED);
//            return "등록 성공!";
        }
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//            return "name 또는 price가 형식에 맞지 않습니다.";
    }

    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId //객체로 감싸면 Null쓸수 있다
    ){
        log.trace("limit = {}",limit);
        log.trace("currentPage = {}",currentPage);
        log.trace("categoryId = {}",categoryId);

        //TODO null체크는 어디서 해야할까
        if(categoryId == null){
            List<Product> products = productService.findProducts(limit,currentPage);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        else{
            List<Product> products = productService.findProducts(limit,currentPage, categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }
    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(value="id") int id){
        // 1. Product반환필드 : id가 없어요
        // 2. id숫자만 들어온거 맞는지 유효성 검사 추가
        System.out.println(id);
        if(Validator.isNumber(id)) {
            //TODO log INFO 레벨 id type찍기
//            logger.error("ERROR");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//        Product resultProduct = productService.findProduct(id);
        Product resultProduct = productService.findProduct(id);

        if(resultProduct == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(resultProduct,HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value="id")  int id){
        System.out.println(id);
        if( !Validator.isNumber(id) || productService.findProduct(id)==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        //TODO 삭제 성공, 실패 한단하려면 필요한 데이터?
        boolean result = productService.deleteProduct(id);
        if(result)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/products/delete")
    public ResponseEntity<Product> deleteProducts(@RequestBody Map<String, ArrayList<Integer>> deleteRequest){
        List<Integer> productsIds = deleteRequest.get("ids");

        if(productsIds.isEmpty()){
            log.info("productsIds가 없네요");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productsIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
