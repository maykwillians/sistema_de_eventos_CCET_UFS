<!DOCTYPE html>

<%
    String erro = "";
    String str = "";
    if (session.getAttribute("msgTrocarSenha") != null) {

        str = session.getAttribute("msgTrocarSenha").toString();

        if (str.equals("nao")) {

            erro = "Senha incorreta.";
        }
        
        if (str.equals("senhaInvalida")) {

            erro = "Senha inválida. A nova senha precisa ter entre 6 e 10 caracteres. Não utilize espaços.";
        }
        
        if (str.equals("senhasIguais")) {

            erro = "A senha atual e a nova senha não podem ser iguais.";
        }
        
        if (str.equals("ok")) {

            erro = "A sua senha foi alterada com sucesso!";
        }
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CCET - UFS</title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600&amp;subset=latin-ext" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="style.css" rel="stylesheet">

        <link href="css/login.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">

        <script Language="JavaScript">
            
            (function() {
                if( window.localStorage ) {
                    if( !localStorage.getItem( 'firstLoad' ) ) {
                        
                        localStorage[ 'firstLoad' ] = true;
                        window.location.reload();
                        
                        // Lógica de alert próprio da página
                        var aux = "<%=str%>";
                        if (aux != "") {
                            
                            alert("<%=erro%>");
                        }
                        <%
                            session.removeAttribute("msgTrocarSenha");
                        %>
                    } else
                        localStorage.removeItem( 'firstLoad' );
                }
            })();
        </script>

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <jsp:include page = "menu_superior.jsp" />
        <main class="site-main"><div class="container" style="margin-top:40px">
                <div class="row">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <strong class="">CCET EVENTOS - ALTERAR SENHA</strong>
                            </div>
                            <div class="panel-body">
                                <form role="form" action="ServletTrocarSenha" id="formulario" name="formulario" method="POST">
                                    <fieldset>
                                        <div class="row">
                                            <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                                <div class="form-group">
                                                    <br>
                                                    <b style="color: black">Iremos trocar a sua senha</b>
                                                    <br>
                                                    <br>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="glyphicon glyphicon-lock"></i>
                                                        </span>
                                                        <input class="form-control" placeholder="Insira a sua senha atual" id="senhaAtual" name="senhaAtual" type="password" maxlength="20">
                                                        <span id="showPassword" class="input-group-addon">
                                                            <i id="olho" class="fa fa-eye"></i>
                                                        </span>
                                                    </div>
                                                    <br>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="glyphicon glyphicon-lock"></i>
                                                        </span>
                                                        <input class="form-control" placeholder="Insira a sua nova senha" id="senhaNova" name="senhaNova" type="password" maxlength="20">
                                                        <span id="showPassword2" class="input-group-addon">
                                                            <i id="olho2" class="fa fa-eye"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <input type="submit" value="Trocar Senha" class="btn btn-lg btn-primary btn-block">
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page = "footer.jsp" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $('.carousel[data-type="multi"] .item').each(function () {
                var next = $(this).next();
                if (!next.length) {
                    next = $(this).siblings(':first');
                }
                next.children(':first-child').clone().appendTo($(this));

                for (var i = 0; i < 4; i++) {
                    next = next.next();
                    if (!next.length) {
                        next = $(this).siblings(':first');
                    }

                    next.children(':first-child').clone().appendTo($(this));
                }
            });
            
            // Para mostrar e ocultar senha atual
            $(document).ready(function(){

              $('#showPassword').on('click', function(){

                var passwordField = $('#senhaAtual');

                var passwordFieldType = passwordField.attr('type');

                if(passwordFieldType == 'password') {

                    passwordField.attr('type', 'text');
                    $('#olho').removeClass("fa fa-eye");
                    $('#olho').addClass("fa fa-eye-slash");
                } else {

                    passwordField.attr('type', 'password');
                    $('#olho').removeClass("fa fa-eye-slash");
                    $('#olho').addClass("fa fa-eye");
                }
              });
            });
            
            // Para mostrar e ocultar senha nova
            $(document).ready(function(){

              $('#showPassword2').on('click', function(){

                var passwordField = $('#senhaNova');

                var passwordFieldType = passwordField.attr('type');

                if(passwordFieldType == 'password') {

                    passwordField.attr('type', 'text');
                    $('#olho2').removeClass("fa fa-eye");
                    $('#olho2').addClass("fa fa-eye-slash");
                } else {

                    passwordField.attr('type', 'password');
                    $('#olho2').removeClass("fa fa-eye-slash");
                    $('#olho2').addClass("fa fa-eye");
                }
              });
            });
        </script>
    </body>
</html>