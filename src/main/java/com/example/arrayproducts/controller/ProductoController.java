package com.example.arrayproducts.controller;

import com.example.arrayproducts.handle.ProductoError;
import com.example.arrayproducts.model.Producto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/productos")
public class ProductoController {

   Logger logger = LogManager.getLogger(ProductoController.class);

    private final List<Producto> productList = new ArrayList<Producto>();

    @GetMapping("/example")
    public String getMensaje(){
       logger.info("GET ejemplo recibido.");

        return "ejemplo";
    }

    @GetMapping("/getall")
    public List<Producto> getAllProducts() throws ProductoError {
        if(productList.isEmpty()){
            logger.error("GET ALL no hay productos.");
            throw new ProductoError("No hay productos.");
        }
        logger.info("GET ALL todos los productos.");
        return productList;
    }

    @GetMapping("/{id}")
    public Producto getProduct(@PathVariable Long id) throws ProductoError {
        for(Producto product : productList){
            if(product.getId() == id){
                logger.info("GET ID mostrando producto.");
                return product;
            }
        }
        logger.error("GET ID no se encontró el producto.");
        throw new ProductoError("Producto no encontrado");
    }

    @PostMapping("/post")
    public String addProduct(@RequestBody Map<String,String> requestParam) {
        String name = requestParam.get("name");
        Integer price = Integer.valueOf(requestParam.get("price"));
        Producto product = new Producto(name,price);
        productList.add(product);
        product.setId(Long.parseLong(String.valueOf(productList.size())));

        logger.info("POST producto agregado.");
        return "Se agrego un nuevo producto con ID: " + productList.size();
    }

}
