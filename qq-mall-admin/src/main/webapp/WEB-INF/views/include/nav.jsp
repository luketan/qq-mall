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
            <a class="navbar-brand" style="padding-top: 5px;" href="${basePath }/index.html"><img src="${basePath }/static/img/logo.jpg" height="40"></a>
            <span class="navbar-brand">${site.title}</span>
        </div>
        <!-- /.navbar-header -->
        <audio id="audioNewOrder" src="${basePath }/static/file/new-order.mp3" loop="true">
        </audio>
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i id="orderMenuIcon" class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>

                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="${basePath }/order/list.html?status=1">
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
                    	<li><a href="admin/updatePwdForm.html"><i class="fa fa-gear fa-fw"></i> 修改密码</a></li>
                    </li>
                    <li class="divider"></li>
                    <li><a href="${basePath }/logout.html"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
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
                        <a href="${basePath }/index.html"><i class="fa fa-home fa-fw"></i> 首页</a>
                    </li>
                    <shiro:hasPermission name="goods">
                        <li class="${selectMenu=='goods' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 商品管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='goods' ? 'in':''}"
                                aria-expanded="${selectMenu=='goods' ? 'true':'false'} ">
                                <shiro:hasPermission name="goods:search">
                                    <li><a href="${basePath }/goods/list.html">商品列表</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="goods:insert">
                                    <li><a href="${basePath }/goods/add.html">添加商品</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="goodsBrand">
                        <li class="${selectMenu=='goodsBrand' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 商品品牌管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='goods' ? 'in':''}"
                                aria-expanded="${selectMenu=='goodsBrand' ? 'true':'false'} ">
                                <li><a href="${basePath }/goodsBrand/list.html">商品品牌列表</a></li>
                                <li><a href="${basePath }/goodsBrand/add.html">添加商品品牌类型</a></li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="goodsType">
                        <li class="${selectMenu=='goodsType' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 商品类型管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='goodsType' ? 'in':''}"
                                aria-expanded="${selectMenu=='goodsTag' ? 'true':'false'} ">
                                    <li><a href="${basePath }/goodsType/list.html">商品类型列表</a></li>
                                    <li><a href="${basePath }/goodsType/add.html">添加商品类型</a></li>
                                    <li><a href="${basePath }/goodsType/subList.html">商品子类型列表</a></li>
                                    <li><a href="${basePath }/goodsType/subAdd.html">添加商品子类型</a></li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="goodsTag">
                        <li class="${selectMenu=='goodsTag' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 商品标签管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='goodsTag' ? 'in':''}"
                                aria-expanded="${selectMenu=='goodsTag' ? 'true':'false'} ">
                                <shiro:hasPermission name="goodsTag:search">
                                    <li><a href="${basePath }/goodsTag/list.html">商品标签列表</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="goodsTag:insert">
                                    <li><a href="${basePath }/goodsTag/add.html">添加商品标签</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="goodsActivity">
                        <li class="${selectMenu=='goodsActivity' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 商品活动管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='goodsActivity' ? 'in':''}"
                                aria-expanded="${selectMenu=='goodsActivity' ? 'true':'false'} ">
                                <shiro:hasPermission name="goodsActivity:search">
                                    <li><a href="${basePath }/goodsActivity/list.html">商品活动列表</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="goodsActivity:insert">
                                    <li><a href="${basePath }/goodsActivity/add.html">添加商品活动</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="societyType">
                        <li class="${selectMenu=='societyType' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 论坛类型管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='societyType' ? 'in':''}"
                                aria-expanded="${selectMenu=='societyType' ? 'true':'false'} ">
                                <li><a href="${basePath }/societyType/list.html">论坛类型列表</a></li>
                                <li><a href="${basePath }/societyType/add.html">添加论坛类型</a></li>
                                <li><a href="${basePath }/societyType/subList.html">论坛子类型列表</a></li>
                                <li><a href="${basePath }/societyType/subAdd.html">添加论坛子类型</a></li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="coupon">
                        <li class="${selectMenu=='coupon' ? 'active':''}">
                            <a href="#"><i class="fa fa-pagelines fa-fw"></i> 优惠券管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='coupon' ? 'in':''}"
                                aria-expanded="${selectMenu=='coupon' ? 'true':'false'} ">
                                <shiro:hasPermission name="coupon:search">
                                    <li><a href="${basePath }/coupon/list.html">优惠券列表</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="coupon:add">
                                    <li><a href="${basePath }/coupon/add.html">添加优惠券</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="coupon:search">
                                    <li><a href="${basePath }/coupon/userConponList.html">用户优惠券列表</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="order">
                        <li class="${(selectMenu=='order') ? 'active':''}">
                            <a href="#"><i class="fa fa-thumb-tack fa-fw"></i> 订单管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${(selectMenu=='order') ? 'in':''}"
                            	aria-expanded="${(selectMenu=='order') ? 'true':'false'} ">
                                <shiro:hasPermission name="order:search">
                                    <li><a class="${(selectMenu=='order') ? 'active':''}" href="${basePath }/order/list.html">订单列表</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="feedBack">
                        <li class="${(selectMenu=='feedBack') ? 'active':''}">
                            <a href="#"><i class="fa fa-thumb-tack fa-fw"></i> 用户反馈信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${(selectMenu=='feedBack') ? 'in':''}"
                                aria-expanded="${(selectMenu=='feedBack') ? 'true':'false'} ">
                                <shiro:hasPermission name="feedBack:search">
                                    <li><a class="${(selectMenu=='feedBack') ? 'active':''}" href="${basePath }/feedBack/list.html">用户反馈列表</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="post">
                        <li class="${(selectMenu=='post') ? 'active':''}">
                            <a href="#"><i class="fa fa-thumb-tack fa-fw"></i>快递公司管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${(selectMenu=='post') ? 'in':''}"
                                aria-expanded="${(selectMenu=='post') ? 'true':'false'} ">
                                <shiro:hasPermission name="post:search">
                                    <li><a class="${(selectMenu=='post') ? 'active':''}" href="${basePath }/post/list.html">快递公司列表</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="post:add">
                                    <li><a href="${basePath }/post/add.html">添加快递公司</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="advertisement">
                        <li class="${selectMenu=='advertisement' ? 'active':''}">
                            <a href="#"><i class="fa fa-film fa-fw"></i> 广告管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='advertisement' ? 'in':''}"
                                aria-expanded="${selectMenu=='advertisement' ? 'true':'false'} ">
                                <shiro:hasPermission name="advertisement:list">
                                    <li><a href="${basePath }/advertisement/list.html">广告列表</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="advertisement:add">
                                    <li><a href="${basePath }/advertisement/add.html">添加广告</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user">
                        <li class="${selectMenu=='user' ? 'active':''}">
                            <a href="#"><i class="fa fa-film fa-fw"></i> 用户管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='user' ? 'in':''}"
                                aria-expanded="${selectMenu=='user' ? 'true':'false'} ">
                                <shiro:hasPermission name="user:list">
                                    <li><a href="${basePath }/user/list.html">用户列表</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasRole name="admin">
                        <li class="${selectMenu=='system' ? 'active':''}">
                            <a href="#"><i class="fa fa-gear fa-fw"></i> 系统设置<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse ${selectMenu=='system' ? 'in':''}"
                                aria-expanded="${selectMenu=='system' ? 'true':'false'} ">
                                <shiro:hasPermission name="system:admin">
                                    <li><a href="${basePath }/admin/list.html">管理员管理</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system:role">
                                    <li><a href="${basePath }/security/role.html">系统角色管理</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system:security">
                                    <li><a href="${basePath }/security/security.html">系统权限管理</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system/parameter">
                                    <li><a href="${basePath }/system/parameter.html">系统参数管理</a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="system:version">
                                    <li><a href="${basePath }/version/list.html">版本管理</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasRole>
                </ul>
            </div>
        </div>
    </nav>