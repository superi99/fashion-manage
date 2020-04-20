<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<nav id="sidebar" class="sidebar">
  <div class="sidebar-content js-simplebar">
    <a class="sidebar-brand" href="index.html">
      <span class="align-middle">AdminKit</span>
    </a>

    <ul class="sidebar-nav">
      <li class="sidebar-header">Danh mục</li>

      <li class="sidebar-item active">
        <a class="sidebar-link" href="index.html">
          <i class="align-middle" data-feather="sliders"></i>
          <span class="align-middle">Dashboard</span>
        </a>
      </li>

	  <li class="sidebar-item">
        <a href="#ui" data-toggle="collapse" class="sidebar-link collapsed">
          <i class="align-middle" data-feather="list"></i>
          <span class="align-middle">Quản Lý</span>
        </a>
        <ul
          id="ui"
          class="sidebar-dropdown list-unstyled collapse "
          data-parent="#sidebar"
		>
		<li class="sidebar-item">
            <a class="sidebar-link" href="#">Đơn hàng</a>
          </li>
          <li class="sidebar-item">
            <a class="sidebar-link" href="admin-sanpham">Sản phẩm</a>
          </li>
          <li class="sidebar-item">
            <a class="sidebar-link" href="admin-category">Mặt hàng</a>
          </li>
          <li class="sidebar-item">
            <a class="sidebar-link" href="admin-brand">Nhãn hiệu</a>
          </li>
          <li class="sidebar-item">
            <a class="sidebar-link" href="#">Bài viết</a>
          </li>
        </ul>
      </li>

      <li class="sidebar-item">
        <a class="sidebar-link" href="pages-profile.html">
          <i class="align-middle" data-feather="user"></i>
          <span class="align-middle">Profile</span>
        </a>
      </li>

      <li class="sidebar-item">
        <a class="sidebar-link" href="pages-settings.html">
          <i class="align-middle" data-feather="settings"></i>
          <span class="align-middle">Settings</span>
        </a>
      </li>

      <li class="sidebar-item">
        <a class="sidebar-link" href="pages-invoice.html">
          <i class="align-middle" data-feather="credit-card"></i>
          <span class="align-middle">Invoice</span>
        </a>
      </li>

      <li class="sidebar-item">
        <a class="sidebar-link" href="pages-blank.html">
          <i class="align-middle" data-feather="book"></i>
          <span class="align-middle">Blank</span>
        </a>
      </li>
	  </ul>
  </div>
</nav>
