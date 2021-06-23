package client;

import java.rmi.RemoteException;

import webservices.Product;
import webservices.ProductsManagerProxy;
public class ClientWS {

	public static void main(String[] args) throws RemoteException  {

		ProductsManagerProxy proxy = new ProductsManagerProxy();

		Product product1= new Product((long) 11,"Imprimante",200.0);
		Product product2= new Product((long) 22,"Ordinateur",7000.0);
		Product product3= new Product((long) 33,"Souris",10.0);
		
		proxy.addProduct(product1);
		proxy.addProduct(product2);
		proxy.addProduct(product3);
		
		System.out.println("Product's list:");

		for (int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("***********************");
			System.out.println("Product's id:"+proxy.getProducts()[i].getId());
			System.out.println("Product's type:"+proxy.getProducts()[i].getLabel());
			System.out.println("Product's price:"+proxy.getProducts()[i].getPrice());
		}
		System.out.println("********************************************************");
		 
		proxy.deleteProduct(30);
		System.out.println("Product deleted");
		
		System.out.println("Product's list:");
		for (int i=0; i<proxy.getProducts().length; i++) {
			System.out.println("***********************");
			System.out.println("Product's id:"+proxy.getProducts()[i].getId());
			System.out.println("Product's type:"+proxy.getProducts()[i].getLabel());
			System.out.println("Product's price:"+proxy.getProducts()[i].getPrice());
		}
		System.out.println("********************************************************");
	}

}