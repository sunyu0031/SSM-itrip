<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>用户注册</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <%--    <script src="https://code.jquery.com/jquery.js"></script>--%>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/local.js"></script>
    <style>

        .container1 {
            margin-top: 70px;
            width: 45%;
            margin-left: 30%;
        }

        /* 需要在一行的元素 */
        .inline-style {
            display: inline-block;
        }

        /* 文字需要靠右 */
        .font-position-right {
            text-align: right;
        }

        /* 注册按钮 */
        .register-btn {
            margin-left: 10%;
        }


    </style>
</head>
<body>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <form class="form-horizontal" action="${pageContext.request.contextPath }/doActive">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">激活</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="txt_email">邮箱号</label>
                        <input type="text" name="txt_email" class="form-control" id="txt_email" placeholder="邮箱号">
                    </div>
                    <div class="form-group">
                        <label for="txt_activateCode">激活码</label>
                        <input type="text" name="txt_activateCode" class="form-control" id="txt_activateCode"
                               placeholder="激活码">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span
                            class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
                    </button>
                    <button type="submit" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span
                            class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>激活
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="container1">

    <form class="form-horizontal" action="${pageContext.request.contextPath }/regiest">
        <div class="form-group">
            <!--<h2 class="form-signin-heading">注册</h2>-->
            <!-- class="sr-only"将label标签隐藏 -->
            <label for="exampleInputUsername1"
                   class="col-sm-2 control-label inline-style font-position-right">用户名</label>
            <div class="col-sm-9 inline-style ">
                <input type="text" name="devName" class="form-control" id="exampleInputUsername1" placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <!--<h2 class="form-signin-heading">注册</h2>-->
            <label for="exampleInputUsername1"
                   class="col-sm-2 control-label  inline-style font-position-right">密码</label>
            <div class="col-sm-9  inline-style">
                <input type="password" name="devPassword" class="form-control" id="exampleInputPassword1"
                       placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label for="exampleInputUsername1"
                   class="col-sm-2 control-label  inline-style font-position-right">邮箱</label>
            <div class="col-sm-9  inline-style">
                <input type="email" name="devEmail" class="form-control" id="exampleInputEmail1" placeholder="邮箱">
            </div>
            <div class="form-group">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9  inline-style">
                <input type="hidden" name="message" class="form-message" id="message" value="${message}"
                       placeholder="提示信息">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <!--<input type="checkbox">
                        记住密码-->
                    </label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-lg btn-primary btn-block register-btn" id="regiestBtn" type="submit">注册</button>
            </div>

        </div>
    </form>

</div>

</body>
</html>