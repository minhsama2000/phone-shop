<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/admin/index">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/table">
          <i class="fas fa-fw fa-table"></i>
          <span>Danh mục & Sản phẩm</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>User & Đơn hàng</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="/admin/user">User</a>
          <a class="dropdown-item" href="/admin/order">Đơn hàng</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/blog">
          <i class="fa fa-newspaper"></i>
          <span>Blogs</span></a>
      </li>
    </ul>

     