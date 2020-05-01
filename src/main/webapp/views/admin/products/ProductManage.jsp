<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description"
	content="Responsive Web UI Kit &amp; Dashboard Template based on Bootstrap" />
<meta name="author" content="AdminKit" />
<meta name="keywords"
	content="adminkit, bootstrap, web ui kit, dashboard template, admin template" />

<link rel="shortcut icon" href="template/admin/img/icons/icon-48x48.png" />

<title>AdminKit Demo - Web UI Kit &amp; Dashboard Template</title>

<link href="template/admin/css/app.css" rel="stylesheet" />
<link href="template/admin/css/modal-box.css" rel="stylesheet" />
</head>

<body>
	<div class="wrapper">
		<%@include file="/common/admin/menu.jsp"%>

		<div class="main">
			<%@include file="/common/admin/header.jsp"%>

			<main class="content">
				<div class="container-fluid p-0">
					<div class="container-fluid p-0">
						<h1 class="h3 mb-3">Quản lý sản phẩm</h1>
						<div class="row mb-2 mb-xl-3">
							<div class="col-auto ml-auto text-right mt-n1">
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb bg-transparent p-0 mt-1 mb-0">
										<li class="breadcrumb-item"><a href="admin-sanpham-add">
												<i class="align-middle" data-feather="plus-square"></i>Thêm
												sản phẩm
										</a></li>
									</ol>
								</nav>
							</div>
						</div>

						<!-- the modal box them san pham -->
						<%-- <div id="myModal" class="modal">
							<!-- Modal content -->
							<div class="modal-content">
								<div>
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
									<div class="alert-message">

										<div class="card-header">
											<h3 class="card-title">Thêm sản phẩm</h3>
											<c:if test="${not empty error }">
												<h6 class="card-subtitle text-danger">${error }</h6>
											</c:if>
										</div>
										<div class="card-body">
											<form action="admin-sanpham-add" method="POST"
												name="validateForm" onsubmit="validateNumber();"
												enctype="multipart/form-data">
												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Tên
														sản phẩm</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="nhập vào tên sản phẩm" name="product-name"
															required />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Đơn
														giá</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="nhập đơn giá" name="unit-price" required />
													</div>
												</div>

												<div class="form-group row">
													<label
														class="col-form-label col-sm-2 text-sm-right pt-sm-0">Giới
														tính</label>
													<div class="col-sm-10">
														<label class="custom-control custom-checkbox m-0">
															<input type="checkbox" class="custom-control-input"
															name="gender" /> <span class="custom-control-label">Nam</span>
														</label> <label class="custom-control custom-checkbox m-0">
															<input type="checkbox" class="custom-control-input"
															name="gender" /> <span class="custom-control-label">Nữ</span>
														</label>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Mặt
														hàng</label>
													<div class="col-sm-10">
														<select class="form-control mb-3" name="category">
															<option selected="" value="-1">chọn mặt hàng</option>
															<c:forEach var="category" items="${categories }">
																<option value="${category.categoryId }">${category.categoryName }</option>
															</c:forEach>

														</select>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Thương
														hiệu</label>
													<div class="col-sm-10">
														<select class="form-control mb-3" name="brand">
															<option selected="" value="-1">chọn thương hiệu</option>
															<c:forEach var="brand" items="${brands }">
																<option value="${brand.brandId }">${brand.brandName }</option>
															</c:forEach>

														</select>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Mô
														tả</label>
													<div class="col-sm-10">
														<textarea class="form-control" placeholder="nhập mô tả"
															rows="3" name="description"></textarea>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Giảm
														giá</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="nhập % giảm giá" name="sale" />
													</div>
												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Ảnh</label>
													<div class="col-sm-10">
														<input type="file" name="file" multiple="multiple">
														<small class="form-text text-muted">Chọn ảnh trong
															máy.</small>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right">Chi
														tiết</label>
													<div class="col-sm-10" id="detail">
														<div class="form-row row">
															<div class="form-group col-md-4">
																<label>Size</label>
															</div>
															<div class="form-group col-md-4">
																<label>Màu</label>
															</div>
															<div class="form-group col-md-4">
																<label>Số lượng</label>
															</div>
														</div>

														<div class="form-row row clone-child" hidden="true">
															<div class="form-group col-md-4">
																<input type="text" class="form-control" name="size">
															</div>
															<div class="form-group col-md-4">
																<input type="text" class="form-control" name="color">
															</div>
															<div class="form-group col-md-4">
																<input type="text" class="form-control" name="quantity">
															</div>
														</div>

													</div>

												</div>

												<div class="form-group row">
													<label class="col-form-label col-sm-2 text-sm-right"></label>
													<div class="col-sm-10">
														<div>
															<a onclick="cloneDetail();" href="javascript:;"><i
																class="align-middle" data-feather="plus-square"></i>Thêm
																chi tiết</a>
														</div>
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-10 ml-sm-auto text-sm-right">
														<button type="submit" class="btn btn-success">Lưu</button>
													</div>

												</div>
											</form>
										</div>

									</div>
								</div>
							</div>
						</div> --%>

						<!-- /the modal box them san pham -->

						<div class="card">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Tên sản phẩm</th>
										<th>Giá tiền</th>
										<th>Mô tả</th>


										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="p" items="${products }">
										<tr>
											<td><img src="${p.featureImage}" width="48" height="48"
												class="avatar img-fluid rounded mr-1" alt="ảnh" />
												${p.productName}</td>
											<td>${p.unitPrice }</td>
											<td>${p.description }</td>

											<td class="table-action"><a href="#"><i
													class="align-middle" data-feather="edit-2"></i></a> <a href="deleteProduct?id=${p.productId }"><i
													class="align-middle" data-feather="trash" onclick="return confirm('Bạn thật sự muốn dừng bán sản phẩm ${p.productName}!');" ></i></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>

			<%@include file="/common/admin/footer.jsp"%>
		</div>
	</div>

	<script src="template/admin/js/vendor.js"></script>
	<script src="template/admin/js/app.js"></script>
	<!-- <script src="template/admin/js/modal-box.js"></script>
	<script src="template/admin/js/clone-child.js"></script> -->
	<script>
		$(function() {
			var ctx = document.getElementById("chartjs-dashboard-line")
					.getContext("2d");
			var gradient = ctx.createLinearGradient(0, 0, 0, 225);
			gradient.addColorStop(0, "rgba(215, 227, 244, 1)");
			gradient.addColorStop(1, "rgba(215, 227, 244, 0)");
			// Line chart
			new Chart(document.getElementById("chartjs-dashboard-line"), {
				type : "line",
				data : {
					labels : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
							"Aug", "Sep", "Oct", "Nov", "Dec", ],
					datasets : [
							{
								label : "Sales ($)",
								fill : true,
								backgroundColor : gradient,
								borderColor : window.theme.primary,
								data : [ 2115, 1562, 1584, 1892, 1587, 1923,
										2566, 2448, 2805, 3438, 2917, 3327, ],
							}, ],
				},
				options : {
					maintainAspectRatio : false,
					legend : {
						display : false,
					},
					tooltips : {
						intersect : false,
					},
					hover : {
						intersect : true,
					},
					plugins : {
						filler : {
							propagate : false,
						},
					},
					scales : {
						xAxes : [ {
							reverse : true,
							gridLines : {
								color : "rgba(0,0,0,0.0)",
							},
						}, ],
						yAxes : [ {
							ticks : {
								stepSize : 1000,
							},
							display : true,
							borderDash : [ 3, 3 ],
							gridLines : {
								color : "rgba(0,0,0,0.0)",
							},
						}, ],
					},
				},
			});
		});
	</script>
	<script>
		$(function() {
			// Pie chart
			new Chart(document.getElementById("chartjs-dashboard-pie"), {
				type : "pie",
				data : {
					labels : [ "Chrome", "Firefox", "IE" ],
					datasets : [
							{
								data : [ 4306, 3801, 1689 ],
								backgroundColor : [ window.theme.primary,
										window.theme.warning,
										window.theme.danger, ],
								borderWidth : 5,
							}, ],
				},
				options : {
					responsive : !window.MSInputMethodContext,
					maintainAspectRatio : false,
					legend : {
						display : false,
					},
					cutoutPercentage : 75,
				},
			});
		});
	</script>
	<script>
		$(function() {
			// Bar chart
			new Chart(document.getElementById("chartjs-dashboard-bar"), {
				type : "bar",
				data : {
					labels : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
							"Aug", "Sep", "Oct", "Nov", "Dec", ],
					datasets : [
							{
								label : "This year",
								backgroundColor : window.theme.primary,
								borderColor : window.theme.primary,
								hoverBackgroundColor : window.theme.primary,
								hoverBorderColor : window.theme.primary,
								data : [ 54, 67, 41, 55, 62, 45, 55, 73, 60,
										76, 48, 79 ],
								barPercentage : 0.75,
								categoryPercentage : 0.5,
							}, ],
				},
				options : {
					maintainAspectRatio : false,
					legend : {
						display : false,
					},
					scales : {
						yAxes : [ {
							gridLines : {
								display : false,
							},
							stacked : false,
							ticks : {
								stepSize : 20,
							},
						}, ],
						xAxes : [ {
							stacked : false,
							gridLines : {
								color : "transparent",
							},
						}, ],
					},
				},
			});
		});
	</script>
	<script>
		$(function() {
			$("#world_map").vectorMap({
				map : "world_mill",
				normalizeFunction : "polynomial",
				hoverOpacity : 0.7,
				hoverColor : false,
				regionStyle : {
					initial : {
						fill : "#e3eaef",
					},
				},
				markerStyle : {
					initial : {
						r : 9,
						fill : window.theme.primary,
						"fill-opacity" : 0.95,
						stroke : "#fff",
						"stroke-width" : 7,
						"stroke-opacity" : 0.4,
					},
					hover : {
						stroke : "#fff",
						"fill-opacity" : 1,
						"stroke-width" : 1.5,
					},
				},
				backgroundColor : "transparent",
				zoomOnScroll : false,
				markers : [ {
					latLng : [ 31.230391, 121.473701 ],
					name : "Shanghai",
				}, {
					latLng : [ 28.70406, 77.102493 ],
					name : "Delhi",
				}, {
					latLng : [ 6.524379, 3.379206 ],
					name : "Lagos",
				}, {
					latLng : [ 35.689487, 139.691711 ],
					name : "Tokyo",
				}, {
					latLng : [ 23.12911, 113.264381 ],
					name : "Guangzhou",
				}, {
					latLng : [ 40.7127837, -74.0059413 ],
					name : "New York",
				}, {
					latLng : [ 34.052235, -118.243683 ],
					name : "Los Angeles",
				}, {
					latLng : [ 41.878113, -87.629799 ],
					name : "Chicago",
				}, {
					latLng : [ 51.507351, -0.127758 ],
					name : "London",
				}, {
					latLng : [ 40.416775, -3.70379 ],
					name : "Madrid",
				}, ],
			});
			setTimeout(function() {
				$(window).trigger("resize");
			}, 250);
		});
	</script>
	<script>
		$(function() {
			$("#datetimepicker-dashboard").datetimepicker({
				inline : true,
				sideBySide : false,
				format : "L",
			});
		});
	</script>
</body>
</html>
