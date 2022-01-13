package com.example.arrayproducts.controller;

import com.example.arrayproducts.handle.ProductoError;
import com.example.arrayproducts.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/productos")
public class ProductoController {

    private List<Producto> productList = new ArrayList<Producto>();

    @GetMapping("/example")
    public String getMensaje(){
        return "ejemplo";
    }

    @GetMapping("/")
    public List<Producto> getAllProducts() throws ProductoError {
        if(productList.isEmpty()){
            throw new ProductoError("No hay productos.");
        }
        return productList;
    }

    @GetMapping("/{id}")
    public Producto getProduct(@PathVariable Long id) throws ProductoError {
        for(Producto product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        throw new ProductoError("Producto no encontrado");
    }

    @PostMapping
    public String addProduct(@RequestBody Map<String,String> requestParam) {
        String name = requestParam.get("name");
        Integer price = Integer.valueOf(requestParam.get("price"));
        Producto product = new Producto(name,price);
        productList.add(product);
        product.setId(Long.parseLong(String.valueOf(productList.size())));
        return "Se agrego un nuevo producto con ID: " + productList.size();
    }

}
