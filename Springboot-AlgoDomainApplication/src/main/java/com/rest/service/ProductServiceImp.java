package com.rest.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Charges;
import com.rest.model.Product;
import com.rest.repo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {
@Autowired
private ProductRepo productRepo;
@Autowired
private Charges charges;
@Override
public Product saveProduct(Product product) {
	double discount=0.0;
	double gst=0.0;
	double tprice=product.getPrice();
	int delivery_Charges=0;
	if (product.getPcategory().equals("Electronics")) {
		charges.setPcategory1("Electronics");
		
		discount=(tprice*15)/100;
		gst=(tprice*18)/100;
		delivery_Charges=350;
	}
	else if (product.getPcategory().equals("Home Appliances")) {
		charges.setPcategory1("Home Appliances");
		
		discount=(tprice*22)/100;
		gst=(tprice*24)/100;
		delivery_Charges=800;
	}
	else if (product.getPcategory().equals("Clothing")) {
		charges.setPcategory1("Clothing");
		
		discount=(tprice*40)/100;
		gst=(tprice*12)/100;
		delivery_Charges=0;
	}
	else if (product.getPcategory().equals("Furniture")) {
		charges.setPcategory1("Furniture");
		
		discount=(tprice*10)/100;
		gst=(tprice*18)/100;
		delivery_Charges=300;
		
	
	}
	charges.setDiscount(discount);
	charges.setGst(gst);
	charges.setDelivery_charges(delivery_Charges);
	product.setCharges(charges);
	Product p=productRepo.save(product);
	return p;
}

@Override
public Product getOneProduct(int pid) {
	Product get=productRepo.findById(pid).get();
	return get;
}

@Override
public List<Product> getAllProducts() {
	List<Product>getAllProducts=productRepo.findAll();
	return getAllProducts;
}


@Override
public void deleteProduct(int pid) {
	productRepo.deleteById(pid);
}


@Override
public Product updateProduct(Product product,int pid) {
	Product oldProduct=productRepo.findById(pid).orElse(null);
	if (oldProduct != null) {
	oldProduct.setPname(product.getPname());
	oldProduct.setPtype(product.getPtype());
	oldProduct.setPcategory(product.getPcategory());
	oldProduct.setCharges(product.getCharges());
	
	if (oldProduct != null) {
		oldProduct.setPname(product.getPname());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setPtype(product.getPtype());
		oldProduct.setPcategory(product.getPcategory());

        double discount = 0.0;
        double gst = 0.0;
        int deliveryCharges = 0;

        if (product.getPcategory().equals("Electronics")) 
        {
            
        	charges.setPcategory1("Electronics");
            discount = (product.getPrice() * 15) / 100;
            gst = (product.getPrice() * 18) / 100;
            deliveryCharges = 350;
        } 
        else if (product.getPcategory().equals("Home Appliances"))
        {
            
        	charges.setPcategory1("Home Appliances");
            discount = (product.getPrice() * 22) / 100;
            gst = (product.getPrice() * 24) / 100;
            deliveryCharges = 800;
        }
        else if (product.getPcategory().equals("Clothing")) 
        {
            charges = new Charges(); // Initialize the Discount object
            charges.setPcategory1("Clothing");
            discount = (product.getPrice() * 40) / 100;
            gst = (product.getPrice() * 12) / 100;
            deliveryCharges = 0;
        } 
        else if (product.getPcategory().equals("Furniture")) 
        {
           
        	charges.setPcategory1("Furniture");
            discount = (product.getPrice() * 10) / 100;
            gst = (product.getPrice() * 18) / 100;
            deliveryCharges = 300;
        }
        double finalprice=product.getPrice()+gst+deliveryCharges-discount;
        charges.setDiscount(discount);
        charges.setGst(gst);
        charges.setDelivery_charges(deliveryCharges);
        oldProduct.setCharges(charges);
        product.setPrice(finalprice);

        Product updatedRecord = productRepo.save(oldProduct);
        return updatedRecord;
    } 
    
}
	return null;
}

}
