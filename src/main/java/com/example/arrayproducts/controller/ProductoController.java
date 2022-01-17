package com.example.arrayproducts.controller;

import com.example.arrayproducts.annotations.CustomMethodAnotation;
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
       logger.info("GET EJEMPLO recibido.");

        return "Mensaje de ejemplo.";
    }

    @GetMapping("/getall")
    public List<Producto> getAllProducts() throws ProductoError {
        logger.info("GET ALL recibido.");
        if(productList.isEmpty()){
            throw new ProductoError("Error: no hay productos.");
        }
        logger.info("GET ALL ejecutado con éxito.");
        return productList;
    }

    @GetMapping("/{id}")
    public Producto getProduct(@PathVariable Long id) throws ProductoError {
        logger.info("POST request recibido.");
        for(Producto product : productList){
            if(product.getId() == id){
                logger.info("GET ejecutado con éxito.");
                return product;
            }
        }
        logger.error("Error: ID inválido.");
        throw new ProductoError("Producto no encontrado");
    }

    @PostMapping("/post")
    public String addProduct(@RequestBody Map<String,String> requestParam) {
        logger.info("POST request recibido.");
        String name = requestParam.get("name");
        Integer price = Integer.valueOf(requestParam.get("price"));
        Producto product = new Producto(name,price);
        productList.add(product);
        product.setId(Long.parseLong(String.valueOf(productList.size())));

        logger.info("POST producto agregado.");
        return "Se agrego un nuevo producto con ID: " + productList.size();
    }

    @PutMapping("/put/{id}")
    @CustomMethodAnotation
    public Producto updateProduct(@PathVariable Long id, @RequestBody Producto p) throws ProductoError {
        logger.info("PUT request recibido.");

        if (id == 0 || id > productList.size()) {
            throw new ProductoError("Error: el ID es 0 o no existe.");
        } else {
            for (Producto product : productList) {
                if (product.getId() == id) {
                    if(p.getName() == ""){
                        throw  new ProductoError("Error: campo name vacio.");
                    }
                    product.setName(p.getName());
                    product.setPrice(p.getPrice());
                    return product;
                }
            }

        }
        return p;
    }

    @DeleteMapping("/delete/{id}")
    @CustomMethodAnotation
    public void deleteProduct(@PathVariable Long id) throws ProductoError{
        logger.info("DELETE request recibido.");

        if (id == 0 || id > productList.size()) {
            logger.info("ID inválido.");
            throw new ProductoError("Error: el ID es 0 o no existe.");
        }else{
            logger.info("Removiendo producto.");
            productList.remove( id.intValue()-1);
        }
    }


}
