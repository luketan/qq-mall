    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    <%@include file="../include/taglib.jsp" %>
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom:0;z-index:89;">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="padding-top: 5px;" href="/index.html">
            	<c:if test="${!independent}">
            		<img src="/static/img/zbgj_logo.png" height="40"></a>
            	</c:if>
            	<c:if test="${independent}">
            		<img src="/static/img/logo.jpg" height="40"></a>
            	</c:if>
            <span class="navbar-brand">${site.title}</span>
        </div>
        <!-- /.navbar-header -->
        <audio id="audioNewOrder" src="/static/file/new-order.mp3" loop="true">
        </audio>
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i id="orderMenuIcon" class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>

                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="/order/list.html?status=1">
                            <div>
                                <i class="fa fa-shopping-cart fa-fw"></i> 新订单
                                <span id="orderMenuNumber" class="pull-right text-muted small orderMenuNumber">0</span>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-alerts -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户中心</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> 个人设置</a>
                    <c:if test="${independent}">
                    	<li><a href="/admin/updatePwdForm.html"><i class="fa fa-gear fa-fw"></i> 修改密码</a></li>
                    </c:if>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/logout.html"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav in" id="side-menu">
                    <li class="${selectMenu=='index' ? 'active':''}">
                        <a href="/index.html"><i class="fa fa-home fa-fw"></i> 首页</a>
                    </li>
                    <shiro:hasPermission name="product">
                        <li class="${selectMenu=='product' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 系列管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='product' ? 'in':''}"
                                aria-expanded="${selectMenu=='product' ? 'true':'false'} ">
                                <shiro:hasPermission name="product/search">
                                    <li>
                                        <a href="/product/list.html">系列列表</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="product/insert">
                                    <li>
                                        <a href="/product/add.html">添加系列</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="product/series">
                                    <li>
                                        <a href="/product/series.html">系列名称列表</a>
                                    </li>
                                </shiro:hasPermission>

                                <shiro:hasPermission name="product/series:insert">
                                    <li>
                                        <a href="/product/series/add.html">添加系列名称</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="product/category">
                                    <li>
                                        <a href="/product/category.html">系列类别列表</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="product/category:insert">
                                    <li>
                                        <a href="/product/category/add.html">添加系列类别</a>
                                    </li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="product">
                        <li class="${selectMenu=='productItem' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 单品管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='productItem' ? 'in':''}"
                                aria-expanded="${selectMenu=='productItem' ? 'true':'false'} ">
                                <shiro:hasPermission name="productItem/search">
                                    <li>
                                        <a href="/productItem/item.html">单品列表</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="productItem/insert">
                                    <li>
                                        <a href="/productItem/item/add.html">添加单品</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="productItem/category:search">
                                    <li>
                                        <a href="/productItem/item/category.html">单品类别列表</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="productItem/category:insert">
                                    <li>
                                        <a href="/productItem/item/category/add.html">添加单品类别</a>
                                    </li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="order">
                        <li class="${(selectMenu=='order'||selectMenu=='shipOrder'||selectMenu=='packOrder') ? 'active':''}">
                            <a href="#"><i class="fa fa-thumb-tack fa-fw"></i> 订单管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${(selectMenu=='order'||selectMenu=='shipOrder'||selectMenu=='packOrder') ? 'in':''}" 
                            	aria-expanded="${(selectMenu=='order'||selectMenu=='shipOrder'||selectMenu=='packOrder') ? 'true':'false'} ">
                                <shiro:hasPermission name="order/search">
                                    <li>
                                        <a class="${(selectMenu=='order') ? 'active':''}" href="/order/list.html">订单列表</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="shipOrder/search">
                                    <li>
                                        <a class="${(selectMenu=='shipOrder') ? 'active':''}" href="/shipOrder/shipList.html">待发货列表</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="packOrder/search">
                                    <li>
                                        <a class="${(selectMenu=='packOrder') ? 'active':''}" href="/packOrder/packList.html">包裹列表</a>
                                    </li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <c:if test="${!independent}">
	                    <shiro:hasPermission name="supplier">
	                        <li class="${selectMenu=='supplier' ? 'active':''}">
	                            <a href="#"><i class="fa fa-film fa-fw"></i> 供应商管理<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level collapse ${selectMenu=='supplier' ? 'in':''}"
	                                aria-expanded="${selectMenu=='supplier' ? 'true':'false'} ">
	                                <shiro:hasPermission name="supplier:search">
	                                    <li>
	                                        <a href="/supplier/list.html">供应商列表</a>
	                                    </li>
	                                </shiro:hasPermission>
	                                <shiro:hasPermission name="supplier:insert">
	                                    <li>
	                                        <a href="/supplier/add.html">添加供应商</a>
	                                    </li>
	                                </shiro:hasPermission>
	                            </ul>
	                        </li>
	                    </shiro:hasPermission>
                    </c:if>
                    <c:if test="${!independent}">
	                    <shiro:hasPermission name="advertisement">
	                        <li class="${selectMenu=='advertisement' ? 'active':''}">
	                            <a href="#"><i class="fa fa-film fa-fw"></i> 广告管理<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level collapse ${selectMenu=='advertisement' ? 'in':''}"
	                                aria-expanded="${selectMenu=='advertisement' ? 'true':'false'} ">
	                                <shiro:hasPermission name="advertisement:list">
	                                    <li>
	                                        <a href="/advertisement/list.html">广告列表</a>
	                                    </li>
	                                </shiro:hasPermission>
	                                <shiro:hasPermission name="advertisement:add">
	                                    <li>
	                                        <a href="/advertisement/add.html">添加广告</a>
	                                    </li>
	                                </shiro:hasPermission>
	                            </ul>
	                        </li>
	                    </shiro:hasPermission>
                    </c:if>
                    <shiro:hasRole name="admin">
                        <li class="${selectMenu=='system' ? 'active':''}">
                            <a href="#"><i class="fa fa-gear fa-fw"></i> 系统设置<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='system' ? 'in':''}"
                                aria-expanded="${selectMenu=='system' ? 'true':'false'} ">
                                <c:if test="${independent}">
	                                <shiro:hasPermission name="system/user">
	                                    <li>
	                                        <a href="/user/list.html">用户管理</a>
	                                    </li>
	                                </shiro:hasPermission>
	                                <shiro:hasPermission name="system/admin">
	                                    <li>
	                                        <a href="/admin/list.html">管理员管理</a>
	                                    </li>
	                                </shiro:hasPermission>
                                </c:if>
                                <shiro:hasPermission name="system/userColor">
                                    <li>
                                        <a href="/userColor/list.html">特殊用户管理</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system/role">
                                    <li>
                                        <a href="/system/role.html">系统角色管理</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system/security">
                                    <li>
                                        <a href="/system/security.html">系统权限管理</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system/parameter">
                                    <li>
                                        <a href="/system/parameter.html">系统参数管理</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system/delivery">
                                    <li>
                                        <a href="/system/delivery.html">快递公司管理</a>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system/pickup">
                                    <li>
                                        <a href="/system/address.html">自提地址管理</a>
                                    </li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasRole>
                </ul>
            </div>
        </div>
    </nav>