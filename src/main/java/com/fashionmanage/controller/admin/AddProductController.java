package com.fashionmanage.controller.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fashionmanage.dao.ProductDao;
import com.fashionmanage.entity.Brand;
import com.fashionmanage.entity.Category;
import com.fashionmanage.entity.Product;
import com.fashionmanage.entity.ProductDetail;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/admin-sanpham-add")
@MultipartConfig
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("views/admin/products/AddProduct.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected Boolean isNumber(String ob) {
		if (ob.matches("^\\d+$")) {
			int a = Integer.parseInt(ob);
			if (a < 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try (PrintWriter writer = response.getWriter()) {

			String productName = request.getParameter("product-name");
			String unitPrice = request.getParameter("unit-price");
			String genders[] = request.getParameterValues("gender");
			String categoryId = request.getParameter("category");
			String brandId = request.getParameter("brand");
			String description = request.getParameter("description");
			String sale = request.getParameter("sale");
			List<String> imgs = new ArrayList<String>();
			String sizes[] = request.getParameterValues("size");
			String colors[] = request.getParameterValues("color");
			String quantities[] = request.getParameterValues("quantity");

			// validate data
			if ("".equals(productName) || "".equals(unitPrice)) {
				writer.println("Vui lòng nhập vào các trường yêu cầu!");

			} else if (!isNumber(unitPrice)) {
				writer.println("Đơn giá phải là số!");

			} else if (genders == null) {
				writer.println("Vui lòng chọn giới tính!");

			} else if (!isNumber(categoryId) || !isNumber(brandId)) {
				writer.println("Vui lòng chọn mặt hàng và thương hiệu!");

			}

			else if (!"".equals(sale) && !isNumber(sale)) {
				writer.println("giảm giá phải là số (0-100)!");

			} else {

				// upload file

				String path = "C:\\Users\\hp\\eclipse-workspace\\fashion-manage\\src\\main\\webapp\\template\\admin\\img\\product-img";
				for (Part filePart : request.getParts()) {
					System.out.println("co part");
					String fileName = getFileName(filePart);
					// insert image

					if (fileName != null && !fileName.equals("")) {
						// add to imgs list
						imgs.add(fileName);
						//
						OutputStream out = null;
						InputStream filecontent = null;

						try {
							out = new FileOutputStream(new File(path + File.separator + fileName));
							filecontent = filePart.getInputStream();

							int read = 0;
							final byte[] bytes = new byte[1024];

							while ((read = filecontent.read(bytes)) != -1) {
								out.write(bytes, 0, read);
							}
							System.out.println("New file " + fileName + " created at " + path);

						} catch (FileNotFoundException fne) {
							System.out.println(fne);

						} finally {
							if (out != null) {
								out.close();
							}
							if (filecontent != null) {
								filecontent.close();
							}
						}
					}
				}

				// add information into database
				Category category = new Category();
				category.setCategoryId(Integer.parseInt(categoryId));

				Brand brand = new Brand();
				brand.setBrandId(Integer.parseInt(brandId));

				Product product = new Product();
				product.setProductName(productName);
				product.setUnitPrice(Integer.parseInt(unitPrice));
				product.setDescription(description);
				product.setBrand(brand);
				product.setCategory(category);
				product.setSale("".equals(sale) ? 0 : Integer.parseInt(sale));
				product.setImgs(imgs);

				for (int i = 0; i < sizes.length; i++) {
					if (isNumber(sizes[i]) && !"".equals(colors[i]) && isNumber(quantities[i])) {
						ProductDetail detail = new ProductDetail();
						detail.setSize(Integer.parseInt(sizes[i]));
						detail.setColor(colors[i]);
						detail.setQuantity(Integer.parseInt(quantities[i]));
						product.getProductDetails().add(detail);

					}
				}

				int productId = -1;
				productId = new ProductDao().insert(product, genders);
				if (productId == -1) {

					writer.println("Thêm thất bại");
				} else {
					
					writer.println("Thêm thành công");
				}
			}

		}

	}

	private String getFileName(final Part part) {
		System.out.println("header: " + part.getHeader("content-disposition").split(";"));
		for (String content : part.getHeader("content-disposition").split(";")) {
			System.out.println("content: " + content);
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
