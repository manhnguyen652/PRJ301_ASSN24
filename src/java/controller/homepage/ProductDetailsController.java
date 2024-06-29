

package controller.homepage;

import dal.implement.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDetailsController extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //get ve id cua product
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = Product.builder()
                                .id(id)
                                .build();
        //lay product tu database
        Product productFoundById = productDAO.findById(product);
        //set product vao request va chuyen sang trang product-details.jsp
        request.setAttribute("product", productFoundById);
        request.getRequestDispatcher("view/homepage/product-details.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
   

}
