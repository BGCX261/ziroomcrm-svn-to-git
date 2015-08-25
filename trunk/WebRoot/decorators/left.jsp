<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Begin left panel -->
    <a href="javascript:;" id="show_menu">&raquo;</a>

    <div id="left_menu">
        <a href="javascript:;" id="hide_menu">&laquo;</a>
        <ul id="main_menu">
            <li><a href="login_blue.html"><img src="icons/icon_home.png" alt="Home"/>首页</a></li>
            <li>
                <a id="menu_pages" href=""><img src="icons/icon_pages.png" alt="Pages"/>合同管理</a>
                <ul>
                    <li><a href="">录入合同</a></li>
                    <li><a href="">编辑合同</a></li>
                </ul>
            </li>
            <li>
                <a href=""><img src="icons/icon_posts.png" alt="Posts"/>房源管理</a>
                <ul>
                    <li><a href="">增加房源</a></li>
                    <li><a href="">编辑房源</a></li>
                    <li><a href="">房源失效</a></li>
                </ul>
            </li>
            <li>
                <a href=""><img src="icons/icon_media.png" alt="Media"/>客户管理</a>
                <ul>
                    <li><a href="">增加客户</a></li>
                    <li><a href="">编辑客户</a></li>
                    <li><a href="">客户失效</a></li>
                </ul>
            </li>
            <li>
                <a href=""><img src="icons/icon_users.png" alt="Users"/>用户管理</a>
                <ul>
                    <li><a href="">增加用户</a></li>
                    <li><a href="">编辑用户</a></li>
                    <li><a href="">用户失效</a></li>
                </ul>
            </li>
        </ul>
        <br class="clear"/>

        <!-- Begin left panel calendar -->
        <div id="calendar"></div>
        <!-- End left panel calendar -->
    </div>
